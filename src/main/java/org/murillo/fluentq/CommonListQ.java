package org.murillo.fluentq;

import java.util.Collection;
import java.util.List;
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
import org.murillo.fluentq.impl.HashMapQ;

public interface CommonListQ<T, A, Z> extends List<T>, FluentQ<A, Z>, java.io.Serializable {

    boolean isDurable();

    boolean isEphemeral();

    <S> S accumulate(BiFunction<S, T, S> function, S initial);

    <S> S accumulateI(BiFunction<S, Iteration<T, S>, S> function, S initial);

    Optional<T> aggregate(BiFunction<T, T, T> function);

    boolean all(Predicate<T> test);

    boolean any(Predicate<T> test);

    boolean any();

    <S> ListQ<S> cast(Class<S> clazz);

    ListQ<ListQ<T>> cluster(BiPredicate<T, T> equalTest);

    ListQ<ListQ<T>> clusterEvery(int numberOfItems);

    int count();

    int count(Predicate<T> selector);

    Optional<T> first();

    Optional<T> first(Predicate<T> test);

    void forEachI(Consumer<Iteration<T, Void>> action);

    void forEachIReverse(Consumer<Iteration<T, Void>> action);

    void forEachReverse(Consumer<T> action);

    <K> HashMapQ<K, ListQ<T>> groupBy(Function<T, K> keySelector);

    <K> HashMapQ<K, ListQ<T>> groupByI(Function<Iteration<T, K>, K> keySelector);

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

    Optional<T> randomElement();

    Optional<T> randomElement(Random random);

    <S> ListQ<S> select(Function<T, S> selector);

    <S> ListQ<S> selectI(Function<Iteration<T, S>, S> selector);

    <S> ListQ<S> selectMany(Function<T, Collection<S>> selector);

    <S> ListQ<S> selectManyI(Function<Iteration<T, Collection<S>>, Collection<S>> selector);

    Optional<T> single();

    Optional<T> single(Predicate<T> test);

    double sumAsDouble();

    double sumAsDouble(ToDoubleFunction<T> toNumber);

    long sumAsLong();

    long sumAsLong(ToLongFunction<T> toNumber);

    ListQ<Iteration<T, T>> toIterations();

    <K, V> HashMapQ<K, V> toMap(Function<T, K> keySelector, Function<T, V> valueSelector);

    <K, V> HashMapQ<K, V> toMapI(Function<Iteration<T,K>, K> keySelector, Function<Iteration<T,V>, V> valueSelector);
    
    <K, V> HashMapQ<K, V> toMap(Function<T, K> keySelector, Function<T, V> valueSelector,
            BiConsumer<Map.Entry<K,V>, HashMapQ<K, V>> conflictResolver);

    <K, V> HashMapQ<K, V> toMapI(Function<Iteration<T,K>, K> keySelector, Function<Iteration<T,V>, V> valueSelector,
            BiConsumer<Map.Entry<K,V>, HashMapQ<K, V>> conflictResolver);

    String toString(String separator);

    String toString(String separator, Function<T, String> toString);

    T[] toTypedArray(Class<T> clazz);

    EphemeralListQ<T> concat(Collection<T> collection);

    EphemeralListQ<T> concat(T... items);
    
    EphemeralListQ<T> concatOne(T item);

    EphemeralListQ<T> distinct();

    EphemeralListQ<T> distinct(BiPredicate<T, T> equalTest);

    EphemeralListQ<T> insert(int index, Collection<T> collection);

    EphemeralListQ<T> insert(int index, T... items);    
        
    EphemeralListQ<T> insertOne(int index, T item);

    EphemeralListQ<T> intersect(Collection<T> collection);

    EphemeralListQ<T> intersect(Collection<T> collection, BiPredicate<T, T> equalTest);

    EphemeralListQ<T> order();

    EphemeralListQ<T> order(ToIntBiFunction<T, T> compareTo);

    EphemeralListQ<T> orderBy(Function<T, Comparable>... selectors);

    EphemeralListQ<T> orderByDesc(Function<T, Comparable>... selectors);

    EphemeralListQ<T> orderDesc();

    EphemeralListQ<T> orderDesc(ToIntBiFunction<T, T> compareTo);

    EphemeralListQ<T> range(int start, int count);

    EphemeralListQ<T> reverse();

    EphemeralListQ<T> shuffle();

    EphemeralListQ<T> shuffle(Random random);

    EphemeralListQ<T> skip(int howMany);

    EphemeralListQ<T> skipWhile(Predicate<T> condition);

    EphemeralListQ<T> skipWhileI(Predicate<Iteration<T, Boolean>> condition);

    EphemeralListQ<T> take(int howMany);

    EphemeralListQ<T> takeWhile(Predicate<T> condition);

    EphemeralListQ<T> takeWhileI(Predicate<Iteration<T, Boolean>> condition);

    EphemeralListQ<T> union(Collection<T> collection);

    EphemeralListQ<T> union(Collection<T> collection, BiPredicate<T, T> equalTest);

    EphemeralListQ<T> where(Predicate<T> selector);

    EphemeralListQ<T> whereI(Predicate<Iteration<T, Boolean>> selector);

    default Z fluentForEach(Consumer<T> action){
        this.forEach(action);
        return (Z)this;
    }
    
    default Z fluentForEachReverse(Consumer<T> action){
        this.forEachReverse(action);
        return (Z)this;
    }

    default Z fluentForEachI(Consumer<Iteration<T, Void>> action){
        this.forEachI(action);
        return (Z)this;
    }

    default Z fluentForEachIReverse(Consumer<Iteration<T, Void>> action){
        this.forEachIReverse(action);
        return (Z)this;
    }
    
}
