package ca.bcit.comp1451.assignment1;

/**
 * @author Brian Truong
 *
 */

public class TransactionRecord {

	private double amountInCAD;
	private Date dateIssued;
	private String accountNumber;
	
	public enum Type {
		DEPOSIT,
		WITHDRAW
	};
	
	private Type transactionType;
	
	public TransactionRecord(double amountInCAD, Date dateIssued, 
			String accountNumber, Type transactionType) {
		// TODO Auto-generated constructor stub
		setAmountInCAD(amountInCAD);
		setDateIssued(dateIssued);
		setAccountNumber(accountNumber);
		setTransactionType(transactionType);
	}

	public void setAmountInCAD(double amountInCAD) {
		if(amountInCAD <= 0) {
			throw new IllegalArgumentException("Amount cannot be negative or 0");
		}
		else {
			this.amountInCAD = amountInCAD;
		}
	}
	
	public double getAmountInCAD() {
		return amountInCAD;
	}
	
	public void setDateIssued(Date dateIssued) {
		if (dateIssued != null) {
			this.dateIssued = dateIssued;
		}
	}
	
	public Date getDateIssued() {
		return dateIssued;
	}
	
	public void setAccountNumber(String accountNumber) {
		if(accountNumber == null || accountNumber.isBlank() || accountNumber.isEmpty()) {
			throw new IllegalArgumentException("Account number cannot be null or empty String");
		}
		else {
			this.accountNumber = accountNumber;
		}
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public void setTransactionType(Type transactionType) {
		if(transactionType != Type.DEPOSIT && transactionType != Type.WITHDRAW) {
			throw new IllegalArgumentException("Invalid transaction type");
		}
		else {
			this.transactionType = transactionType;
		}
	}
	
	public Type getTransactionType() {
		return transactionType;
	}
	
	public void displayDetails() {
		System.out.println();
		System.out.println("Account Number : " + getAccountNumber());
		System.out.println("Type of transaction : " + getTransactionType().toString());
		System.out.println("Amount : " + getAmountInCAD());
		System.out.println("Date Issued : " + getDateIssued().displayDate());
	}
}
