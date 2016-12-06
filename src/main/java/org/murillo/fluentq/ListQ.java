/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.murillo.fluentq;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalLong;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntBiFunction;
import java.util.function.ToLongFunction;

public interface ListQ<T> extends List<T>, java.io.Serializable
{
    <S> S accumulate(BiFunction<S, T, S> function, S initial);

    <S> S accumulateI(BiFunction<S, Iteration<T, S>, S> function, S initial);

    Optional<T> aggregate(BiFunction<T, T, T> function);

    boolean all(Predicate<T> test);

    boolean any(Predicate<T> test);

    boolean any();

    <S> ListQ<S> cast(Class<S> clazz);

    ListQ<ListQ<T>> cluster(BiPredicate<T, T> equalTest);
    
    ListQ<ListQ<T>> clusterEvery(int numberOfItems);

    ListQ<T> concat(Collection<T> collection);

    ListQ<T> concat(T... items);

    ListQ<T> concatSelf(Collection<T> collection);
    
    ListQ<T> concatSelf(T... items);

    int count();

    int count(Predicate<T> selector);

    ListQ<T> distinct();

    ListQ<T> distinct(BiPredicate<T, T> equalTest);

    ListQ<T> distinctSelf();

    ListQ<T> distinctSelf(BiPredicate<T, T> equalTest);

    Optional<T> first();

    Optional<T> first(Predicate<T> test);

    void forEachI(Consumer<Iteration<T, Void>> action);

    void forEachIReverse(Consumer<Iteration<T, Void>> action);

    void forEachReverse(Consumer<T> action);

    <K> HashMap<K, ListQ<T>> groupBy(Function<T, K> keySelector);

    <K> HashMap<K, ListQ<T>> groupByI(Function<Iteration<T, K>, K> keySelector);

    ListQ<T> insert(int index, Collection<T> collection);

    ListQ<T> insert(int index, T... items);

    ListQ<T> insertSelf(int index, Collection<T> collection);
    
    ListQ<T> insertSelf(int index, T... items);

    ListQ<T> intersect(Collection<T> collection);

    ListQ<T> intersect(Collection<T> collection, BiPredicate<T, T> equalTest);

    ListQ<T> intersectSelf(Collection<T> collection);

    ListQ<T> intersectSelf(Collection<T> collection, BiPredicate<T, T> equalTest);

    Optional<T> last() throws IndexOutOfBoundsException;

    Optional<T> last(Predicate<T> test);

    OptionalDouble maxAsDouble();

    OptionalDouble maxAsDouble(ToDoubleFunction<T> toNumber);

    OptionalLong maxAsLong();

    OptionalLong maxAsLong(ToLongFunction<T> toNumber);

    OptionalDouble minAsDouble();

    OptionalDouble minAsDouble(ToDoubleFunction<T> toNumber);

    OptionalLong minAsLong();

    OptionalLong minAsLong(ToLongFunction<T> toNumber);

    ListQ<T> order();

    ListQ<T> order(ToIntBiFunction<T, T> compareTo);

    ListQ<T> orderBy(Function<T, Comparable>... selectors);

    ListQ<T> orderByDesc(Function<T, Comparable>... selectors);

    ListQ<T> orderByDescSelf(Function<T, Comparable>... selectors);

    ListQ<T> orderBySelf(Function<T, Comparable>... selectors);

    ListQ<T> orderDesc();

    ListQ<T> orderDesc(ToIntBiFunction<T, T> compareTo);

    ListQ<T> orderDescSelf();

    ListQ<T> orderDescSelf(ToIntBiFunction<T, T> compareTo);

    ListQ<T> orderSelf();

    ListQ<T> orderSelf(ToIntBiFunction<T, T> compareTo);

    Optional<T> randomElement();

    Optional<T> randomElement(Random random);

    ListQ<T> range(int start, int count);
    
    ListQ<T> rangeSelf(int start, int count);
    
    ListQ<T> reverse();

    ListQ<T> reverseSelf();

    <S> ListQ<S> select(Function<T, S> selector);

    <S> ListQ<S> selectI(Function<Iteration<T, S>, S> selector);

    <S> ListQ<S> selectMany(Function<T, Collection<S>> selector);

    <S> ListQ<S> selectManyI(Function<Iteration<T, Collection<S>>, Collection<S>> selector);

    ListQ<T> shuffle();

    ListQ<T> shuffle(Random random);

    ListQ<T> shuffleSelf();

    ListQ<T> shuffleSelf(Random random);

    Optional<T> single();

    Optional<T> single(Predicate<T> test);

    ListQ<T> skip(int howMany);

    ListQ<T> skipSelf(int howMany);

    ListQ<T> skipWhile(Predicate<T> condition);

    ListQ<T> skipWhileI(Predicate<Iteration<T, Boolean>> condition);

    ListQ<T> skipWhileISelf(Predicate<Iteration<T, Boolean>> condition);

    ListQ<T> skipWhileSelf(Predicate<T> condition);

    double sumAsDouble();

    double sumAsDouble(ToDoubleFunction<T> toNumber);

    long sumAsLong();

    long sumAsLong(ToLongFunction<T> toNumber);

    ListQ<T> take(int howMany);

    ListQ<T> takeSelf(int howMany);

    ListQ<T> takeWhile(Predicate<T> condition);

    ListQ<T> takeWhileI(Predicate<Iteration<T, Boolean>> condition);

    ListQ<T> takeWhileISelf(Predicate<Iteration<T, Boolean>> condition);

    ListQ<T> takeWhileSelf(Predicate<T> condition);
    
    ListQ<Iteration<T,T>> toIterations();

    <K, V> HashMap<K, V> toMap(Function<T, K> keySelector, Function<T, V> valueSelector);

    <K, V> HashMap<K, V> toMap(BiFunction<T, Integer, K> keySelector, BiFunction<T, Integer, V> valueSelector);

    <K, V> HashMap<K, V> toMap(BiFunction<T, Integer, K> keySelector, Function<T, V> valueSelector);

    <K, V> HashMap<K, V> toMap(Function<T, K> keySelector, BiFunction<T, Integer, V> valueSelector);

    String toString(String separator);

    String toString(String separator, Function<T, String> toString);
    
    T[] toTypedArray(Class<T> clazz);

    ListQ<T> union(Collection<T> collection);

    ListQ<T> union(Collection<T> collection, BiPredicate<T, T> equalTest);

    ListQ<T> unionSelf(Collection<T> collection);

    ListQ<T> unionSelf(Collection<T> collection, BiPredicate<T, T> equalTest);

    ListQ<T> where(Predicate<T> selector);

    ListQ<T> whereI(Predicate<Iteration<T, Boolean>> selector);

    ListQ<T> whereISelf(Predicate<Iteration<T, Boolean>> selector);

    ListQ<T> whereSelf(Predicate<T> selector);
    
}
