package ca.bcit.comp1451.assignment1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DateTest {

	private Date myDate;
	
	@BeforeEach
	void setUp() throws Exception {
		myDate = new Date(1,1,1);
	}

	@AfterEach
	void tearDown() throws Exception {
		myDate = null;
	}

	@Test
	public void testSetDayValid() {
		myDate.setDay(31);
		assertEquals(31,myDate.getDay());
	}
	
	@Test
	public void testSetDayInvalid() {
		myDate.setDay(0);
		assertEquals(1,myDate.getDay());
	}
	
	@Test
	public void testSetMonthValid() {
		myDate.setMonth(12);
		assertEquals(12,myDate.getMonth());
	}
	
	@Test
	public void testSetMonthInvalid() {
		myDate.setMonth(13);
		assertEquals(1,myDate.getMonth());
	}
	
	@Test
	public void testSetYearValid() {
		myDate.setYear(2019);
		assertEquals(2019,myDate.getYear());
	}
	
	@Test
	public void testSetYearInvalid() {
		myDate.setYear(2021);
		assertEquals(1900,myDate.getYear());
	}

	@Test
	public void testDisplayDateWithDayMoreThanTen() {
		myDate.setDay(15);
		myDate.setMonth(2);
		myDate.setYear(2019);
		assertEquals("15/Feburary/2019",myDate.displayDate());
	}
	
	@Test
	public void testDisplayDateWithDayLessThanTen() {
		myDate.setDay(1);
		myDate.setMonth(9);
		myDate.setYear(2018);
		assertEquals("01/September/2018",myDate.displayDate());
	}
}
