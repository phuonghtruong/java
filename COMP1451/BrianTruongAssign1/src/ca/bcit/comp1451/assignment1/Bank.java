package ca.bcit.comp1451.assignment1;

/**
 * @author Brian Truong
 *
 */

import java.util.HashMap;
import java.util.Calendar;
import java.util.Scanner;

public class Bank {
	private String bankName;
	private HashMap<String, Account> hashmap;
	private Scanner input;
	
	
	public Bank(String bankName) {
		// TODO Auto-generated constructor stub
		setBankName(bankName);
		hashmap = new HashMap<String, Account>();
		input = new Scanner(System.in);

	}

	public void setBankName(String bankName) {
		if(bankName == null || bankName.isBlank() || bankName.isEmpty()) {
			throw new IllegalArgumentException("Bank name cannot be null or empty string");
		}
		else {
			this.bankName = bankName;
		}
	}
	
	public String getBankName() {
		return bankName;
	}
	
	public void addAccount(Account toadd) {
		if(toadd != null) {
			hashmap.put(toadd.getAccountNumber(), toadd);
		}
	}
	
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
	
	public void showTransactions(String name) {
		for(String accountNumber : hashmap.keySet()) {
			if(getAccount(accountNumber).getCustomer().getName().equalsIgnoreCase(name)) {
				getAccount(accountNumber).showTransactions();
			}
		}
	}
	
	public void displayAccountNumbers() {
		for(String accountNumber : hashmap.keySet()) {
			hashmap.get(accountNumber).displayDetails();
			System.out.println();
		}
	}
	
	public void makeTransaction() {
		
		while(true) {
			System.out.println("Enter your account number: ");
			String accountNumber = input.next();
			
			if(hashmap.containsKey(formatString(accountNumber))) {
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
						if(getAccount(accountNumber).deposit(amount)) {
							while(true) {
								System.out.println("Enter a day:");
								int day = input.nextInt();
								System.out.println("Enter a month:");
								int month = input.nextInt();
								System.out.println("Enter a year:");
								int year = input.nextInt();
								boolean isValidDate = isValidDateTransaction(accountNumber, day, month, year);
								if(isValidDate) {
									Date date = new Date(day,month,year);
									TransactionRecord transaction = new TransactionRecord(amount, date, accountNumber, TransactionRecord.Type.DEPOSIT);
									getAccount(accountNumber).addTransaction(transaction);
									break;
								}
								else {
									System.out.println("Transaction date is not valid ! Please enter again.");
								}
							}
						}
						break;
					case 2:
						System.out.println("Enter the withdraw amount: ");
						amount = input.nextDouble();
						if(getAccount(accountNumber).withdraw(amount)) {
							while(true) {
								System.out.println("Enter a day:");
								int day = input.nextInt();
								System.out.println("Enter a month:");
								int month = input.nextInt();
								System.out.println("Enter a year:");
								int year = input.nextInt();
								boolean isValidDate = isValidDateTransaction(accountNumber, day, month, year);
								if(isValidDate) {
									Date date = new Date(day,month,year);							
									TransactionRecord transaction = new TransactionRecord(amount, date, accountNumber, TransactionRecord.Type.WITHDRAW);
									getAccount(accountNumber).addTransaction(transaction);
									break;
								}
								else {
									System.out.println("Transaction date is not valid ! Please enter again.");
								}
							}
						}
						break;
					case 3:
						System.out.println("Enter your name: ");
						String name = input.nextLine();
						getAccount(accountNumber).showTransactions();
						break;
					default:
						System.out.println("Invalid choice");
				}
				System.out.println();
				System.out.print("Make another transaction ? ");
				String answer = input.next();
				if(answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")) {
					System.out.println("Thank you ! See you again.");
					break;
				}
			}
			else {
				System.out.println("Account number is not found");
				System.out.print("Try again ? ");
				String answer = input.next();
				if(answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("n")) {
					System.out.println("Thank you ! See you again.");
					break;
				}
			}
		}
	}
	
	public boolean isValidDateTransaction(String accountNumber, int day, int month, int year) {
		boolean isValid = false;
		
		int yearCreated = hashmap.get(accountNumber).getAccountDateCreated().getYear();
		int monthCreated = hashmap.get(accountNumber).getAccountDateCreated().getMonth();
		int dayCreated = hashmap.get(accountNumber).getAccountDateCreated().getDay();
		
		int yearCurrent = Calendar.getInstance().get(Calendar.YEAR);
		int monthCurrent = Calendar.getInstance().get(Calendar.MONTH);
		int dayCurrent = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		
		if(year > yearCreated && year < yearCurrent) {
			isValid = true;
		}
		
		else if (year == yearCreated && year != yearCurrent) {
			if((month > monthCreated) || (month == monthCreated && day >= dayCreated)) {
				isValid = true;
			}
		}
		else if (year == yearCurrent && year != yearCreated) {
			if((month < monthCurrent) || (month == monthCurrent && day <= dayCurrent)) {
				isValid = true;
			}
		}
		else if (year == yearCurrent && year == yearCreated) {
			if((month < monthCurrent) || (month == monthCurrent && day <= dayCurrent)) {
				isValid = true;
			}
		}
		return isValid;		
	}
	
	public String formatString(String str) {
		String firstLetter = str.toUpperCase().substring(0, 1);
		String theRest = str.toLowerCase().substring(1);
		return firstLetter + theRest;
	}
}
