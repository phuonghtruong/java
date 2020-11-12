package ca.bcit.comp2526.assign2;


public class Main
{
    public static void main(final String[] argv)
    {
        final DataStore<Integer> intStore;
        final DataStore<String> strStore;
        final Accumulator<Integer, Integer> intAccumulator;
        final Accumulator<String, String> strAccumulator;

        intStore = new MemoryDataStore<>(1, 3);
        intStore.setValueAt(0, 0, 10);
        intStore.setValueAt(0, 1, 200);
        intStore.setValueAt(0, 2, 3);

        strStore = new MemoryDataStore<>(1, 3);
        strStore.setValueAt(0, 0, "Hello");
        strStore.setValueAt(0, 1, "Evil");
        strStore.setValueAt(0, 2, "World");

        intAccumulator = new IntegerAccumulator();
        intAccumulator.add((value) -> value, intStore);
        System.out.println(intAccumulator.getResult());

        strAccumulator = new StringAccumulator();
        strAccumulator.add((value) -> value, strStore);
        System.out.println(strAccumulator.getResult()); // Hello, Evil, World

        strStore.setValueAt(0, 0, "Bye");
        strStore.setValueAt(0, 1, null);
        strStore.setValueAt(0, 2, "Bye!"); // Hello, Evil, World, Bye, , Bye!

        strAccumulator.add((value) -> value, strStore);
        System.out.println(strAccumulator.getResult());
    }
}
