import java.lang.reflect.Array;
import java.util.Arrays;

interface MyValue
{
    double getValue();
}

interface MyParamValue
{
    double getValue(double v);
}

interface  NumericTest
{
    boolean test(int n, int m);
}

public class Main {
    public static void reverseString(char[] s) {
        char[] reverseStr = new char[s.length];
        for(int index = s.length - 1, id = 0; index >= 0; index--, id++)
        {
            reverseStr[id] = s[index];
        }
        System.out.println(Arrays.asList(reverseStr));
    }
    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        reverseString(s);

//        MyValue myVal;
//
//        myVal = () -> 98.6;
//        System.out.println("A constant value: " + myVal.getValue());
//
//        MyParamValue myPval = (n)->1.0 / n;
//
//        System.out.println("Recprocal of 4 is " + myPval.getValue(4.0));
//
//        NumericTest isFactor = (n, d) -> (n % d) == 0;
//
//        System.out.println(isFactor.test(10,3));
//        System.out.println(isFactor.test(10,2));
    }
}
