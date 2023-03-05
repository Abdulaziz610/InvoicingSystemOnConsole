import java.util.Scanner;

public class MainMenu {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("\t\t\t\t\t========================== Welcome ==========================");
		
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


	      case 2:

	   
	      case 3:
	    	  
	    	  System.out.println("======= New Invoice =======");

	        break;
	      case 4:
	    	  
	    	  System.out.println("======= Statistics =======");
		        break;
	      case 5:
	    	  System.out.println("======= All Invoices =======");
		        break;
	      case 6:
	    	  System.out.println("======= Search (1) Invoice =======");
	    	  break;
	      case 7:
	    	  System.out.println("======= Program Statistics =======");
		        break;
	      case 8:
	    	  System.out.print("======= Are you sure you want to exit? press Y: ");
	    	  String userInput = sc.next();
	    	  if(userInput.equalsIgnoreCase("y")) {
	    		  System.out.println("Thank You");
	    		  choice = false;
		        break;

	    	}
		
		
		}
	}


}