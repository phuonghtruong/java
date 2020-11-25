package ca.bcit.comp2526.assign3;

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
        assertThat(a.getResult(), equalTo("b"));
        assertThat(b.getResult(), equalTo(""));

        store.setValueAt(0, 0, "c");
        a.add((value) -> value, store);
        assertThat(a.getResult(), equalTo("c"));
        assertThat(b.getResult(), equalTo(""));

        store.setValueAt(0, 0, null);
        a.add((value) -> value, store);
        assertThat(a.getResult(), equalTo(""));
        assertThat(b.getResult(), equalTo(""));

        store.setValueAt(0, 0, "");
        a.add((value) -> value, store);
        assertThat(a.getResult(), equalTo(""));
        assertThat(b.getResult(), equalTo(""));

        store.setValueAt(0, 0, "hello, World!");
        a.add(value -> value, store);
        assertThat(a.getResult(), equalTo("hello, World!"));
        assertThat(b.getResult(), equalTo(""));

        a.add(String::toUpperCase, store);
        assertThat(a.getResult(), equalTo("HELLO, WORLD!"));
        assertThat(b.getResult(), equalTo(""));
    }

    @Test
    void add2()
    {
        final StringAccumulator a;
        final StringAccumulator b;
        final DataStore<String> store;

        a = new StringAccumulator();
        b = new StringAccumulator();
        assertThat(a.getResult(), equalTo(""));
        assertThat(b.getResult(), equalTo(""));

        store = new MemoryDataStore<>(3, 4);
        a.add((value) -> value, store);
        assertThat(a.getResult(), equalTo(""));
        assertThat(b.getResult(), equalTo(""));

        store.setValueAt(0, 0, "a");
        a.add((value) -> value, store);
        assertThat(a.getResult(), equalTo("a"));
        assertThat(b.getResult(), equalTo(""));

        store.setValueAt(0, 1, "b");
        a.add((value) -> value, store);
        assertThat(a.getResult(), equalTo("a, b"));
        assertThat(b.getResult(), equalTo(""));

        store.setValueAt(0, 2, "c");
        a.add((value) -> value, store);
        assertThat(a.getResult(), equalTo("a, b, c"));
        assertThat(b.getResult(), equalTo(""));

        store.setValueAt(1, 0, "e");
        a.add((value) -> value, store);
        assertThat(a.getResult(), equalTo("a, b, c, , e"));
        assertThat(b.getResult(), equalTo(""));

        store.setValueAt(0, 3, "d");
        a.add((value) -> value, store);
        assertThat(a.getResult(), equalTo("a, b, c, d, e"));
        assertThat(b.getResult(), equalTo(""));

        store.setValueAt(0, 3, "d");
        a.add(value -> (value == null ? "" : value.toUpperCase()), store);
        assertThat(a.getResult(), equalTo("A, B, C, D, E"));
        assertThat(b.getResult(), equalTo(""));

        store.setValueAt(0, 0, null);
        store.setValueAt(0, 1, null);
        store.setValueAt(0, 2, null);
        store.setValueAt(0, 3, null);
        store.setValueAt(1, 0, null);
        store.setValueAt(1, 1, "hello");
        a.add(value -> value, store);
        assertThat(a.getResult(), equalTo("hello"));
        assertThat(b.getResult(), equalTo(""));

        store.setValueAt(1, 3, "world");
        a.add(value -> value, store);
        assertThat(a.getResult(), equalTo("hello, , world"));
        assertThat(b.getResult(), equalTo(""));
    }
}