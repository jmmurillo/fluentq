package org.murillo.fluentq.implementation.test.arraylistq;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.murillo.fluentq.impl.ArrayListQ;
import org.murillo.fluentq.ListQ;

public class SelectTests {

        ListQ<String> list;
    
    @Before
    public void initList(){
        list = new ArrayListQ("a","2","!","3","e");
    }
    
    @Test
    public void select_happypath() {
        ListQ<Character> alpha = list.select(x -> x.charAt(0)).hold();
        ListQ<Integer> numeric = list.select(x -> (int)x.charAt(0)).hold();
        Assert.assertArrayEquals(alpha.toTypedArray(Character.class), new Character[]{'a','2','!','3','e'});
        Assert.assertArrayEquals(numeric.toTypedArray(Integer.class), new Integer[]{97,50,33,51,101});
        Assert.assertArrayEquals(list.toTypedArray(String.class), new String[]{"a","2","!","3","e"});
    }
   
    @Test
    public void selectI_happypath() {
        ListQ<String> indices = list.<String>selectI(x -> x.getValue()+"["+x.getIndex()+"]")
                .hold();
   
        Assert.assertArrayEquals(indices.toTypedArray(String.class), new String[]{"a[0]","2[1]","![2]","3[3]","e[4]"});
        Assert.assertArrayEquals(list.toTypedArray(String.class), new String[]{"a","2","!","3","e"});
    }
    
}
