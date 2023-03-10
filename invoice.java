
import java.util.*;

public class invoice {

	private String customerName;
	private String phoneNumber;
	private Date invoiceDate;
	private int invoiceNumber;
	private int invoiceFax;
	private int invoiceTel;
	private String invEmail;
	private String invWebsite;
	private int numberOfItems;
	private double totalAmount;
	private double paidAmount;
	private double balance;
 
	ArrayList<item> itemsList = new ArrayList<item>();

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public int getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(int invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public int getNumberOfItems() {
		return numberOfItems;
	}

	public void setNumberOfItems(int numberOfItems) {
		this.numberOfItems = numberOfItems;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public double getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(double paidAmount) {
		this.paidAmount = paidAmount;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public ArrayList<item> getItemsList() {
		return itemsList;
	}

	public void setItemsList(ArrayList<item> itemsList) {
		this.itemsList = itemsList;
	}

	public int getInvoiceFax() {
		return invoiceFax;
	}

	public void setInvoiceFax(int invoiceFax) {
		this.invoiceFax = invoiceFax;
	}

	public int getInvoiceTel() {
		return invoiceTel;
	}

	public void setInvoiceTel(int invoiceTel) {
		this.invoiceTel = invoiceTel;
	}

	public String getInvEmail() {
		return invEmail;
	}

	public void setInvEmail(String invEmail) {
		this.invEmail = invEmail;
	}

	public String getInvWebsite() {
		return invWebsite;
	}

	public void setInvWebsite(String invWebsite) {
		this.invWebsite = invWebsite;
	}
	
	
	
	
}