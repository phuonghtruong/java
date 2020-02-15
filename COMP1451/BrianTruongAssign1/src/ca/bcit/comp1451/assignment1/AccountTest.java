package ca.bcit.comp1451.assignment1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AccountTest {

	private Customer customer;
	private Date birthday;
	private Date accDateCreated;
	private Account acc1;
	private Account acc2;
	@BeforeEach
	void setUp() throws Exception {
		birthday = new Date(12,9,1990);
		accDateCreated = new Date(20,1,2020);
		customer = new Customer("Brian Truong", "Vancouver", birthday );
		acc1 = new Account(customer, accDateCreated, 100);
	}

	@AfterEach
	void tearDown() throws Exception {
		acc1 = null;
		acc1 = null;
	}

	@Test
	public void testGetAccountNumber() {
		acc2 = new Account(customer, accDateCreated, 100);
		assertEquals("A1002", acc2.getAccountNumber());
	}

	@Test
	public void testSetBalancePositive() {
		acc1.setBalance(200.34);
		assertEquals(200.34, acc1.getBalance());
	}
	
	@Test
	public void testSetBalanceZero() {
		acc1.setBalance(0);
		assertEquals(0, acc1.getBalance());
	}
	
	@Test
	public void testSetBalanceNegative() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {			
			acc1.setBalance(-150.75);
		});
	}
	
	@Test
	public void testDepositPositive() {
		assertEquals(true,acc1.deposit(137));
		assertEquals(237,acc1.getBalance());
	}
	
	@Test
	public void testDepositNegative() {
		assertEquals(false,acc1.deposit(-1));
	}
	
	@Test
	public void testDepositZero() {
		assertEquals(false,acc1.deposit(0));
	}
	
	@Test
	public void testWithdrawValidPositive() {
		assertEquals(true,acc1.withdraw(50));
		assertEquals(50,acc1.getBalance());
	}
	
	@Test
	public void testWithdrawInvalidPositive() {
		assertEquals(false,acc1.withdraw(150));
	}
	
	@Test
	public void testWithdrawNegative() {
		assertEquals(false,acc1.withdraw(-1));
	}
	
	@Test
	public void testWithdrawZero() {
		assertEquals(false,acc1.withdraw(0));
	}
}
