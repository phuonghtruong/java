package ca.bcit.comp1451.session04LabB;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BankAccountTestClass {

	private BankAccount bankAcco1;
	private BankAccount bankAcco2;

	@BeforeEach
	void setUp() throws Exception {
		bankAcco1 = new BankAccount("colleen", 100.50);
		bankAcco2 = new BankAccount("Sam");
	}

	@AfterEach
	void tearDown() throws Exception {
		bankAcco1 = null;
		bankAcco2 = null;
	}


	@Test
	   public void testConstructorTwoParameters()
	   {
	       assertEquals(100.5, bankAcco1.getBalance(), .01);
	   }
		@Test
		public void testConstructorNAmeNegativeNull() {
			BankAccount account = new BankAccount(null,100);
			assertEquals("unknown", account.getName());
		}
		@Test
		public void testConstructorNAmeNegativeEmptyString() {
			BankAccount account = new BankAccount("",100);
			assertEquals("unknown", account.getName());
		}

		@Test
	   public void testConstructorOneParameter()
	   {
	       assertEquals(0.0, bankAcco2.getBalance(), .01);
	   }

		@Test
	   public void testConstructorNegativeTest()
	   {
	       BankAccount bankAcco3 = new BankAccount("Sharon", -100.0);
	       assertEquals(0.0, bankAcco3.getBalance(), .01);
	   }

		@Test
	   public void testDepositPositive()
	   {
	       bankAcco1.deposit(200.10);
	       assertEquals(300.60, bankAcco1.getBalance(), .01);
	   }
		@Test
		public void testSetNameNegativeNull() {
			
			bankAcco1.setName(null);
			assertEquals("unknown",bankAcco1.getName() );
		}
		
		@Test
		public void testSetNameNegativeEmptyString() {
			
			bankAcco2.setName("");
			assertEquals("unknown",bankAcco2.getName() );
		}
		@Test
		public void testSetNamePositive() {
			
			bankAcco2.setName("Bob");
			assertEquals("Bob",bankAcco2.getName() );
		}

		@Test
	   public void testDepositNegative()
	   {
	       bankAcco1.deposit(-50.0);
	       assertEquals(100.5, bankAcco1.getBalance(), .01);
	   }

		@Test
	   public void testWithdrawPositive()
	   {
	       bankAcco1.withdraw(60.0);
	       assertEquals(40.5, bankAcco1.getBalance(), .01);
	   }
	   
		@Test
	   public void testWithdrawNegativeOverBalance()
	   {
	       bankAcco1.withdraw(500);
	       assertEquals(100.5, bankAcco1.getBalance(), .01);
	   }

		@Test
	   public void testWithdrawNegativeAmount()
	   {
	       bankAcco1.withdraw(-60);
	       assertEquals(100.5, bankAcco1.getBalance(), .01);
	   }

		@Test
	   public void testApplyInterestPositive()
	   {
	       bankAcco1.applyInterest();
	       assertEquals(105.525, bankAcco1.getBalance(), .01);
	   }

		@Test
	   public void testApplyInterestNegative()
	   {
	       bankAcco2.applyInterest();
	       assertEquals(0.0, bankAcco2.getBalance(), .01);
	   }

		@Test
	   public void testApplyInterestTwicePositive()
	   {
	       bankAcco1.applyInterest();
	       bankAcco1.applyInterest();
	       assertEquals(110.80, bankAcco1.getBalance(), .01);
	   }
		@Test
	   public void testNewGetBalance()
	   {
	       bankAcco2.deposit(100.95);
	       assertEquals(100.95, bankAcco2.getBalance(), 0.1);
	   }


}
