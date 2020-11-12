import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Map<Integer, String>> rows = new ArrayList<>();
        Map<Integer,String> colAndValue = new HashMap<>();

        colAndValue.put(1,"Hello");
        colAndValue.put(2, "wold");
        colAndValue.put(3, "ok");

        System.out.println(colAndValue);
        rows.add(colAndValue);
        System.out.println(rows);

        int sizeOfValue = rows.get(0).size();
        System.out.println(sizeOfValue);
        String test2 = rows.get(-1).get(2);
        System.out.println(test2);

    }

    
    
}
