package org.murillo.fluentq.implementation;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalLong;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntBiFunction;
import java.util.function.ToLongFunction;
import org.murillo.fluentq.EphemeralListQ;
import org.murillo.fluentq.Iteration;
import org.murillo.fluentq.ListQ;

class MoanerListQ<T> implements ListQ<T> {

    private static final MoanerListQ INSTANCE = new MoanerListQ<>();

    public static MoanerListQ getInstance() {
        return INSTANCE;
    }

    private MoanerListQ() {
    }

    @Override
    public ListQ<T> concatSelf(Collection<T> collection) {
        throw moan();
    }

    @Override
    public ListQ<T> concatSelf(T... items) {
        throw moan();
    }

    @Override
    public ListQ<T> distinctSelf() {
        throw moan();
    }

    @Override
    public ListQ<T> distinctSelf(BiPredicate<T, T> equalTest) {
        throw moan();
    }

    @Override
    public ListQ<T> insertSelf(int index, Collection<T> collection) {
        throw moan();
    }

    @Override
    public ListQ<T> insertSelf(int index, T... items) {
        throw moan();
    }

    @Override
    public ListQ<T> intersectSelf(Collection<T> collection) {
        throw moan();
    }

    @Override
    public ListQ<T> intersectSelf(Collection<T> collection, BiPredicate<T, T> equalTest) {
        throw moan();
    }

    @Override
    public ListQ<T> orderByDescSelf(Function<T, Comparable>... selectors) {
        throw moan();
    }

    @Override
    public ListQ<T> orderBySelf(Function<T, Comparable>... selectors) {
        throw moan();
    }

    @Override
    public ListQ<T> orderDescSelf() {
        throw moan();
    }

    @Override
    public ListQ<T> orderDescSelf(ToIntBiFunction<T, T> compareTo) {
        throw moan();
    }

    @Override
    public ListQ<T> orderSelf() {
        throw moan();
    }

    @Override
    public ListQ<T> orderSelf(ToIntBiFunction<T, T> compareTo) {
        throw moan();
    }

    @Override
    public ListQ<T> rangeSelf(int start, int count) {
        throw moan();
    }

    @Override
    public ListQ<T> reverseSelf() {
        throw moan();
    }

    @Override
    public ListQ<T> shuffleSelf() {
        throw moan();
    }

    @Override
    public ListQ<T> shuffleSelf(Random random) {
        throw moan();
    }

    @Override
    public ListQ<T> skipSelf(int howMany) {
        throw moan();
    }

    @Override
    public ListQ<T> skipWhileISelf(Predicate<Iteration<T, Boolean>> condition) {
        throw moan();
    }

    @Override
    public ListQ<T> skipWhileSelf(Predicate<T> condition) {
        throw moan();
    }

    @Override
    public ListQ<T> takeSelf(int howMany) {
        throw moan();
    }

    @Override
    public ListQ<T> takeWhileISelf(Predicate<Iteration<T, Boolean>> condition) {
        throw moan();
    }

    @Override
    public ListQ<T> takeWhileSelf(Predicate<T> condition) {
        throw moan();
    }

    @Override
    public ListQ<T> unionSelf(Collection<T> collection) {
        throw moan();
    }

    @Override
    public ListQ<T> unionSelf(Collection<T> collection, BiPredicate<T, T> equalTest) {
        throw moan();
    }

    @Override
    public ListQ<T> whereISelf(Predicate<Iteration<T, Boolean>> selector) {
        throw moan();
    }

    @Override
    public ListQ<T> whereSelf(Predicate<T> selector) {
        throw moan();
    }

    @Override
    public boolean isDurable() {
        throw moan();
    }

    @Override
    public boolean isEphemeral() {
        throw moan();
    }

    @Override
    public <S> S accumulate(BiFunction<S, T, S> function, S initial) {
        throw moan();
    }

    @Override
    public <S> S accumulateI(BiFunction<S, Iteration<T, S>, S> function, S initial) {
        throw moan();
    }

    @Override
    public Optional<T> aggregate(BiFunction<T, T, T> function) {
        throw moan();
    }

    @Override
    public boolean all(Predicate<T> test) {
        throw moan();
    }

    @Override
    public boolean any(Predicate<T> test) {
        throw moan();
    }

    @Override
    public boolean any() {
        throw moan();
    }

    @Override
    public <S> ListQ<S> cast(Class<S> clazz) {
        throw moan();
    }

    @Override
    public ListQ<ListQ<T>> cluster(BiPredicate<T, T> equalTest) {
        throw moan();
    }

