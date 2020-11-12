public class Main {
    public static void main(String[] args) {
        final DoubleList list;

        list = new DoubleList();
        if(list.size() != 0)
        {
            throw new IllegalStateException();
        }
        list.add(10);
        System.out.println(list.getAt(0));
        if(list.size() != 1)
        {
            throw new IllegalStateException();
        }
        list.add(20);
        System.out.println(list.getAt(0));
        System.out.println(list.getAt(1));

    }
}
