package org.murillo.fluentq.implementation.test.arraylistq;

import org.junit.Assert;
import org.junit.Test;
import org.murillo.fluentq.impl.ArrayListQ;
import org.murillo.fluentq.ListQ;

public class AggregateTests {

    @Test
    public void aggregate_happypath() {
        ListQ<String> list = new ArrayListQ("a","b","c","d","e");
        String result = list.aggregate((x, y) -> x + ", " + y).get();
        Assert.assertEquals("a, b, c, d, e", result);
    }

    @Test
    public void accumulate_happypath() {
        ListQ<String> list = new ArrayListQ("a","b","c","d","e");
        Integer result = list.accumulate((Integer x, String y) -> x + y.length(), 0);
        Assert.assertEquals(5, result.intValue());
    }
    
    @Test
    public void accumulateI_happypath() {
        ListQ<Integer> list = ArrayListQ.of(2,3,5,7,11,13);
        String result = list.accumulateI((x, y) -> x + "a["+y.getIndex()+"] = " + y.getValue() + ", ", "");
        Assert.assertEquals("a[0] = 2, a[1] = 3, a[2] = 5, a[3] = 7, a[4] = 11, a[5] = 13, ", result);
    }
}
