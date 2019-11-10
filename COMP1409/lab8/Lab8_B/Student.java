
/**
 * Write a description of class Student here.
 *
 * @author Brian
 * @version (a version number or a date)
 */
public class Student
{
    // instance variables - replace the example below with your own
    public static final int NUM_OF_SUBJECTS = 10;
    public static final int PASS_MARK = 50;
    public static final int MIN_MARK = 0;
    public static final int MAX_MARK = 100;
    
    private String studentName;
    private double[] studentMarks;
    

    /**
     * Constructor for objects of class Student
     */      
    public Student(String studentName){
        setName(studentName);
        studentMarks = new double[NUM_OF_SUBJECTS];
    }
    
    /**
     * Mutator method to setName
     * @para studentName to set student name
     */
    public void setName(String studentName){
        if(studentName == null || studentName.length() == 0 ){
            throw new IllegalArgumentException("name cannot be null or empty");
        }
        else{
            this.studentName = studentName;
        }
    }
    
    /**
     * Method to prompt student marks
     */
    public void promptStudentMarks(){
        int index = 0;
        double score = 0.0;
        InputReader reader = new InputReader();
        
        while(index < studentMarks.length){
            System.out.print("Subject " + (index+1)+" : ");
            score = reader.readDouble();
            if (score < MIN_MARK || score > MAX_MARK){
                System.out.println("marks must in the range 0 to 100");
            }
            else{
                studentMarks[index] = score;
                index++;
            }
        }
    }
    
    /**
     * Accessor method to getName
     * @return studentName
     */
    public String getName(){
        return studentName;
    }
    /**
     * Method to calculate average mark
     * @return average mark
     */    
    public double calculateAverageMark(){
        int index = 0;
        double sum = 0.0;
        while(index < studentMarks.length){
            sum += studentMarks[index];
            index++;
        }
        return sum / NUM_OF_SUBJECTS;
    }
    
    /**
     * Method to calculate total passed exams
     * @return numberOfPassExams
     */
    public int calculateTotalPassedExams(){
        int index = 0;
        int numberOfPassedExams = 0;
        while(index < studentMarks.length){
            if(studentMarks[index] >= PASS_MARK){
                numberOfPassedExams += 1;
            }
            index++;
        }
        return numberOfPassedExams;
    }
    /**
     * Method to check if student pass all exams
     * @return boolean
     */
    public boolean isPassed(){
        double averageMark = calculateAverageMark();
        int numberOfPassedExams = calculateTotalPassedExams();
        
        if(averageMark >= PASS_MARK && numberOfPassedExams == NUM_OF_SUBJECTS)
            return true;
        else
            return false;
    }
    
    public static void main(String[] args){
        Student student1 = new Student("Brian");
        System.out.println("Student name: " + student1.getName());
        student1.promptStudentMarks();
        System.out.println("Average Mark: " + student1.calculateAverageMark());
        System.out.println("Number of Pass Exams: " + student1.calculateTotalPassedExams());
        if(student1.isPassed())
            System.out.println("Result : PASSED");
        else
            System.out.println("Result : FAILED");
    }
}
