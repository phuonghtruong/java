package ca.bcit.comp2526.assign1;

public class CapitalizationFilter extends Filter
{
    @Override
    public String apply(String source)
    {
        if (source == null)
        {
            throw new IllegalArgumentException("value cannot be null");
        }
        String result = source.substring(0, 1).toUpperCase() + source.substring(1).toLowerCase();
        return result;
    }
}
