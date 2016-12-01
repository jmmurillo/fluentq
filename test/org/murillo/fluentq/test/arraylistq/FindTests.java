/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.murillo.fluentq.test.arraylistq;

import java.util.Optional;
import java.util.function.Function;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.murillo.fluentq.ArrayListQ;
import org.murillo.fluentq.Iteration;
import org.murillo.fluentq.ListQ;

/**
 *
 * @author Usuario
 */
public class FindTests {

    ListQ<String> list;

    @Before
    public void initList() {
        list = new ArrayListQ("a", "2", "!", "3", "e");
    }

    @Test
    public void findFirst_happypath() {
        Optional<Character> findFirst = list.findFirst(x -> {
            char c = x.charAt(0);
            if (c == Character.toUpperCase(c)) {
                return Optional.of(c);
            } else {
                return Optional.empty();
            }
        });
        Assert.assertEquals('2', findFirst.get().charValue());
    }
    
    @Test
    public void findFirstI_happypath() {
        Optional<Character> findFirst = list.findFirstI(x -> {
            char c = x.getValue().charAt(0);
            if (Character.isDigit(c)
                    && x.getIndex() == Character.digit(c,10)) {
                return Optional.of(c);
            } else {
                return Optional.empty();
            }
        });
        Assert.assertEquals('3', findFirst.get().charValue());
    }

        @Test
    public void findLast_happypath() {
        Optional<Character> findFirst = list.findLast(x -> {
            char c = x.charAt(0);
            if (c == Character.toUpperCase(c)) {
                return Optional.of(c);
            } else {
                return Optional.empty();
            }
        });
        Assert.assertEquals('3', findFirst.get().charValue());
    }
    
    @Test
    public void findLastI_happypath() {
        Optional<Character> findFirst = list.findLastI(x -> {
            char c = x.getValue().charAt(0);
            if (Character.isDigit(c)
                    && x.getIndex() == Character.digit(c,10)) {
                return Optional.of(c);
            } else {
                return Optional.empty();
            }
        });
        Assert.assertEquals('3', findFirst.get().charValue());
    }
}
