import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final List<String> list;

        list = new ArrayList<>();
        list.add("Hello");
        list.add("Evil");
        list.add("World");

        String str = list.stream()
                .max(Comparator.comparing(String::length))
                .orElse(null);
        System.out.println(str);
    }


}
