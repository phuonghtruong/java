package ca.bcit.comp2526.assign2;

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
        assertThat(a.getResult(), equalTo(  2));
        assertThat(b.getResult(), equalTo(0));

        store.setValueAt(0, 0, 3);
        a.add((value) -> value, store);
        assertThat(a.getResult(), equalTo(5));
        assertThat(b.getResult(), equalTo(0));

        store.setValueAt(0, 0, null);
        a.add((value) -> value, store);
        assertThat(a.getResult(), equalTo(5));
        assertThat(b.getResult(), equalTo(0));

        store.setValueAt(0, 0, -6);
        a.add((value) -> value, store);
        assertThat(a.getResult(), equalTo(-1));
        assertThat(b.getResult(), equalTo(0));
    }
}