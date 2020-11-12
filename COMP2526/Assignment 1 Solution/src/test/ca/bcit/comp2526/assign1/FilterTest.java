package ca.bcit.comp2526.assign1;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;


public abstract class FilterTest<T extends Filter>
{
    private final List<T> filters;

    protected FilterTest(T ... filterList)
    {
        filters = new ArrayList<>();

        for(final T filter : filterList)
        {
            filters.add(filter);
        }
    }

    protected void testFilters(final String source,
                               final String expected)
    {
        for(final T filter : filters)
        {
            testFilter(filter, source, expected);
        }
    }

    private void testFilter(final Filter filter,
                            final String source,
                            final String expected)
    {
        assertThat(filter.apply(source), equalTo(expected));
    }

    protected void testFiltersException(final String source,
                                        final Class<? extends Throwable> expectedType,
                                        final String expectedMessage)
    {
        for(final T filter : filters)
        {
            testFilterException(filter, source, expectedType,expectedMessage);
        }
    }

    private void testFilterException(final Filter filter,
                                     final String source,
                                     final Class<? extends Throwable> expectedType,
                                     final String expectedMessage)
    {
        Throwable ex;

        ex = assertThrows(expectedType, () -> { filter.apply(source); } );
        assertThat(ex.getMessage(), equalTo(expectedMessage));
    }

}
