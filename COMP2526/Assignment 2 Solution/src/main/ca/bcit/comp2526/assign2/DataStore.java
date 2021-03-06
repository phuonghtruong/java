package ca.bcit.comp2526.assign2;

public interface DataStore<T>
{
    void setValueAt(int row, int col, T value);
    T getValueAt(int row, int col);
    int getRows();
    int getCols();
}
