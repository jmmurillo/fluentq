package org.murillo.fluentq.implementation.test.arraylistq;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.murillo.fluentq.implementation.ArrayListQ;
import org.murillo.fluentq.ListQ;

public class IntersectTests {

    ListQ<String> list1;
    ListQ<String> list2;

    @Before
    public void initList() {
        list1 = new ArrayListQ("a", "2", "!", "3", "a", "bc", null);
        list2 = new ArrayListQ("a", null, "b", "xyz");
    }

    @Test
    public void intersect_happypath() {
        ListQ<String> intersection = list1.intersect(list2).hold();
        Assert.assertArrayEquals(intersection.toTypedArray(String.class), new String[]{"a", "a", null});
    }

    @Test
    public void union_equality_happypath() {
        ListQ<String> intersection = list1.intersect(list2, (a,b) ->  
                a==b || (a!=null && b!=null && a.length() == b.length())).hold();
        Assert.assertArrayEquals(intersection.toTypedArray(String.class), new String[]{"a", "2", "!", "3", "a", null});
    }   

    @Test
    public void intersect_self_happypath() {
        ListQ<String> intersect = list1.intersectSelf(list2);
        Assert.assertSame(list1, intersect);
        Assert.assertArrayEquals(list1.toTypedArray(String.class), new String[]{"a", "a", null});
    }

    @Test
    public void intersect_equality_self_happypath() {
        ListQ<String> intersect = list1.intersectSelf(list2, (a,b) ->  
                a==b || (a!=null && b!=null && a.length() == b.length()));
        Assert.assertSame(list1, intersect);
        Assert.assertArrayEquals(list1.toTypedArray(String.class), new String[]{"a", "2", "!", "3", "a", null});
    } 
    
}
