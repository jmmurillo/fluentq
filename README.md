# FluentQ

FluentQ is a library inspired by the ease of use of .Net LINQ to manipulate collections and the personal nuisance of using the powerful but ugly Stream java API. 

It mainly consists on an implementation of the `java.util.ArrayList<T>` class to which you can apply a generous set of fluent methods, such as:

 - aggregate
 - where
 - select
 - all/any
 - first/last/single
 - distinct
 - union/intersect
 - count
 - concat/insert
 - sum/max/min
 - groupBy/cluster
 - forEach
 - reverse/shuffle
 - take/skip
 - etc.

##Basic Usage

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
or the static constructors when the mapping requires some more effort, for example
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
###Inherited list operations
ArrayListQ is an extension of `java.util.ArrayList<T>` so all its methods are available (see [ArrayList documentation](http://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html))
```java
ArrayListQ<MyClass> fluent;
...
fluent.add(obj1); //Inherited, non-fluent
boolean removed = fluent.remove(obj2); //Inherited, non-fluent
```

###Basic queries
Once you have your fluent list you can perform some basic queries on it, for example
```java
ArrayListQ<MyClass> fluent;
...
Optional <MyField> value = fluent
   .where(x -> x.property != null) //Discard all elements with null property
   .select(x -> x.property.field) //Take a list of the fields
   .last(); //Take the last field, if it exists
```
or you can use some more advanced methods for more complex processing

```java
ArrayListQ<MyAlbums> fluent;
...
for(Map<Artist, ListQ<MyAbums>> group : fluent.groupBy(x -> x.artist))
TBC.
```

You can also apply some simple numerical aggregation methods to your lists, most of them give the option to calculate them as an integer (`long`) or as a floating point number (`double`)
```java
ArrayListQ<Integer> fluent;
...
OptionalLong max = fluent.maxAsLong();
OptionalLong min = fluent.minAsLong();
if(fluent.any())
	double mean = fluent.sumAsDouble() / fluent.count();
```

Many more methods are available, most of them should be intuitive and self-explained in their use, try experimenting with them.

###How fluent methods work
Unlike Stream or LINQ, **FluentQ is not lazily evaluated**. Instead it relies on another strategy to help resource economy: performing operations in-place without destroying the original data. This is achieved by differenctiating between **durable** and **ephemeral** collections. Collections you may want to track along your code should be *durable*, while temporary collections derived from queries can be *ephemeral*. The latest have the peculiarity that operations can "destroy" or overwrite their content and nobody would get hurt.
Let's show this whith an example:
```java
ArrayListQ<MyClass> fluent;
...
Optional <MyField> value = fluent //durable
   .distinct() //ephemeral
   .where(x -> x.property != null) //same ephemeral instance
   .select(x -> x.property.field) //new ephemeral
   .last(); //element
```
In the example, when `distinct()` is called, a copy of `fluent` is internally made to preserve the original list intact. From then on, chained calls will modify that same copy (*in-place*) to save some resources. When `select(...)` is called a new ephemeral instance is returned, as it may contain elements of other class or type (`MyField` objects in the example). Finally `last()` is called and a single element is returned.

Sometimes you may want to make an *ephemeral* list *durable*, for which you can call `hold()`, which performs with (virtually) zero cost.
```java
ArrayListQ<MyClass> fluent;
...
ListQ<MyField> fields = fluent //durable
   .select(x -> x.property.field) //new ephemeral
   .hold(); //durable
```

Finally, you can force durable lists to operate on themselves (modifying their content!) by calling the versions of the metods suffixed by "-self"

 -  whereSelf
 - concatSelf
 - distinctSelf
 - orderSelf
 - etc.

For example:
```java
ArrayListQ<MyClass> fluent;
...
fluent //durable
   .distinctSelf() //same durable (modified)
   .whereSelf(x -> x.property != null); //same durable (modified)
```

##Advanced features
###Accessing elements indices
Sometimes it can be useful to know the index of the element you are processing. A possible solution for this can be to manipulate element-index pairs, which can be done by the following code:
```java
ArrayListQ<MyClass> fluent;
...
ListQ<Iteration<MyClass, ?>> iterations = fluent.toIterations();
...
Iteration<MyClass, ?> lastIteration = iterations.last().get();
int lastIndex = lastIteration.getIndex();
MyClass lastValue = lastIteration.getValue();
```
However there is an easier way of manipulating indexes. Many of the methods provide a variant suffixed with an "-I" (for *Iteration*), for instance

 - forEachI
 - whereI
 - selectI
 - groupByI
 - etc.

These methods provide as a parameter an *Iteration* object, from which the receiver can tell the element (`iteration.getValue()`) and its index (`iteration.getIndex()`). For example
```java
ArrayListQ<MyClass> fluent;
...
//Iterate over elements with a pair index
for(MyClass element : fluent.whereI(x -> x.getIndex()%2 == 0))
...
```
TBC.
###Interrupting queries
TBC.
###Fluent API extension

TBC.

