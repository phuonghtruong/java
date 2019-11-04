
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;

import org.junit.Test;


public class TestParkingMeter{  //

    private static Grader grader = new Grader(21);
    private ParkingMeter meter;

    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("ParkingMeter test class strat");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("ParkingMeter test class Score: " + grader.getMarks() + " / " + grader.getMax());
        grader = new Grader(21);
    }

    // instance variables getters and setters test

    @Test
    public void testMeterLocation() {
        testField(ParkingMeter.class,"meterLocation",String.class, new String[] {"private", },
            new String [] {"static","final",});
        testMethod(ParkingMeter.class,"getMeterLocation",String.class, new String[] {"public"},new String[] {"static", "final"});
        testMethod(ParkingMeter.class,"setMeterLocation",void.class, new String[] {"public"},new String[] {"static", "final"},String.class);
        grader.addMark(1);
        //System.out.println("Score: " + grader.getMarks() + " / " + grader.getMax());
    }

    @Test
    public void testHasCamera() {
        testField(ParkingMeter.class,"hasACamera",boolean.class, new String[] {"private", },
            new String [] {"static","final",});
        testMethod(ParkingMeter.class,"getHasACamera",boolean.class, new String[] {"public"},new String[] {"static", "final"});
        testMethod(ParkingMeter.class,"setHasACamera",void.class, new String[] {"public"},new String[] {"static", "final"},boolean.class);
        grader.addMark(1);
        //System.out.println("Score: " + grader.getMarks() + " / " + grader.getMax());
    }

    @Test
    public void testPriceOfOneMinuteInCAD() {
        testField(ParkingMeter.class,"priceOfOneMinuteInCAD",double.class, new String[] {"private", },
            new String [] {"static","final",});
        testMethod(ParkingMeter.class,"getPriceOfOneMinuteInCAD",double.class, new String[] {"public"},new String[] {"static", "final"});
        testMethod(ParkingMeter.class,"setPriceOfOneMinuteInCAD",void.class, new String[] {"public"},new String[] {"static", "final"},double.class);
        grader.addMark(1);

    }

    @Test
    public void testNumberOfPurchasedMinutes() {
        testField(ParkingMeter.class,"numberOfPurchasedMinutes",int.class, new String[] {"private", },
            new String [] {"static","final",});
        testMethod(ParkingMeter.class,"getNumberOfPurchasedMinutes",int.class, new String[] {"public"},new String[] {"static", "final"});
        testMethod(ParkingMeter.class,"setNumberOfPurchasedMinutes",void.class, new String[] {"public"},new String[] {"static", "final"},int.class);
        grader.addMark(1);
    }

    // constructor test

    @Test
    public void testContructorMeterLocationNegative() {
        try {
            ParkingMeter oneMeter = new ParkingMeter(null,false,10.5,65);
            fail("null meter location must throw an Illegal Argument Exception");
        }
        catch(IllegalArgumentException ex) {
            assertEquals("meter location cannot be null", ex.getMessage());
        }
        grader.addMark(1);
    }

    // constructor test

    @Test
    public void testConstructorMeterLocationPositive() {

        ParkingMeter oneMeter = new ParkingMeter("Burnaby",false,10.5,65);
        assertEquals("Burnaby", oneMeter.getMeterLocation());
        grader.addMark(1);
    }

    @Test
    public void testConstructorHasACamera() {
        ParkingMeter oneMeter = new ParkingMeter("Burnaby", true, 10.5,65);
        assertEquals(true,oneMeter.getHasACamera());
        grader.addMark(1);
    }

    @Test
    public void testPriceOfMinuteConstructorNegative() {
        try {
            ParkingMeter oneMeter = new ParkingMeter("Burnaby",false,0,65);
            fail("price of one minutes must not be 0");
        }
        catch(IllegalArgumentException ex) {
            assertEquals("price of one minute cannot be 0 or less", ex.getMessage());

        }

        try {
            ParkingMeter oneMeter = new ParkingMeter("Burnaby",false,-1,65);
            fail("price of one minutes must not be 0");
        }
        catch(IllegalArgumentException ex) {
            assertEquals("price of one minute cannot be 0 or less", ex.getMessage());

        }
        grader.addMark(1);
    }

    @Test
    public void testNumberOfPurchasedMinutesConstructorNegativeZero() {
        try {
            ParkingMeter oneMeter = new ParkingMeter("Burnaby",false,10.5,0);
            fail("price of one minutes must not be 0");
        }
        catch(IllegalArgumentException ex) {
            assertEquals("number of purchased minutes cannot be 0 or negative", ex.getMessage());
            grader.addMark(1);

        }
    }

    @Test
    public void testNumberOfPurchasedMinutesConstructorNegative() {
        try {
            ParkingMeter oneMeter = new ParkingMeter("Burnaby",false,10.5,-1);
            fail("price of one minutes must not be 0");
        }
        catch(IllegalArgumentException ex) {
            assertEquals("number of purchased minutes cannot be 0 or negative", ex.getMessage());
            grader.addMark(1);

        }
    }

    @Test
    public void testNumberOfpurchsedMinutesNegativeUpperLimit() {
        ParkingMeter oneMeter = new ParkingMeter("Burnaby",false,10.5,181);
        assertEquals(180, oneMeter.getNumberOfPurchasedMinutes());
        grader.addMark(1);
    }

    @Test
    public void testNumberOfpurchsedMinutesPositiveUpperLimit() {
        ParkingMeter oneMeter = new ParkingMeter("Burnaby",false,10.5,180);
        assertEquals(180, oneMeter.getNumberOfPurchasedMinutes());
        grader.addMark(1);
    }

    @Test
    public void testNumberOfPurchasedMinutesConstructorPositive() {

        ParkingMeter oneMeter = new ParkingMeter("Burnaby",false,10.5,1);
        assertEquals(1,oneMeter.getNumberOfPurchasedMinutes());
        grader.addMark(1);

    }

    // test mutators validation
    @Test
    public void testSetMeterLocationNegative() {
        try {
            meter = new ParkingMeter("Burnaby",true,10.5,120);
            meter.setMeterLocation(null);
            fail("meter location must not be null");
        } catch(IllegalArgumentException ex) {
            assertEquals("meter location cannot be null",ex.getMessage());
            grader.addMark(1);
        }
    }

    @Test
    public void testSetMeterLocationPositive() {
        meter = new ParkingMeter("Burnaby",true,10.5,120);
        meter.setMeterLocation("BCIT");
        assertEquals("BCIT",meter.getMeterLocation());
        grader.addMark(1);

    }

    @Test
    public void testSetHasACamera() {
        //meter.setHasACamera(false);
        ParkingMeter oneMeter = new ParkingMeter("Burnaby",false,10.5,180);
        oneMeter.setHasACamera(true);
        assertEquals(true, oneMeter.getHasACamera());
    }

    @Test
    public void testsetPriceOfMinuteNegative() {
        try {
            ParkingMeter oneMeter = new ParkingMeter("Burnaby",false,10.5,180);
            oneMeter.setPriceOfOneMinuteInCAD(0);
            fail("price of one minutes must not be 0");
        }
        catch(IllegalArgumentException ex) {
            assertEquals("price of one minute cannot be 0 or less", ex.getMessage());

        }

        try {
            meter = new ParkingMeter("Burnaby",true,10.5,120);
            meter.setPriceOfOneMinuteInCAD(-1);
            fail("price of one minutes must not be 0");
        }
        catch(IllegalArgumentException ex) {
            assertEquals("price of one minute cannot be 0 or less", ex.getMessage());

        }
        grader.addMark(1);
    }

    @Test
    public void testsetPriceOfMinutepositive() {
        meter = new ParkingMeter("Burnaby",true,10.5,120);
        meter.setPriceOfOneMinuteInCAD(1);
        assertEquals(1,meter.getPriceOfOneMinuteInCAD(),0.01);
        grader.addMark(1);
    }

    @Test
    public void testSetNumberOfpurchsedMinutesNegativeUpperLimit() {
        meter = new ParkingMeter("Burnaby",true,10.5,120);
        meter.setNumberOfPurchasedMinutes(181);
        assertEquals(180, meter.getNumberOfPurchasedMinutes());
        grader.addMark(1);
    }

    @Test  
    public void testSetNumberOfpurchsedMinutesPositiveUpperLimit() {
        meter = new ParkingMeter("Burnaby",true,10.5,120);
        meter.setNumberOfPurchasedMinutes(180);
        assertEquals(180, meter.getNumberOfPurchasedMinutes());
        grader.addMark(1);
    }

    @Test
    public void testSetNumberOfPurchasedMinutesPositive() {
        meter = new ParkingMeter("Burnaby",true,10.5,120);
        meter.setNumberOfPurchasedMinutes(1);
        assertEquals(1,meter.getNumberOfPurchasedMinutes());
        grader.addMark(1);

    }

    @Test
    public void testdisplayDetails() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        final PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        ParkingMeter oneMeter = new ParkingMeter("Burnaby",false,10.5,180);
        oneMeter.displayDetails();
        System.setOut(new PrintStream(originalOut));
        assertEquals("metre location: Burnaby" + System.getProperty("line.separator")
            + "meter have a camera: false" + System.getProperty("line.separator")
            + "price of one minute in CAD: 10.5" + System.getProperty("line.separator")
            + "number of purchased minutes: 180"+ System.getProperty("line.separator")
        , outContent.toString());

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


