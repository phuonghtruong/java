package ca.bcit.comp2526.assign1;

import org.junit.jupiter.api.Test;


class CapitalizationFilterTest
        extends FilterTest<CapitalizationFilter>
{
    public CapitalizationFilterTest()
    {
        super(new CapitalizationFilter(),
              new CapitalizationFilter());
    }

    @Test
    public void testApply()
    {
        testFilters("hello", "Hello");
        testFilters("Evil", "Evil");
        testFilters("WORLD", "World");
        testFilters("HELLO", "Hello");
        testFilters("Hello, evil World!", "Hello, evil world!");
    }

    @Test
    public void testApplyException()
    {
        testFiltersException(null, IllegalArgumentException.class, "value cannot be null");
    }
}