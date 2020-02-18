package ca.bcit.comp1451.assignment1;

/**
 * @author Brian Truong
 *
 */

import java.util.HashMap;
import java.util.Scanner;

public class Bank {
	private String bankName;
	private HashMap<String, Account> hashmap;
	private Scanner input;
	
	/**
	 * Constructor Bank
	 * @param bankName
	 */
	public Bank(String bankName) {
		// TODO Auto-generated constructor stub
		setBankName(bankName);
		hashmap = new HashMap<String, Account>();
		input = new Scanner(System.in);

	}
	/**
	 * 
	 * @param bankName
	 */
	public void setBankName(String bankName) {
		if(bankName == null || bankName.isBlank() || bankName.isEmpty()) {
			throw new IllegalArgumentException("Bank name cannot be null or empty string");
		}
		else {
			this.bankName = bankName;
		}
	}
	/**
	 * 
	 * @return bankName
	 */
	public String getBankName() {
		return bankName;
	}
	/**
	 * 
	 * @param toadd
	 */
	public void addAccount(Account toadd) {
		if(toadd != null) {
			hashmap.put(toadd.getAccountNumber(), toadd);
		}
	}
	/**
	 * 
	 * @param accountNumber
	 * @return object Account
	 */
	public Account getAccount(String accountNumber) {
		accountNumber = formatString(accountNumber);
		Account account = null;
		if(accountNumber != null && hashmap.containsKey(accountNumber)) {
			account = hashmap.get(accountNumber);
			account.displayDetails();
		}
		else {
			throw new IllegalArgumentException("Account number cannot be null");
		}
		return account;
	}
	/**
	 * 
	 * @param name to set customer name
	 */
	public void showTransactions(String name) {
		for(String accountNumber : hashmap.keySet()) {
			if(getAccount(accountNumber).getCustomer().getName().equalsIgnoreCase(name)) {
				getAccount(accountNumber).showTransactions();
			}
		}
	}
	/**
	 * Display details of account numbers
	 */
	public void displayAccountNumbers() {
		for(String accountNumber : hashmap.keySet()) {
			hashmap.get(accountNumber).displayDetails();
			System.out.println();
		}
	}
	/**
	 * Transaction menu
	 */
	public void makeTransaction() {
		
		while(true) {
			System.out.println("Enter your account number: ");
			String accountNumber = formatString(input.next());
			
			if(hashmap.containsKey(accountNumber)) {
				Account acc = getAccount(accountNumber);
				System.out.println("========== Transaction Menu ==========");
				System.out.println("1. Deposit");
				System.out.println("2. Withdraw");
				System.out.println("3. Show Transactions");
				System.out.println();
				System.out.println("Enter your choice: ");
				int choice = input.nextInt();
				switch(choice) {
					case 1:
						System.out.println("Enter the deposit amount: ");
						double amount = input.nextDouble();
						boolean isValidDeposit = acc.deposit(amount);
						if(isValidDeposit) {

							System.out.println("Enter a day:");
							int day = input.nextInt();
							System.out.println("Enter a month:");
							int month = input.nextInt();
							System.out.println("Enter a year:");
							int year = input.nextInt();
							Date date = new Date(day,month,year);
							TransactionRecord transaction = new TransactionRecord(amount, date, accountNumber, TransactionRecord.Type.DEPOSIT);
							acc.addTransaction(transaction);
						}
						break;
					case 2:
						System.out.println("Enter the withdraw amount: ");
						amount = input.nextDouble();
						boolean isValidWithdraw = acc.withdraw(amount);
						if(isValidWithdraw) {
							System.out.println("Enter a day:");
							int day = input.nextInt();
							System.out.println("Enter a month:");
							int month = input.nextInt();
							System.out.println("Enter a year:");
							int year = input.nextInt();
							Date date = new Date(day,month,year);							
							TransactionRecord transaction = new TransactionRecord(amount, date, accountNumber, TransactionRecord.Type.WITHDRAW);
							acc.addTransaction(transaction);
						}
						break;
					case 3:
						System.out.println("Enter your name: ");
						input.nextLine(); //consume new line leftover
						String name = input.nextLine();					
						String getCustomerName = acc.getCustomer().getName();
						boolean isMatched = getCustomerName.equalsIgnoreCase(name);
						if(isMatched) {
							System.out.println();
							System.out.println("***** List of transactions *****");
							acc.showTransactions();
						}
						else {
							System.out.println("Customer name is not matched with account number!!!");
						}
						break;
					default:
						System.out.println("Invalid choice");
				}
				System.out.println();
				System.out.print("Make another transaction ? ");
				String answer = input.next();
				if(!("yes".equalsIgnoreCase(answer) || ("y".equalsIgnoreCase(answer)))) {
					System.out.println("Thank you ! See you again.");
					break;
				}
			}
			else {
				System.out.println("Account number is not found");
				System.out.print("Try again ? ");
				String answer = input.next();
				if(!("yes".equalsIgnoreCase(answer) || ("y".equalsIgnoreCase(answer)))) {
					System.out.println("Thank you ! See you again.");
					break;
				}
			}
		}
	}
	
	public String formatString(String str) {
		String firstLetter = str.toUpperCase().substring(0, 1);
		String theRest = str.toLowerCase().substring(1);
		return firstLetter + theRest;
	}
}
