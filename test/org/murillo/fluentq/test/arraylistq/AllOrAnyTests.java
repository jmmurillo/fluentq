/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.murillo.fluentq.test.arraylistq;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.murillo.fluentq.ArrayListQ;
import org.murillo.fluentq.ListQ;

/**
 *
 * @author Usuario
 */
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
