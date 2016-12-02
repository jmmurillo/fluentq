package org.murillo.fluentq.test.arraylistq;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.murillo.fluentq.ArrayListQ;
import org.murillo.fluentq.ListQ;

public class UnionTests {

    ListQ<String> list1, list2;

    @Before
    public void initList() {
        list1 = new ArrayListQ("a", "2", "!", "3", "a", null);
        list2 = new ArrayListQ("a", null, "b", "xyz");
    }

    @Test
    public void union_happypath() {
        ListQ<String> union = list1.union(list2);
        Assert.assertArrayEquals(union.toTypedArray(String.class), new String[]{"a", "2", "!", "3", "a", null, "b", "xyz"});
    }

    @Test
    public void union_equality_happypath() {
        ListQ<String> union = list1.union(list2, (a,b) ->  
                a==b || (a!=null && b!=null && a.length() == b.length()));
        Assert.assertArrayEquals(union.toTypedArray(String.class), new String[]{"a", "2", "!", "3", "a", null, "xyz"});
    }
    
    @Test
    public void union_self_happypath() {
        list1.unionSelf(list2);
        Assert.assertArrayEquals(list1.toTypedArray(String.class), new String[]{"a", "2", "!", "3", "a", null, "b", "xyz"});
    }

    @Test
    public void union_equality_self_happypath() {
        list1.unionSelf(list2, (a,b) ->  
                a==b || (a!=null && b!=null && a.length() == b.length()));
        Assert.assertArrayEquals(list1.toTypedArray(String.class), new String[]{"a", "2", "!", "3", "a", null, "xyz"});
    }

}