package ca.bcit.comp2526.assign2;

import java.util.function.Function;

public class IntegerAccumulator implements Accumulator<Integer,Integer>{
    private int sumValues;

    public void add (Integer value)
    {
        if(value == null)
        {
            value = 0;
        }
        sumValues += value;
    }
    @Override
    public void add(Function<Integer,Integer> function, DataStore<Integer> store)
    {
        final int rowInStore = store.getRows();
        final int colInStore = store.getCols();

        for(int indexRow = 0 ; indexRow < rowInStore; ++indexRow )
        {
            for (int indexCol = 0; indexCol < colInStore; ++indexCol)
            {
                int value = store.getValueAt(indexRow,indexCol);
                System.out.printf("Row: %d Col: %d Value: %d\n", indexRow, indexCol, value);
                function = res -> {add(res); return sumValues;};
                function.apply(value);
            }
        }
    }

    @Override
    public Integer getResult()
    {
        return sumValues;
    }
}
