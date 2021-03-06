package org.murillo.fluentq.implementation.test.arraylistq;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.murillo.fluentq.impl.ArrayListQ;
import org.murillo.fluentq.ListQ;
import org.murillo.fluentq.impl.ListQFuncs;

public class CastTests {

    ListQ<Integer> list;

    @Before
    public void initList() {
        list = new ArrayListQ(2, 3, 4, null);
    }

    @Test
    public void cast_happypath() {
        ListQ<Number> numbers = list.cast(Number.class).hold();
        int[] expected = numbers.extend(ListQFuncs::toIntArray, 0);
        int[] actual = list.extend(ListQFuncs::toIntArray, 0);
        Assert.assertArrayEquals(expected, actual);
        Assert.assertNotSame(numbers, list);
    }

}
