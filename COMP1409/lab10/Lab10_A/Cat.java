
/**
 * Write a description of class Cat here.
 *
 * @author Brian
 * @version 01
 */
public class Cat
{
    // instance variables - replace the example below with your own
    private String name;
    private int birthYear;
    private double weightInKilos;

    /**
     * Constructor for objects of class Cat
     */
    public Cat()
    {
        // initialise instance variables
        name = "unknown";
        birthYear = 0;
        weightInKilos = 0.0;
    }
    /**
     * Constructor for objects of class Cat
     * @para name to set name of cat
     * @para birthYear to set the year of birth
     * @para weightInKilos to set weight in kilos
     */
    public Cat(String name, int birthYear, double weightInKilos){
        setName(name);
        setBirthYear(birthYear);
        setWeightInKilos(weightInKilos);
    }
    
    /**
     * Mutator method setName
     * @para name to set name of cat
     */
    public void setName(String name){
        if(name != null){
            this.name = name;
        }
        else{
            throw new IllegalArgumentException("name cannot be null");
        }
    }
    /**
     * Accessor method getName
     * @return name
     */
    public String getName(){ return name;}
    /**
     * Mutator method setBirthYear
     * @para birthYear to set birth year
     */
    public void setBirthYear(int birthYear){
        if(birthYear < 0 ){
            throw new IllegalArgumentException("birth year cannot be negative");
        }
        else{
            this.birthYear = birthYear;
        }
    }
    /**
     * Accessor method getBirthYear
     * @return birthYear;
     */
    public int getBirthYear(){ return birthYear;}
    /**
     * Mutator method to setWeightInKilos
     * @para weightInKilos to set weight in Kilos
     */
    public void setWeightInKilos(double weightInKilos){
        if(weightInKilos <= 0){
            throw new IllegalArgumentException("Weight cannot be less than 0");
        }
        else{
            this.weightInKilos = weightInKilos;
        }
    }
    /**
     * Accessor method getWeightInKilos
     * @return weightInKilos
     */
    public double getWeightInKilos(){ return weightInKilos;}
    /**
     * Method to display details
     */
    public void displayDetails(){
        System.out.println("Name: " + getName());
        System.out.println("Birth Year: " + getBirthYear());
        System.out.println("Weight In Kilos: " + getWeightInKilos());
    }
}
