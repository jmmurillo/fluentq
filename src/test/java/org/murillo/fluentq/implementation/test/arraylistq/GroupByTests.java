package org.murillo.fluentq.implementation.test.arraylistq;

import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.murillo.fluentq.implementation.ArrayListQ;
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
    
}
