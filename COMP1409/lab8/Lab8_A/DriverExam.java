
/**
 * Write a description of class DriverExam here.
 *
 * @author Brian
 * @version (a version number or a date)
 */
public class DriverExam
{
    // instance variables - replace the example below with your own
    public static final String[] ANSWERS = {"B","D","A","A","C",
                                            "A","B","A","C","D",
                                            "B","C","D","A","D",
                                            "C","C","B","D","A"};
    public static final int NUMBER_OF_QUESTIONS = 20;
    public static final int MINIMUM_PASS = 15;
    private String[] driverAnswers;
    

    /**
     * Constructor for objects of class DriverExam
     */
    public DriverExam()
    {
        // initialise instance variables
        driverAnswers = new String[NUMBER_OF_QUESTIONS];
        int index = 0;
        while(index < NUMBER_OF_QUESTIONS){
            driverAnswers[index] = "unknown";
            index++;
        }
    }

    /**
     * Method prompt Student answers
     */
    public void promptStudentAnswers(){
        int index = 0;
        InputReader reader = new InputReader();
        String answer = new String("");
        System.out.println("Enter the answer: ");
        while(index < NUMBER_OF_QUESTIONS){
            System.out.print("Question " + (index+1)+ " : ");
            answer = reader.readString();
            if(answer.equals("A") ||answer.equals("B") ||
                answer.equals("C") || answer.equals("D")) {
                   driverAnswers[index] = answer;
                   index++;
            }
            else{
                System.out.println("Invalid answer! Answer must be A or B or C or D");
            }
        }
    }
   
    /**
     * Method to get total correct answers
     * @return totalCorrectAnswers
     */
    public int getTotalCorrectAnswers(){
        int index = 0;
        int totalCorrectAnswers = 0;
        while(index < NUMBER_OF_QUESTIONS){
            if(driverAnswers[index].equals(ANSWERS[index])){
                totalCorrectAnswers++;
            }
            index++;
        }
        return totalCorrectAnswers;
    }
    /**
     * Method to get number of incorrect answers
     * @return totalInCorrectAnswer
     */
    public int getTotalInCorrectAnswers(){
        int index = 0;
        int totalInCorrectAnswers = 0;
        while(index < NUMBER_OF_QUESTIONS){
            if(driverAnswers[index].equals(ANSWERS[index])){
                
            }
            else{
                totalInCorrectAnswers++;
            }
            index++;
        }
        return totalInCorrectAnswers;
    }
    /**
     * method to check if driver pass the exam
     * @return boolean
     */
    public boolean isPass(){
        int numberOfCorrectAnswers = getTotalCorrectAnswers();
        if(numberOfCorrectAnswers < MINIMUM_PASS){
            return false;
        }
        else{
            return true;
        }
    }
    
    public static void main(String[] args){
        DriverExam driver1 = new DriverExam();
        driver1.promptStudentAnswers();
        System.out.println("Total correct answers: " + driver1.getTotalCorrectAnswers());
        System.out.println("Total incorrect answers: " + driver1.getTotalInCorrectAnswers());
        if(driver1.isPass())
            System.out.println("Result : PASSED");
        else
            System.out.println("Result : FAILED");
    }
}
