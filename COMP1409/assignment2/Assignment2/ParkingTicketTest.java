
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;

import java.lang.reflect.Method;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;


/**
 * 
 */

/**
 * @author Rana
 *
 */
public class ParkingTicketTest  {
    private static Grader grader = new Grader(23);

    

    // @BeforeClass
    // public static void setUpBeforeClass() {
        // System.out.println("ParkingTicket test class strat");
    // }

    // @AfterClass
    // public static void tearDownAfterClass() throws Exception {
        // System.out.println("ParkingTicket test class Score: " + grader.getMarks() + " / " + grader.getMax());

    // }
    
    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("ParkingTicket test class strat");
    }
    /**
     * @throws java.lang.Exception
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("ParkingTicket test class Score: " + grader.getMarks() + " / " + grader.getMax());
      //  grader = new Grader(23);
    }

    
    @Test
    public void testOfficerName() {
        testField(ParkingTicket.class,"officerName",String.class, new String[] {"private",},new String []{"static","final",});
        testMethod(ParkingTicket.class,"getOfficerName",String.class, new String[] {"public"},new String[] {"static", "final"});
        testMethod(ParkingTicket.class,"setOfficerName",void.class, new String[] {"public"},new String[] {"static", "final"},String.class);
        grader.addMark(1);
    }

    @Test
    public void testOfficerBadgeNumber() {
        testField(ParkingTicket.class,"officerBadgeNumber",String.class, new String[] {"private",},new String []{"static","final",});
        testMethod(ParkingTicket.class,"getOfficerBadgeNumber",String.class, new String[] {"public"},new String[] {"static", "final"});
        testMethod(ParkingTicket.class,"setOfficerBadgeNumber",void.class, new String[] {"public"},new String[] {"static", "final"},String.class);
        grader.addMark(1);
    }

    @Test
    public void testCarLicensePlateNumber() {
        testField(ParkingTicket.class,"carLicensePlateNumber",String.class, new String[] {"private",},new String []{"static","final",});
        testMethod(ParkingTicket.class,"getCarLicensePlateNumber",String.class, new String[] {"public"},new String[] {"static", "final"});
        testMethod(ParkingTicket.class,"setCarLicensePlateNumber",void.class, new String[] {"public"},new String[] {"static", "final"},String.class);
        grader.addMark(1);
    }

    @Test
    public void testTicketNumber() {
        testField(ParkingTicket.class,"ticketNumber",String.class, new String[] {"private",},new String []{"static","final",});
        testMethod(ParkingTicket.class,"getTicketNumber",String.class, new String[] {"public"},new String[] {"static", "final"});
        grader.addMark(1);
    }

    @Test
    public void testFineAmountInCAD() {
        testField(ParkingTicket.class,"fineAmountInCAD",double.class, new String[] {"private",},new String []{"static","final",});
        testMethod(ParkingTicket.class,"getFineAmountInCAD",double.class, new String[] {"public"},new String[] {"static", "final"});
        testMethod(ParkingTicket.class,"setFineAmountInCAD",void.class, new String[] {"public"},new String[] {"static", "final"},double.class);
        grader.addMark(1);
    }

    @Test
    public void testCounter() {
        testField(ParkingTicket.class,"counter",int.class, new String[] {"public","static",},new String []{"final","private"});
        grader.addMark(1);
    }

    @Test
    public void testTICKET_PREFIX() {
        testField(ParkingTicket.class,"TICKET_PREFIX",String.class, new String[] {"final","static","public"},new String []{"private",});
        grader.addMark(1);
    }

    @Test
    public void testConstructorOfficerNameNull() {
        try {
            ParkingTicket ticket = new ParkingTicket(null,"VAN5225", "1A2B3C", 40);
            fail ("null officer name must throw an Illegal Argument Excepiton");
        } catch(IllegalArgumentException ex){
            assertEquals("officer name must not be null", ex.getMessage());
            grader.addMark(1);
        }   
    }

    @Test
    public void testConstructorOfficerNameEmptyString() {
        try {
            ParkingTicket ticket = new ParkingTicket("","VAN5225", "1A2B3C", 40);
            fail ("Empty String officer name must throw an Illegal Argument Excepiton");
        } catch(IllegalArgumentException ex){
            assertEquals("officer name must not be an empty String", ex.getMessage());
            grader.addMark(1);
        }
    }

    @Test
    public void testConstructorOfficerNamevalidValue() {

        ParkingTicket ticket = new ParkingTicket("Adam White","VAN5225", "1A2B3C", 40);

        assertEquals("Adam White", ticket.getOfficerName());
        grader.addMark(1);

    }

    @Test
    public void testConstructorOfficerBadgeNumberNull() {
        try {
            ParkingTicket ticket = new ParkingTicket("Adam White",null, "1A2B3C", 40);
            fail ("null officer badge number must throw an Illegal Argument Excepiton");
        } catch(IllegalArgumentException ex){
            assertEquals("badge number must not be null", ex.getMessage());
            grader.addMark(1);
        }       
    }

    @Test
    public void testConstructorOfficerBadgeNumberEmptyString() {
        try {
            ParkingTicket ticket = new ParkingTicket("Adam White","", "1A2B3C", 40);
            fail ("Empty String  officer badge number must throw an Illegal Argument Excepiton");
        } catch(IllegalArgumentException ex){
            assertEquals("badge number must not be empty String", ex.getMessage());
            grader.addMark(1);
        }       
    }

    @Test
    public void testConstructorOfficerBadgeNumberValidValue() {

        ParkingTicket ticket = new ParkingTicket("Adam White","VAN5225", "1A2B3C", 40);
        assertEquals("VAN5225", ticket.getOfficerBadgeNumber());
        grader.addMark(1);

    }

    @Test
    public void testConstructorCarLicensePalateNumberNull() {
        try {
            ParkingTicket ticket = new ParkingTicket("Adam White","VAN5225", null, 40);
            fail ("null  car license number must throw an Illegal Argument Excepiton");
        } catch(IllegalArgumentException ex){
            assertEquals("car license plate number must not be null", ex.getMessage());
            grader.addMark(1);
        }       
    }

    @Test
    public void testConstructorCarLicensePalateNumberEmptyString() {
        try {
            ParkingTicket ticket = new ParkingTicket("Adam White","VAN5225", "", 40);
            fail ("Empty String  car license number must throw an Illegal Argument Excepiton");
        } catch(IllegalArgumentException ex){
            assertEquals("car license plate number must not be empty String", ex.getMessage());
            grader.addMark(1);
        }       
    }

    @Test
    public void testConstructorCarLicensePalateNumberValidValue() {

        ParkingTicket ticket = new ParkingTicket("Adam White","VAN5225", "1A2B3C", 40);
        assertEquals("1A2B3C", ticket.getCarLicensePlateNumber());
        grader.addMark(1);

    }

    @Test
    public void testConstructorfineAmount0() {

        try {
            ParkingTicket ticket = new ParkingTicket("Adam White","VAN5225", "1A2B3C", 0);
            fail ("0 fine amount must throw an Illegal Argument Excepiton");
        } catch(IllegalArgumentException ex) {
            assertEquals("fine amount must not be 0", ex.getMessage());
            grader.addMark(1);
        }

    }

    @Test
    public void testConstructorfineAmountNegative() {

        try {
            ParkingTicket ticket = new ParkingTicket("Adam White","VAN5225", "1A2B3C", -1);
            fail (" negative fine amount must throw an Illegal Argument Excepiton");
        } catch(IllegalArgumentException ex) {
            assertEquals("fine amount must not be negative", ex.getMessage());
            grader.addMark(1);
        }

    }

    @Test
    public void testConstructorfineAmountValidValue() {

        ParkingTicket ticket = new ParkingTicket("Adam White","VAN5225", "1A2B3C",20 );
        assertEquals(20, ticket.getFineAmountInCAD(),0.005);
        grader.addMark(1);
    }

    @Test
    public void testConstructorTicketNumber() {
        ParkingTicket.resetCounter();
        ParkingTicket ticket = new ParkingTicket("Adam White","VAN5225", "1A2B3C",20 ); 
        assertEquals("VAN1001", ticket.getTicketNumber());
        grader.addMark(1);
    }

    @Test
    public void testConstructorTicketNumberSEquential() {
        ParkingTicket.resetCounter();
        ParkingTicket ticket = new ParkingTicket("Adam White","VAN5225", "1A2B3C",20 ); 
        ParkingTicket ticket2 = new ParkingTicket("Adam White","VAN5225", "1A2B3C",20 ); 
        ParkingTicket ticket3 = new ParkingTicket("Adam White","VAN5225", "1A2B3C",20 ); 
        assertEquals("VAN1001",ticket.getTicketNumber());
        assertEquals("VAN1003", ticket3.getTicketNumber());
        grader.addMark(1);
    }

    @Test
    public void  testDisplayDetails() {
        ParkingTicket.resetCounter();

        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        final PrintStream originalOut = System.out;
        System.setOut(new PrintStream (outContent));
        ParkingTicket ticket = new ParkingTicket("Bob Smith", "RCMP2251", "1A2B3C", 150.0);
        ticket.displayDetails();
        assertEquals("Ticket Number: VAN1001" + System.getProperty("line.separator") 
            +"Officer Name: Bob Smith" + System.getProperty("line.separator") 
            +"Officer Badge number: RCMP2251" + System.getProperty("line.separator")  
            +"Car License Plate Number: 1A2B3C" + System.getProperty("line.separator")  
            +"Fine amount: 150.0" + System.getProperty("line.separator")  ,outContent.toString());
        System.setOut(originalOut);
        grader.addMark(1);
    }

    @Test
    public void  testResetCounter() {
        ParkingTicket.resetCounter();
        assertEquals(1000,ParkingTicket.counter);
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

