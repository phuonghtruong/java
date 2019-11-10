
/**
 * Write a description of class Play here.
 *
 * @author Brian
 * @version 01
 */
import java.util.Random;
public class Play
{
    // instance variables - replace the example below with your own
    public static final int LOWER_LIMIT = 1;
    public static final int UPPER_LIMIT = 10;
    private InputReader reader;

    /**
     * Constructor for objects of class Play
     */
    public Play()
    {
        // initialise instance variables
        reader = new InputReader();
    }

    /**
     * Method String Play
     */
    public void stringPlay()
    {
        System.out.println("Enter a string: ");
        String inputString = reader.readString();
        
        for(int count = 0; count < inputString.length() ; ++count){
            System.out.print(inputString.substring(0,1).toUpperCase() + inputString.substring(1).toLowerCase());
            System.out.print(" ");
        }
        System.out.println();
    }
    
    /**
     * Method getMultiplicationTable
     */
    public void getMultiplicationTable(){
        int num1 = 0;
        int num2 = 0;
        int [][]arrayTable;
        while(true){
            System.out.println("Enter two integer number between 1 and 10: ");
            num1 = reader.readInt();
            num2 = reader.readInt();
            if(num1 < LOWER_LIMIT || num1 > UPPER_LIMIT || num2 < LOWER_LIMIT || num2 > UPPER_LIMIT){
                System.out.println("Invalid number!");
            }
            else{
                arrayTable = new int[num1+1][num2+1];
                break;
            }
        }
        
        for(int row = 0; row < arrayTable.length; ++row){
            for(int col = 0;  col < arrayTable[row].length; ++col){
                arrayTable[row][col] = row * col;
            }
        }
        
        for(int row = 0; row < arrayTable.length; ++row){
            for(int col = 0;  col < arrayTable[row].length; ++col){
                System.out.print(arrayTable[row][col] + " ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args){
        Play play1 = new Play();
        play1.stringPlay();
        play1.getMultiplicationTable();
    }
}
