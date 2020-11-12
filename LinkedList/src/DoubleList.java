public class DoubleList
{
    private static class Node
    {
        private int value;
        private Node next;
        private Node prev;

        Node(final int val)
        {
            value =val;
        }
    }

    private Node head;
    private Node tail;
    private static int count;

    public DoubleList()
    {

    }

    public void checkState()
    {
        if (head == null && tail != null)
        {
            throw new IllegalStateException("head null, tail isn't");
        }
        if (head != null && tail == null)
        {
            throw new IllegalStateException("head isn't, tail null");
        }
        if (count < 0)
        {
            throw new IllegalStateException("count can't be less than 0");
        }
        if (head == null &&  count != 0)
        {
            throw new IllegalStateException("count should be 0");
        }
        if (head != null && tail == head && count != 1)
        {
            throw new IllegalStateException("count should be 1");
        }
        if (head != null && tail != head && count < 2)
        {
            throw new IllegalStateException("count should be >= 2");
        }
    }

    public int size()
    {
        return count;
    }
    public void add(final int val)
    {
        final Node newNode;

        newNode = new Node(val);
        count++;

        if(head == null)
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }

        checkState();
    }

    public int getAt(final int index)
    {
        Node tmpNode;

        if(index > count - 1)
        {
            throw new IllegalArgumentException(" index must be < " + (count - 1) + " was, " + index);
        }

        tmpNode = head;

        for (int i=0; i < index; i++)
        {

        }

        return tmpNode.value;
    }
}
