# FluentQ

FluentQ is a library inspired by the ease of use of .Net LINQ to manipulate collections and the personal nuisance of using the powerful but ugly Stream java API. 

The current version consists on an implementation of the java.util.ArrayList<T> class to which you can apply a generous set of fluent methods, such as:
    * aggregate
	* where
	* select
	* all/any
	* first/last
	* distinct
	* union/intersect
	* count
	* concat/insert
	* sum/max/min
	* groupBy/cluster
	* forEach
	* reverse/shuffle
	* take/skip
	* etc.
	
##Usage

The main focus on this development is the ease of use. Let's see some basic usage examples.

###Creation
To create a new fluent list you can use
```java
ArrayListQ<String> fluent = new ArrayListQ<>("some", "initial", "values");
```

You can also wrap an existent collection to manipulate it more easily, using the available constructors, for example
```java
MyClass[] array;
Set<MyClass> set;
Stream<MyClass> stream;
Iterator<MyClass> iterator;
...
ArrayListQ<MyClass> fluent1 = new ArrayListQ<>(array);
ArrayListQ<MyClass> fluent2 = new ArrayListQ<>(set);
ArrayListQ<MyClass> fluent3 = new ArrayListQ<>(stream);
ArrayListQ<MyClass> fluent4 = new ArrayListQ<>(iterator);
...
```
or the static constructors when the mapping requires some more mapping effort, for example
```java
byte[] array;
int[][] array2D;
Map<String, MyClass> map;
...
ArrayListQ<Byte> fluent1 = ArrayListQ.of(array);
ArrayListQ<ListQ<Integer>> fluent2 = ArrayListQ.ofLists(array2D);
ArrayListQ<Map.Entry<String, MyClass>> fluent3 = ArrayListQ.ofEntries(map);
...
```

For a more advanced way of creating an ArrayListQ you can use the static 'generate' method, see Advanced features below.
```java
int maxIterations;
...
ArrayListQ<MyClass> fluent = ArrayListQ.generate(SomeClass::buildMyClassInstance);
...
```

###Basic queries
Once you have your fluent list you can perform some queries on it, for example
```java
ArrayListQ<MyClass> fluent;
...
Optional <MyField> value = fluent
                           .where(x -> x.property != null)
                           .select(x -> x.property.field)
                           .last();
```

We can also apply some simple numerical aggregation methods to our lists
```java
ArrayListQ<Long> fluent;
...
OptionalLong max = fluent.maxAsLong();
OptionalLong min = fluent.minAsLong();
if(fluent.any())
	double mean = fluent.sumAsDouble() / fluent.count();
```

Many more methods are available, most of them should be intuitive and self-explained in their use, try experimenting with them.

##Advanced features
###Indexed and interruptable queries
Sometime it can be useful to know the index of the element you are processing. A possible solution for this can be to manipulate element-index pairs, which can be easily done by the following code:
```java
ArrayListQ<MyClass> fluent;
...
ListQ<Iteration<MyClass, ?>> iterations = fluent.toIterations();
...
Iteration<MyClass, ?> lastIteration = iterations.last().get();
int lastIndex = lastIteration.getIndex();
MyClass lastValue = lastIteration.getValue();
```
However there is an easier way of manipulating indexes: using the methods suffixed with an -I provides Iteration objects to the inner code.

TBC.

###Fluent API extension

TBC.
