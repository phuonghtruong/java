public class Main
{
    public static void main(String[] args)
    {
        final Egg egg;
        egg = new Egg(10);
        System.out.println(egg.toString());
    }
}

class Egg
{
    private class Yolk
    {
        private int weight;
        Yolk(final int w)
        {
            weight = w;
            x = 55;
        }

        public int getWeight()
        {
            return weight;
        }
    }

    private Yolk yolk;
    private int x;

    public Egg(final int w)
    {
        yolk = new Yolk(w);
    }

    @Override
    public String toString()
    {
        return "Egg { " +
                "yolk = " + yolk.weight +
                " }";
    }
}

