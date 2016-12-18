package org.murillo.fluentq.implementation.test.arraylistq;

import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.murillo.fluentq.impl.ArrayListQ;
import org.murillo.fluentq.ListQ;

public class GroupByTests {

        ListQ<String> list;
    
    @Before
    public void initList(){
        list = new ArrayListQ("a","2","!","3","e", "aa", "22", "!!", "33", "ee");
    }
    
    @Test
    public void groupBy_happypath() {
        HashMap<Character, ListQ<String>> groupBy1 = list.groupBy(x -> x.charAt(0));
        
        ListQ<Map.Entry<Character, ListQ<String>>> newList = ArrayListQ.ofEntries(groupBy1).orderBySelf(x -> x.getKey());
        ListQ<Character> keys = newList.select(x -> x.getKey());
        ListQ<ListQ<String>> values = newList.select(x -> x.getValue());
        
        Assert.assertEquals(keys, ArrayListQ.of('!','2','3','a','e'));
        Assert.assertEquals(values, ArrayListQ.ofLists(new String[][]{{"!","!!"},{"2","22"},{"3","33"},{"a","aa"},{"e","ee"}}));
    }
    
    @Test
    public void groupByI_happypath() {
        HashMap<Integer, ListQ<String>> groupBy1 = list.groupByI(x -> x.getIndex()%3);
        
        ListQ<Integer> keys = new ArrayListQ<>(groupBy1.keySet()).orderSelf();
        ListQ<ListQ<String>> values = new ArrayListQ<>(groupBy1.values());
        
        Assert.assertEquals(keys, ArrayListQ.of(0,1,2));
        Assert.assertEquals(values, ArrayListQ.ofLists(new String[][]{{"a","3","22","ee"},{"2","e","!!"},{"!","aa","33"}}));
    }
    
}
