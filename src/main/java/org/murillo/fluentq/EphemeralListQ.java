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

public interface EphemeralListQ<T> extends CommonListQ<T>, java.io.Serializable {

    default boolean isDurable() {
        return false;
    }

    default boolean isEphemeral() {
        return true;
    }

    default EphemeralListQ<T> concat(Collection<T> collection) {
        return this.concatSelf(collection);
    }

    default EphemeralListQ<T> concat(T... items) {
        return this.concatSelf(items);
    }

    EphemeralListQ<T> concatSelf(Collection<T> collection);

    EphemeralListQ<T> concatSelf(T... items);

    default EphemeralListQ<T> distinct() {
        return this.distinctSelf();
    }

    default EphemeralListQ<T> distinct(BiPredicate<T, T> equalTest) {
        return this.distinctSelf(equalTest);
    }

    EphemeralListQ<T> distinctSelf();

    EphemeralListQ<T> distinctSelf(BiPredicate<T, T> equalTest);

    default EphemeralListQ<T> insert(int index, Collection<T> collection) {
        return this.insertSelf(index, collection);
    }

    default EphemeralListQ<T> insert(int index, T... items) {
        return this.insertSelf(index, items);
    }

    EphemeralListQ<T> insertSelf(int index, Collection<T> collection);

    EphemeralListQ<T> insertSelf(int index, T... items);

    default EphemeralListQ<T> intersect(Collection<T> collection) {
        return this.intersectSelf(collection);
    }

    default EphemeralListQ<T> intersect(Collection<T> collection, BiPredicate<T, T> equalTest) {
        return this.intersectSelf(collection, equalTest);
    }

    EphemeralListQ<T> intersectSelf(Collection<T> collection);

    EphemeralListQ<T> intersectSelf(Collection<T> collection, BiPredicate<T, T> equalTest);

    default EphemeralListQ<T> order() {
        return this.orderSelf();
    }

    default EphemeralListQ<T> order(ToIntBiFunction<T, T> compareTo) {
        return this.orderSelf();
    }

    default EphemeralListQ<T> orderBy(Function<T, Comparable>... selectors) {
        return this.orderBySelf(selectors);
    }

    default EphemeralListQ<T> orderByDesc(Function<T, Comparable>... selectors) {
        return this.orderByDescSelf(selectors);
    }

    EphemeralListQ<T> orderByDescSelf(Function<T, Comparable>... selectors);

    EphemeralListQ<T> orderBySelf(Function<T, Comparable>... selectors);

    default EphemeralListQ<T> orderDesc() {
        return this.orderDescSelf();
    }

    default EphemeralListQ<T> orderDesc(ToIntBiFunction<T, T> compareTo) {
        return this.orderDescSelf(compareTo);
    }

    EphemeralListQ<T> orderDescSelf();

    EphemeralListQ<T> orderDescSelf(ToIntBiFunction<T, T> compareTo);

    EphemeralListQ<T> orderSelf();

    EphemeralListQ<T> orderSelf(ToIntBiFunction<T, T> compareTo);

    default EphemeralListQ<T> range(int start, int count) {
        return this.rangeSelf(start, count);
    }

    EphemeralListQ<T> rangeSelf(int start, int count);

    default EphemeralListQ<T> reverse() {
        return this.reverseSelf();
    }

    EphemeralListQ<T> reverseSelf();

    default EphemeralListQ<T> shuffle() {
        return this.shuffleSelf();
    }

    default EphemeralListQ<T> shuffle(Random random) {
        return this.shuffleSelf(random);
    }

    EphemeralListQ<T> shuffleSelf();

    EphemeralListQ<T> shuffleSelf(Random random);

    default EphemeralListQ<T> skip(int howMany) {
        return this.skipSelf(howMany);
    }

    EphemeralListQ<T> skipSelf(int howMany);

    default EphemeralListQ<T> skipWhile(Predicate<T> condition) {
        return this.skipWhileSelf(condition);
    }

    default EphemeralListQ<T> skipWhileI(Predicate<Iteration<T, Boolean>> condition) {
        return this.skipWhileISelf(condition);
    }

    EphemeralListQ<T> skipWhileISelf(Predicate<Iteration<T, Boolean>> condition);

    EphemeralListQ<T> skipWhileSelf(Predicate<T> condition);

    default EphemeralListQ<T> take(int howMany) {
        return this.takeSelf(howMany);
    }

    EphemeralListQ<T> takeSelf(int howMany);

    default EphemeralListQ<T> takeWhile(Predicate<T> condition) {
        return this.takeWhileSelf(condition);
    }

    default EphemeralListQ<T> takeWhileI(Predicate<Iteration<T, Boolean>> condition) {
        return this.takeWhileISelf(condition);
    }

    EphemeralListQ<T> takeWhileISelf(Predicate<Iteration<T, Boolean>> condition);

    EphemeralListQ<T> takeWhileSelf(Predicate<T> condition);

    default EphemeralListQ<T> union(Collection<T> collection) {
        return this.unionSelf(collection);
    }

    default EphemeralListQ<T> union(Collection<T> collection, BiPredicate<T, T> equalTest) {
        return this.unionSelf(collection, equalTest);
    }

    EphemeralListQ<T> unionSelf(Collection<T> collection);

    EphemeralListQ<T> unionSelf(Collection<T> collection, BiPredicate<T, T> equalTest);

    default EphemeralListQ<T> where(Predicate<T> selector) {
        return this.whereSelf(selector);
    }

    default EphemeralListQ<T> whereI(Predicate<Iteration<T, Boolean>> selector) {
        return this.whereISelf(selector);
    }

    EphemeralListQ<T> whereISelf(Predicate<Iteration<T, Boolean>> selector);

    EphemeralListQ<T> whereSelf(Predicate<T> selector);

    ListQ<T> hold();
}
