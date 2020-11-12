package ca.bcit.comp2526.assign1;

import org.junit.jupiter.api.Test;


class ReverseFilterTest
        extends FilterTest<ReverseFilter>
{
    public ReverseFilterTest()
    {
        super(new ReverseFilter(),
              new ReverseFilter());
    }

    @Test
    public void testApply()
    {
        testFilters("hello", "olleh");
        testFilters("Evil", "livE");
        testFilters("WORLD", "DLROW");
        testFilters("HELLO", "OLLEH");
        testFilters("Hello, evil World!", "!dlroW live ,olleH");
    }

    @Test
    public void testApplyException()
    {
        testFiltersException(null, IllegalArgumentException.class, "value cannot be null");
    }
}