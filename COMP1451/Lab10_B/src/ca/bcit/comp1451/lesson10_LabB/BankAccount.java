/**
 * 
 */
package ca.bcit.comp1451.lesson10_LabB;

/**
 * @author Brian Truong
 * Mar. 22, 2020
 * BankAccount.java
 */
public class BankAccount {
	private String name;
	private double balance;
	/**
	 * 
	 */
	public BankAccount(String name, double balance) {
		// TODO Auto-generated constructor stub
		setName(name);
		setBalance(balance);
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		if(name == null || name.isBlank() || name.isEmpty()) {
			name = "unknown name";
		}
		else {
			this.name = name;
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
	
	public void deposit(double amount) throws NegativeAmountException{
		if(amount < 0) {
			throw new NegativeAmountException("The amount is negative");
		}
		else {
			balance += amount;
		}
	}
	
	public void withdraw(double amount) throws InsufficientFundException{
		if(amount >=0 && amount <= getBalance()) {
			balance -= amount;
		}
		else {
			throw new InsufficientFundException("Insufficient Fund");
		}
	}
	
	@Override
	public String toString() {
		return "Name: " + getName() +"\n"+
				"Balance: " + String.format("%.2f",getBalance());
	}
}
