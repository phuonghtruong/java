package ca.bcit.comp2526.assign1;

import org.junit.jupiter.api.Test;


class LowerCaseFilterTest
    extends FilterTest<LowerCaseFilter>
{
    public LowerCaseFilterTest()
    {
        super(new LowerCaseFilter(),
              new LowerCaseFilter());
    }

    @Test
    public void testApply()
    {
        testFilters("hello", "hello");
        testFilters("Evil", "evil");
        testFilters("WORLD", "world");
        testFilters("HELLO", "hello");
        testFilters("Hello, evil World!", "hello, evil world!");
    }

    @Test
    public void testApplyException()
    {
        testFiltersException(null, IllegalArgumentException.class, "value cannot be null");
    }
}