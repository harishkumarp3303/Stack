The Java Stream API provides a rich set of methods that allow you to perform various operations on streams. Here's a comprehensive list of the main methods available in the Java Stream API:

# Intermediate Operations:

1. filter(Predicate<T> predicate): Returns a stream that includes only elements matching the given predicate.

2. map(Function<T, R> mapper): Transforms each element in the stream using the given function.

3. flatMap(Function<T, Stream<R>> mapper): Transforms each element and flattens the resulting streams into a single stream.
4. distinct(): Returns a stream with distinct elements (based on their equals() method).
5. sorted(): Sorts the elements in natural order (requires elements to be comparable).
6. sorted(Comparator<T> comparator): Sorts the elements using the specified comparator.
7. peek(Consumer<T> action): Performs the specified action on each element, returning the same stream.


# Terminal Operations:

1. forEach(Consumer<T> action): Applies the given action to each element in the stream.
2. collect(Collector<T, A, R> collector): Collects the 3. elements into a collection using the provided collector.
3. toArray(): Converts the stream to an array.
4. reduce(BinaryOperator<T> accumulator): Performs a reduction on the elements using the provided binary operator.
5. reduce(T identity, BinaryOperator<T> accumulator): Performs a reduction using the identity and the binary operator.


7. min(Comparator<T> comparator): Returns the minimum element according to the specified comparator.
8. max(Comparator<T> comparator): Returns the maximum element according to the specified comparator.
9. count(): Returns the number of elements in the stream.
10. anyMatch(Predicate<T> predicate): Returns true if any elements match the given predicate.
11. allMatch(Predicate<T> predicate): Returns true if all elements match the given predicate.
12. noneMatch(Predicate<T> predicate): Returns true if no elements match the given predicate.
13. findFirst(): Returns the first element in the stream.
14. findAny(): Returns any element in the stream.
Short-circuiting Operations:

limit(long maxSize): Limits the stream to a fixed-size.
skip(long n): Skips the first 'n' elements in the stream.
These are the main methods available in the Java Stream API. Utilizing these methods effectively allows you to perform powerful data processing and manipulation operations in a functional and declarative style.
