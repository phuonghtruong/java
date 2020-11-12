package ca.bcit.comp2526.assign2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

public class StringAccumulator implements Accumulator<String, String>
{
    List<String> strList;

    public StringAccumulator()
    {
        strList = new ArrayList<>();
    }

    public void add(String value)
    {
        strList.add(Objects.requireNonNullElse(value, ""));
    }
    @Override
    public void add(Function<String, String> function, DataStore<String> store) {
        final int rowInStore = store.getRows();
        final int colInStore = store.getCols();

        for(int indexRow = 0 ; indexRow < rowInStore; ++indexRow )
        {
            for (int indexCol = 0; indexCol < colInStore; ++indexCol)
            {
                String value = store.getValueAt(indexRow,indexCol);
                System.out.printf("Row: %d Col: %d Value: %s\n", indexRow, indexCol, value);
                function = (String var) -> {add(var); return this.getResult();};
                function.apply(value);
            }
        }
    }

    @Override
    public String getResult()
    {
        String delim = ", ";
        return String.join(delim, strList);
    }
}
