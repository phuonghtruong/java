package ca.bcit.comp2526.assign2;


import java.util.function.Function;


public interface Accumulator<D, T>
{
    void add(Function<D, T> function, DataStore<D> store);
    T getResult();
}
