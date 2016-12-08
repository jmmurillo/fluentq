/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.murillo.fluentq;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalLong;
import java.util.Random;
import java.util.Spliterator;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntBiFunction;
import java.util.function.ToLongFunction;
import java.util.function.UnaryOperator;

/**
 *
 * @author Usuario
 */
public class EphemeralArrayListQ<T> implements EphemeralListQ<T> {

    protected ListQ<T> innerList;
    
    public static <S> EphemeralArrayListQ<S> wrap(ListQ<S> innerList){
        EphemeralArrayListQ<S> result = new EphemeralArrayListQ<>();
        result.innerList = innerList;
        return result;
    }
            
    private EphemeralArrayListQ(){}            
    
    @Override
    public ListQ<T> hold() {
        ListQ<T> result = this.innerList;
        this.innerList = null;
        return result;
    }
    
    @Override
    public Optional<T> aggregate(BiFunction<T, T, T> function) {
        return innerList.aggregate(function);
    }

    @Override
    public <S> S accumulate(BiFunction<S, T, S> function, S initial) {
        return innerList.accumulate(function, initial);
    }

    @Override
    public <S> S accumulateI(BiFunction<S, Iteration<T, S>, S> function, S initial) {
        return innerList.accumulateI(function, initial);
    }

    @Override
    public EphemeralListQ<T> where(Predicate<T> selector) {
        innerList.whereSelf(selector);
        return this;
    }

    @Override
    public EphemeralListQ<T> whereI(Predicate<Iteration<T, Boolean>> selector) {
        innerList.whereISelf(selector);
        return this;
    }

    @Override
    public <S> ListQ<S> select(Function<T, S> selector) {
        return innerList.select(selector);
    }

    @Override
    public <S> ListQ<S> selectI(Function<Iteration<T, S>, S> selector) {
        return innerList.selectI(selector);
    }

    @Override
    public boolean all(Predicate<T> test) {
        return innerList.all(test);
    }

    @Override
    public boolean any(Predicate<T> test) {
        return innerList.any(test);
    }

    @Override
    public boolean any() {
        return innerList.any();
    }

    @Override
    public Optional<T> first() {
        return innerList.first();
    }

    @Override
    public Optional<T> first(Predicate<T> test) {
        return innerList.first(test);
    }

    @Override
    public Optional<T> last() {
        return innerList.last();
    }

    @Override
    public Optional<T> last(Predicate<T> test) {
        return innerList.last(test);
    }

    @Override
    public Optional<T> single() {
        return innerList.single();
    }

    @Override
    public Optional<T> single(Predicate<T> test) {
        return innerList.single(test);
    }

    @Override
    public Optional<T> randomElement() {
        return innerList.randomElement();
    }

    @Override
    public Optional<T> randomElement(Random random) {
        return innerList.randomElement(random);
    }

    @Override
    public EphemeralListQ<T> distinct() {
        innerList.distinctSelf();
        return this;
    }

    @Override
    public EphemeralListQ<T> distinct(BiPredicate<T, T> equalTest) {
        innerList.distinctSelf(equalTest);
        return this;
    }

    @Override
    public EphemeralListQ<T> union(Collection<T> collection) {
        innerList.unionSelf(collection);
        return this;
    }

    @Override
    public EphemeralListQ<T> union(Collection<T> collection, BiPredicate<T, T> equalTest) {
        innerList.unionSelf(collection, equalTest);
        return this;
    }

    @Override
    public EphemeralListQ<T> intersect(Collection<T> collection) {
        innerList.intersectSelf(collection);
        return this;
    }

    @Override
    public EphemeralListQ<T> intersect(Collection<T> collection, BiPredicate<T, T> equalTest) {
        innerList.intersectSelf(collection, equalTest);
        return this;
    }

    @Override
    public int count() {
        return innerList.count();
    }

    @Override
    public int count(Predicate<T> selector) {
        return innerList.count(selector);
    }

    @Override
    public EphemeralListQ<T> concat(Collection<T> collection) {
        innerList.concatSelf(collection);
        return this;
    }

    @Override
    public EphemeralListQ<T> concat(T... items) {
        innerList.concatSelf(items);
        return this;
    }

    @Override
    public EphemeralListQ<T> insert(int index, Collection<T> collection) {
        innerList.insertSelf(index, collection);
        return this;
    }

