
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.InvocationTargetException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * 
 */

/**
 * @author Rana
 *
 */
public class PoliceOfficerTest {
    private static Grader grader = new Grader(18);

    /* (non-Javadoc)
     * @see GeneralSpecificationsTest#setUpBeforeClass()
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("Test Police Officer start");
    }

    /* (non-Javadoc)
     * @see GeneralSpecificationsTest#tearDownAfterClass()
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("PoliceOfficer test class Score: " + grader.getMarks() + " / " + grader.getMax());
    }

    @Test
    public void testOfficerName() {
        testField(PoliceOfficer.class,"officerName",String.class, new String[] {"private",},new String []{"static","final",});
        testMethod(PoliceOfficer.class,"getOfficerName",String.class, new String[] {"public"},new String[] {"static", "final"});
        testMethod(PoliceOfficer.class,"setOfficerName",void.class, new String[] {"public"},new String[] {"static", "final"},String.class);
        grader.addMark(1);
    }

    @Test
    public void testOfficerBadgeNumber() {
        testField(PoliceOfficer.class,"officerBadgeNumber",String.class, new String[] {"private",},new String []{"static","final",});
        testMethod(PoliceOfficer.class,"getOfficerBadgeNumber",String.class, new String[] {"public"},new String[] {"static", "final"});
        testMethod(PoliceOfficer.class,"setOfficerBadgeNumber",void.class, new String[] {"public"},new String[] {"static", "final"},String.class);
        grader.addMark(1);
    }

    @Test
    public void testMethodIsParkingTimeExpired() {
        testMethod(PoliceOfficer.class,"isParkingTimeExpired",boolean.class, new String[] {"private"},new String[] {"static", "final","public"},ParkedCar.class,ParkingMeter.class);
        grader.addMark(1);
    }

    @Test
    public void testMethodCalculateFine() {
        testMethod(PoliceOfficer.class,"calculateFine",double.class, new String[] {"private"},new String[] {"static", "final","public"},ParkedCar.class,ParkingMeter.class);
        grader.addMark(1);
    }

    @Test
    public void testIssueParkingTicket() {
        testMethod(PoliceOfficer.class,"issueParkingTicket",ParkingTicket.class, new String[] {"public"},new String[] {"static", "final","private"},ParkedCar.class,ParkingMeter.class);
        grader.addMark(1);
    }

    @Test
    public void testConstructorOfficerNameNull() {
        try {
            PoliceOfficer officer = new PoliceOfficer(null,"RCMP2075");
            fail ("null officer name must throw an Illegal Argument Excepiton");
        } catch(IllegalArgumentException ex){
            assertEquals("officer name must not be null", ex.getMessage());
            grader.addMark(1);
        }	
    }

    @Test
    public void testConstructorOfficerNameEmptyString() {
        try {
            PoliceOfficer officer = new PoliceOfficer("","RCMP5698");
            fail ("Empty String officer name must throw an Illegal Argument Excepiton");
        } catch(IllegalArgumentException ex){
            assertEquals("officer name must not be an empty String", ex.getMessage());
            grader.addMark(1);
        }
    }

    @Test
    public void testConstructorOfficerNamevalidValue() {

        PoliceOfficer officer = new PoliceOfficer("Adam White","RCMP2569");

        assertEquals("Adam White", officer.getOfficerName());
        grader.addMark(1);

    }

    @Test
    public void testConstructorOfficerBadgeNumberNull() {
        try {
            PoliceOfficer officer = new PoliceOfficer("Adam White",null);
            fail ("null officer badge number must throw an Illegal Argument Excepiton");
        } catch(IllegalArgumentException ex){
            assertEquals("badge number must not be null", ex.getMessage());
            grader.addMark(1);
        }		
    }

    @Test
    public void testConstructorOfficerBadgeNumberEmptyString() {
        try {
            PoliceOfficer officer = new PoliceOfficer("Adam White","");
            fail ("Empty String  officer badge number must throw an Illegal Argument Excepiton");
        } catch(IllegalArgumentException ex){
            assertEquals("badge number must not be empty String", ex.getMessage());
            grader.addMark(1);
        }		
    }

    @Test
    public void testConstructorOfficerBadgeNumberValidValue() {

        PoliceOfficer officer = new PoliceOfficer("Adam White","RCMP2569");
        assertEquals("RCMP2569", officer.getOfficerBadgeNumber());
        grader.addMark(1);

    }

    @Test
    public void testIsParkingTimeExpiredValid() throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        PoliceOfficer p = new PoliceOfficer("Adam White","RCMP5225");
        ParkedCar car = new ParkedCar("Bob Smith", "Porsche", 2015, "1A2B3C", 125);
        ParkingMeter meter = new ParkingMeter("Burnaby",false,10.5,60);
        Method method = p.getClass().getDeclaredMethod("isParkingTimeExpired", ParkedCar.class,ParkingMeter.class);
        method.setAccessible(true);
        assertEquals(true,method.invoke(p, car,meter));
        grader.addMark(1);
        method.setAccessible(false);
    }

    @Test
    public void testIsParkingTimeExpiredInValid() throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException,InvocationTargetException{
        PoliceOfficer p = new PoliceOfficer("Adam White","RCMP5225");
        ParkedCar car = new ParkedCar("Bob Smith", "Porsche", 2015, "1A2B3C", 60);
        ParkingMeter meter = new ParkingMeter("Burnaby",false,10.5,60);
        Method method = p.getClass().getDeclaredMethod("isParkingTimeExpired", ParkedCar.class,ParkingMeter.class);
        method.setAccessible(true);
        assertEquals(false,method.invoke(p, car,meter));
        grader.addMark(1);
        method.setAccessible(false);

    }

    @Test
    public void testCalculateFine() throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException ,InvocationTargetException{
        PoliceOfficer p = new PoliceOfficer("Adam White","RCMP5225");
        ParkedCar car = new ParkedCar("Bob Smith", "Porsche", 2015, "1A2B3C", 125);
        ParkingMeter meter = new ParkingMeter("Burnaby",false,10.5,60);
        Method method = p.getClass().getDeclaredMethod("calculateFine", ParkedCar.class,ParkingMeter.class);
        method.setAccessible(true);
        assertEquals(40.0,method.invoke(p, car,meter));
        grader.addMark(1);
        method.setAccessible(false);
    }

    @Test
    public void testCalculateFineNoFine() throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException,InvocationTargetException {
        PoliceOfficer p = new PoliceOfficer("Adam White","RCMP5225");
        ParkedCar car = new ParkedCar("Bob Smith", "Porsche", 2015, "1A2B3C", 60);
        ParkingMeter meter = new ParkingMeter("Burnaby",false,10.5,61);
        Method method = p.getClass().getDeclaredMethod("calculateFine", ParkedCar.class,ParkingMeter.class);
        method.setAccessible(true);
        assertEquals(0.0,method.invoke(p, car,meter));
        grader.addMark(1);
        method.setAccessible(false);
    }

    @Test
    public void testIssueParkingTicketValid(){
        PoliceOfficer p = new PoliceOfficer("Adam White","RCMP5225");
        ParkedCar car = new ParkedCar("Bob Smith", "Porsche", 2015, "1A2B3C", 61);
        ParkingMeter meter = new ParkingMeter("Burnaby",false,10.5,60);
        assertNotNull(p.issueParkingTicket(car, meter));
        grader.addMark(1);

    }

    @Test
    public void testIssueParkingTicketNoTicket(){
        PoliceOfficer p = new PoliceOfficer("Adam White","RCMP5225");
        ParkedCar car = new ParkedCar("Bob Smith", "Porsche", 2015, "1A2B3C", 60);
        ParkingMeter meter = new ParkingMeter("Burnaby",false,10.5,60);
        assertNull(p.issueParkingTicket(car, meter));
        grader.addMark(1);

    }

    @Test
    public void  testDisplayDetails() {
        PoliceOfficer p = new PoliceOfficer("Adam White","RCMP5225");
        ParkedCar car = new ParkedCar("Bob Smith", "Porsche", 2015, "1A2B3C", 61);
        ParkingMeter meter = new ParkingMeter("Burnaby",false,10.5,60);
        ParkingTicket.resetCounter();
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        final PrintStream originalOut = System.out;
        System.setOut(new PrintStream (outContent));

        p.issueParkingTicket(car, meter);
        assertEquals("Ticket Number: VAN1001" + System.getProperty("line.separator")
            +"Officer Name: Adam White" +  System.getProperty("line.separator")
            +"Officer Badge number: RCMP5225" +  System.getProperty("line.separator")
            +"Car License Plate Number: 1A2B3C" +  System.getProperty("line.separator")
            +"Fine amount: 20.0" +  System.getProperty("line.separator"),outContent.toString());

        System.setOut(originalOut);
        grader.addMark(1);
    }

	public void testField(final Class<?> clazz, 
			final String   fieldName,
			final Class    expectedType,
			final String[] expectedModifiers,
			final String[] forbiddenModifiers)
	{
		if(clazz == null){
			throw new IllegalArgumentException("clazz cannot be null");
		}

		if(fieldName == null){
			throw new IllegalArgumentException("fieldName cannot be null");
		}

		try {
			final Field    field;
			final int      modifiers;
			final Class<?> type;

			field = clazz.getDeclaredField(fieldName);
			type  = field.getType();

			if(!(type.equals(expectedType))) {
				fail(clazz.getName() + "." + fieldName + " must be declared as \"" + expectedType.getName() + "\"");
			}

			modifiers = field.getModifiers();
			checkRequiredModifiers(clazz, fieldName, expectedModifiers, modifiers);
			checkForbiddenModifiers(clazz, fieldName, forbiddenModifiers, modifiers);
		}
		catch(final NoSuchFieldException ex) {
			fail(clazz.getName() + " must have a field named: \"" + fieldName + "\"");
		}
	}

	public void testMethod(final Class<?>    clazz, 
			final String      methodName,
			final Class       expectedReturnType,                           
			final String[]    expectedModifiers,
			final String[]    forbiddenModifiers,
			final Class<?>... expectedParameters)
	{
		if(clazz == null)
		{
			throw new IllegalArgumentException("clazz cannot be null");
		}

		if(methodName == null)
		{
			throw new IllegalArgumentException("methodName cannot be null");
		}

		try
		{
			final Method   method;
			final int      modifiers;
			final Class<?> returnType;

			method     = clazz.getDeclaredMethod(methodName, expectedParameters);
			returnType = method.getReturnType();

			if(!(returnType.equals(expectedReturnType)))
			{
				fail(clazz.getName() + "." + methodName + " must be return \"" + expectedReturnType.getName() + "\"");
			}

			modifiers = method.getModifiers();
			checkRequiredModifiers(clazz, methodName, expectedModifiers, modifiers);
			checkForbiddenModifiers(clazz, methodName, forbiddenModifiers, modifiers);
		}
		catch(final NoSuchMethodException ex)
		{
			fail(clazz.getName() + " must have a method named: \"" + methodName + "\"");
		}
	}
	public void checkRequiredModifiers(final Class<?> clazz,
			final String   name,
			final String[] expectedModifiers, 
			final int      actualModifiers)
	{
		for(final String expected : expectedModifiers)
		{
			switch(expected)
			{
			case "public":
			{
				if(!(Modifier.isPublic(actualModifiers)))
				{
					fail(clazz.getName() + "." + name + " must be declared \"public\"");
				}
				break;
			}        
			case "private":
			{
				if(!(Modifier.isPrivate(actualModifiers)))
				{
					fail(clazz.getName() + "." + name + " must be declared \"private\"");
				}
				break;
			}        
			case "protected":
			{
				if(!(Modifier.isProtected(actualModifiers)))
				{
					fail(clazz.getName() + "." + name + " must be declared \"protected\"");
				}
				break;
			}        
			case "final":
			{
				if(!(Modifier.isFinal(actualModifiers)))
				{
					fail(clazz.getName() + "." + name + " must be declared \"final\"");
				}
				break;
			}        
			case "static":
			{
				if(!(Modifier.isStatic(actualModifiers)))
				{
					fail(clazz.getName() + "." + name + " must be declared \"static\"");
				}
				break;
			}        
			}
		}
	}

	public void checkForbiddenModifiers(final Class<?> clazz,
			final String   name,
			final String[] unexpectedModifiers, 
			final int      actualModifiers)
	{
		for(final String unexpected : unexpectedModifiers)
		{
			switch(unexpected)
			{
			case "public":
			{
				if(Modifier.isPublic(actualModifiers))
				{
					fail(clazz.getName() + "." + name + " must not be declared \"public\"");
				}
				break;
			}        
			case "private":
			{
				if(Modifier.isPrivate(actualModifiers))
				{
					fail(clazz.getName() + "." + name + " must not be declared \"private\"");
				}
				break;
			}        
			case "protected":
			{
				if(Modifier.isProtected(actualModifiers))
				{
					fail(clazz.getName() + "." + name + " must not be declared \"protected\"");
				}
				break;
			}        
			case "final":
			{
				if(Modifier.isFinal(actualModifiers))
				{
					fail(clazz.getName() + "." + name + " must not be declared \"final\"");
				}
				break;
			}        
			case "static":
			{
				if(Modifier.isStatic(actualModifiers))
				{
					fail(clazz.getName() + "." + name + " must not be declared \"static\"");
				}
				break;
			}        
			}
		}
	}

}
