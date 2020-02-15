package ca.bcit.comp1451.assignment1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BankTest {

	private Bank b1;
	@BeforeEach
	void setUp() throws Exception {
		b1 = new Bank("THP");
	}

	@AfterEach
	void tearDown() throws Exception {
		b1 = null;
	}

	@Test
	void testSetBankNameWithNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {			
			b1.setBankName(null);
		});
	}

	@Test
	void testSetBankNameWithEmpty() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {			
			b1.setBankName("");
		});
	}
	
	@Test
	void testSetBankNameWithBlank() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {			
			b1.setBankName("  ");
		});
	}
	
	@Test
	void testSetBankNameValid() {
		b1.setBankName("OMG");
		assertEquals("OMG", b1.getBankName());
	}

}
