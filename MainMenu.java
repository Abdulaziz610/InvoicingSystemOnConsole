import java.util.Scanner;

public class MainMenu {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		System.out.println("\t\t\t\t\t========================== Welcome ==========================");
		Main mainMethod = new Main();
		
		 String user = "sa";
		 String pass = "root";
		 boolean passwordC = true ;
		 while (passwordC)
		 {
		 System.out.print("Enter Username: ");
		 String username = sc.next();
		 System.out.print("Enter Password: ");
		 String password = sc.next();

		 if (username.equals(user) && password.equals(pass))
		 {
			 passwordC = false ;
		 }
		 else if (username != (user) && password != (pass)) 
		 {
		 System.out.println("Worng Username and Password ");
		 
		 }

	 }
	
		boolean choice = true;
		while(choice) {
		System.out.println("1-Shop Settings");
		System.out.println("2-Manage Shop Items");
		System.out.println("3-Create New Invoice");
		System.out.println("4-Report: Statistics");
		System.out.println("5-Report: All Invoices");
		System.out.println("6-Search (1) Invoice");
		System.out.println("7-Program Statistics");
		System.out.println("8-Exit");
		
		System.out.print("\nChoose your option from the menu: ");
		int option = sc.nextInt();
		
	    switch (option) {
	      case 1:
	    	  boolean choice1 = true;
	    	  while(choice1) {
	    		System.out.println("------------------------------------------------------------");
		        System.out.println("1. Load Data (Items and invoices)");
		        System.out.println("2. Set Shop Name");
		        System.out.println("3. Set Invoice Header (Tel / Fax / Email / Website)");
		        System.out.println("4. Go Back");
		        System.out.println("------------------------------------------------------------");
		        System.out.print("Enter Your Choice: ");
		        int userOp = sc.nextInt();
		        System.out.println("------------------------------------------------------------");
		    	 if(userOp == 1) {
		    		 mainMethod.loadDataFormInvoiceItems();
		    		 mainMethod.loadDAataFromInvoice();
		    		 
		    	  }
	    	  if(userOp == 2) {
	    		  mainMethod.addShop();
	    		  choice1 = true;
	    	  }
	    	  else
	    	  if(userOp == 3) {
	    		  mainMethod.invoiceheader();
	    			choice1 = true;
	    	  }
	    	  else
	    	  if(userOp == 4) {
	    		  choice1 = false;
	    			
	    	  }
	   }
	        break;
	      case 2:
	    	  boolean choice2 = true;
	    	  while(choice2) {
	    	  System.out.println("------------------------------------------------------------");
	          System.out.println("1. Add Items");
	    	  System.out.println("2. Delete Items");
	    	  System.out.println("3. Change Item Price");
	    	  System.out.println("4. Report All Items");
	    	  System.out.println("5. Go Back");
	    	  System.out.println("------------------------------------------------------------");
		      System.out.print("Enter Your Choice: ");
		      int userOp = sc.nextInt();
		      System.out.println("------------------------------------------------------------");
		      
		      
	    	  if(userOp == 1) {
	    		  System.out.println(" Item Details: ");
	    		  mainMethod.addInvoiceItems();
				  choice2 = true;
	    	
	    	  }
	    	  
	    	  if(userOp == 2) {
					System.out.print("Enter ID of the item to bo deleted: ");
				mainMethod.deletDataBase();
					
	    		  choice2 = true;
	    	  }
	    	  if(userOp == 3) {
	    		  System.out.print("Enter ID of the item to change its price: ");
	    		  mainMethod.updateDataBsePrice();
	    		 choice2 = true;
	    	  }
		      
		      if(userOp == 4) {
	    		  System.out.println("==================== Report Item ====================");
	    		 choice2 = true;
	    	  }
	    	  if(userOp == 5) {
	    		  choice2 = false;
	    	  }
	    	  
	   }
	        break;
	      case 3:
	    	  mainMethod.newCustomer();
	    	  System.out.println("======= New Invoice =======");
	    	  mainMethod.addInvoice();
	    	  choice = true;

	        break;
	      case 4:
	    	  
	    	  System.out.println("======= Statistics =======");
	    	  System.out.println("======= Customer =======");
	    	  mainMethod.printCustomerDataBase();
	    	  System.out.println("======= Invoice =======");
	    	  mainMethod.printinvoiceDataBase();
	    	  System.out.println("======= Item =======");
	    	  mainMethod.printInvoiceItems();
	    	  System.out.println("======= Invoice Header =======");
	    	  mainMethod.printInvoicingHeader();
		        break;
	      case 5:
	    	  System.out.println("======= All Invoices =======");
	    	  //////////////////////
		        break;
	      case 6:
	    	  System.out.println("======= Search (1) Invoice =======");
	    	  System.out.println("Enter an item to be searched: ");
	    	  //////////////////////
	    	  break;
	      case 7:
	    	  System.out.println("======= Program Statistics =======");
	    	  ///////////////////////////
		        break;
	      case 8:
	    	  System.out.print("======= Are you sure you want to exit? press Y: ");
	    	  //////////////////////////////
	    	  String userInput = sc.next();
	    	  if(userInput.equalsIgnoreCase("y")) {
	    		  System.out.println("Thank You");
	    		  choice = false;
	    	  }
		        break;

	    	}
		
		
		}
	}


}