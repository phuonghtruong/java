/**
 * 
 */
package ca.bcit.comp1451.lesson10_LabB;

/**
 * @author Brian Truong
 * Mar. 22, 2020
 * Bank.java
 */
import java.util.Scanner;

public class Bank {
	private Scanner scanner;
	private BankAccount account;
	/**
	 * 
	 */
	public Bank(BankAccount account) {
		// TODO Auto-generated constructor stub
		setAccount(account);
		scanner = new Scanner(System.in);
	}

	
	/**
	 * @return the account
	 */
	public BankAccount getAccount() {
		return account;
	}


	/**
	 * @param account the account to set
	 */
	public void setAccount(BankAccount account) {
		if(account != null)
		{
			this.account = account;
		}
	}

	public void processTransaction() {
		while(true) {
			System.out.println("Choose the transaction type: ");
			System.out.println("1 deposit");
			System.out.println("2 withdraw");
			System.out.println("3 display information");
			
			int input = scanner.nextInt();
			switch(input) {
			case 1:
				try {
					System.out.println("Enter the amount: ");
					double amount = scanner.nextDouble();
					getAccount().deposit(amount);
				}catch (NegativeAmountException e1){
					System.out.println(e1.getMessage());
				}
				break;
			case 2:
				try {
					System.out.println("Enter the amount: ");
					double amount = scanner.nextDouble();
					getAccount().withdraw(amount);
				}catch (InsufficientFundException e2){
					System.out.println(e2.getMessage());
				}
				break;
			case 3:
				System.out.println(getAccount());
				break;
			default:
				System.out.println("Invalid transaction type");
			}
			
			System.out.println("Do you want to make another transaction ? (y|n)");
			String ans = scanner.next();
			while(!(ans.equalsIgnoreCase("y") || ans.equalsIgnoreCase("n"))) {
				System.out.println("Invalid choice");
				ans = scanner.next();
			}
			if("n".equalsIgnoreCase(ans)) {
				System.out.println("Thank you and see you again");
				break;
			}
			
		}
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount acc = new BankAccount("Brian", 25.12);
		Bank b1 = new Bank(acc);
		b1.processTransaction();
	}

}
