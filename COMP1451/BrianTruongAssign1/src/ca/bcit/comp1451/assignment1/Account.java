package ca.bcit.comp1451.assignment1;

/**
 * @author Brian Truong
 *
 */

import java.util.ArrayList;

public class Account {

	private Customer customer;
	private String accountNumber;
	private Date accountDateCreated;
	private double balance;
	private ArrayList<TransactionRecord> listOfTransactions;
	
	private static int accountIndex = 1000;
	
	public Account(Customer customer, Date accountDateCreated, double balance) {
		// TODO Auto-generated constructor stub
		accountIndex += 1;
		setCustomer(customer);
		setAccountDateCreated(accountDateCreated);
		setBalance(balance);
		setAccountNumber();
		listOfTransactions = new ArrayList<TransactionRecord>();
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		if(customer != null) {
			this.customer = customer;
		}
	}

	/**
	 * @return the accountNumber
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber() {		
		this.accountNumber = "A" + Integer.toString(accountIndex);
	}

	/**
	 * @return the accountDateCreated
	 */
	public Date getAccountDateCreated() {
		return accountDateCreated;
	}

	/**
	 * @param accountDateCreated the accountDateCreated to set
	 */
	public void setAccountDateCreated(Date accountDateCreated) {
		if(accountDateCreated != null) {
			this.accountDateCreated = accountDateCreated;
		}
	}

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		if(balance < 0) {
			throw new IllegalArgumentException("balance cannot be negative");
		}
		else {
			this.balance = balance;
		}
	}
    /**
     * 
     * @param amount
     * @return result
     */
	public boolean deposit(double amount) {
		boolean result = false;
		if(amount > 0) {
			double new_balance = getBalance()+amount;
			setBalance(new_balance);
			result = true;
		}
		else {
			System.out.println("The amount was invalid");
			result = false;
		}
		return result;
	}
	/**
	 * 
	 * @param amount
	 * @return result
	 */
	public boolean withdraw(double amount) {
		boolean result = false;
		if(amount > 0 && amount <= getBalance()) {
			double new_balance = getBalance()-amount;
			setBalance(new_balance);
			result = true;
		}
		else {
			System.out.println("The amount was invalid");
			result = false;
		}
		return result;
	}
	/**
	 * 
	 * @param transaction
	 */
	public void addTransaction(TransactionRecord transaction) {
		if(transaction != null) {
			listOfTransactions.add(transaction);
		}
	}
	/**
	 * Method show all transactions
	 */
	public void showTransactions() {
		for(TransactionRecord transaction : listOfTransactions) {
			transaction.displayDetails();
		}
	}
	
	public void displayDetails() {
		System.out.println("Customer full name: " + getCustomer().getName());
		System.out.println("Account number: " + getAccountNumber());
		System.out.println("Balance: " + getBalance());
		System.out.println("Date of account created: " + getAccountDateCreated().displayDate());
	}
	
}
