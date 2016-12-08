package org.murillo.fluentq.implementation;

import org.murillo.fluentq.Iteration;
import org.murillo.fluentq.implementation.EphemeralListQImpl;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
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
import java.util.stream.BaseStream;
import org.murillo.fluentq.EphemeralListQ;
import org.murillo.fluentq.ListQ;

/**
 *
 * @author Jose Miguel Murillo
 * @param <T>
 */
public class ArrayListQ<T> extends ArrayList<T> implements ListQ<T> {

    private static boolean equalsWithNulls(Object a, Object b) {
        if (a == b) {
            return true;
        }
        if ((a == null) || (b == null)) {
            return false;
        }
        return a.equals(b);
    }

    private static <A> int compareWithNullsWithCast(A a, A b) {
        if (a == null) {
            return -(((Comparable) b).compareTo(a));
        } else {
            return ((Comparable) a).compareTo(b);
        }
    }

    private static int compareWithNulls(Comparable a, Comparable b) {
        if (a == null) {
            return -(b.compareTo(a));
        } else {
            return a.compareTo(b);
        }
    }

    private static <A> int compareWithNullsWithSelectors(A a, A b, Function<A, Comparable>... selectors) {
        int result = 0;
        for (Function<A, Comparable> selector : selectors) {
            Comparable ca = selector.apply(a);
            Comparable cb = selector.apply(b);
            result = compareWithNulls(ca, cb);
            if (result != 0) {
                break;
            }
        }
        return result;
    }

//<editor-fold defaultstate="collapsed" desc="newList">
    public static <K, V> ArrayListQ<Map.Entry<K, V>> newList(Map<K, V> map) {
        return new ArrayListQ<>(map.entrySet());
    }
    
    public static ArrayListQ<Byte> newList(byte... array) {
        ArrayListQ<Byte> result = new ArrayListQ<>(array.length);
        for (byte i : array) {
            result.add(i);
        }
        return result;
    }
    
    public static ArrayListQ<Short> newList(short... array) {
        ArrayListQ<Short> result = new ArrayListQ<>(array.length);
        for (short i : array) {
            result.add(i);
        }
        return result;
    }
    
    public static ArrayListQ<Integer> newList(int... array) {
        ArrayListQ<Integer> result = new ArrayListQ<>(array.length);
        for (int i : array) {
            result.add(i);
        }
        return result;
    }
    
    public static ArrayListQ<Long> newList(long... array) {
        ArrayListQ<Long> result = new ArrayListQ<>(array.length);
        for (long i : array) {
            result.add(i);
        }
        return result;
    }
    
    public static ArrayListQ<Float> newList(float... array) {
        ArrayListQ<Float> result = new ArrayListQ<>(array.length);
        for (float i : array) {
            result.add(i);
        }
        return result;
    }
    
    public static ArrayListQ<Double> newList(double... array) {
        ArrayListQ<Double> result = new ArrayListQ<>(array.length);
        for (double i : array) {
            result.add(i);
        }
        return result;
    }
    
    public static ArrayListQ<Boolean> newList(boolean... array) {
        ArrayListQ<Boolean> result = new ArrayListQ<>(array.length);
        for (boolean i : array) {
            result.add(i);
        }
        return result;
    }
    
    public static ArrayListQ<Character> newList(char... array) {
        ArrayListQ<Character> result = new ArrayListQ<>(array.length);
        for (char i : array) {
            result.add(i);
        }
        return result;
    }
  
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="fromIterations">
    public static <S> ArrayListQ<S> fromIterations(boolean keepGaps, Iteration<S,?>... iterations){
        return _fromIterations(keepGaps, new ArrayListQ<>(iterations));
    }
    
    public static <S> ArrayListQ<S> fromIterations(boolean keepGaps, Iterable<Iteration<S,?>> iterations) {
        return _fromIterations(keepGaps, new ArrayListQ<>(iterations));
    }
    
    public static <S> ArrayListQ<S> fromIterations(boolean keepGaps, Iterator<Iteration<S,?>> iterations){
        return _fromIterations(keepGaps, new ArrayListQ<>(iterations));
    }
    
    public static <S> ArrayListQ<S> fromIterations(boolean keepGaps, Collection<Iteration<S,?>> iterations) {
        return _fromIterations(keepGaps, new ArrayListQ<>(iterations));
    }
    
    private static <S> ArrayListQ<S> _fromIterations(boolean keepGaps, ArrayListQ<Iteration<S,?>> iterations) {        
        if(iterations.isEmpty()) return new ArrayListQ<>();
        
        ArrayListQ<S> result;
        if(keepGaps){
            HashMap<Integer, S> toMap = iterations.toMap(iteration -> iteration.getIndex(), iteration -> iteration.getValue());
            int maxIndex = (int) iterations.maxAsLong(iteration -> iteration.getIndex()).getAsLong();
            result = new ArrayListQ<>(maxIndex+1);
            for(int i = 0; i < maxIndex; i++){
                result.add(toMap.get(i));
            }
        }else{
            result = (ArrayListQ<S>) iterations.orderSelf().select(iteration -> iteration.getValue());
        }
        return result;
    }
//</editor-fold>  
    
//<editor-fold defaultstate="collapsed" desc="to primitive arrays">
    public static byte[] toByteArray(ListQ<? extends Number> list){
        byte[] result = new byte[list.size()];
        for(int i = 0; i < result.length; i++){
            result[i] = list.get(i).byteValue();
        }
        return result;
    }
    
    public static short[] toShortArray(ListQ<? extends Number> list){
        short[] result = new short[list.size()];
        for(int i = 0; i < result.length; i++){
            result[i] = list.get(i).shortValue();
        }
        return result;
    }
    
    public static int[] toIntArray(ListQ<? extends Number> list){
        int[] result = new int[list.size()];
        for(int i = 0; i < result.length; i++){
            result[i] = list.get(i).intValue();
        }
        return result;
    }
    
