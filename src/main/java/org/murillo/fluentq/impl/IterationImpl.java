/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.murillo.fluentq.impl;

import org.murillo.fluentq.Iteration;
import java.util.Optional;

public class IterationImpl<T, R> implements Iteration<T, R> {

    private final T value;
    private final int index;

    public IterationImpl(T value, int index) {
        this.value = value;
        this.index = index;
    }

    @Override
    public T getValue() {
        return value;
    }

    @Override
    public int getIndex() {
        return index;
    }

    @Override
    public Optional<R> breakLoop() throws BreakLoopException {
        throw new BreakLoopException();
    }

    @Override
    public Optional<R> breakLoop(Optional<R> returned) throws BreakLoopException {
        throw new BreakLoopException(returned, this);
    }

    @Override
    public int compareTo(Object o) {
        if (o == null) return -1;
        
        Iteration<?, ?> iteration = ((Iteration<?, ?>) o);
        return Integer.compare(this.index, iteration.getIndex());
    }

}
