package org.murillo.fluentq;

import java.io.Serializable;
import java.util.Optional;

public interface Iteration<T, R> extends Comparable, Serializable {

    R breakLoop();

    R breakLoop(R returned);

    int getIndex();

    T getValue();
    
}
