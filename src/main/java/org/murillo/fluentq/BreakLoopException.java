/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.murillo.fluentq;

import java.util.Optional;

final class BreakLoopException extends RuntimeException{

    private Iteration<?,?> lastIteration;
    private Optional<?> returned = null;
    private boolean initialized = false;
    
    public BreakLoopException() {
        super(null, null, false, false);
    }
    
    public <T,R> BreakLoopException(Optional<R> returned, Iteration<T,R> lastIteration) {
        this();
        this.returned = returned;
        this.lastIteration = lastIteration;
        this.initialized = true;
    }

    public Optional<?> getReturned() {
        return returned;
    }

    public Iteration<?, ?> getLastIteration() {
        return lastIteration;
    }

    public boolean isInitialized() {
        return returned != null && returned.isPresent();
    }       
    
}