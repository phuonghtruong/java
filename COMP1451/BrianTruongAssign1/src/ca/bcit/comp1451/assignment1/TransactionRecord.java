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
	/**
	 * 
	 * @param amountInCAD
	 * @param dateIssued
	 * @param accountNumber
	 * @param transactionType
	 */
	public TransactionRecord(double amountInCAD, Date dateIssued, 
			String accountNumber, Type transactionType) {
		// TODO Auto-generated constructor stub
		setAmountInCAD(amountInCAD);
		setDateIssued(dateIssued);
		setAccountNumber(accountNumber);
		setTransactionType(transactionType);
	}

	/**
	 * 
	 * @param amountInCAD
	 */
	public void setAmountInCAD(double amountInCAD) {
		if(amountInCAD <= 0) {
			throw new IllegalArgumentException("Amount cannot be negative or 0");
		}
		else {
			this.amountInCAD = amountInCAD;
		}
	}
	/**
	 * 
	 * @return amountInCAD
	 */
	public double getAmountInCAD() {
		return amountInCAD;
	}
	
	/**
	 * 
	 * @param dateIssued
	 */
	public void setDateIssued(Date dateIssued) {
		if (dateIssued != null) {
			this.dateIssued = dateIssued;
		}
	}
	/**
	 * 
	 * @return dateIssued
	 */
	public Date getDateIssued() {
		return dateIssued;
	}
	/**
	 * 
	 * @param accountNumber
	 */
	public void setAccountNumber(String accountNumber) {
		if(accountNumber == null || accountNumber.isBlank() || accountNumber.isEmpty()) {
			throw new IllegalArgumentException("Account number cannot be null or empty String");
		}
		else {
			this.accountNumber = accountNumber;
		}
	}
	/**
	 * 
	 * @return accountNumber
	 */
	public String getAccountNumber() {
		return accountNumber;
	}
	/**
	 * 
	 * @param transactionType
	 */
	public void setTransactionType(Type transactionType) {
		if(transactionType != Type.DEPOSIT && transactionType != Type.WITHDRAW) {
			throw new IllegalArgumentException("Invalid transaction type");
		}
		else {
			this.transactionType = transactionType;
		}
	}
	/**
	 * 
	 * @return transactionType
	 */
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
