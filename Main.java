import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	ArrayList<shop> shopList = new ArrayList<shop>();
	ArrayList<customer> customerList = new ArrayList<customer>();
	ArrayList<item> itemList = new ArrayList<item>();
	ArrayList<invoice> invoiceList = new ArrayList<invoice>();
	
	Scanner sc = new Scanner(System.in);
	
	//************================ Shop ================************//
	public void addShop() {
		boolean condition0 = true;
		
		while(condition0) {
			shop firstShop = new shop();
			System.out.println(" Enter the shop name: ");
			String shopName = sc.next();
			firstShop.setShopName(shopName);
			
			System.out.println(" Enter the shop ID: ");
			int shopID = sc.nextInt();
			firstShop.setShopID(shopID);
			
			shopList.add(firstShop);
			
		}
		condition0 = false;
	}
	
	public void printShopDetails()
	{
		for (shop fShop : shopList)
		{
		System.out.println(" Shop Name is: "+ fShop.getShopName() + "   ");
		}
	
	}
	
	//************================ Item ================************//
	 public void addInvoiceItems()
	    {
	    	invoice fInvoice = new invoice();
	    	System.out.println("Enter the invoice Id: ");
	    	int invoiceId = sc.nextInt();
	    	
	    	System.out.println("Enter items ID: ");
	    	int itemID = sc.nextInt();
	    	
	    	System.out.println("Enter item Name: ");
	    	String itemName = sc.next();
	    	
	    	System.out.println("Enter Unit price: ");
	    	double unitPrice = sc.nextDouble();
	    	
	    	System.out.println("Enter Quantity: ");
	    	int quantity = sc.nextInt();
	    	
	    	System.out.println("Enter Quantity Amount: ");
	    	int quantityAmount = sc.nextInt();
	    	
	    	invoiceList.add(fInvoice);
	    	
	    	

		    String url = "jdbc:sqlserver://localhost:1433;" + "databaseName=DatabseInvoice;" + "encrypt=true;"
					+ "trustServerCertificate=true";
			String user = "sa";
			String pass = "root";
			
			
			Connection con = null;
			
			try {
				Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
				DriverManager.registerDriver(driver);
				con = DriverManager.getConnection(url, user, pass);
				Statement st = con.createStatement();
			
		    String sql = "INSERT INTO InvoiceItems (InvoiceItem_Id,Invoice_Id,Item_Id,Item_Name,UnitPrice,Quantity,Qty_Amount)"+
		            "VALUES ("+invoiceId+","+itemID+",'"+itemName+"',"+unitPrice+","+quantity+","+quantityAmount+ ")";
		    System.out.println(sql);

			Integer m = st.executeUpdate(sql);
			if (m >= 1) {
				System.out.println("inserted successfully : " + sql);
			} else {
				System.out.println("insertion failed");
			}
			String sql1 = "Select * from Employee_Type";
			ResultSet resultSet = st.executeQuery(sql1);
		    
			con.close();
			} catch (Exception ex) {
				System.err.println(ex);
			}
			 
			}
	  
	 public void deletDataBase()
		{
		 String url = "jdbc:sqlserver://localhost:1433;" + "databaseName=DatabseInvoice;" + "encrypt=true;"
					+ "trustServerCertificate=true";
			String user = "sa";
			String pass = "root";
			
			
			Connection con = null;
			
			try {
				Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
				DriverManager.registerDriver(driver);
				con = DriverManager.getConnection(url, user, pass);
				Statement st = con.createStatement();
			System.out.println("Enter the Item ID ");
		    String sql = "DELETE FROM [dbo].[InvoiceItems]\r\n"
		    		+ "      WHERE Item_Id= "+ sc.nextInt() ;
		    System.out.println(sql);

			Integer m = st.executeUpdate(sql);
			if (m >= 1) {
				System.out.println("inserted successfully : " + sql);
			} else {
				System.out.println("insertion failed");
			}
			
		    
			con.close();
			} catch (Exception ex) {
				System.err.println(ex);
			}
		
		}
	 
	 
	
}