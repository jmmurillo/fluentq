/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.murillo.fluentq.test.arraylistq;

import java.util.Random;
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
    
    @Test
    public void single_happypath() {
        String single = new ArrayListQ<String>("test").single();
        Assert.assertEquals("test", single);
    }
   
    @Test(expected = IllegalStateException.class)
    public void single_empty() {
        new ArrayListQ().single();
    }
    
    @Test(expected = IllegalStateException.class)
    public void single_two() {
        new ArrayListQ<>("test1", "test2").single();
    }
    
    @Test
    public void singleOrDefault_happypath() {
        String single = new ArrayListQ<String>("test").singleOrDefault();
        Assert.assertEquals("test", single);
    }
    
    @Test
    public void singleOrDefault_empty() {
        String single = new ArrayListQ<String>().singleOrDefault();
        Assert.assertNull(single);
    }   
    
    @Test(expected = IllegalStateException.class)
    public void singleOrDefault_two() {
        new ArrayListQ<>("test1", "test2").singleOrDefault();
    }
    
    @Test
    public void single_predicate_happypath() {
        String single = list.single(x -> "3".equals(x));
        Assert.assertEquals("3", single);
    }
    
    @Test(expected = IllegalStateException.class)
    public void single_predicate_empty() {
        list.single(x -> x.length() > 1);
    }
   
    @Test(expected = IllegalStateException.class)
    public void single_predicate_two() {
        new ArrayListQ<>("test1", "test2").single(x -> !x.isEmpty());
    }
    
    @Test
    public void singleOrDefault_predicate_happypath() {
        String single = list.singleOrDefault(x -> "3".equals(x));
        Assert.assertEquals("3", single);
    }
    
    @Test
    public void singleOrDefault_predicate_empty() {
        String single = list.singleOrDefault(x -> x.length() > 1);
        Assert.assertNull(single);
    }
    
    @Test(expected = IllegalStateException.class)
    public void singleOrDefault_predicate_two() {
        new ArrayListQ<>("test1", "test2").singleOrDefault(x -> !x.isEmpty());
    }
    
    public void randomElement_happypath(){
        String randomElement = list.randomElement();
        Assert.assertTrue(list.contains(randomElement));
    }

    @Test(expected = IllegalStateException.class)
    public void randomElement_empty(){
        new ArrayListQ<String>().randomElement();
    }
    
    @Test
    public void randomElement_custom_happypath(){
        String randomElement = list.randomElement(new Random(123));
        Assert.assertEquals("!", randomElement);
    }

    @Test(expected = IllegalStateException.class)
    public void randomElement_custom_empty(){
        new ArrayListQ<String>().randomElement(new Random(123));
    }
}
