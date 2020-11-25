package ca.bcit.comp2526.assign3;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class IntegerAccumulatorTest
{
    @Test
    void add()
    {
        final IntegerAccumulator a;
        final IntegerAccumulator b;
        DataStore<Integer> store;

        a = new IntegerAccumulator();
        b = new IntegerAccumulator();
        assertThat(a.getResult(), equalTo(0));
        assertThat(b.getResult(), equalTo(0));

        store = new MemoryDataStore<>(1, 1);
        store.setValueAt(0, 0, 1);
        a.add((value) -> value, store);
        assertThat(a.getResult(), equalTo(1));
        assertThat(b.getResult(), equalTo(0));

        a.add((value) -> value, store);
        assertThat(a.getResult(), equalTo(1));
        assertThat(b.getResult(), equalTo(0));

        store.setValueAt(0, 0, 3);
        a.add((value) -> value, store);
        assertThat(a.getResult(), equalTo(3));
        assertThat(b.getResult(), equalTo(0));

        store.setValueAt(0, 0, null);
        a.add((value) -> value, store);
        assertThat(a.getResult(), equalTo(0));
        assertThat(b.getResult(), equalTo(0));

        store.setValueAt(0, 0, -6);
        a.add((value) -> value, store);
        assertThat(a.getResult(), equalTo(-6));
        assertThat(b.getResult(), equalTo(0));

        store = new MemoryDataStore<>(1, 1);
        store.setValueAt(0, 0, 1);
        b.add((value) -> value * 2, store);
        assertThat(a.getResult(), equalTo(-6));
        assertThat(b.getResult(), equalTo(2));
    }

    @Test
    void add2()
    {
        final IntegerAccumulator a;
        final IntegerAccumulator b;
        DataStore<Integer> store;

        a = new IntegerAccumulator();
        b = new IntegerAccumulator();
        assertThat(a.getResult(), equalTo(0));
        assertThat(b.getResult(), equalTo(0));

        store = new MemoryDataStore<>(2, 3);

        a.add((value) -> value, store);
        assertThat(a.getResult(), equalTo(0));
        assertThat(b.getResult(), equalTo(0));

        store.setValueAt(0, 0, 1);
        store.setValueAt(0, 1, 1);
        store.setValueAt(0, 2, 1);
        store.setValueAt(1, 0, 1);
        store.setValueAt(1, 1, 1);
        store.setValueAt(1, 2, 1);

        a.add((value) -> value, store);
        assertThat(a.getResult(), equalTo(6));
        assertThat(b.getResult(), equalTo(0));

        a.add((value) -> value * 2, store);
        assertThat(a.getResult(), equalTo(12));
        assertThat(b.getResult(), equalTo(0));

        store.setValueAt(0, 0, 1);
        store.setValueAt(0, 1, 2);
        store.setValueAt(0, 2, 3);
        store.setValueAt(1, 0, 4);
        store.setValueAt(1, 1, 5);
        store.setValueAt(1, 2, 6);

        a.add((value) -> value, store);
        assertThat(a.getResult(), equalTo(21));
        assertThat(b.getResult(), equalTo(0));

        a.add((value) -> 0, store);
        assertThat(a.getResult(), equalTo(0));
        assertThat(b.getResult(), equalTo(0));
    }
}