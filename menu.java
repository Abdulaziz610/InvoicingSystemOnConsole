

import java.util.ArrayList;

public class menu {
	private ArrayList<String> menuItems;
	
	// constructor
	public menu() {
	    menuItems = new ArrayList<>();
	}

	// add menu item
	public void addMenuItem(String item) {
	    menuItems.add(item);
	}

	// remove menu item
	public void removeMenuItem(String item) {
	    menuItems.remove(item);
	}

	// display menu
	public void showMenu() {
	    for (int i = 0; i < menuItems.size(); i++) {
	        System.out.println((i + 1) + "-" + menuItems.get(i));
	    }
	}

}