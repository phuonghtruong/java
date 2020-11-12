package ca.bcit.comp2526.assign2;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class StringAccumulatorTest
{
    @Test
    void add()
    {
        final StringAccumulator a;
        final StringAccumulator b;

        a = new StringAccumulator();
        b = new StringAccumulator();
        assertThat(a.getResult(), equalTo(""));
        assertThat(b.getResult(), equalTo(""));

        a.add("a");
        assertThat(a.getResult(), equalTo("a"));
        assertThat(b.getResult(), equalTo(""));

        a.add("b");
        assertThat(a.getResult(), equalTo("a, b"));
        assertThat(b.getResult(), equalTo(""));

        a.add("c");
        assertThat(a.getResult(), equalTo("a, b, c"));
        assertThat(b.getResult(), equalTo(""));

        a.add(null);
        assertThat(a.getResult(), equalTo("a, b, c, "));
        assertThat(b.getResult(), equalTo(""));

        a.add("");
        assertThat(a.getResult(), equalTo("a, b, c, , "));
        assertThat(b.getResult(), equalTo(""));

        a.add("hello, World!");
        assertThat(a.getResult(), equalTo("a, b, c, , , hello, World!"));
        assertThat(b.getResult(), equalTo(""));
    }
}