package ca.bcit.comp2526.assign2;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class IntegerAccumulatorTest
{
    @Test
    void add()
    {
        final IntegerAccumulator a;
        final IntegerAccumulator b;

        a = new IntegerAccumulator();
        b = new IntegerAccumulator();
        assertThat(a.getResult(), equalTo(0));
        assertThat(b.getResult(), equalTo(0));

        a.add(1);
        assertThat(a.getResult(), equalTo(1));
        assertThat(b.getResult(), equalTo(0));

        a.add(1);
        assertThat(a.getResult(), equalTo(2));
        assertThat(b.getResult(), equalTo(0));

        a.add(3);
        assertThat(a.getResult(), equalTo(5));
        assertThat(b.getResult(), equalTo(0));

        a.add(null);
        assertThat(a.getResult(), equalTo(5));
        assertThat(b.getResult(), equalTo(0));

        a.add(-6);
        assertThat(a.getResult(), equalTo(-1));
        assertThat(b.getResult(), equalTo(0));
    }
}