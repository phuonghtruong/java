package ca.bcit.comp2526.assign1;

public class Filter
{
    public String apply(final String source) {
        if (source == null) {
            throw new IllegalArgumentException("value cannot be null");
        }
        return source;
    }
}