    public static long[] toLongArray(ListQ<? extends Number> list){
        long[] result = new long[list.size()];
        for(int i = 0; i < result.length; i++){
            result[i] = list.get(i).longValue();
        }
        return result;
    }
    
    public static float[] toFloatArray(ListQ<? extends Number> list){
        float[] result = new float[list.size()];
        for(int i = 0; i < result.length; i++){
            result[i] = list.get(i).floatValue();
        }
        return result;
    }
    
    public static double[] toDoubleArray(ListQ<? extends Number> list){
        double[] result = new double[list.size()];
        for(int i = 0; i < result.length; i++){
            result[i] = list.get(i).doubleValue();
        }
        return result;
    }
    
    public static boolean[] toBooleanArray(ListQ<Boolean> list){
        boolean[] result = new boolean[list.size()];
        for(int i = 0; i < result.length; i++){
            result[i] = list.get(i);
        }
        return result;
    }
    
    public static char[] toCharArray(ListQ<Character> list){
        char[] result = new char[list.size()];
        for(int i = 0; i < result.length; i++){
            result[i] = list.get(i);
        }
        return result;
    }
    
    public static byte[] toByteArray(ListQ<? extends Number> list, byte nullValue){
        byte[] result = new byte[list.size()];
        for(int i = 0; i < result.length; i++){
            Number get = list.get(i);
            if(get == null) result[i] = nullValue;
            else result[i] = list.get(i).byteValue();
        }
        return result;
    }
    
    public static short[] toShortArray(ListQ<? extends Number> list, short nullValue){
        short[] result = new short[list.size()];
        for(int i = 0; i < result.length; i++){
            Number get = list.get(i);
            if(get == null) result[i] = nullValue;
            else result[i] = list.get(i).shortValue();
        }
        return result;
    }
    
    public static int[] toIntArray(ListQ<? extends Number> list, int nullValue){
        int[] result = new int[list.size()];
        for(int i = 0; i < result.length; i++){
            Number get = list.get(i);
            if(get == null) result[i] = nullValue;
            else result[i] = list.get(i).intValue();
        }
        return result;
    }
    
    public static long[] toLongArray(ListQ<? extends Number> list, long nullValue){
        long[] result = new long[list.size()];
        for(int i = 0; i < result.length; i++){
            Number get = list.get(i);
            if(get == null) result[i] = nullValue;
            else result[i] = list.get(i).longValue();
        }
        return result;
    }
    
    public static float[] toFloatArray(ListQ<? extends Number> list, float nullValue){
        float[] result = new float[list.size()];
        for(int i = 0; i < result.length; i++){
            Number get = list.get(i);
            if(get == null) result[i] = nullValue;
            else result[i] = list.get(i).floatValue();
        }
        return result;
    }
    
    public static double[] toDoubleArray(ListQ<? extends Number> list, double nullValue){
        double[] result = new double[list.size()];
        for(int i = 0; i < result.length; i++){
            Number get = list.get(i);
            if(get == null) result[i] = nullValue;
            else result[i] = list.get(i).doubleValue();
        }
        return result;
    }
    
    public static boolean[] toBooleanArray(ListQ<Boolean> list, boolean nullValue){
        boolean[] result = new boolean[list.size()];
        for(int i = 0; i < result.length; i++){
            Boolean get = list.get(i);
            if(get == null) result[i] = nullValue;
            else result[i] = list.get(i);
        }
        return result;
    }
    
    public static char[] toCharArray(ListQ<Character> list, char nullValue){
        char[] result = new char[list.size()];
        for(int i = 0; i < result.length; i++){
            Character get = list.get(i);
            if(get == null) result[i] = nullValue;
            else result[i] = list.get(i);
        }
        return result;
    }       
//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="generate">
    public static <A> ArrayListQ<A> generate(Function<Iteration<A, A>, A> generator) {
        return generate(generator, Integer.MAX_VALUE);
    }
    
    public static <A> ArrayListQ<A> generate(Function<Iteration<A, A>, A> generator, int maxCount) {
        ArrayListQ<A> result = new ArrayListQ<>();
        int count = 0;
        try {
            A item = null;
            while (count < maxCount) {
                Iteration<A, A> iteration = new IterationImpl(item, count);
                item = generator.apply(iteration);
                result.add(item);
                count++;
            }
        } catch (BreakLoopException ex) {
            if (ex.isInitialized()) {
                result.add((A) ex.getReturned());
            }
        }
        return result;
    }
//</editor-fold>

    private Random randomGenerator;

//<editor-fold defaultstate="collapsed" desc="constructors">
    public ArrayListQ() {
        super();
        this.randomGenerator = new Random();
    }

    public ArrayListQ(Collection<T> collection) {
        super(collection);
        this.randomGenerator = new Random();
    }

    public ArrayListQ(T... array) {
        this(Arrays.asList(array));
    }

    public ArrayListQ(int reservedSize) {
        super(reservedSize);
        this.randomGenerator = new Random();
    }
    
    public ArrayListQ(Iterable<T> iterable) {
        this();
        iterable.forEach(x -> this.add(x));
    }
        
    public ArrayListQ(Iterator<T> iterator) {
        this();
        iterator.forEachRemaining(x -> this.add(x));
    }
    
    public ArrayListQ(BaseStream<T,?> stream) {
        this(stream.iterator());
    }
//</editor-fold>

    public Random getRandomGenerator() {
        return randomGenerator;
    }

