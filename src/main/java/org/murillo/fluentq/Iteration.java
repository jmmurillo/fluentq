/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.murillo.fluentq;

import java.io.Serializable;
import java.util.Optional;

public class Iteration<T, R> implements Serializable, Comparable {

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

    public Optional<R> breakLoop() throws BreakLoopException {
        throw new BreakLoopException();
    }

    public Optional<R> breakLoop(Optional<R> returned) throws BreakLoopException {
        throw new BreakLoopException(returned, this);
    }

    @Override
    public int compareTo(Object o) {
        if (o == null) return -1;
        
        Iteration<?, ?> iteration = ((Iteration<?, ?>) o);
        return Integer.compare(this.index, iteration.index);
    }

}
