package org.murillo.fluentq.implementation.test.arraylistq;

import java.util.Optional;
import java.util.Random;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.murillo.fluentq.implementation.ArrayListQ;
import org.murillo.fluentq.ListQ;

public class PickOneTests {

    ListQ<String> list;
    
    @Before
    public void initList(){
        list = new ArrayListQ("a","2","!","3","e");
    }

    @Test
    public void first_happypath() {
        Optional<String> first = list.first();
        Assert.assertEquals("a", first.get());
    }
   
    @Test
    public void first_empty() {
        Optional<String> first = new ArrayListQ().first();
        Assert.assertFalse(first.isPresent());
    }
    
    @Test
    public void first_predicate_happypath() {
        Optional<String> first = list.first(x -> Character.isDigit(x.charAt(0)));
        Assert.assertEquals("2", first.get());
    }
   
    @Test
    public void first_predicate_empty() {
        Optional<String> first = list.first(x -> x.length() > 1);
        Assert.assertFalse(first.isPresent());
    }
    
    @Test
    public void last_happypath() {
        Optional<String> last = list.last();
        Assert.assertEquals("e", last.get());
    }
   
    @Test
    public void last_empty() {
        Optional<String> last = new ArrayListQ().last();
        Assert.assertFalse(last.isPresent());
    } 
    
    @Test
    public void last_predicate_happypath() {
        Optional<String> last = list.last(x -> Character.isDigit(x.charAt(0)));
        Assert.assertEquals("3", last.get());
    }   
    
    @Test
    public void last_predicate_empty() {
        Optional<String> last = list.last(x -> x.length() > 1);
        Assert.assertFalse(last.isPresent());
    }
    
    @Test
    public void single_happypath() {
        Optional<String> single = new ArrayListQ<String>("test").single();
        Assert.assertEquals("test", single.get());
    }
   
    @Test
    public void single_empty() {
        Optional single = new ArrayListQ().single();
        Assert.assertFalse(single.isPresent());
    }
    
    @Test(expected = IllegalStateException.class)
    public void single_two() {
        new ArrayListQ<>("test1", "test2").single();
    }  
    
    @Test
    public void single_predicate_happypath() {
        Optional<String> single = list.single(x -> "3".equals(x));
        Assert.assertEquals("3", single.get());
    }
    
    @Test
    public void single_predicate_empty() {
        Optional<String> single = list.single(x -> x.length() > 1);
        Assert.assertFalse(single.isPresent());
    }
   
    @Test(expected = IllegalStateException.class)
    public void single_predicate_two() {
        new ArrayListQ<>("test1", "test2").single(x -> !x.isEmpty());
    }
    
    public void randomElement_happypath(){
        String randomElement = list.randomElement().get();
        Assert.assertTrue(list.contains(randomElement));
    }

    @Test
    public void randomElement_empty(){
        Optional<String> randomElement = new ArrayListQ<String>().randomElement();
        Assert.assertTrue(!randomElement.isPresent());
    }
    
    @Test
    public void randomElement_custom_happypath(){
        String randomElement = list.randomElement(new Random(123)).get();
        Assert.assertEquals("!", randomElement);
    }

    @Test
    public void randomElement_custom_empty(){
        Optional<String> randomElement = new ArrayListQ<String>().randomElement(new Random(123));
        Assert.assertTrue(!randomElement.isPresent());
    }
}
