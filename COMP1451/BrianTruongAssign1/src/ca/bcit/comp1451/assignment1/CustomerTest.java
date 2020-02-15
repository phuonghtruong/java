package ca.bcit.comp1451.assignment1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerTest {
	
	private Customer c1;
	private Date dateOfBirth;

	@BeforeEach
	void setUp() throws Exception {
		dateOfBirth = new Date(5,7,1992);
		c1 = new Customer("Lilian", "SouthBank", dateOfBirth);
	}

	@AfterEach
	void tearDown() throws Exception {
		c1 = null;
	}

	@Test
	void testSetNameWithNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {			
			c1.setName(null);
		});
	}

	@Test
	void testSetNameWithEmpty() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {			
			c1.setName("");
		});
	}
	
	@Test
	void testSetNameWithBlank() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {			
			c1.setName("  ");
		});
	}
	
	@Test
	void testSetAddressWithNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {			
			c1.setAddress(null);
		});
	}

	@Test
	void testSetAddressWithEmpty() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {			
			c1.setAddress("");
		});
	}
	
	@Test
	void testSetAddressWithBlank() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {			
			c1.setAddress("  ");
		});
	}
	
	
}
