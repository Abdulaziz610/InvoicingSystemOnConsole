import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

	// ************================ Shop ================************//
	public void addShop() {
		boolean choice0 = false;
		do {
			choice0 = false;
			try // for handing the exception
			{
				shop firstShop = new shop();
				System.out.println("Enter Shop Name:  ");
				String shopName = sc.next();
				firstShop.setshopName(shopName);
				System.out.println("Enter Shop ID: ");
				int shopID = sc.nextInt();
				firstShop.setshopID(shopID);

				shopList.add(firstShop);
			} catch (InputMismatchException w) { // for handing the try and showing the given pritn insted of showing an
													// error excpation
				System.out.println("ID should be integer, Name should be String!");
		
				choice0 = true;
				sc.nextLine(); // with out the sc.nextLine() there will be an infinty loop going
			}
		} while (choice0); // we have to do (do - while) to make the condation happen

	}

	public void printShopDetails() {
		for (shop fShop : shopList) {
			System.out.println("Shop Name is: " + fShop.getshopName() + "        ");
		}

	}

	// ************================ Item ================************//
	public void addInvoiceItems() {
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

			String sql = "INSERT INTO InvoiceItems (InvoiceItem_Id,Invoice_Id,Item_Id,Item_Name,UnitPrice,Quantity,Qty_Amount)"
					+ "VALUES (" + invoiceId + "," + itemID + ",'" + itemName + "'," + unitPrice + "," + quantity + ","
					+ quantityAmount + ")";
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

	public void deletDataBase() {
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
			System.out.println("Enter Item ID ");
			String sql = "DELETE FROM [dbo].[InvoiceItems]\r\n" + "      WHERE Item_Id= " + sc.nextInt();
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

	public void printCustomerName() {
		for (customer fCustomer : customerList) {
			System.out.println("The Cutomer First Name: " + fCustomer.getCustomerFirstName());
			System.out.println("The Cutomer Second Name: " + fCustomer.getCustomerSecondName());
			System.out.println("The Cutomer  ID: " + fCustomer.getCustomerId());
			System.out.println("The Cutomer Phone Number: " + fCustomer.getCustomerPhoneNumber());
		}
	}

	public void print() {
		for (item fItem : itemList) {
			System.out.println("The Item Price:    " + fItem.getUnitPrice() + "      ");
			System.out.println("the item ID:   " + fItem.getItemID() + "      ");
			System.out.println("the item Amount:       " + fItem.getQtyAmount() + "      ");
		}
	}

	public void updateDataBsePrice() {
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
			System.out.println("Enter the Item ID: ");
			int Item_id = sc.nextInt();
			System.out.println("Enter the New Price: ");
			double newPrice = sc.nextDouble();
			String sql = "UPDATE [dbo].[InvoiceItems]\r\n" + "   SET[UnitPrice] = " + newPrice + " WHERE Item_Id = "
					+ Item_id;
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

	//////////////////// Customer/////////////////////////

	public void updateDataBseCustomerPhone() {
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
			System.out.println("Enter the Customer ID: ");
			int itemId = sc.nextInt();
			System.out.println("Enter the Customer New Phone Number: ");
			int CutmoerNumber = sc.nextInt();
			String sql = "UPDATE [dbo].[Customers]\r\n" + "   SET[Customer_Phone_Number] = " + CutmoerNumber
					+ " WHERE Customer_Id = " + itemId;
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

	public void deletDataBaseCustomer() {
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
			System.out.println("Enter the Customer ID that you wish to delete: ");
			String sql = "DELETE FROM [dbo].[Customers]\r\n" + "      WHERE customer_ID = " + sc.nextInt();
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

	public void newCustomer() {
		customer customer = new customer();
		System.out.println("Enter the Cstomer First name: ");
		String customerFirstName = sc.next();
		customer.setCustomerFirstName(customerFirstName);

		System.out.println("Enter the Cstomer Second name: ");
		String customerSecondName = sc.next();
		customer.setCustomerSecondName(customerSecondName);

		System.out.println("Enter the Custoemr Phone Number: ");
		int customerPhoneNumber = sc.nextInt();
		customer.setCustomerPhoneNumber(customerPhoneNumber);
		customerList.add(customer);

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

			String sql = "INSERT INTO Customers (Customer_Full_Name,Customer_Phone_Number)"

					+ "VALUES ('" + customerFirstName + "','" + customerSecondName + "','" + customerPhoneNumber + "')";
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

////////////////////////////////////////////////////////////////////////////////INVOICE////////////////////////////////////////////////////////////////////////////////////////////
	public void addInvoice() {
		System.out.println("Enter the Invoice ID: ");
		int invoiceId = sc.nextInt();
		System.out.println("Enter the Customer ID: ");
		int customerId = sc.nextInt();
		System.out.println("enter the Invoice Date: ");
		String invoiceDate = sc.next();
		System.out.println("Enter the Number of Items: ");
		int itemsNumber = sc.nextInt();
		System.out.println("Enter the total Amount: ");
		double totalAmount = sc.nextDouble();
		System.out.println("Enter the Paid Amount: ");
		double paidAmount = sc.nextDouble();
		System.out.println("Enter the Total Balance: ");
		double totalbalance = sc.nextDouble();

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

			String sql = "INSERT INTO Invoices (Invoice_Id,Customer_Id,Invoice_Date,Number_Of_Items,total_Amount,paid_Amount,totkal_Balance)"

					+ "VALUES (" + invoiceId + "," + customerId + ",'" + invoiceDate + "'," + itemsNumber + ","
					+ totalAmount + "," + paidAmount + "," + totalbalance + ")";
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

	public void invoiceheader() {
		invoice FirstInvoice = new invoice();

		System.out.println("Enter the invoice ID: ");
		int InvoiceId = sc.nextInt();
		FirstInvoice.setInvoiceNumber(InvoiceId);
		
		System.out.println("Enter the invoice Fax: ");
		int invoiceFax = sc.nextInt();
		FirstInvoice.setInvoiceFax(invoiceFax);

		System.out.println(" Enter the invoice phone: ");
		int invoicePhone = sc.nextInt();
		FirstInvoice.setInvoiceTel(invoicePhone);

		System.out.println("Enter the invoice Email: ");
		String invoiceEmail = sc.next();
		FirstInvoice.setInvEmail(invoiceEmail);
		
		System.out.println("Enter the invoice Website: ");
		String invoiceWebsite = sc.next();
		FirstInvoice.setInvEmail(invoiceWebsite);


		invoiceList.add(FirstInvoice);

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

			String sql = "INSERT INTO Invoice_header (Invoice_header_ID,Invoice_Id,Invoice_Fax,Invoice_phone,Invoice_Email,Invoice_Data)"

					+ "VALUES (" + InvoiceId + "," + invoiceFax + "," + invoicePhone + ",'"
					+ invoiceEmail + "');";
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

	public void printInvoicingHeader() {
		for (invoice fInvoice : invoiceList) {
			System.out.println("Fax is: " + fInvoice.getInvoiceFax());
			System.out.println("tel number is: " + fInvoice.getInvoiceNumber());
			System.out.println("Email is: " + fInvoice.getInvEmail());
			System.out.println("Website is: " + fInvoice.getInvEmail());

		}

	}

	public void printcustomer() {
		for (customer fCustomer : customerList) {
			System.out.println("Customer First Name is: " + fCustomer.getCustomerFirstName());
			System.out.println("Customer Second Name is: " + fCustomer.getCustomerSecondName());
			System.out.println("Customer Phone Number is: " + fCustomer.getCustomerPhoneNumber());

		}
	}

	public static void findInvoice()

			throws IOException, InterruptedException {
		String url = "jdbc:sqlserver://localhost:1433;" + "databaseName=DatabseInvoice;" + "encrypt=true;"
				+ "trustServerCertificate=true";
		String user = "sa";
		String pass = "root";
		Scanner sr = new Scanner(System.in);
		Connection con = null;
		try {
			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection(url, user, pass);
			System.out.println("Please Enter the Invoice ID:");
			int invoiceID = sr.nextInt();
			String sql = "SELECT * FROM Invoices WHERE Invoice_Id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, invoiceID);
			ResultSet rs = ps.executeQuery();
			if (!rs.next()) {
				System.out.println("Invoice Not Found");
			} else {
				System.out.println("Invoice Details:");
				System.out.println(
						"--------------------------------------------------------------------------------------------------------------------------------");
				System.out.println(
						"Invoice ID\tCustomer ID\tInvoice Date\tNumber of Items\tTotal Amount\tPaid Amount\ttotal Balance");
				System.out.println(
						"--------------------------------------------------------------------------------------------------------------------------------");
				// Print the details of the invoice
				do {
					int invoiceId = rs.getInt("Invoice_Id");
					int customerId = rs.getInt("Customer_Id");
					String invoiceDate = rs.getString("Invoice_Date");
					int itemsNumber = rs.getInt("Number_Of_Items");
					double total_Amount = rs.getInt("total_Amount");
					double paidAmount = rs.getFloat("paid_Amount");
					double total_Balance = rs.getFloat("totkal_Balance");
					System.out.println(invoiceId + "\t\t" + customerId + "\t\t" + invoiceDate + "\t\t" + itemsNumber
							+ "\t\t" + total_Amount + "\t\t" + paidAmount + "\t\t" + total_Balance);
					System.out.println(
							"--------------------------------------------------------------------------------------------------------------------------------");
				} while (rs.next());
			}
		} catch (Exception ex) {
			System.err.println(ex);
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					System.err.println(e);
				}
			}
		}
	}
	
	
	
	//////////////////////////////////////Show Data///////////////////////////////
	
	public void printInvoiceHeader() {
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

			String sql = "select * from Invoice_header";

			ResultSet resultSet = st.executeQuery(sql);
			int count = 1;
			while (resultSet.next()) {
				System.out.println("=============================== " + count + " ============================");
				System.out.println("Invoice_header_ID = " + resultSet.getString("Invoice_header_ID"));
				System.out.println("Invoice_Id = " + resultSet.getString("Invoice_Id"));
				System.out.println("Invoice_Fax = " + resultSet.getString("Invoice_Fax"));
				System.out.println("Invoice_phone = " + resultSet.getString("Invoice_phone"));
				System.out.println("Invoice_Email = " + resultSet.getString("Invoice_Email"));
				System.out.println("Invoice_Data = " + resultSet.getString("Invoice_Data"));
				count++;
			}

			con.close();
		} catch (Exception ex) {
			System.err.println(ex);
		}
	}

	public static void loadDataFormInvoiceItems() {
		String url = "jdbc:sqlserver://localhost:1433;" + "databaseName=DatabseInvoice;" + "encrypt=true;"
				+ "trustServerCertificate=true";
		String user = "sa";
		String pass = "root";
		Connection con = null;
		try {
			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection(url, user, pass);
			String sql = "SELECT * FROM InvoiceItems ";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (!rs.next()) {
				System.out.println("Items Not Found");
			} else {
				System.out.println("Items Details:");
				System.out.println(
						"--------------------------------------------------------------------------------------------------------------------------------");
				System.out.println(
						"Invoice_Items_ID\tinvoice ID\tItem_Id\tItem_Id\tItem_Name\tUnitPrice\tQuantity\tQty_Amount");
				System.out.println(
						"--------------------------------------------------------------------------------------------------------------------------------");
				do {
					int InvoiceItem_Id = rs.getInt("InvoiceItem_Id");
					int Invoice_Id = rs.getInt("Invoice_Id");
					int Item_Id = rs.getInt("Item_Id");
					String Item_Name = rs.getString("Item_Name");
					double UnitPrice = rs.getInt("UnitPrice");
					int Quantity = rs.getInt("Quantity");
					double Qty_Amount = rs.getFloat("Qty_Amount");
					System.out.println(InvoiceItem_Id + "\t\t" + Invoice_Id + "\t\t" + Item_Id + "\t\t" + Item_Name
							+ "\t\t" + UnitPrice + "\t\t" + Quantity + "\t\t" + Qty_Amount);
					System.out.println(
							"--------------------------------------------------------------------------------------------------------------------------------");
				} while (rs.next());
			}
		} catch (Exception ex) {
			System.err.println(ex);
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					System.err.println(e);
				}
			}
		}
	}

	public static void loadDAataFromInvoice() {
		String url = "jdbc:sqlserver://localhost:1433;" + "databaseName=DatabseInvoice;" + "encrypt=true;"
				+ "trustServerCertificate=true";
		String user = "sa";
		String pass = "root";
		Connection con = null;
		try {
			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection(url, user, pass);
			String sql = "SELECT * FROM Invoices ";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (!rs.next()) {
				System.out.println("Invoice Not Found");
			} else {
				System.out.println("Invoice Details:");
				System.out.println(
						"--------------------------------------------------------------------------------------------------------------------------------");
				System.out.println(
						"Invoice ID\tCustomer ID\tInvoice Date\tNumber of Items\tTotal Amount\tPaid Amount\ttotal Balance");
				System.out.println(
						"--------------------------------------------------------------------------------------------------------------------------------");
				do {
					int invoice_Id = rs.getInt("Invoice_Id");
					int Customer_Id = rs.getInt("Customer_Id");
					String invoice_Date = rs.getString("Invoice_Date");
					String Number_Of_Items = rs.getString("Number_Of_Items");
					double total_Amount = rs.getInt("total_Amount");
					double paid_Amount = rs.getFloat("paid_Amount");
					double totkal_Balance = rs.getFloat("totkal_Balance");
					System.out.println(invoice_Id + "\t\t" + Customer_Id + "\t\t" + invoice_Date + "\t\t"
							+ Number_Of_Items + "\t\t" + total_Amount + "\t\t" + paid_Amount + "\t\t" + totkal_Balance);
					System.out.println(
							"--------------------------------------------------------------------------------------------------------------------------------");
				} while (rs.next());
			}
		} catch (Exception ex) {
			System.err.println(ex);
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					System.err.println(e);
				}
			}
		}
	}

	public void printCustomerDataBase() {
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

			String sql = "select * from customers";
			int count = 1;
			ResultSet resultSet = st.executeQuery(sql);
			while (resultSet.next()) {
				System.out.println("=============================== " + count + " ============================");
				System.out.println("Id = " + resultSet.getString("Customer_Id"));
				System.out.println("customer name = " + resultSet.getString("Customer_Full_Name"));
				System.out.println("phone number = " + resultSet.getString("Customer_Phone_Number"));
				count++;

			}

			con.close();
		} catch (Exception ex) {
			System.err.println(ex);
		}
	}

	public void printinvoiceDataBase() {

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

			String sql = "select * from Invoices";

			ResultSet resultSet = st.executeQuery(sql);
			int count = 1;
			while (resultSet.next()) {
				System.out.println("=============================== " + count + " ============================");
				System.out.println("Id = " + resultSet.getString("Invoice_Id"));
				System.out.println("Customer_Id = " + resultSet.getString("Customer_Id"));
				System.out.println("Invoice_Date = " + resultSet.getString("Invoice_Date"));
				System.out.println("Number_Of_Items = " + resultSet.getString("Number_Of_Items"));
				System.out.println("total_Amount = " + resultSet.getString("total_Amount"));
				System.out.println("total_Balancer = " + resultSet.getString("totkal_Balance"));
				count++;
			}

			con.close();
		} catch (Exception ex) {
			System.err.println(ex);
		}
	}

	public void printInvoiceItems() {

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

			String sql = "select * from InvoiceItems";

			ResultSet resultSet = st.executeQuery(sql);
			int count = 1;
			while (resultSet.next()) {
				System.out.println("=============================== " + count + " ============================");
				System.out.println("Id = " + resultSet.getString("InvoiceItem_Id"));
				System.out.println("Invoice_Id = " + resultSet.getString("Invoice_Id"));
				System.out.println("Item_Id = " + resultSet.getString("Item_Id"));
				System.out.println("Item_Name = " + resultSet.getString("Item_Name"));
				System.out.println("UnitPrice = " + resultSet.getString("UnitPrice"));
				System.out.println("Quantity = " + resultSet.getString("Quantity"));
				System.out.println("Qty_Amount = " + resultSet.getString("Qty_Amount"));
				count++;
			}

			con.close();
		} catch (Exception ex) {
			System.err.println(ex);
		}

	}

	
	

}