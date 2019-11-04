
import java.lang.reflect.Method;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestParkedCar {
    private static Grader grader = new Grader(27);
    private ParkedCar oneCar;

	
    @AfterClass	
    public  static void tearDownAfterClass() throws Exception {
        System.out.println(" ParkedCar Test class Score: " + grader.getMarks() + " / " + grader.getMax());
        System.out.println("ParkedCar Test Class ends");
        grader = new Grader(27);

    }

	
    @BeforeClass
    public static void setUpBeforeClass()throws Exception {
        System.out.println("ParkedCar Test Class Start");
    }
    // Instance variables getters and setters tests

    @Test
    public void testOwnerName() {
        testField(ParkedCar.class, "ownerName", String.class, new String[] {"private",},
            new String[]{"static","final",});

        testMethod(ParkedCar.class,"getOwnerName",String.class,new String[] {"public"}, new String[] {"static", "final"});

        testMethod(ParkedCar.class,"setOwnerName",void.class, new String[] {"public"},new String[] {"static","final"},String.class);
        grader.addMark(1);

    }

    @Test
    public void testcarMake() {
        testField(ParkedCar.class, "carMake", String.class, new String[] {"private",},
            new String[]{"static","final",});

        testMethod(ParkedCar.class,"getCarMake",String.class,new String[] {"public"}, new String[] {"static", "final"});

        testMethod(ParkedCar.class,"setCarMake",void.class, new String[] {"public"},new String[] {"static","final"},String.class);
        grader.addMark(1);

    }

    @Test
    public void testLicensePlateNumber() {
        testField(ParkedCar.class, "licensePlateNumber", String.class, new String[] {"private",},
            new String[]{"static","final",});

        testMethod(ParkedCar.class,"getLicensePlateNumber",String.class,new String[] {"public"}, new String[] {"static", "final"});

        testMethod(ParkedCar.class,"setLicensePlateNumber",void.class, new String[] {"public"},new String[] {"static","final"},String.class);
        grader.addMark(1);

    }

    @Test
    public void testModelYear() {
        testField(ParkedCar.class, "modelYear", int.class, new String[] {"private",},
            new String[]{"static","final",});

        testMethod(ParkedCar.class,"getModelYear",int.class,new String[] {"public"}, new String[] {"static", "final"});

        testMethod(ParkedCar.class,"setModelYear",void.class, new String[] {"public"},new String[] {"static","final"},int.class);
        grader.addMark(1);

    }

    @Test
    public void testNumberOfMinutesParked() {
        testField(ParkedCar.class, "numberOfMinutesParked", int.class, new String[] {"private",},
            new String[]{"static","final",});

        testMethod(ParkedCar.class,"getNumberOfMinutesParked",int.class,new String[] {"public"}, new String[] {"static", "final"});

        testMethod(ParkedCar.class,"setNumberOfMinutesParked",void.class, new String[] {"public"},new String[] {"static","final"},int.class);
        grader.addMark(1);

    }

    // constructor validation tests

    @Test
    public void constuctorOwnerNameValidationTestNegative() {
        try {
            ParkedCar car = new ParkedCar(null,"Porsche",2015,"1A2B3C",60);
            fail("null owner name must throw an IllegalArgumentException");
        }
        catch(IllegalArgumentException ex) {

            assertEquals("owner name cannot be null", ex.getMessage());
            grader.addMark(1);
        } 

    }

    @Test
    public void constructorOwnerNameValidationTestPositive() {

        ParkedCar car = new ParkedCar("Bob Smith", "Porsche", 2015, "1A2B3C", 15);
        assertEquals("Bob Smith",car.getOwnerName());	
        grader.addMark(1);
    }

    @Test
    public void construdtorCarMakeValdationTestNegative() {
        try {
            ParkedCar car = new ParkedCar("Bob Smith", null, 2015,"1A2B3C",60);
            fail(" null car make must throw an IllegalArgumentException");
        }
        catch(IllegalArgumentException ex) {

            assertEquals("car make cannot be null", ex.getMessage());	
            grader.addMark(1);
        }
    }

    @Test
    public void constructorCarMakeValidationTestPositive() {

        ParkedCar car = new ParkedCar("Bob Smith", "Porsche", 2015, "1A2B3C", 15);
        assertEquals("Porsche",car.getCarMake());	
        grader.addMark(1);
    }

    @Test 
    public void constructorModelYearValidationTestNegative() {
        try {
            ParkedCar car = new ParkedCar("Bob Smith", "Porsche", (ParkedCar.CAR_MODEL_YEAR_LOWER_LIMIT-1),"1A2B3C",60);
            fail("model year cannot be earlier than " + ParkedCar.CAR_MODEL_YEAR_LOWER_LIMIT);
        }
        catch(IllegalArgumentException ex) {
            assertEquals("model year cannot be earlier than " + ParkedCar.CAR_MODEL_YEAR_LOWER_LIMIT, ex.getMessage());
            grader.addMark(1);
        }

        try {
            ParkedCar car = new ParkedCar("Bob Smith", "Porsche", (ParkedCar.CURRENT_YEAR + 1),"1A2B3C",60);
            fail("model year must not be later than "+  ParkedCar.CURRENT_YEAR);

        }
        catch(IllegalArgumentException ex) {
            assertEquals("model year cannot be later than " + ParkedCar.CURRENT_YEAR, ex.getMessage());
        }
    }

    @Test
    public void constructorModelYearValidtionTestPositive() {
        ParkedCar car = new ParkedCar("Bob Smith", "Porsche", 2015, "1A2B3C", 15);
        assertEquals(2015, car.getModelYear());
        grader.addMark(1);
    }

    @Test 
    public void constructorLicensePlateNumberValidationNegative() {

        try {
            ParkedCar car = new ParkedCar("Bob Smith", "Porsche", (ParkedCar.CURRENT_YEAR + 1),null,60);
            fail("license plate number must not be null");
        }
        catch(IllegalArgumentException ex) {
            assertEquals("car license number connot be null", ex.getMessage());
            grader.addMark(1);

        }
    }

    @Test
    public void constructorLicenseNumberValidationPositive() {
        ParkedCar car = new ParkedCar("Bob Smith", "Porsche", 2015, "1A2B3C", 15);
        assertEquals("1A2B3C", car.getLicensePlateNumber());
        grader.addMark(1);
    }

    @Test
    public void constructorMinutesParkedValidationNegative() {
        try {
            ParkedCar car = new ParkedCar("Bob Smith", "Porsche", 2015, "1A2B3C", -1);
            fail("minutes parked must not be negative or 0");
            ParkedCar car1 = new ParkedCar("Bob Smith", "Porsche", 2015, "1A2B3C", 0);
            fail("minutes parked must not be negative or 0");
        }
        catch(IllegalArgumentException ex){
            assertEquals("minutes parked should be greater than 0", ex.getMessage());
            grader.addMark(1);
        }

		
    }
    // mutators validation

    @Test 
    public void setOwnerNameTestPositive() {
        oneCar = new ParkedCar("adam white","Mazda",2010,"1A2B3C",95);
        oneCar.setOwnerName("Adam Smith");
        assertEquals("Adam Smith", oneCar.getOwnerName());
        grader.addMark(1);
    }

    @Test 
    public void setOwnerNameTestPositiveEmptyString() {
        oneCar = new ParkedCar("adam white","Mazda",2010,"1A2B3C",95);
        oneCar.setOwnerName("");
        assertEquals("", oneCar.getOwnerName());
        grader.addMark(1);
    }

    @Test 
    public void setOwnerNameTestPositiveOneCharName() {
        oneCar = new ParkedCar("adam white","Mazda",2010,"1A2B3C",95);
        oneCar.setOwnerName("A");
        assertEquals("A", oneCar.getOwnerName());
        grader.addMark(1);
    }

    @Test 
    public void setOwnerNameTestNegative() {
        try {
            oneCar = new ParkedCar("adam white","Mazda",2010,"1A2B3C",95);
            oneCar.setOwnerName(null);
            fail("owner name must not be null");
        }
        catch(IllegalArgumentException ex) {
            assertEquals("owner name cannot be null", ex.getMessage());
            grader.addMark(1);
        }

    }

    @Test 
    public void setLicensePlateNumberTestPositive() {
        oneCar = new ParkedCar("adam white","Mazda",2010,"1A2B3C",95);
        oneCar.setLicensePlateNumber("C4D5E6");
        assertEquals("C4D5E6", oneCar.getLicensePlateNumber());
        grader.addMark(1);
    }

    @Test 
    public void setLicensePlateNumberTestNegative() {
        try {
            oneCar = new ParkedCar("adam white","Mazda",2010,"1A2B3C",95);
            oneCar.setLicensePlateNumber(null);
            fail("license plate number must not be null");
        }
        catch(IllegalArgumentException ex) {
            assertEquals("car license number connot be null", ex.getMessage());
            grader.addMark(1);
        }

    }

    @Test
    public void setModelYearTestNegative() {
        try {
            oneCar = new ParkedCar("adam white","Mazda",2010,"1A2B3C",95);
            oneCar.setModelYear(ParkedCar.CAR_MODEL_YEAR_LOWER_LIMIT - 1);
            fail(" mode year must not be earlier than " +ParkedCar.CAR_MODEL_YEAR_LOWER_LIMIT);
        }
        catch (IllegalArgumentException ex) {
            assertEquals("model year cannot be earlier than " + ParkedCar.CAR_MODEL_YEAR_LOWER_LIMIT, ex.getMessage());
            grader.addMark(1);
        }

        try {
            oneCar.setModelYear(ParkedCar.CURRENT_YEAR + 1);
            fail(" mode year must not be later than " +ParkedCar.CAR_MODEL_YEAR_LOWER_LIMIT);
        }
        catch (IllegalArgumentException ex) {
            assertEquals("model year cannot be later than " + ParkedCar.CURRENT_YEAR, ex.getMessage());
            grader.addMark(1);
        }
    }

    @Test
    public void setModelYearTestPositive() {
        try {
            oneCar = new ParkedCar("adam white","Mazda",2010,"1A2B3C",95);
            oneCar.setModelYear(ParkedCar.CAR_MODEL_YEAR_LOWER_LIMIT);
            assertEquals(ParkedCar.CAR_MODEL_YEAR_LOWER_LIMIT, oneCar.getModelYear());
        }
        catch(IllegalArgumentException ex) {
            fail("model year can be " +ParkedCar.CAR_MODEL_YEAR_LOWER_LIMIT);

        }
        try {
            oneCar.setModelYear(ParkedCar.CURRENT_YEAR);
            assertEquals(ParkedCar.CURRENT_YEAR, oneCar.getModelYear());
        }
        catch(IllegalArgumentException ex) {
            fail("model year can be " + ParkedCar.CURRENT_YEAR);
        }

        oneCar.setModelYear(1901);
        assertEquals(1901,oneCar.getModelYear());
        grader.addMark(1);
    }

    @Test
    public void setNumberOfMinutesParkedTestNegativeZero() {
        try {
            oneCar = new ParkedCar("adam white","Mazda",2010,"1A2B3C",95);
            oneCar.setNumberOfMinutesParked(0);
            fail("number of minutes parked cannot be 0");
        }
        catch(IllegalArgumentException ex) {
            assertEquals("minutes parked should be greater than 0", ex.getMessage());
            grader.addMark(1);
        }

    }
    @Test
    public void setNumberOfMinutesParkedTestNegative() {
        try {
            oneCar = new ParkedCar("adam white","Mazda",2010,"1A2B3C",95);
            oneCar.setNumberOfMinutesParked(-1);
            fail("number of minutes parked cannot be negative");
        }
        catch(IllegalArgumentException ex) {
            assertEquals("minutes parked should be greater than 0", ex.getMessage());
            grader.addMark(1);
        }
    }

    @Test
    public void setNumberOfMinutesParkedTestPositive() {
        oneCar = new ParkedCar("adam white","Mazda",2010,"1A2B3C",95);
        oneCar.setNumberOfMinutesParked(1);
        assertEquals(1, oneCar.getNumberOfMinutesParked());
        grader.addMark(1);
    }

    @Test
    public void testdisplayDetails() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        final PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        oneCar = new ParkedCar("Adam White","Mazda",2010,"1A2B3C",95);
        oneCar.displayDetails();
       
        System.setOut(originalOut);
         assertEquals("Owner name: Adam White"+ System.getProperty("line.separator")
            +   "Car make: Mazda"+System.getProperty("line.separator")
            +   "Car model year: 2010" + System.getProperty("line.separator")
            +   "Car license Plate number: 1A2B3C" + System.getProperty("line.separator")
            +   "Number of minutes parked: 95" + System.getProperty("line.separator"), outContent.toString());
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
            fail(clazz.getName() + " must have a field named: \"" + methodName + "\"");
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

class Grader {
    private final int max;
    private int marks;

    public Grader(final int m) {
        max = m;
        marks = 0;
    }

    public void addMark(final int mark ) {
        marks += mark;

    }

    public int getMarks() {
        return marks;
    }

    public int getMax() {
        return max;
    }
}