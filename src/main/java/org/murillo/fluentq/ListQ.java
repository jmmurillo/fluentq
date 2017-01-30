/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.murillo.fluentq;

import java.util.Collection;
import java.util.Random;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntBiFunction;

public interface ListQ<T> extends CommonListQ<T, ListQ<T>, ListQ<T>>, java.io.Serializable {

    @Override
    default boolean isDurable() {
        return true;
    }

    @Override
    default boolean isEphemeral() {
        return false;
    }

    ListQ<T> concatSelf(Collection<T> collection);

    ListQ<T> concatSelf(T... items);

    ListQ<T> concatOneSelf(T item);
    
    ListQ<T> copy();

    ListQ<T> distinctSelf();

    ListQ<T> distinctSelf(BiPredicate<T, T> equalTest);
    
    ListQ<T> insertSelf(int index, Collection<T> collection);

    ListQ<T> insertSelf(int index, T... items);

    ListQ<T> insertOneSelf(int index, T item);

    ListQ<T> intersectSelf(Collection<T> collection);

    ListQ<T> intersectSelf(Collection<T> collection, BiPredicate<T, T> equalTest);

    ListQ<T> orderByDescSelf(Function<T, Comparable>... selectors);

    ListQ<T> orderBySelf(Function<T, Comparable>... selectors);

    ListQ<T> orderDescSelf();

    ListQ<T> orderDescSelf(ToIntBiFunction<T, T> compareTo);

    ListQ<T> orderSelf();

    ListQ<T> orderSelf(ToIntBiFunction<T, T> compareTo);

    ListQ<T> rangeSelf(int start, int count);

    ListQ<T> reverseSelf();

    ListQ<T> shuffleSelf();

    ListQ<T> shuffleSelf(Random random);

    ListQ<T> skipSelf(int howMany);

    ListQ<T> skipWhileISelf(Predicate<Iteration<T, Boolean>> condition);

    ListQ<T> skipWhileSelf(Predicate<T> condition);

    ListQ<T> takeSelf(int howMany);

    ListQ<T> takeWhileISelf(Predicate<Iteration<T, Boolean>> condition);

    ListQ<T> takeWhileSelf(Predicate<T> condition);

    ListQ<T> unionSelf(Collection<T> collection);

    ListQ<T> unionSelf(Collection<T> collection, BiPredicate<T, T> equalTest);

    ListQ<T> whereISelf(Predicate<Iteration<T, Boolean>> selector);

    ListQ<T> whereSelf(Predicate<T> selector);
    
}
