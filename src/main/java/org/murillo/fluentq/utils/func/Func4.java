package org.murillo.fluentq.utils.func;

@FunctionalInterface
public interface Func4<A, B, C, D, R> {    
    R apply(A a, B b, C c, D d);    
}
