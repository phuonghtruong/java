import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //int value = 5;

        Collection values = new ArrayList<Integer>();

        values.add(7);
        values.add("hello");

        Iterator i = values.iterator();

        while(i.hasNext())
        {
            System.out.println(i.next());
        }

        for(Object j : values)
        {
            System.out.println(j);
        }
    }
}
