package org.murillo.fluentq.test.arraylistq;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.murillo.fluentq.ArrayListQ;
import org.murillo.fluentq.ListQ;

public class ConcatInsertTests {

    ListQ<String> list1;
    ListQ<String> list2;

    @Before
    public void initList() {
        list1 = new ArrayListQ("a", "2", "!", "3", "a", null);
        list2 = new ArrayListQ("a", null, "b", "xyz");
    }

    @Test
    public void concat_happypath() {
        ListQ<String> concat = list1.concat(list2).hold();
        Assert.assertArrayEquals(concat.toTypedArray(String.class), new String[]{"a", "2", "!", "3", "a", null, "a", null, "b", "xyz"});
    }
    
    @Test
    public void concat_array_happypath() {
        ListQ<String> concat = list1.concat(list2.toTypedArray(String.class)).hold();
        Assert.assertArrayEquals(concat.toTypedArray(String.class), new String[]{"a", "2", "!", "3", "a", null, "a", null, "b", "xyz"});
    }
    
    @Test
    public void concat_self_happypath() {
        ListQ<String> concat = list1.concatSelf(list2);
        Assert.assertSame(list1, concat);
        Assert.assertArrayEquals(list1.toTypedArray(String.class), new String[]{"a", "2", "!", "3", "a", null, "a", null, "b", "xyz"});
    }
    
    @Test
    public void concat_self_array_happypath() {
        ListQ<String> concat = list1.concatSelf(list2.toTypedArray(String.class));
        Assert.assertSame(list1, concat);
        Assert.assertArrayEquals(list1.toTypedArray(String.class), new String[]{"a", "2", "!", "3", "a", null, "a", null, "b", "xyz"});
    }
    
    @Test
    public void insert_happypath() {
        ListQ<String> insert = list1.insert(3, list2).hold();
        Assert.assertArrayEquals(insert.toTypedArray(String.class), new String[]{"a", "2", "!", "a", null, "b", "xyz", "3", "a", null});
    }
    
    @Test
    public void insert_array_happypath() {
        ListQ<String> insert = list1.insert(3, list2.toTypedArray(String.class)).hold();
        Assert.assertArrayEquals(insert.toTypedArray(String.class), new String[]{"a", "2", "!", "a", null, "b", "xyz", "3", "a", null});
    }
    
    @Test
    public void insert_self_happypath() {
        ListQ<String> insert = list1.insertSelf(3, list2);
        Assert.assertSame(list1, insert);
        Assert.assertArrayEquals(list1.toTypedArray(String.class), new String[]{"a", "2", "!", "a", null, "b", "xyz", "3", "a", null});
    }
    
    @Test
    public void insert_self_array_happypath() {
        ListQ<String> insert = list1.insertSelf(3, list2.toTypedArray(String.class));
        Assert.assertSame(list1, insert);
        Assert.assertArrayEquals(list1.toTypedArray(String.class), new String[]{"a", "2", "!", "a", null, "b", "xyz", "3", "a", null});
    }

}
