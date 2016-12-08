package org.murillo.fluentq.implementation.test.arraylistq;

import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.Assert;
import org.junit.Test;
import org.murillo.fluentq.implementation.ArrayListQ;

public class ConstructorTests {
    
    @Test
    public void constructor_objectStream_happypath() {
        String[] content = new String[]{"a", "b", "c", null};
        ArrayListQ<String> list = new ArrayListQ<>(Stream.of(content));
        Assert.assertArrayEquals(content, list.toTypedArray(String.class));
    }
    
    @Test
    public void constructor_primitiveStream_happypath() {
        int[] content = new int[]{1,2,3,4};
        ArrayListQ<Integer> list = new ArrayListQ<>(IntStream.of(content));
        Assert.assertArrayEquals(content, ArrayListQ.toIntArray(list));
    }

}
