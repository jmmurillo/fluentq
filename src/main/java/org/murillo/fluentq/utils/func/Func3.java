package org.murillo.fluentq.utils.func;

@FunctionalInterface
public interface Func3<A, B, C, R> {    
    R apply(A a, B b, C c);    
}
