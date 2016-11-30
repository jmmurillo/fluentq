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
public class PickOneTests {

    ListQ<String> list;
    
    @Before
    public void initList(){
        list = new ArrayListQ("a","2","!","3","e");
    }

    @Test
    public void first_happypath() {
        String first = list.first();
        Assert.assertEquals("a", first);
    }
   
    @Test(expected = IllegalStateException.class)
    public void first_empty() {
        new ArrayListQ().first();
    }
    
    @Test
    public void firstOrDefault_happypath() {
        String first = list.firstOrDefault();
        Assert.assertEquals("a", first);
    }
    
    @Test
    public void firstOrDefault_empty() {
        String first = new ArrayListQ<String>().firstOrDefault();
        Assert.assertNull(first);
    }
    
    @Test
    public void last_happypath() {
        String last = list.last();
        Assert.assertEquals("e", last);
    }
   
    @Test(expected = IllegalStateException.class)
    public void last_empty() {
        new ArrayListQ().last();
    }
    
    @Test
    public void lastOrDefault_happypath() {
        String last = list.lastOrDefault();
        Assert.assertEquals("e", last);
    }
    
    @Test
    public void lastOrDefault_empty() {
        String last = new ArrayListQ<String>().lastOrDefault();
        Assert.assertNull(last);
    }
    
    @Test
    public void first_predicate_happypath() {
        String first = list.first(x -> Character.isDigit(x.charAt(0)));
        Assert.assertEquals("2", first);
    }
   
    @Test(expected = IllegalStateException.class)
    public void first_predicate_empty() {
        list.first(x -> x.length() > 1);
    }
    
    @Test
    public void firstOrDefault_predicate_happypath() {
        String first = list.firstOrDefault(x -> Character.isDigit(x.charAt(0)));
        Assert.assertEquals("2", first);
    }
    
    @Test
    public void firstOrDefault_predicate_empty() {
        String first = list.firstOrDefault(x -> x.length() > 1);
        Assert.assertNull(first);
    }
    
    @Test
    public void last_predicate_happypath() {
        String last = list.last(x -> Character.isDigit(x.charAt(0)));
        Assert.assertEquals("3", last);
    }
    
    @Test(expected = IllegalStateException.class)
    public void last_predicate_empty() {
        list.last(x -> x.length() > 1);
    }
   
    @Test
    public void lastOrDefault_predicate_happypath() {
        String last = list.lastOrDefault(x -> Character.isDigit(x.charAt(0)));
        Assert.assertEquals("3", last);
    }
    
    @Test
    public void lastOrDefault_predicate_empty() {
        String last = list.lastOrDefault(x -> x.length() > 1);
        Assert.assertNull(last);
    }
    
}
