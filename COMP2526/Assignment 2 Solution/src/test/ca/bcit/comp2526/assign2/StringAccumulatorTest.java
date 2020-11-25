package ca.bcit.comp2526.assign2;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class StringAccumulatorTest
{
    @Test
    void add()
    {
        final StringAccumulator a;
        final StringAccumulator b;
        final DataStore<String> store;

        a = new StringAccumulator();
        b = new StringAccumulator();
        assertThat(a.getResult(), equalTo(""));
        assertThat(b.getResult(), equalTo(""));

        store = new MemoryDataStore<>(1, 1);
        store.setValueAt(0, 0, "a");
        a.add((value) -> value, store);
        assertThat(a.getResult(), equalTo("a"));
        assertThat(b.getResult(), equalTo(""));

        store.setValueAt(0, 0, "b");
        a.add((value) -> value, store);
        assertThat(a.getResult(), equalTo("a, b"));
        assertThat(b.getResult(), equalTo(""));

        store.setValueAt(0, 0, "c");
        a.add((value) -> value, store);
        assertThat(a.getResult(), equalTo("a, b, c"));
        assertThat(b.getResult(), equalTo(""));

        store.setValueAt(0, 0, null);
        a.add((value) -> value, store);
        assertThat(a.getResult(), equalTo("a, b, c, "));
        assertThat(b.getResult(), equalTo(""));

        store.setValueAt(0, 0, "");
        a.add((value) -> value, store);
        assertThat(a.getResult(), equalTo("a, b, c, , "));
        assertThat(b.getResult(), equalTo(""));

        store.setValueAt(0, 0, "hello, World!");
        a.add((value) -> value, store);
        assertThat(a.getResult(), equalTo("a, b, c, , , hello, World!"));
        assertThat(b.getResult(), equalTo(""));
    }
}