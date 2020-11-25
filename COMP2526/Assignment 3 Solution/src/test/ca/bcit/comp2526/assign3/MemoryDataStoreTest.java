package ca.bcit.comp2526.assign3;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MemoryDataStoreTest
{
    @Test
    void testBadConstuctor()
    {
        testBadConstuctor(0, 0, IllegalArgumentException.class, "rows must be >= 1, was: 0");
        testBadConstuctor(0, 1, IllegalArgumentException.class, "rows must be >= 1, was: 0");
        testBadConstuctor(1, 0, IllegalArgumentException.class, "cols must be >= 1, was: 0");
        testBadConstuctor(-1, 1, IllegalArgumentException.class, "rows must be >= 1, was: -1");
        testBadConstuctor(1, -1, IllegalArgumentException.class, "cols must be >= 1, was: -1");
        testBadConstuctor(-123, 1, IllegalArgumentException.class, "rows must be >= 1, was: -123");
        testBadConstuctor(1, -1432, IllegalArgumentException.class, "cols must be >= 1, was: -1432");
    }

    private void testBadConstuctor(final int rows,
                                   final int cols,
                                   final Class<? extends Throwable> expectedException,
                                   final String expectedMessage)
    {
        final Throwable ex;

        ex = assertThrows(expectedException, () -> { new MemoryDataStore<Object>(rows, cols); });
        assertThat(ex.getMessage(), equalTo(expectedMessage));
    }

    @Test
    void getRowsCols()
    {
        final MemoryDataStore<Character> charStore;
        final MemoryDataStore<Float> floatStore;

        charStore = createStore(3, 5);
        floatStore = createStore(2, 4);

        assertThat(charStore.getRows(), equalTo(3));
        assertThat(charStore.getCols(), equalTo(5));

        assertThat(floatStore.getRows(), equalTo(2));
        assertThat(floatStore.getCols(), equalTo(4));
    }

    @Test void badSetValueAt()
    {
        final MemoryDataStore<Character> charStore;
        final MemoryDataStore<Float> floatStore;

        charStore = createStore(1, 1);
        floatStore = createStore(2, 3);

        badSetValueAt(charStore, -1, 0, 'B', IllegalArgumentException.class, "Row -1 does not exist");
        badSetValueAt(charStore, 1, 0, 'B', IllegalArgumentException.class, "Row 1 does not exist");
        badSetValueAt(charStore, 0, 1, 'B', IllegalArgumentException.class, "Col 1 does not exist");
        badSetValueAt(charStore, 0, -1, 'B', IllegalArgumentException.class, "Col -1 does not exist");

        badSetValueAt(floatStore, -1, 0, 1.0f, IllegalArgumentException.class, "Row -1 does not exist");
        badSetValueAt(floatStore, 2, 0, 1.0f, IllegalArgumentException.class, "Row 2 does not exist");
        badSetValueAt(floatStore, 0, 3, 1.0f, IllegalArgumentException.class, "Col 3 does not exist");
        badSetValueAt(floatStore, 0, -1, 1.0f, IllegalArgumentException.class, "Col -1 does not exist");
    }

    @Test void badGetValueAt()
    {
        final MemoryDataStore<Character> charStore;
        final MemoryDataStore<Float> floatStore;

        charStore = createStore(1, 1);
        floatStore = createStore(2, 3);

        badGetValueAt(charStore, -1, 0, IllegalArgumentException.class, "Row -1 does not exist");
        badGetValueAt(charStore, 1, 0, IllegalArgumentException.class, "Row 1 does not exist");
        badGetValueAt(charStore, 0, 1, IllegalArgumentException.class, "Col 1 does not exist");
        badGetValueAt(charStore, 0, -1, IllegalArgumentException.class, "Col -1 does not exist");

        badGetValueAt(floatStore, -1, 0, IllegalArgumentException.class, "Row -1 does not exist");
        badGetValueAt(floatStore, 2, 0, IllegalArgumentException.class, "Row 2 does not exist");
        badGetValueAt(floatStore, 0, 3, IllegalArgumentException.class, "Col 3 does not exist");
        badGetValueAt(floatStore, 0, -1, IllegalArgumentException.class, "Col -1 does not exist");
    }

    private <T> void badSetValueAt(final DataStore<T> store,
                                   final int row,
                                   final int col,
                                   final T value,
                                   final Class<? extends Throwable> expectedException,
                                   final String expectedMessage)
    {
        final Throwable ex;

        ex = assertThrows(expectedException, () -> { store.setValueAt(row, col, value); });
        assertThat(ex.getMessage(), equalTo(expectedMessage));
    }

    private <T> void badGetValueAt(final DataStore<T> store,
                                   final int row,
                                   final int col,
                                   final Class<? extends Throwable> expectedException,
                                   final String expectedMessage)
    {
        final Throwable ex;

        ex = assertThrows(expectedException, () -> { store.getValueAt(row, col); });
        assertThat(ex.getMessage(), equalTo(expectedMessage));
    }

    @Test
    void setGetValueAt()
    {
        final MemoryDataStore<Character> charStore;
        final MemoryDataStore<Float> floatStore;

        charStore = createStore(2, 3);
        floatStore = createStore(3, 1);

        assertThat(charStore.getValueAt(0, 0), equalTo(null));
        assertThat(charStore.getValueAt(0, 1), equalTo(null));
        assertThat(charStore.getValueAt(0, 2), equalTo(null));
        assertThat(charStore.getValueAt(1, 0), equalTo(null));
        assertThat(charStore.getValueAt(1, 1), equalTo(null));
        assertThat(charStore.getValueAt(1, 2), equalTo(null));

        assertThat(floatStore.getValueAt(0, 0), equalTo(null));
        assertThat(floatStore.getValueAt(1, 0), equalTo(null));
        assertThat(floatStore.getValueAt(2, 0), equalTo(null));

        charStore.setValueAt(0, 0, 'A');
        charStore.setValueAt(1, 0, 'B');
        charStore.setValueAt(0, 2, 'C');
        floatStore.setValueAt(0, 0, 1.0f);
        floatStore.setValueAt(2, 0, 2.2f);

        assertThat(charStore.getValueAt(0, 0), equalTo('A'));
        assertThat(charStore.getValueAt(0, 1), equalTo(null));
        assertThat(charStore.getValueAt(0, 2), equalTo('C'));
        assertThat(charStore.getValueAt(1, 0), equalTo('B'));
        assertThat(charStore.getValueAt(1, 1), equalTo(null));
        assertThat(charStore.getValueAt(1, 2), equalTo(null));

        assertThat(floatStore.getValueAt(0, 0), equalTo(1.0f));
        assertThat(floatStore.getValueAt(1, 0), equalTo(null));
        assertThat(floatStore.getValueAt(2, 0), equalTo(2.2f));
    }

    private static <T> MemoryDataStore<T> createStore(final int rows,
                                                      final int cols)
    {
        final MemoryDataStore<T> store;

        store = new MemoryDataStore<>(rows, cols);

        return  store;
    }
}