    @Override
    public EphemeralListQ<T> insert(int index, T... items) {
        innerList.insertSelf(index, items);
        return this;
    }

    @Override
    public <S> ListQ<S> cast(Class<S> clazz) {
        return innerList.cast(clazz);
    }

    @Override
    public double sumAsDouble() {
        return innerList.sumAsDouble();
    }

    @Override
    public double sumAsDouble(ToDoubleFunction<T> toNumber) {
        return innerList.sumAsDouble(toNumber);
    }

    @Override
    public long sumAsLong() {
        return innerList.sumAsLong();
    }

    @Override
    public long sumAsLong(ToLongFunction<T> toNumber) {
        return innerList.sumAsLong(toNumber);
    }

    @Override
    public OptionalDouble maxAsDouble() {
        return innerList.maxAsDouble();
    }

    @Override
    public OptionalDouble maxAsDouble(ToDoubleFunction<T> toNumber) {
        return innerList.maxAsDouble(toNumber);
    }

    @Override
    public OptionalLong maxAsLong() {
        return innerList.maxAsLong();
    }

    @Override
    public OptionalLong maxAsLong(ToLongFunction<T> toNumber) {
        return innerList.maxAsLong(toNumber);
    }

    @Override
    public OptionalDouble minAsDouble() {
        return innerList.minAsDouble();
    }

    @Override
    public OptionalDouble minAsDouble(ToDoubleFunction<T> toNumber) {
        return innerList.minAsDouble(toNumber);
    }

    @Override
    public OptionalLong minAsLong() {
        return innerList.minAsLong();
    }

    @Override
    public OptionalLong minAsLong(ToLongFunction<T> toNumber) {
        return innerList.minAsLong(toNumber);
    }

    @Override
    public <K> HashMap<K, ListQ<T>> groupBy(Function<T, K> keySelector) {
        return innerList.groupBy(keySelector);
    }

    @Override
    public <K> HashMap<K, ListQ<T>> groupByI(Function<Iteration<T, K>, K> keySelector) {
        return innerList.groupByI(keySelector);
    }

    @Override
    public ListQ<ListQ<T>> cluster(BiPredicate<T, T> equalTest) {
        return innerList.cluster(equalTest);
    }

    @Override
    public ListQ<ListQ<T>> clusterEvery(int numberOfItems) {
        return innerList.clusterEvery(numberOfItems);
    }

    @Override
    public <K, V> HashMap<K, V> toMap(Function<T, K> keySelector, Function<T, V> valueSelector) {
        return innerList.toMap(keySelector, valueSelector);
    }

    @Override
    public <K, V> HashMap<K, V> toMap(BiFunction<T, Integer, K> keySelector, BiFunction<T, Integer, V> valueSelector) {
        return innerList.toMap(keySelector, valueSelector);
    }

    @Override
    public <K, V> HashMap<K, V> toMap(BiFunction<T, Integer, K> keySelector, Function<T, V> valueSelector) {
        return innerList.toMap(keySelector, valueSelector);
    }

    @Override
    public <K, V> HashMap<K, V> toMap(Function<T, K> keySelector, BiFunction<T, Integer, V> valueSelector) {
        return innerList.toMap(keySelector, valueSelector);
    }

    @Override
    public <S> ListQ<S> selectMany(Function<T, Collection<S>> selector) {
        return innerList.selectMany(selector);
    }

    @Override
    public <S> ListQ<S> selectManyI(Function<Iteration<T, Collection<S>>, Collection<S>> selector) {
        return innerList.selectManyI(selector);
    }

    @Override
    public void forEachReverse(Consumer<T> action) {
        innerList.forEachReverse(action);
    }

    @Override
    public void forEachI(Consumer<Iteration<T, Void>> action) {
        innerList.forEachI(action);
    }

    @Override
    public void forEachIReverse(Consumer<Iteration<T, Void>> action) {
        innerList.forEachIReverse(action);
    }

    @Override
    public EphemeralListQ<T> reverse() {
        innerList.reverse();
        return this;
    }

    @Override
    public EphemeralListQ<T> shuffle() {
        innerList.shuffle();
        return this;
    }

    @Override
    public EphemeralListQ<T> shuffle(Random random) {
        innerList.shuffleSelf(random);
        return this;
    }

