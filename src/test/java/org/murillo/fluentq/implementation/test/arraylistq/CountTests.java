package org.murillo.fluentq.implementation.test.arraylistq;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.murillo.fluentq.impl.ArrayListQ;
import org.murillo.fluentq.ListQ;

public class CountTests {

    ListQ<String> list;

    @Before
    public void initList() {
        list = new ArrayListQ("a", "2", "!", "3", "a", "bc", null);
    }

    @Test
    public void count_happypath() {
        int count = list.count();
        Assert.assertEquals(7, count);
    }

    @Test
    public void count_predicate_happypath() {
        int count = list.count(x -> x==null || x.length()>1);
        Assert.assertEquals(2, count);
    }       
}
