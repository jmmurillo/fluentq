package org.murillo.fluentq.utils.func;

@FunctionalInterface
public interface Action3<A, B, C> {    
    void accept(A a, B b, C c);    
}
