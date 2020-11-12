/**
 * 
 */
package ca.bcit.comp1451.session04LabA;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author A00919230
 *
 */
class TestTime {
	private Time myTime;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		myTime = new Time(10, 10, 10);

	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		myTime = null;

	}
	
	@Test
	public void testConstructorTimeThreeParameters(){
		Time myTime3 = new Time(25,60,60);
		assertEquals(0, myTime3.getHours());
		assertEquals(0, myTime3.getMinutes());
		assertEquals(0, myTime3.getSeconds());
	}

	@Test
	public void testConstructorTimeStringParameterTwoIntegers(){
		Time myTime1 = new Time("23:59");
		assertEquals(23, myTime1.getHours());
		assertEquals(59, myTime1.getMinutes());
	}
	
	@Test
	public void testConstructorTimeStringParameterThreeIntegers(){
		Time myTime1 = new Time("23:59:59");
		assertEquals(23, myTime1.getHours());
		assertEquals(59, myTime1.getMinutes());
		assertEquals(59, myTime1.getSeconds());
	}
	
	@Test
	public void testSetHoursValidPositive(){
		myTime.setHours(1);
		assertEquals(1, myTime.getHours());
	}
	
	
	@Test
	public void testSetHoursInvalidPositive(){
		myTime.setHours(25);
		assertEquals(10, myTime.getHours());
	}
	
	@Test
	public void testSetHoursBoundaryTwentyFour(){
		myTime.setHours(24);
		assertEquals(10, myTime.getHours());
	}
	
	@Test
	public void testSetHoursBoundaryZero(){
		myTime.setHours(0);
		assertEquals(0, myTime.getHours());
	}
	
	@Test
	public void testSetHoursNegative() {
		myTime.setHours(-1);
		assertEquals(10, myTime.getHours());
	}
	
	
	@Test
	public void testSetMinuteValidPositive(){
		myTime.setMinutes(1);
		assertEquals(1, myTime.getMinutes());
	}
	
	@Test
	public void testSetMinuteInValidPositive(){
		myTime.setMinutes(61);
		assertEquals(10, myTime.getMinutes());
	}
	
	@Test
	public void testSetMinuteBoundarySixty(){
		myTime.setMinutes(60);
		assertEquals(10, myTime.getMinutes());
	}
	
	@Test
	public void testSetMinuteBoundaryZero(){
		myTime.setMinutes(0);
		assertEquals(0, myTime.getMinutes());
	}
	
	@Test
	public void testSetMinutesInvalidNegative() {
		myTime.setMinutes(-1);
		assertEquals(10, myTime.getMinutes());
	}
	

	@Test
	public void testSetSecondsValidPositive(){
		myTime.setSeconds(1);
		assertEquals(1, myTime.getSeconds());
	}
	
	@Test
	public void testSetSecondsInvalidPositive(){
		myTime.setSeconds(61);
		assertEquals(10, myTime.getSeconds());
	}
	
	@Test
	public void testSetSecondsBoundarySixty(){
		myTime.setSeconds(60);
		assertEquals(10, myTime.getSeconds());
	} 
	
	@Test
	public void testSetSecondsBoundaryZero(){
		myTime.setSeconds(0);
		assertEquals(0, myTime.getSeconds());
	} 
	
	@Test
	public void testSetSecondsInvalidNegative() {
		myTime.setSeconds(-1);
		assertEquals(10, myTime.getSeconds());
	}
	
	@Test
	public void testInSecondsPositive() {
		int result = myTime.inSeconds();
		assertEquals(36610, result);
	}
	
	@Test
	public void testInSecondsNegative() {
		myTime.setHours(-1);
		int result = myTime.inSeconds();
		assertEquals(36610, result);
	}
	
	@Test
	public void testInSecondsZero() {
		myTime.setHours(0);
		myTime.setMinutes(0);
		myTime.setSeconds(0);
		assertEquals(0, myTime.inSeconds());
	}
	
	@Test
	public void testGetTimePlusValidSecond() {
		myTime.setHours(0);
		myTime.setMinutes(59);
		myTime.setSeconds(59);
		String result = myTime.getTimePlus(2);
		assertEquals("01:00:01", result);
	}
	
	@Test
	public void testGetTimePlusInvalidSecond() {
		String result = myTime.getTimePlus(-1);
		assertEquals("00:00:00", result);
	}
	
	@Test
	public void testGetTimePlusZeroSecond() {
		String result = myTime.getTimePlus(0);
		assertEquals("10:10:10", result);
	}
	
}
