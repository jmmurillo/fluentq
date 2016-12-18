package org.murillo.fluentq.implementation.test.arraylistq;

import java.util.OptionalDouble;
import java.util.OptionalLong;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.murillo.fluentq.impl.ArrayListQ;
import org.murillo.fluentq.ListQ;

public class NumericalTests {

    ListQ<Number> list;
    
    @Before
    public void initList(){
        list = new ArrayListQ(0.1, 2.3, 1.2, 3.4, 5.6, 4.5, 2L, 1, 3L, 4, 5L);
    }
    
    @Test
    public void sumAsDouble_happypath() {
        double sum = list.sumAsDouble();
        Assert.assertEquals(32.1, sum, 0);
    }
    
    @Test
    public void sumAsLong_happypath() {
        long sum = list.sumAsLong();
        Assert.assertEquals(30, sum);
    }
    
    @Test
    public void sumAsDouble_select_happypath() {
        double sum = list.sumAsDouble(x -> x.doubleValue() * x.doubleValue());
        Assert.assertEquals(124.91, sum, 0);
    }
    
    @Test
    public void sumAsLong_select_happypath() {
        long sum = list.sumAsLong(x -> (long)(x.doubleValue() * x.doubleValue()));
        Assert.assertEquals(123, sum);
    }
    
    @Test
    public void maxAsDouble_happypath() {
        OptionalDouble max = list.maxAsDouble();
        Assert.assertEquals(5.6, max.getAsDouble(), 0);
    }
    
    @Test
    public void maxAsLong_happypath() {
        OptionalLong max = list.maxAsLong();
        Assert.assertEquals(5, max.getAsLong(), 0);
    }
    
    @Test
    public void maxAsDouble_select_happypath() {
        OptionalDouble max = list.maxAsDouble(x -> x.doubleValue() * x.doubleValue());
        Assert.assertEquals(31.36, max.getAsDouble(), 1E-14);
    }
    
    @Test
    public void maxAsLong_select_happypath() {
        OptionalLong max = list.maxAsLong(x -> (long)(x.doubleValue() * x.doubleValue()));
        Assert.assertEquals(31, max.getAsLong(), 0);
    }
    
    @Test
    public void minAsDouble_happypath() {
        OptionalDouble min = list.minAsDouble();
        Assert.assertEquals(0.1, min.getAsDouble(), 1E-14);
    }
    
    @Test
    public void minAsLong_happypath() {
        OptionalLong min = list.minAsLong();
        Assert.assertEquals(0, min.getAsLong(), 0);
    }
    
    @Test
    public void minAsDouble_select_happypath() {
        OptionalDouble min = list.minAsDouble(x -> x.doubleValue() * x.doubleValue());
        Assert.assertEquals(0.01, min.getAsDouble(), 1E-14);
    }
    
    @Test
    public void minAsLong_select_happypath() {
        OptionalLong min = list.minAsLong(x -> (long)(x.doubleValue() * x.doubleValue()));
        Assert.assertEquals(0, min.getAsLong(), 0);
    }
}
