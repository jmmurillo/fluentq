package org.murillo.fluentq.implementation.test.arraylistq;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.murillo.fluentq.impl.ArrayListQ;
import org.murillo.fluentq.ListQ;

public class WhereTests {

    ListQ<String> list;
    
    @Before
    public void initList(){
        list = new ArrayListQ("a","2","!","3","e");
    }
    
    @Test
    public void where_happypath() {
        ListQ<String> alpha = list.where(x -> Character.isAlphabetic(x.charAt(0))).hold();
        ListQ<String> numeric = list.where(x -> Character.isDigit(x.charAt(0))).hold();
        Assert.assertArrayEquals(alpha.toTypedArray(String.class), new String[]{"a", "e"});
        Assert.assertArrayEquals(numeric.toTypedArray(String.class), new String[]{"2", "3"});
        Assert.assertArrayEquals(list.toTypedArray(String.class), new String[]{"a","2","!","3","e"});
    }
   
    @Test
    public void whereI_happypath() {
        ListQ<String> numeric = list.whereI(x -> Character.isDigit(x.getValue().charAt(0))).hold();
        ListQ<String> evenIndices = list.whereI(x -> x.getIndex()%2 == 0).hold();
        Assert.assertArrayEquals(numeric.toTypedArray(String.class), new String[]{"2", "3"});
        Assert.assertArrayEquals(evenIndices.toTypedArray(String.class), new String[]{"a","!","e"});
        Assert.assertArrayEquals(list.toTypedArray(String.class), new String[]{"a","2","!","3","e"});
    }
    
    @Test
    public void whereSelf_happypath() {       
        ListQ<String> alpha = list.whereSelf(x -> Character.isAlphabetic(x.charAt(0)));
        Assert.assertSame(list, alpha);
        Assert.assertArrayEquals(alpha.toTypedArray(String.class), new String[]{"a","e"});
    }
   
    @Test
    public void whereISelf_happypath() {
        ListQ<String> evenIndices = list.whereISelf(x -> x.getIndex()%2 == 0);
        Assert.assertSame(list, evenIndices);
        Assert.assertArrayEquals(evenIndices.toTypedArray(String.class), new String[]{"a","!","e"});
    }
}