    @Override
    public ListQ<ListQ<T>> clusterEvery(int numberOfItems) {
        throw moan();
    }

    @Override
    public int count() {
        throw moan();
    }

    @Override
    public int count(Predicate<T> selector) {
        throw moan();
    }

    @Override
    public Optional<T> first() {
        throw moan();
    }

    @Override
    public Optional<T> first(Predicate<T> test) {
        throw moan();
    }

    @Override
    public void forEachI(Consumer<Iteration<T, Void>> action) {
        throw moan();
    }

    @Override
    public void forEachIReverse(Consumer<Iteration<T, Void>> action) {
        throw moan();
    }

    @Override
    public void forEachReverse(Consumer<T> action) {
        throw moan();
    }

    @Override
    public <K> HashMap<K, ListQ<T>> groupBy(Function<T, K> keySelector) {
        throw moan();
    }

    @Override
    public <K> HashMap<K, ListQ<T>> groupByI(Function<Iteration<T, K>, K> keySelector) {
        throw moan();
    }

    @Override
    public Optional<T> last() throws IndexOutOfBoundsException {
        throw moan();
    }

    @Override
    public Optional<T> last(Predicate<T> test) {
        throw moan();
    }

    @Override
    public OptionalDouble maxAsDouble() {
        throw moan();
    }

    @Override
    public OptionalDouble maxAsDouble(ToDoubleFunction<T> toNumber) {
        throw moan();
    }

    @Override
    public OptionalLong maxAsLong() {
        throw moan();
    }

    @Override
    public OptionalLong maxAsLong(ToLongFunction<T> toNumber) {
        throw moan();
    }

    @Override
    public OptionalDouble minAsDouble() {
        throw moan();
    }

    @Override
    public OptionalDouble minAsDouble(ToDoubleFunction<T> toNumber) {
        throw moan();
    }

    @Override
    public OptionalLong minAsLong() {
        throw moan();
    }

    @Override
    public OptionalLong minAsLong(ToLongFunction<T> toNumber) {
        throw moan();
    }

    @Override
    public Optional<T> randomElement() {
        throw moan();
    }

    @Override
    public Optional<T> randomElement(Random random) {
        throw moan();
    }

    @Override
    public <S> ListQ<S> select(Function<T, S> selector) {
        throw moan();
    }

    @Override
    public <S> ListQ<S> selectI(Function<Iteration<T, S>, S> selector) {
        throw moan();
    }

    @Override
    public <S> ListQ<S> selectMany(Function<T, Collection<S>> selector) {
        throw moan();
    }

    @Override
    public <S> ListQ<S> selectManyI(Function<Iteration<T, Collection<S>>, Collection<S>> selector) {
        throw moan();
    }

    @Override
    public Optional<T> single() {
        throw moan();
    }

    @Override
    public Optional<T> single(Predicate<T> test) {
        throw moan();
    }

    @Override
    public double sumAsDouble() {
        throw moan();
    }

    @Override
    public double sumAsDouble(ToDoubleFunction<T> toNumber) {
        throw moan();
    }

    @Override
    public long sumAsLong() {
        throw moan();
    }

    @Override
    public long sumAsLong(ToLongFunction<T> toNumber) {
        throw moan();
    }

    @Override
    public ListQ<Iteration<T, T>> toIterations() {
        throw moan();
    }

    @Override
    public <K, V> HashMap<K, V> toMap(Function<T, K> keySelector, Function<T, V> valueSelector) {
        throw moan();
    }

    @Override
    public <K, V> HashMap<K, V> toMapI(Function<Iteration<T, K>, K> keySelector, Function<Iteration<T, V>, V> valueSelector) {
        throw moan();
    }

    @Override
    public <K, V> HashMap<K, V> toMap(Function<T, K> keySelector, Function<T, V> valueSelector, BiConsumer<Map.Entry<K, V>, HashMap<K, V>> conflictResolver) {
        throw moan();
    }

    @Override
    public <K, V> HashMap<K, V> toMapI(Function<Iteration<T, K>, K> keySelector, Function<Iteration<T, V>, V> valueSelector, BiConsumer<Map.Entry<K, V>, HashMap<K, V>> conflictResolver) {
        throw moan();
    }

    @Override
    public String toString(String separator) {
        throw moan();
    }

    @Override
    public String toString(String separator, Function<T, String> toString) {
        throw moan();
    }

    @Override
    public T[] toTypedArray(Class<T> clazz) {
        throw moan();
    }

