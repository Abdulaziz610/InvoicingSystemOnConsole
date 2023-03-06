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
	ArrayList<invoice> invoicList = new ArrayList<invoice>();
	
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
	
	
	
}