
/**
 * Write a description of class MathUtilities here.
 *
 * @author Brian
 * @version (a version number or a date)
 */
public class MathUtilities
{

    /**
     * Static method power
     *
     * @param base to set base
     * @param exponent to set exponent
     * @return result
     */
    public static int power(int base, int exponent)
    {
        // put your code here
        int result = 1;
        while(exponent > 0){
            result = result * base;
            exponent--;
        }
        return result;
    }

    /**
     * Method calculator
     * @param firstNumber to set the first number
     * @param secondNumber to set the second number
     * @param operation to set the operation
     */

    public static void calculator(double firstNumber, char operation, double secondNumber){
        double result = 0.0;
        switch (operation){
            case '+':   result = firstNumber + secondNumber;
            System.out.println("The result of " + firstNumber + " " +operation+" "+secondNumber+ " = " + result);
            break;
            case '-':   result = firstNumber - secondNumber;
            System.out.println("The result of " + firstNumber + " " +operation+" "+secondNumber+ " = " + result);
            break;
            case '*':   result = firstNumber * secondNumber;
            System.out.println("The result of " + firstNumber + " " +operation+" "+secondNumber+ " = " + result);
            break;
            case '/':   if(secondNumber == 0){
                throw new IllegalArgumentException("Denominator cannot be zero");
            }else{
                result = firstNumber / secondNumber;
                System.out.println("The result of " + firstNumber + " " +operation+" "+secondNumber+ " = " + result);
            }
            break;
            case '%':   if(secondNumber == 0){
                throw new IllegalArgumentException("Denominator cannot be zero");
            }else{
                result = firstNumber % secondNumber;
                System.out.println("The result of " + firstNumber + " " +operation+" "+secondNumber+ " = " + result);
            }
            break;
            default:    System.out.println("Invalid operation");
        }
    }

    /**
     * Static method sumOddNumbers
     * @param number to set number
     */
    public static double sumOddNumbers(int number){
        double sum = 0;
        if(number < 0){
            throw new IllegalArgumentException("Number cannot be negative");
        }else{
            while(number > 0){
                if(number % 2 != 0){
                    System.out.println(number);
                    sum += number;
                }
                number--;
            }
            System.out.println("Sum of odd numbers is : " + sum);
            return sum;
        }
    }
    /**
     * static method to display square number
     * @param number to set number
     */
    public static void displaySquareNumbers(int number){
        int count = 0;
        if(number < 0){
            while(number < 0){
                System.out.println("The square of " + number + " is: " + power(number,2));
                number++;
            }
        }else{
            while(count <= number){
                System.out.println("The square of " + count + " is: " + power(count,2));
                count++;
            }
        }
    }
    /**
     * static method to get Factorial
     * @param number to set number
     */
    public static void getFactorial(int number){
        int result;
        if(number < 0){
            throw new IllegalArgumentException("Factorial of negative number cannot be defined");
        } else if(number == 0){
            result = 1;
            System.out.println("Factorial of " + number+ " : " + result);
        }else{
            result = 1;
            int inputNum = number;
            while(number > 0){
                result *= number;
                number--;
            }
            System.out.println("Factorial of " + inputNum+ " : " + result);
        }
    }
      
}