    @Override
    public EphemeralListQ<T> concat(Collection<T> collection) {
        throw moan();
    }

    @Override
    public EphemeralListQ<T> concat(T... items) {
        throw moan();
    }

    @Override
    public EphemeralListQ<T> distinct() {
        throw moan();
    }

    @Override
    public EphemeralListQ<T> distinct(BiPredicate<T, T> equalTest) {
        throw moan();
    }

    @Override
    public EphemeralListQ<T> insert(int index, Collection<T> collection) {
        throw moan();
    }

    @Override
    public EphemeralListQ<T> insert(int index, T... items) {
        throw moan();
    }

    @Override
    public EphemeralListQ<T> intersect(Collection<T> collection) {
        throw moan();
    }

    @Override
    public EphemeralListQ<T> intersect(Collection<T> collection, BiPredicate<T, T> equalTest) {
        throw moan();
    }

    @Override
    public EphemeralListQ<T> order() {
        throw moan();
    }

    @Override
    public EphemeralListQ<T> order(ToIntBiFunction<T, T> compareTo) {
        throw moan();
    }

    @Override
    public EphemeralListQ<T> orderBy(Function<T, Comparable>... selectors) {
        throw moan();
    }

    @Override
    public EphemeralListQ<T> orderByDesc(Function<T, Comparable>... selectors) {
        throw moan();
    }

    @Override
    public EphemeralListQ<T> orderDesc() {
        throw moan();
    }

    @Override
    public EphemeralListQ<T> orderDesc(ToIntBiFunction<T, T> compareTo) {
        throw moan();
    }

    @Override
    public EphemeralListQ<T> range(int start, int count) {
        throw moan();
    }

    @Override
    public EphemeralListQ<T> reverse() {
        throw moan();
    }

    @Override
    public EphemeralListQ<T> shuffle() {
        throw moan();
    }

    @Override
    public EphemeralListQ<T> shuffle(Random random) {
        throw moan();
    }

    @Override
    public EphemeralListQ<T> skip(int howMany) {
        throw moan();
    }

    @Override
    public EphemeralListQ<T> skipWhile(Predicate<T> condition) {
        throw moan();
    }

    @Override
    public EphemeralListQ<T> skipWhileI(Predicate<Iteration<T, Boolean>> condition) {
        throw moan();
    }

    @Override
    public EphemeralListQ<T> take(int howMany) {
        throw moan();
    }

    @Override
    public EphemeralListQ<T> takeWhile(Predicate<T> condition) {
        throw moan();
    }

    @Override
    public EphemeralListQ<T> takeWhileI(Predicate<Iteration<T, Boolean>> condition) {
        throw moan();
    }

    @Override
    public EphemeralListQ<T> union(Collection<T> collection) {
        throw moan();
    }

    @Override
    public EphemeralListQ<T> union(Collection<T> collection, BiPredicate<T, T> equalTest) {
        throw moan();
    }

    @Override
    public EphemeralListQ<T> where(Predicate<T> selector) {
        throw moan();
    }

    @Override
    public EphemeralListQ<T> whereI(Predicate<Iteration<T, Boolean>> selector) {
        throw moan();
    }

    @Override
    public int size() {
        throw moan();
    }

    @Override
    public boolean isEmpty() {
        throw moan();
    }

    @Override
    public boolean contains(Object o) {
        throw moan();
    }

    @Override
    public Iterator<T> iterator() {
        throw moan();
    }

    @Override
    public Object[] toArray() {
        throw moan();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw moan();
    }

    @Override
    public boolean add(T e) {
        throw moan();
    }

    @Override
    public boolean remove(Object o) {
        throw moan();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw moan();
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        throw moan();
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        throw moan();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw moan();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw moan();
    }

    @Override
    public void clear() {
        throw moan();
    }

    @Override
    public T get(int index) {
        throw moan();
    }

    @Override
    public T set(int index, T element) {
        throw moan();
    }

    @Override
    public void add(int index, T element) {
        throw moan();
    }

    @Override
    public T remove(int index) {
        throw moan();
    }

    @Override
    public int indexOf(Object o) {
        throw moan();
    }

    @Override
    public int lastIndexOf(Object o) {
        throw moan();
    }

    @Override
    public ListIterator<T> listIterator() {
        throw moan();
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        throw moan();
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw moan();
    }

    public static RuntimeException moan() {
        throw new IllegalStateException("The ephemeral list cannot be used again because it has already been disposed.");
    }

}
