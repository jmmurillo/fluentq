package org.murillo.fluentq.test.arraylistq;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.murillo.fluentq.ArrayListQ;
import org.murillo.fluentq.ListQ;

public class DistinctTests {

    ListQ<String> list;

    @Before
    public void initList() {
        list = new ArrayListQ("a", "2", "!", "3", "a", null);
    }

    @Test
    public void distinct_happypath() {
        ListQ<String> distinct = list.distinct();
        Assert.assertArrayEquals(distinct.toTypedArray(String.class), new String[]{"a", "2", "!", "3", null});
    }

    @Test
    public void distinct_equality_happypath() {
        ListQ<String> distinct = list.distinct((a, b)
                -> a == b
                || ((a != null && b != null)
                && ((Character.isAlphabetic(a.charAt(0)) && Character.isAlphabetic(b.charAt(0)))
                || (Character.isDigit(a.charAt(0)) && Character.isDigit(b.charAt(0))))));
        Assert.assertArrayEquals(distinct.toTypedArray(String.class), new String[]{"a", "2", "!", null});
    }

    @Test
    public void distinct_self_happypath() {
        ListQ<String> distinct = list.distinctSelf();
        Assert.assertSame(list, distinct);
        Assert.assertArrayEquals(list.toTypedArray(String.class), new String[]{"a", "2", "!", "3", null});
    }

    @Test
    public void distinct_equality_self_happypath() {
        ListQ<String> distinct = list.distinctSelf((a, b)
                -> a == b
                || ((a != null && b != null)
                && ((Character.isAlphabetic(a.charAt(0)) && Character.isAlphabetic(b.charAt(0)))
                || (Character.isDigit(a.charAt(0)) && Character.isDigit(b.charAt(0))))));
        Assert.assertSame(list, distinct);
        Assert.assertArrayEquals(list.toTypedArray(String.class), new String[]{"a", "2", "!", null});
    }

}
