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

public interface ListQ<T> extends CommonListQ<T>, java.io.Serializable {

    default boolean isDurable() {
        return true;
    }

    default boolean isEphemeral() {
        return false;
    }

    EphemeralListQ<T> concat(Collection<T> collection);

    EphemeralListQ<T> concat(T... items);

    ListQ<T> concatSelf(Collection<T> collection);

    ListQ<T> concatSelf(T... items);

    EphemeralListQ<T> distinct();

    EphemeralListQ<T> distinct(BiPredicate<T, T> equalTest);

    ListQ<T> distinctSelf();

    ListQ<T> distinctSelf(BiPredicate<T, T> equalTest);

    EphemeralListQ<T> insert(int index, Collection<T> collection);

    EphemeralListQ<T> insert(int index, T... items);

    ListQ<T> insertSelf(int index, Collection<T> collection);

    ListQ<T> insertSelf(int index, T... items);

    EphemeralListQ<T> intersect(Collection<T> collection);

    EphemeralListQ<T> intersect(Collection<T> collection, BiPredicate<T, T> equalTest);

    ListQ<T> intersectSelf(Collection<T> collection);

    ListQ<T> intersectSelf(Collection<T> collection, BiPredicate<T, T> equalTest);

    EphemeralListQ<T> order();

    EphemeralListQ<T> order(ToIntBiFunction<T, T> compareTo);

    EphemeralListQ<T> orderBy(Function<T, Comparable>... selectors);

    EphemeralListQ<T> orderByDesc(Function<T, Comparable>... selectors);

    ListQ<T> orderByDescSelf(Function<T, Comparable>... selectors);

    ListQ<T> orderBySelf(Function<T, Comparable>... selectors);

    EphemeralListQ<T> orderDesc();

    EphemeralListQ<T> orderDesc(ToIntBiFunction<T, T> compareTo);

    ListQ<T> orderDescSelf();

    ListQ<T> orderDescSelf(ToIntBiFunction<T, T> compareTo);

    ListQ<T> orderSelf();

    ListQ<T> orderSelf(ToIntBiFunction<T, T> compareTo);

    EphemeralListQ<T> range(int start, int count);

    ListQ<T> rangeSelf(int start, int count);

    EphemeralListQ<T> reverse();

    ListQ<T> reverseSelf();

    EphemeralListQ<T> shuffle();

    EphemeralListQ<T> shuffle(Random random);

    ListQ<T> shuffleSelf();

    ListQ<T> shuffleSelf(Random random);

    EphemeralListQ<T> skip(int howMany);

    ListQ<T> skipSelf(int howMany);

    EphemeralListQ<T> skipWhile(Predicate<T> condition);

    EphemeralListQ<T> skipWhileI(Predicate<Iteration<T, Boolean>> condition);

    ListQ<T> skipWhileISelf(Predicate<Iteration<T, Boolean>> condition);

    ListQ<T> skipWhileSelf(Predicate<T> condition);

    EphemeralListQ<T> take(int howMany);

    ListQ<T> takeSelf(int howMany);

    EphemeralListQ<T> takeWhile(Predicate<T> condition);

    EphemeralListQ<T> takeWhileI(Predicate<Iteration<T, Boolean>> condition);

    ListQ<T> takeWhileISelf(Predicate<Iteration<T, Boolean>> condition);

    ListQ<T> takeWhileSelf(Predicate<T> condition);

    EphemeralListQ<T> union(Collection<T> collection);

    EphemeralListQ<T> union(Collection<T> collection, BiPredicate<T, T> equalTest);

    ListQ<T> unionSelf(Collection<T> collection);

    ListQ<T> unionSelf(Collection<T> collection, BiPredicate<T, T> equalTest);

    EphemeralListQ<T> where(Predicate<T> selector);

    EphemeralListQ<T> whereI(Predicate<Iteration<T, Boolean>> selector);

    ListQ<T> whereISelf(Predicate<Iteration<T, Boolean>> selector);

    ListQ<T> whereSelf(Predicate<T> selector);

}
