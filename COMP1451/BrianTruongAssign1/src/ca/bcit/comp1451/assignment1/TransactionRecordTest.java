package ca.bcit.comp1451.assignment1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


import ca.bcit.comp1451.assignment1.TransactionRecord.Type;

class TransactionRecordTest {

	private Date d1;
	private TransactionRecord t1;
	@BeforeEach
	void setUp() throws Exception {
		d1 = new Date(1,1,2019);
		t1 = new TransactionRecord(1,d1,"A001",Type.DEPOSIT);
	}

	@AfterEach
	void tearDown() throws Exception {
		t1 = null;
	}

	@Test
	public void testSetAmountInCADWithZero() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {			
			t1.setAmountInCAD(0);
		});
	}
	
	@Test
	public void testSetAmountInCADValid() {
		t1.setAmountInCAD(2.5);
		assertEquals(2.5,t1.getAmountInCAD());
	}
	
	@Test 
	public void testSetAccountNumberWithEmpty() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {			
			t1.setAccountNumber("");
		});
	}
	
	@Test
	public void testSetAccountNumberWithBlank() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {			
			t1.setAccountNumber("    ");
		});
	}
	
	@Test
	public void testSetAccountNumberWithNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {			
			t1.setAccountNumber(null);
		});
	}
	
	@Test
	public void testSetAccountNumber() {
		t1.setAccountNumber("A001");
		assertEquals("A001",t1.getAccountNumber());
	}
	
	@Test
	public void testSetTransactionTypeDeposit() {
		t1.setTransactionType(Type.DEPOSIT);
		assertEquals(Type.DEPOSIT,t1.getTransactionType());
	}
	
	@Test
	public void testSetTransactionTypeWithdraw() {
		t1.setTransactionType(Type.WITHDRAW);
		assertEquals(Type.WITHDRAW,t1.getTransactionType());
	}	

}