    public void setRandomGenerator(Random randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

//<editor-fold defaultstate="collapsed" desc="aggregate">
    @Override
    public Optional<T> aggregate(BiFunction<T, T, T> function) {
        if(this.isEmpty()) Optional.empty();
        T aggregate = this.get(0);
        for (int i = 1; i < this.size(); i++) {
            T item = this.get(i);
            aggregate = function.apply(aggregate, item);
        }
        return Optional.of(aggregate);        
    }

    @Override
    public <S> S accumulate(BiFunction<S, T, S> function, S initial) {
        S accumulate = initial;
        for (int i = 0; i < this.size(); i++) {
            T item = this.get(i);
            accumulate = function.apply(accumulate, item);
        }
        return accumulate;
    }

    @Override
    public <S> S accumulateI(BiFunction<S, Iteration<T, S>, S> function, S initial) {
        S accumulate = initial;
        try {
            for (int i = 0; i < this.size(); i++) {
                T item = this.get(i);
                accumulate = function.apply(accumulate, new IterationImpl<>(item, i));
            }
        } catch (BreakLoopException ex) {
            if (ex.isInitialized()) {
                accumulate = (S) ex.getReturned();
            }
        }
        return accumulate;
    }

//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="where">
    @Override
    public EphemeralListQ<T> where(Predicate<T> selector) {
        return EphemeralListQImpl.wrap(this._where(selector, false));
    }

    @Override
    public ListQ<T> whereSelf(Predicate<T> selector) {
        return this._where(selector, true);
    }

    @Override
    public EphemeralListQ<T> whereI(Predicate<Iteration<T, Boolean>> selector) {
        return EphemeralListQImpl.wrap(this._whereI(selector, false));
    }

    @Override
    public ListQ<T> whereISelf(Predicate<Iteration<T, Boolean>> selector) {
        return this._whereI(selector, true);
    }

    private ListQ<T> _where(Predicate<T> selector, boolean inPlace) {
        if (inPlace) {
            SelfImplementation.where(this, selector);
            return this;
        } else {
            return NewListImplementation.where(this, selector);
        }
    }

    private ListQ<T> _whereI(Predicate<Iteration<T, Boolean>> selector, boolean inPlace) {
        if (inPlace) {
            SelfImplementation.whereI(this, selector);
            return this;
        } else {
            return NewListImplementation.whereI(this, selector);
        }
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="select">
    @Override
    public <S> ListQ<S> select(Function<T, S> selector) {
        ArrayListQ<S> result = new ArrayListQ<>(this.size());
        for (T item : this) {
            result.add(selector.apply(item));
        }
        return result;
    }

    @Override
    public <S> ListQ<S> selectI(Function<Iteration<T, S>, S> selector) {
        ArrayListQ<S> result = new ArrayListQ<>(this.size());
        try {
            for (int i = 0; i < this.size(); i++) {
                T item = this.get(i);
                Iteration<T, S> iteration = new IterationImpl(item, i);
                result.add(selector.apply(iteration));
            }
        } catch (BreakLoopException ex) {
            if (ex.isInitialized()) {
                result.add((S) ex.getReturned());
            }
        }
        return result;
    }

//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="all or any">
    @Override
    public boolean all(Predicate<T> test) {
        for (T item : this) {
            if (!test.test(item)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean any(Predicate<T> test) {
        for (T item : this) {
            if (test.test(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean any() {
        return !this.isEmpty();
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="pick one">

    @Override
    public Optional<T> first() {
        if (this.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.ofNullable(this.get(0));
        }
    }

    @Override
    public Optional<T> first(Predicate<T> test) {
        for (T item : this) {
            if (test.test(item)) {
                return Optional.ofNullable(item);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<T> last() {
        if (this.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.ofNullable(this.get(this.size() - 1));
        }
    }

    @Override
    public Optional<T> last(Predicate<T> test) {
        for (int i = this.size() - 1; i >= 0; i--) {
            T item = this.get(i);
            if (test.test(item)) {
                return Optional.ofNullable(item);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<T> single() {
        if (this.isEmpty()) {
            return Optional.empty();
        } else if (this.size() > 1) {
            throw new IllegalStateException("The sequence contains more than one element.");
        } else {
            return Optional.ofNullable(this.get(0));
        }
    }

    @Override
    public Optional<T> single(Predicate<T> test) {
        boolean found = false;
        T result = null;
        for (T item : this) {
            if (test.test(item)) {
                if (found) {
                    throw new IllegalStateException("The sequence contains more than one matching element.");
                } else {
                    result = item;
                    found = true;
                }
            }
        }
        return Optional.ofNullable(result);
    }

    @Override
    public Optional<T> randomElement() {
        if(this.isEmpty()) return Optional.empty();
        int index = randomGenerator.nextInt(this.size());
        T item = this.get(index);
        return Optional.of(item);
    }

    @Override
    public Optional<T> randomElement(Random random) {
        if(this.isEmpty()) return Optional.empty();
        int index = random.nextInt(this.size());
        T item = this.get(index);
        return Optional.of(item);
    }

//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="distinct">
    @Override
    public EphemeralListQ<T> distinct() {
        return EphemeralListQImpl.wrap(_distinct(ArrayListQ::equalsWithNulls, false));
    }

    @Override
    public EphemeralListQ<T> distinct(BiPredicate<T, T> equalTest) {
        return EphemeralListQImpl.wrap(_distinct(equalTest, false));
    }

    @Override
    public ListQ<T> distinctSelf() {
        return _distinct(ArrayListQ::equalsWithNulls, true);
    }

    @Override
    public ListQ<T> distinctSelf(BiPredicate<T, T> equalTest) {
        return _distinct(equalTest, true);
    }
    
    private ListQ<T> _distinct(BiPredicate<T, T> equalTest, boolean inPlace) {
        if (inPlace) {
            SelfImplementation.distinct(this, equalTest);
            return this;
        } else {
            return NewListImplementation.distinct(this, equalTest);
        }
    }

//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="union">
    @Override
    public EphemeralListQ<T> union(Collection<T> collection) {
        return EphemeralListQImpl.wrap(_union(ArrayListQ::equalsWithNulls, collection, false));
    }

    @Override
    public EphemeralListQ<T> union(Collection<T> collection, BiPredicate<T, T> equalTest) {
        return EphemeralListQImpl.wrap(_union(equalTest, collection, false));
    }

    @Override
    public ListQ<T> unionSelf(Collection<T> collection) {
        return _union(ArrayListQ::equalsWithNulls, collection, true);
    }

    @Override
    public ListQ<T> unionSelf(Collection<T> collection, BiPredicate<T, T> equalTest) {
        return _union(equalTest, collection, true);
    }

    private ListQ<T> _union(BiPredicate<T, T> equalTest, Collection<T> collection, boolean inPlace) {
        if (inPlace) {
            SelfImplementation.union(this, equalTest, collection);
            return this;
        } else {
            return NewListImplementation.union(this, equalTest, collection);
        }
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="intersect">
    @Override
    public EphemeralListQ<T> intersect(Collection<T> collection) {
        return EphemeralListQImpl.wrap(_intersection(ArrayListQ::equalsWithNulls, collection, false));
    }

    @Override
    public EphemeralListQ<T> intersect(Collection<T> collection, BiPredicate<T, T> equalTest) {
        return EphemeralListQImpl.wrap(_intersection(equalTest, collection, false));
    }

    @Override
    public ListQ<T> intersectSelf(Collection<T> collection) {
        return _intersection(ArrayListQ::equalsWithNulls, collection, true);
    }

    @Override
    public ListQ<T> intersectSelf(Collection<T> collection, BiPredicate<T, T> equalTest) {
        return _intersection(equalTest, collection, true);
    }

    private ListQ<T> _intersection(BiPredicate<T, T> equalTest, Collection<T> collection, boolean inPlace) {
        return this._where(x -> {
            for (T item : collection) {
                if (equalTest.test(x, item)) {
                    return true;
                }
            }
            return false;
        },
                inPlace);
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="count">
    @Override
    public int count() {
        return this.size();
    }

    @Override
    public int count(Predicate<T> selector) {
        int counter = 0;
        for (T item : this) {
            if (selector.test(item)) {
                counter++;
            }
        }
        return counter;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="concat insert">
    @Override
    public EphemeralListQ<T> concat(Collection<T> collection) {
        return EphemeralListQImpl.wrap(this._insert(this.size(), collection, false));
    }

    @Override
    public ListQ<T> concatSelf(Collection<T> collection) {
        return this._insert(this.size(), collection, true);
    }

    @Override
    public EphemeralListQ<T> concat(T... items) {
        return EphemeralListQImpl.wrap(this._insert(this.size(), Arrays.asList(items), false));
    }

    @Override
    public ListQ<T> concatSelf(T... items) {
        return this._insert(this.size(), Arrays.asList(items), true);
    }

    @Override
    public EphemeralListQ<T> insert(int index, Collection<T> collection) {
        return EphemeralListQImpl.wrap(this._insert(index, collection, false));
    }

    @Override
    public ListQ<T> insertSelf(int index, Collection<T> collection) {
        return this._insert(index, collection, true);
    }

    @Override
    public EphemeralListQ<T> insert(int index, T... items) {
        return EphemeralListQImpl.wrap(this._insert(index, Arrays.asList(items), false));
    }

    @Override
    public ListQ<T> insertSelf(int index, T... items) {
        return this._insert(index, Arrays.asList(items), true);
    }

    private ListQ<T> _insert(int index, Collection<T> collection, boolean inPlace) {
        if (inPlace) {
            SelfImplementation.insert(this, index, collection);
            return this;
        } else {
            return NewListImplementation.insert(this, index, collection);
        }
    }
//</editor-fold>

    @Override
    public <S> ListQ<S> cast(Class<S> clazz) {
        ArrayListQ<S> result = new ArrayListQ<>(this.size());
        for (T item : this) {
            result.add(clazz.cast(item));
        }
        return result;
    }   
    
//<editor-fold defaultstate="collapsed" desc="numerical">
    @Override
    public double sumAsDouble() {
        double sum = 0.0D;
        for (T item : this) {
            if (item != null && item instanceof Number) {
                double d = ((Number) item).doubleValue();
                sum += d;
            }
        }
        return sum;
    }

    @Override
    public double sumAsDouble(ToDoubleFunction<T> toNumber) {
        double sum = 0.0D;
        for (T item : this) {
            double d = toNumber.applyAsDouble(item);
            sum += d;
        }
        return sum;
    }

    @Override
    public long sumAsLong() {
        long sum = 0L;
        for (T item : this) {
            if (item != null && item instanceof Number) {
                long l = ((Number) item).longValue();
                sum += l;
            }
        }
        return sum;
    }

    @Override
    public long sumAsLong(ToLongFunction<T> toNumber) {
        long sum = 0L;
        for (T item : this) {
            long l = toNumber.applyAsLong(item);
            sum += l;
        }
        return sum;
    }

    @Override
    public OptionalDouble maxAsDouble() {
        if (this.isEmpty()) return OptionalDouble.empty();

        double max = Double.NEGATIVE_INFINITY;
        boolean found = false;
        for (T item : this) {
            double d = ((Number) item).doubleValue();
            found = true;
            if (d > max) {
                max = d;
            }
        }
        if (!found) return OptionalDouble.empty();
        else return OptionalDouble.of(max);
    }

    @Override
    public OptionalDouble maxAsDouble(ToDoubleFunction<T> toNumber) {
        if (this.isEmpty()) return OptionalDouble.empty();
        
        double max = Double.NEGATIVE_INFINITY;
        for (T item : this) {
            double d = toNumber.applyAsDouble(item);
            if (d > max) {
                max = d;
            }
        }
        return OptionalDouble.of(max);
    }

    @Override
    public OptionalLong maxAsLong() {
        if (this.isEmpty()) return OptionalLong.empty();
        
        long max = Long.MIN_VALUE;
        boolean found = false;
        for (T item : this) {
            long l = ((Number) item).longValue();
            found = true;
            if (l > max) {
                max = l;
            }
        }
        
        if (!found) return OptionalLong.empty();
        else return OptionalLong.of(max);
    }

    @Override
    public OptionalLong maxAsLong(ToLongFunction<T> toNumber) {
        if (this.isEmpty()) return OptionalLong.empty();
        
        long max = Long.MIN_VALUE;
        for (T item : this) {
            long l = toNumber.applyAsLong(item);
            if (l > max) {
                max = l;
            }
        }
        return OptionalLong.of(max);
    }

    @Override
    public OptionalDouble minAsDouble() {
        if (this.isEmpty()) return OptionalDouble.empty();
        
        double min = Double.POSITIVE_INFINITY;
        boolean found = false;
        for (T item : this) {
            double d = ((Number) item).doubleValue();
            found = true;
            if (d < min) {
                min = d;
            }
        }
        
        if (!found) return OptionalDouble.empty();
        else return OptionalDouble.of(min);
    }

    @Override
    public OptionalDouble minAsDouble(ToDoubleFunction<T> toNumber) {
        if (this.isEmpty()) return OptionalDouble.empty();
        
        double min = Double.POSITIVE_INFINITY;
        for (T item : this) {
            double d = toNumber.applyAsDouble(item);
            if (d < min) {
                min = d;
            }
        }
        return OptionalDouble.of(min);
    }

    @Override
    public OptionalLong minAsLong() {
        if (this.isEmpty()) return OptionalLong.empty();

        long min = Long.MAX_VALUE;
        boolean found = false;
        for (T item : this) {
            long l = ((Number) item).longValue();
            found = true;
            if (l < min) {
                min = l;
            }
        }
        
        if (!found) return OptionalLong.empty();
        else return OptionalLong.of(min);
    }

    @Override
    public OptionalLong minAsLong(ToLongFunction<T> toNumber) {
        if (this.isEmpty()) return OptionalLong.empty();
        
        long min = Long.MAX_VALUE;
        for (T item : this) {
            long l = toNumber.applyAsLong(item);
            if (l < min) {
                min = l;
            }
        }
        return OptionalLong.of(min);
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="groupBy">
    @Override
    public <K> HashMap<K, ListQ<T>> groupBy(Function<T, K> keySelector) {
        HashMap<K, ListQ<T>> result = new HashMap<>();
        for (T item : this) {
            K key = keySelector.apply(item);
            groupKeyValue(result, key, item);
        }
        return result;
    }

    @Override
    public <K> HashMap<K, ListQ<T>> groupByI(Function<Iteration<T, K>, K> keySelector) {
        HashMap<K, ListQ<T>> result = new HashMap<>();
        try {
            for (int i = 0; i < this.size(); i++) {
                T item = this.get(i);
                Iteration<T, K> iteration = new IterationImpl(item, i);
                K key = keySelector.apply(iteration);
                groupKeyValue(result, key, item);
            }
        } catch (BreakLoopException ex) {
            if (ex.isInitialized()) {
                K key = (K) ex.getReturned();
                T item = (T) ex.getLastIteration().getValue();
                groupKeyValue(result, key, item);
            }
        }
        return result;
    }

    private <K> void groupKeyValue(HashMap<K, ListQ<T>> result, K key, T item) {
        ListQ<T> list = result.get(key);
        if (list != null) {
            list.add(item);
        } else {
            list = new ArrayListQ<>();
            list.add(item);
            result.put(key, list);
        }
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="cluster">
    @Override
    public ListQ<ListQ<T>> cluster(BiPredicate<T, T> equalTest) {
        ArrayList<T> prototypes = new ArrayList<>();
        ArrayListQ<ListQ<T>> result = new ArrayListQ<>();
        for (T item : this) {
            int index = lookForPrototype(item, prototypes, equalTest);
            ListQ<T> cluster;
            if (index >= 0) {
                cluster = result.get(index);
            } else {
                cluster = new ArrayListQ<>();
                result.add(cluster);
                prototypes.add(item);
            }
            cluster.add(item);
        }
        return result;
    }

    private static <T> int lookForPrototype(T item, ArrayList<T> prototypes, BiPredicate<T, T> equalTest) {
        for (int i = prototypes.size() - 1; i >= 0; i--) {
            T prototype = prototypes.get(i);
            if (equalTest.test(prototype, item)) {
                return i;
            }
        }
        return -1;
    }
    
    @Override
    public ListQ<ListQ<T>> clusterEvery(int numberOfItems) {
        ArrayListQ<ListQ<T>> result = new ArrayListQ<>();
        ListQ<T> currentList = null;
        int modular;
        for(int i = 0; i < this.size(); i++){
            modular = i%numberOfItems;
            if(modular == 0){
                currentList = new ArrayListQ<>(numberOfItems);
                result.add(currentList);
            }
            T item = this.get(i);
            currentList.add(item);            
        }
        
        return result;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="toMap">
    @Override
    public <K, V> HashMap<K, V> toMap(Function<T, K> keySelector, Function<T, V> valueSelector) {
        HashMap<K, V> result = new HashMap<>();
        for (T item : this) {
            K key = keySelector.apply(item);
            V value = valueSelector.apply(item);
            result.put(key, value);
        }
        return result;
    }

    @Override
    public <K, V> HashMap<K, V> toMap(BiFunction<T, Integer, K> keySelector, BiFunction<T, Integer, V> valueSelector) {
        HashMap<K, V> result = new HashMap<>();
        for (int i = 0; i < this.size(); i++) {
            T item = this.get(i);
            K key = keySelector.apply(item, i);
            V value = valueSelector.apply(item, i);
            result.put(key, value);
        }
        return result;
    }

    @Override
    public <K, V> HashMap<K, V> toMap(BiFunction<T, Integer, K> keySelector, Function<T, V> valueSelector) {
        HashMap<K, V> result = new HashMap<>();
        for (int i = 0; i < this.size(); i++) {
            T item = this.get(i);
            K key = keySelector.apply(item, i);
            V value = valueSelector.apply(item);
            result.put(key, value);
        }
        return result;
    }

    @Override
    public <K, V> HashMap<K, V> toMap(Function<T, K> keySelector, BiFunction<T, Integer, V> valueSelector) {
        HashMap<K, V> result = new HashMap<>();
        for (int i = 0; i < this.size(); i++) {
            T item = this.get(i);
            K key = keySelector.apply(item);
            V value = valueSelector.apply(item, i);
            result.put(key, value);
        }
        return result;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="selectMany">
    @Override
    public <S> ListQ<S> selectMany(Function<T, Collection<S>> selector) {
        ArrayListQ<S> result = new ArrayListQ<S>(this.size());
        for (T item : this) {
            result.addAll(selector.apply(item));
        }
        return result;
    }

    @Override
    public <S> ListQ<S> selectManyI(Function<Iteration<T, Collection<S>>, Collection<S>> selector) {
        ArrayListQ<S> result = new ArrayListQ<S>(this.size());
        try {
            int i = 0;
            for (T item : this) {
                Iteration<T, Collection<S>> iteration = new IterationImpl<>(item, i);
                result.addAll(selector.apply(iteration));
                i++;
            }
        } catch (BreakLoopException ex) {
            if (ex.isInitialized()) {
                result.addAll((Collection<S>) ex.getReturned().get());
            }
        }
        return result;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="forEach">
    @Override
    public void forEachReverse(Consumer<T> action) {
        for (int i = this.size() - 1; i >= 0; i--) {
            T item = this.get(i);
            action.accept(item);
        }
    }

    @Override
    public void forEachI(Consumer<Iteration<T, Void>> action) {
        try {
            for (int i = 0; i < this.size(); i++) {
                Iteration<T, Void> item = new IterationImpl<>(this.get(i), i);
                action.accept(item);
            }
        } catch (BreakLoopException e) {
        }
    }

    @Override
    public void forEachIReverse(Consumer<Iteration<T, Void>> action) {
        try {
            for (int i = this.size() - 1; i >= 0; i--) {
                Iteration<T, Void> item = new IterationImpl<>(this.get(i), i);
                action.accept(item);
            }
        } catch (BreakLoopException e) {
        }
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="reverse">
    @Override
    public EphemeralListQ<T> reverse() {
        return EphemeralListQImpl.wrap(this._reverse(false));
    }

    @Override
    public ListQ<T> reverseSelf() {
        return this._reverse(true);
    }

    private ListQ<T> _reverse(boolean inPlace) {
        ArrayListQ<T> result = inPlace ? this : new ArrayListQ<>(this);
        Collections.reverse(result);
        return result;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="shuffle">
    @Override
    public EphemeralListQ<T> shuffle() {
        return EphemeralListQImpl.wrap(this._shuffle(this.randomGenerator, false));
    }

    @Override
    public ListQ<T> shuffleSelf() {
        return this._shuffle(this.randomGenerator, true);
    }

    @Override
    public EphemeralListQ<T> shuffle(Random random) {
        return EphemeralListQImpl.wrap(this._shuffle(random, false));
    }

    @Override
    public ListQ<T> shuffleSelf(Random random) {
        return this._shuffle(random, true);
    }

    private ListQ<T> _shuffle(Random random, boolean inPlace) {
        ArrayListQ<T> result = inPlace ? this : new ArrayListQ<>(this);
        Collections.shuffle(result, random);
        return result;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="order">
    @Override
    public EphemeralListQ<T> order() {
        return EphemeralListQImpl.wrap(this._order(false, false, ArrayListQ::compareWithNullsWithCast));
    }

    @Override
    public ListQ<T> orderSelf() {
        return this._order(true, false, ArrayListQ::compareWithNullsWithCast);
    }

    @Override
    public EphemeralListQ<T> orderDesc() {
        return EphemeralListQImpl.wrap(this._order(false, true, ArrayListQ::compareWithNullsWithCast));
    }

    @Override
    public ListQ<T> orderDescSelf() {
        return this._order(true, true, ArrayListQ::compareWithNullsWithCast);
    }

    @Override
    public EphemeralListQ<T> order(ToIntBiFunction<T, T> compareTo) {
        return EphemeralListQImpl.wrap(this._order(false, false, compareTo));
    }

    @Override
    public ListQ<T> orderSelf(ToIntBiFunction<T, T> compareTo) {
        return this._order(true, false, compareTo);
    }

    @Override
    public EphemeralListQ<T> orderDesc(ToIntBiFunction<T, T> compareTo) {
        return EphemeralListQImpl.wrap(this._order(false, true, compareTo));
    }

    @Override
    public ListQ<T> orderDescSelf(ToIntBiFunction<T, T> compareTo) {
        return this._order(true, true, compareTo);
    }

    @Override
    public EphemeralListQ<T> orderBy(Function<T, Comparable>... selectors) {
        return EphemeralListQImpl.wrap(this._order(false, false, (a, b) -> compareWithNullsWithSelectors(a, b, selectors)));
    }

    @Override
    public ListQ<T> orderBySelf(Function<T, Comparable>... selectors) {
        return this._order(true, false, (a, b) -> compareWithNullsWithSelectors(a, b, selectors));
    }

    @Override
    public EphemeralListQ<T> orderByDesc(Function<T, Comparable>... selectors) {
        return EphemeralListQImpl.wrap(this._order(false, true, (a, b) -> compareWithNullsWithSelectors(a, b, selectors)));
    }

    @Override
    public ListQ<T> orderByDescSelf(Function<T, Comparable>... selectors) {
        return this._order(true, true, (a, b) -> compareWithNullsWithSelectors(a, b, selectors));
    }

    private ListQ<T> _order(boolean inPlace, boolean desc, ToIntBiFunction<T, T> compareTo) {
        ArrayListQ<T> result = inPlace ? this : new ArrayListQ<>(this);
        Comparator<T> c;
        if (desc) {
            c = new Comparator<T>() {
                @Override
                public int compare(T o1, T o2) {
                    return compareTo.applyAsInt(o2, o1);
                }
            };
        } else {
            c = new Comparator<T>() {
                @Override
                public int compare(T o1, T o2) {
                    return compareTo.applyAsInt(o1, o2);
                }
            };
        }

        Collections.sort(result, c);
        return result;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="take">
    @Override
    public EphemeralListQ<T> take(int howMany) {
        ListQ<T> result;
        if (howMany < this.size()) {
            result = new ArrayListQ<>(this.subList(0, howMany));
        } else {
            result = new ArrayListQ<>(this);
        }
        return EphemeralListQImpl.wrap(result);
    }

    @Override
    public ListQ<T> takeSelf(int howMany) {
        int size = this.size();
        if (howMany < size) {
            int fromIndex = size - howMany;
            this.removeRange(fromIndex, size);
        }
        return this;
    }

    @Override
    public EphemeralListQ<T> takeWhile(Predicate<T> condition) {
        int toIndex = 0;
        for (; toIndex < this.size(); toIndex++) {
            T item = this.get(toIndex);
            if (!condition.test(item)) {
                break;
            }
        }
        ListQ<T> result;
        if (toIndex >= this.size()) {
            result = new ArrayListQ<>(this);
        } else {
            result = new ArrayListQ<>(this.subList(0, toIndex));
        }
        return EphemeralListQImpl.wrap(result);
    }

    @Override
    public ListQ<T> takeWhileSelf(Predicate<T> condition) {
        int fromIndex = 0;
        for (; fromIndex < this.size(); fromIndex++) {
            T item = this.get(fromIndex);
            if (!condition.test(item)) {
                break;
            }
        }
        this.removeRange(fromIndex, this.size());
        return this;
    }

    @Override
    public EphemeralListQ<T> takeWhileI(Predicate<Iteration<T, Boolean>> condition) {
        int toIndex = 0;
        try {
            for (; toIndex < this.size(); toIndex++) {
                Iteration<T, Boolean> iteration = new IterationImpl<>(this.get(toIndex), toIndex);
                if (!condition.test(iteration)) {
                    break;
                }
            }
        } catch (BreakLoopException ex) {
            if (ex.isInitialized() && (Boolean) ex.getReturned().get()) {
                toIndex++;
            }
        }

        ArrayListQ<T> result;
        if (toIndex >= this.size()) {
            result = new ArrayListQ<>(this);
        } else {
            result = new ArrayListQ<>(this.subList(0, toIndex));
        }
        return EphemeralListQImpl.wrap(result);
    }

    @Override
    public ListQ<T> takeWhileISelf(Predicate<Iteration<T, Boolean>> condition) {
        int fromIndex = 0;
        try {
            for (; fromIndex < this.size(); fromIndex++) {
                Iteration<T, Boolean> iteration = new IterationImpl<>(this.get(fromIndex), fromIndex);
                if (!condition.test(iteration)) {
                    break;
                }
            }
        } catch (BreakLoopException ex) {
            if (ex.isInitialized() && (Boolean) ex.getReturned().get()) {
                fromIndex++;
            }
        }
        this.removeRange(fromIndex, this.size());
        return this;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="skip">
    @Override
    public EphemeralListQ<T> skip(int howMany) {
        ListQ<T> result;
        if (howMany < this.size()) {
            result = new ArrayListQ<>(this.subList(howMany, this.size()));
        } else {
            result = new ArrayListQ<>();
        }
        return EphemeralListQImpl.wrap(result);
    }

    @Override
    public ListQ<T> skipSelf(int howMany) {
        int size = this.size();
        if (howMany < size) {
            int toIndex = size - howMany;
            this.removeRange(0, toIndex);
        }
        return this;
    }

    @Override
    public EphemeralListQ<T> skipWhile(Predicate<T> condition) {
        int fromIndex = 0;
        for (; fromIndex < this.size(); fromIndex++) {
            T item = this.get(fromIndex);
            if (!condition.test(item)) {
                break;
            }
        }
        ListQ<T> result;
        if (fromIndex >= this.size()) {
            result = new ArrayListQ<>();
        } else {
            result = new ArrayListQ<>(this.subList(fromIndex, this.size()));
        }
        return EphemeralListQImpl.wrap(result);
    }

    @Override
    public ListQ<T> skipWhileSelf(Predicate<T> condition) {
        int toIndex = 0;
        for (; toIndex < this.size(); toIndex++) {
            T item = this.get(toIndex);
            if (!condition.test(item)) {
                break;
            }
        }

        if (toIndex < this.size()) {
            this.removeRange(0, toIndex);
        } else {
            this.clear();
        }

        return this;
    }

    @Override
    public EphemeralListQ<T> skipWhileI(Predicate<Iteration<T, Boolean>> condition) {
        int fromIndex = 0;
        try {
            for (; fromIndex < this.size(); fromIndex++) {
                Iteration<T, Boolean> iteration = new IterationImpl<>(this.get(fromIndex), fromIndex);
                if (!condition.test(iteration)) {
                    break;
                }
            }
        } catch (BreakLoopException ex) {
            if (ex.isInitialized() && (Boolean) ex.getReturned().get()) {
                fromIndex++;
            }
        }
        ListQ<T> result;
        if (fromIndex >= this.size()) {
            result = new ArrayListQ<>();
        } else {
            result = new ArrayListQ<>(this.subList(fromIndex, this.size()));
        }
        return EphemeralListQImpl.wrap(result);
    }

    @Override
    public ListQ<T> skipWhileISelf(Predicate<Iteration<T, Boolean>> condition) {
        int toIndex = 0;
        try {
            for (; toIndex < this.size(); toIndex++) {
                Iteration<T, Boolean> iteration = new IterationImpl<>(this.get(toIndex), toIndex);
                if (!condition.test(iteration)) {
                    break;
                }
            }
        } catch (BreakLoopException ex) {
            if (ex.isInitialized() && (Boolean) ex.getReturned().get()) {
                toIndex++;
            }
        }

        if (toIndex < this.size()) {
            this.removeRange(0, toIndex);
        } else {
            this.clear();
        }

        return this;
    }

//</editor-fold>          
    @Override
    public String toString(String separator) {
        return this.toString(separator, String::valueOf);
    }

    @Override
    public String toString(String separator, Function<T, String> toString) {
        if (!this.isEmpty()) {
            StringBuilder sb = new StringBuilder(toString.apply(this.get(0)));
            for (int i = 1; i < this.size(); i++) {
                sb.append(separator);
                sb.append(toString.apply(this.get(i)));
            }
            return sb.toString();
        } else {
            return "";
        }
    }

    @Override
    public T[] toTypedArray(Class<T> clazz) {
        T[] array = (T[]) Array.newInstance(clazz, this.size());
        return this.toArray(array);
    }

    @Override
    public ListQ<Iteration<T,T>> toIterations(){
        ArrayListQ<Iteration<T,T>> result = new ArrayListQ<>(this.size());
        for(int i = 0; i< this.size();i++){
            result.add(new IterationImpl<>(this.get(i), i));
        }
        return result;
    }
    
    @Override
    public EphemeralListQ<T> range(int start, int count){
        return EphemeralListQImpl.wrap(new ArrayListQ<>(this.subList(start, start + count)));
    }
    
    @Override
    public ListQ<T> rangeSelf(int start, int count){
        this.removeRange(start + count - 1, this.size());
        this.removeRange(0, start);
        return this;
    }
    
    private static class SelfImplementation {

        static <A> void where(ArrayListQ<A> thisList, Predicate<A> selector) {
            boolean inDeletionRange = false;
            int rangeStart = 0;
            int i = 0;
            for (; i < thisList.size() - 1; i++) {
                A item = thisList.get(i);
                boolean matches = selector.test(item);

                if (inDeletionRange && matches) {
                    inDeletionRange = false;
                    thisList.removeRange(rangeStart, i);
                    i = rangeStart;
                } else if (!inDeletionRange && !matches) {
                    inDeletionRange = true;
                    rangeStart = i;
                }
            }

            A item = thisList.get(i);
            boolean matches = selector.test(item);
            if (inDeletionRange) {
                thisList.removeRange(rangeStart, matches ? i : i + 1);
            } else if (!matches) {
                thisList.remove(i);
            }
        }

        static <A> void whereI(ArrayListQ<A> thisList, Predicate<Iteration<A, Boolean>> selector) {
            boolean inDeletionRange = false;
            int rangeStart = 0;
            int i = 0;
            int oldi = 0;
            try {
                for (; i < thisList.size() - 1; i++, oldi++) {
                    Iteration<A, Boolean> iteration = new IterationImpl<>(thisList.get(i), oldi);
                    boolean matches = selector.test(iteration);
                    if (inDeletionRange && matches) {
                        inDeletionRange = false;
                        thisList.removeRange(rangeStart, i);
                        i = rangeStart;
                    } else if (!inDeletionRange && !matches) {
                        inDeletionRange = true;
                        rangeStart = i;
                    }
                }

                Iteration<A, Boolean> iteration = new IterationImpl<>(thisList.get(i), oldi);
                boolean matches = selector.test(iteration);
                if (inDeletionRange) {
                    thisList.removeRange(rangeStart, matches ? i : i + 1);
                } else if (!matches) {
                    thisList.remove(i);
                }
            } catch (BreakLoopException ex) {
                boolean matches = ex.isInitialized() && (Boolean) ex.getReturned().get();
                if (inDeletionRange) {
                    thisList.removeRange(rangeStart, thisList.size());
                } else {
                    thisList.removeRange(ex.getLastIteration().getIndex(), thisList.size());
                }
                if (matches) {
                    thisList.add((A) ex.getLastIteration().getValue());
                }
            }
        }

        static <A> void distinct(ArrayListQ<A> thisList, BiPredicate<A, A> equalTest) {
            for (int i = 1; i < thisList.size(); i++) {
                A item = thisList.get(i);
                for (int j = i - 1; j >= 0; j--) {
                    A previous = thisList.get(j);
                    if (equalTest.test(item, previous)) {
                        thisList.remove(i);
                        i--;
                        break;
                    }
                }
            }
        }

        static <A> void union(ArrayListQ<A> thisList, BiPredicate<A, A> equalTest, Collection<A> collection) {
            for (A item : collection) {
                if (!thisList.any(x -> equalTest.test(x, item))) {
                    thisList.add(item);
                }
            }
        }

        static <A> void insert(ArrayListQ<A> thisList, int index, Collection<A> collection) {
            thisList.addAll(index, collection);
        }
    }

    private static class NewListImplementation {

        static <A> ListQ<A> where(ArrayListQ<A> thisList, Predicate<A> selector) {
            ListQ<A> result = new ArrayListQ<>();
            for (A item : thisList) {
                if (selector.test(item)) {
                    result.add(item);
                }
            }
            return result;
        }

        static <A> ListQ<A> whereI(ArrayListQ<A> thisList, Predicate<Iteration<A, Boolean>> selector) {
            ArrayListQ<A> result = new ArrayListQ<>();
            try {
                for (int i = 0; i < thisList.size(); i++) {
                    A item = thisList.get(i);
                    Iteration<A, Boolean> iteration = new IterationImpl<>(item, i);
                    if (selector.test(iteration)) {
                        result.add(item);
                    }
                }
            } catch (BreakLoopException ex) {
                boolean matches = ex.isInitialized() && (Boolean) ex.getReturned().get();
                if (matches) {
                    result.add((A) ex.getLastIteration().getValue());
                }
            }
            return result;
        }

        static <A> ListQ<A> distinct(ArrayListQ<A> thisList, BiPredicate<A, A> equalTest) {
            ArrayListQ<A> result = new ArrayListQ<>();
            for (A item : thisList) {
                if (!result.any(x -> equalTest.test(x, item))) {
                    result.add(item);
                }
            }
            return result;
        }

        static <A> ListQ<A> union(ArrayListQ<A> thisList, BiPredicate<A, A> equalTest, Collection<A> collection) {
            ArrayListQ<A> result = new ArrayListQ<>(thisList);
            for (A item : collection) {
                if (!result.any(x -> equalTest.test(x, item))) {
                    result.add(item);
                }
            }
            return result;
        }

        static <A> ListQ<A> insert(ListQ<A> thisList, int index, Collection<A> collection) {
            ArrayListQ<A> result = new ArrayListQ<>(thisList.size() + collection.size());
            result.addAll(thisList);
            result.addAll(index, collection);
            return result;
        }
    }
}