    @Override
    public EphemeralListQ<T> order() {
        innerList.orderSelf();
        return this;
    }

    @Override
    public EphemeralListQ<T> orderDesc() {
        innerList.orderDescSelf();
        return this;
    }

    @Override
    public EphemeralListQ<T> order(ToIntBiFunction<T, T> compareTo) {
        innerList.orderSelf(compareTo);
        return this;
    }

    @Override
    public EphemeralListQ<T> orderDesc(ToIntBiFunction<T, T> compareTo) {
        innerList.orderDescSelf(compareTo);
        return this;
    }

    @Override
    public EphemeralListQ<T> orderBy(Function<T, Comparable>... selectors) {
        innerList.orderBySelf(selectors);
        return this;
    }

    @Override
    public EphemeralListQ<T> orderByDesc(Function<T, Comparable>... selectors) {
        innerList.orderByDescSelf(selectors);
        return this;
    }

    @Override
    public EphemeralListQ<T> take(int howMany) {
        innerList.takeSelf(howMany);
        return this;
    }

    @Override
    public EphemeralListQ<T> takeWhile(Predicate<T> condition) {
        innerList.takeWhileSelf(condition);
        return this;
    }

    @Override
    public EphemeralListQ<T> takeWhileI(Predicate<Iteration<T, Boolean>> condition) {
        innerList.takeWhileISelf(condition);
        return this;
    }

    @Override
    public EphemeralListQ<T> skip(int howMany) {
        innerList.skipSelf(howMany);
        return this;
    }

    @Override
    public EphemeralListQ<T> skipWhile(Predicate<T> condition) {
        innerList.skipWhileSelf(condition);
        return this;
    }

    @Override
    public EphemeralListQ<T> skipWhileI(Predicate<Iteration<T, Boolean>> condition) {
        innerList.skipWhileISelf(condition);
        return this;
    }

    @Override
    public String toString(String separator) {
        return innerList.toString(separator);
    }

    @Override
    public String toString(String separator, Function<T, String> toString) {
        return innerList.toString(separator, toString);
    }

    @Override
    public T[] toTypedArray(Class<T> clazz) {
        return innerList.toTypedArray(clazz);
    }

    @Override
    public ListQ<Iteration<T, T>> toIterations() {
        return innerList.toIterations();
    }

    @Override
    public EphemeralListQ<T> range(int start, int count) {
        innerList.rangeSelf(start, count);
        return this;
    }

    @Override
    public int size() {
        return innerList.size();
    }

    @Override
    public boolean isEmpty() {
        return innerList.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return innerList.contains(o);
    }

    @Override
    public int indexOf(Object o) {
        return innerList.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return innerList.lastIndexOf(o);
    }

    @Override
    public Object[] toArray() {
        return innerList.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return innerList.toArray(a);
    }

    @Override
    public T get(int index) {
        return innerList.get(index);
    }

    @Override
    public T set(int index, T element) {
        return innerList.set(index, element);
    }

    @Override
    public boolean add(T e) {
        return innerList.add(e);
    }

    @Override
    public void add(int index, T element) {
        innerList.add(index, element);
    }

    @Override
    public T remove(int index) {
        return innerList.remove(index);
    }

    @Override
    public boolean remove(Object o) {
        return innerList.remove(o);
    }

    @Override
    public void clear() {
        innerList.clear();
    }
    
    @Override
    public boolean containsAll(Collection<?> c) {
        return innerList.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return innerList.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return innerList.addAll(index, c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return innerList.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return innerList.retainAll(c);
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return innerList.listIterator(index);
    }

    @Override
    public ListIterator<T> listIterator() {
        return innerList.listIterator();
    }

    @Override
    public Iterator<T> iterator() {
        return innerList.iterator();
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return innerList.subList(fromIndex, toIndex);
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        innerList.forEach(action);
    }

    @Override
    public Spliterator<T> spliterator() {
        return innerList.spliterator();
    }

    @Override
    public boolean removeIf(Predicate<? super T> filter) {
        return innerList.removeIf(filter);
    }

    @Override
    public void replaceAll(UnaryOperator<T> operator) {
        innerList.replaceAll(operator);
    }

    @Override
    public void sort(Comparator<? super T> c) {
        innerList.sort(c);
    }    

}
