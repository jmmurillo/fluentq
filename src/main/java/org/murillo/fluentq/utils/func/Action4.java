package org.murillo.fluentq.utils.func;

@FunctionalInterface
public interface Action4<A, B, C, D> {    
    void accept(A a, B b, C c, D d);    
}
