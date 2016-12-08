package org.murillo.fluentq;

import java.io.Serializable;
import java.util.Optional;

public interface Iteration<T, R> extends Comparable, Serializable {

    Optional<R> breakLoop();

    Optional<R> breakLoop(Optional<R> returned);

    int getIndex();

    T getValue();
    
}
