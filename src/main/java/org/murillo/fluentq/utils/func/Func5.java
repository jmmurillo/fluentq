package org.murillo.fluentq.utils.func;

@FunctionalInterface
public interface Func5<A, B, C, D, E, R> {    
    R apply(A a, B b, C c, D d, E e);    
}
