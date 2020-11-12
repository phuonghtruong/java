package ca.bcit.comp2526.assign1;

import org.junit.jupiter.api.Test;


class UpperCaseFilterTest
    extends FilterTest<UpperCaseFilter>
{
    public UpperCaseFilterTest()
    {
        super(new UpperCaseFilter(),
              new UpperCaseFilter());
    }

    @Test
    public void testApply()
    {
        testFilters("hello", "HELLO");
        testFilters("Evil", "EVIL");
        testFilters("WORLD", "WORLD");
        testFilters("HELLO", "HELLO");
        testFilters("Hello, evil World!", "HELLO, EVIL WORLD!");
    }

    @Test
    public void testApplyException()
    {
        testFiltersException(null, IllegalArgumentException.class, "value cannot be null");
    }
}