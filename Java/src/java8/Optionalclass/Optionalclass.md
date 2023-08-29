`Optional` is a class introduced in Java 8 to handle the problem of representing nullable values in a safer and more expressive way. It's designed to avoid `NullPointerException` errors that can occur when attempting to access methods or properties of a null object. `Optional` is a container class that may or may not contain a non-null value.

Here's a detailed explanation of how `Optional` works with examples:

```java
import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        // Creating an Optional with a non-null value
        Optional<String> nonNullOptional = Optional.of("Hello, Optional!");
        System.out.println(nonNullOptional.isPresent()); // Output: true
        System.out.println(nonNullOptional.get());       // Output: Hello, Optional!

        // Creating an empty Optional
        Optional<String> emptyOptional = Optional.empty();
        System.out.println(emptyOptional.isPresent());   // Output: false

        // Creating an Optional that may or may not contain a value
        String text = null;
        Optional<String> optionalWithNullableValue = Optional.ofNullable(text);
        System.out.println(optionalWithNullableValue.isPresent()); // Output: false

        // Using ifPresent to perform an action if a value is present
        nonNullOptional.ifPresent(value -> System.out.println("Value: " + value));

        // Using orElse to provide a default value if no value is present
        String result1 = emptyOptional.orElse("Default Value");
        System.out.println(result1); // Output: Default Value

        // Using orElseGet with a Supplier to provide a default value
        String result2 = emptyOptional.orElseGet(() -> "Default Value from Supplier");
        System.out.println(result2); // Output: Default Value from Supplier

        // Using orElseThrow to throw an exception if no value is present
        try {
            emptyOptional.orElseThrow(() -> new IllegalArgumentException("No value present"));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Output: No value present
        }

        // Using map to transform the value if it's present
        Optional<Integer> mappedOptional = nonNullOptional.map(s -> s.length());
        System.out.println(mappedOptional.orElse(0)); // Output: 16 (length of "Hello, Optional!")

        // Using filter to conditionally transform the value
        Optional<String> filteredOptional = nonNullOptional.filter(s -> s.length() > 10);
        System.out.println(filteredOptional.orElse("No value matching the condition")); // Output: Hello, Optional!
    }
}
```

In this example, we've demonstrated various aspects of `Optional`:

- Creating `Optional` instances with non-null values, nullable values, and empty values.
- Using methods like `isPresent()`, `get()`, `ifPresent()`, `orElse()`, `orElseGet()`, and `orElseThrow()` to handle different scenarios.
- Using `map()` to transform the value inside the `Optional` and applying a condition with `filter()`.

`Optional` encourages a more explicit handling of nullable values, making your code safer and less prone to unexpected null pointer exceptions. However, it's essential to use `Optional` judiciously and not to overuse it, as it might introduce unnecessary complexity in some cases.