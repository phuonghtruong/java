/**
 * 
 */
package ca.bcit.comp1451.session04LabB;

/**
 * @author Brian Truong
 *
 */
public class BankAccount {

	private String name;
	private double balance;
	
	private static final double INTEREST_RATE = 0.05;
	/**
	 * 
	 */
	public BankAccount(String name) {
		setName(name);
	}

	public BankAccount(String name, double balance) {
		setName(name);
		setBalance(balance);
	}
	
	public String getName() {
		return name;
	}
	
	public double getBalance() {
		return balance;
	}
	
	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		if(name == null || name.isEmpty() || name.isBlank()) {
			this.name = "unknown";
		}
		else {
			this.name = name;
		}
	}
	
	/**
	 * 
	 * @param balance
	 */
	public void setBalance(double balance) {
		if(balance >= 0) {
			this.balance = balance;
		}
	}
	
	/**
	 * 
	 * @param amountOfMoney
	 */
	public void deposit(double amountOfMoney) {
		if(amountOfMoney >= 0) {
			this.balance += amountOfMoney; 
		}
	}
	
	/**
	 * 
	 * @param amountOfMoney
	 */
	public void withdraw(double amountOfMoney) {
		if(amountOfMoney >= 0 && amountOfMoney <= balance) {
			this.balance -= amountOfMoney;
		}
	}
	
	public void applyInterest() {
		this.balance += this.balance * INTEREST_RATE;
	}
	
}
