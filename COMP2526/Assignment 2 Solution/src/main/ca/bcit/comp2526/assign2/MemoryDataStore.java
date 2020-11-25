package ca.bcit.comp2526.assign2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryDataStore<T> implements DataStore<T>{
    List<Map<Integer, T>> rows = new ArrayList<>();

    public MemoryDataStore(final int numberOfRows, final int numberOfColumns) {
        if(numberOfRows <= 0 )
        {
            throw new IllegalArgumentException("rows must be >= 1, was: " + numberOfRows);
        }
        else if (numberOfColumns <= 0)
        {
            throw new IllegalArgumentException("cols must be >= 1, was: " + numberOfColumns);
        }
        else
        {
            createStore(numberOfRows,numberOfColumns,null);
        }

    }

    public void createStore(final int numberOfRows, final int numberOfColumns, final T value)
    {
        for(int rowIndex = 0; rowIndex < numberOfRows; ++rowIndex)
        {
            Map<Integer,T> colAndValue = new HashMap<>();
            for(int colIndex = 0; colIndex < numberOfColumns; ++colIndex)
            {
                colAndValue.put(colIndex,value);
            }
            rows.add(colAndValue);
        }
    }

    @Override
    public void setValueAt(int row, int col, T value)
    {
        if(row < 0 || row >= rows.size() )
        {
            throw new IllegalArgumentException("Row " + row + " does not exist");
        }
        else if(col < 0 || col >= rows.get(row).size())
        {
            throw new IllegalArgumentException("Col " + col + " does not exist");
        }
        else {
            rows.get(row).put(col, value);
        }
    }

    @Override
    public T getValueAt(int row, int col)
    {
        if(row < 0 || row >= rows.size() )
        {
            throw new IllegalArgumentException("Row " + row + " does not exist");
        }
        else if(col < 0 || col >= rows.get(row).size())
        {
            throw new IllegalArgumentException("Col " + col + " does not exist");
        }
        else {
            return rows.get(row).get(col);
        }
    }

    @Override
    public int getRows() {
        return rows.size();
    }

    @Override
    public int getCols() {
        return rows.get(0).size();
    }
}
