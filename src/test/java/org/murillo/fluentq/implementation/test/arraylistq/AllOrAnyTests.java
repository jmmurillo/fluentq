package org.murillo.fluentq.implementation.test.arraylistq;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.murillo.fluentq.implementation.ArrayListQ;
import org.murillo.fluentq.ListQ;

public class AllOrAnyTests {

    ListQ<String> list;
    
    @Before
    public void initList(){
        list = new ArrayListQ("a","2","!","3","e");
    }
    
    @Test    
    public void all_happypath() {
        boolean resultTrue = list.all(x -> x.length() == 1);
        boolean resultFalse = list.all(x -> Character.isLetterOrDigit(x.charAt(0)));
        Assert.assertTrue(resultTrue);
        Assert.assertFalse(resultFalse);
    }
   
    @Test
    public void any_happypath() {
        boolean resultFalse = list.any(x -> x.length() != 1);
        boolean resultTrue = list.any(x -> !Character.isLetterOrDigit(x.charAt(0)));
        Assert.assertTrue(resultTrue);
        Assert.assertFalse(resultFalse);
    }
    
}
