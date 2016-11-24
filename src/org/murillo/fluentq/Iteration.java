/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.murillo.fluentq;

public class Iteration<T,R>{
    private final T value;
    private final int index;

    public Iteration(T value, int index) {
        this.value = value;
        this.index = index;
    }               

    public T getValue() {
        return value;
    }

    public int getIndex() {
        return index;
    }

    public R breakLoop() throws BreakLoopException {
        throw new BreakLoopException();
    }

    public R breakLoop(R returned) throws BreakLoopException {
        throw new BreakLoopException(returned, this);
    }        
}