package org.murillo.fluentq.test.arraylistq;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.murillo.fluentq.ArrayListQ;
import org.murillo.fluentq.ListQ;

public class CastTests {

    ListQ<Integer> list;

    @Before
    public void initList() {
        list = new ArrayListQ(2, 3, 4, null);
    }

    @Test
    public void cast_happypath() {
        ListQ<Number> numbers = list.cast(Number.class);
        Assert.assertArrayEquals(ArrayListQ.toIntArray(numbers, 0), ArrayListQ.toIntArray(list, 0));
        Assert.assertNotSame(numbers, list);
    }

}
