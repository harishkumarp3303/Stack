# Lambda expressions

Lambda expressions, introduced in Java 8, are a concise way to express instances of single-method interfaces (also known as functional interfaces). A lambda expression can be thought of as a compact representation of an anonymous function that can be passed around and used as data.

Here's the basic syntax of a lambda expression:

```java
(parameters) -> expression
```

Lambda expressions can be used wherever functional interfaces are expected, such as in places where an interface with a single abstract method (SAM) is required. Common use cases include passing behavior as an argument to a method, implementing callbacks, and simplifying code.

Here's an example that shows the use of lambda expressions to define a comparator for sorting strings:

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdaExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        // Using a lambda expression to define a comparator
        Collections.sort(names, (a, b) -> a.compareTo(b));

        // Printing the sorted names
        for (String name : names) {
            System.out.println(name);
        }
    }
}
```


# Functional interface

In Java 8, a functional interface is an interface that has exactly one abstract method. Functional interfaces are also known as "SAM interfaces" (Single Abstract Method interfaces) or "lambda interfaces." They play a crucial role in enabling the use of lambda expressions, method references, and functional programming features introduced in Java 8.

Functional interfaces serve as the basis for lambda expressions because a lambda expression can be used to implement the abstract method of a functional interface. This allows you to write more concise and expressive code when dealing with simple tasks that involve passing behavior as an argument.

Here are some key points about functional interfaces:

1. **Single Abstract Method (SAM):** A functional interface must have only one abstract method. It can still have default methods, static methods, and methods inherited from `Object`.

2. **@FunctionalInterface Annotation:** While it's not mandatory to use the `@FunctionalInterface` annotation for a functional interface, it's a good practice to use it to ensure that the interface has only one abstract method. The Java compiler will generate an error if you try to mark an interface as `@FunctionalInterface` but it has more than one abstract method.

3. **Common Functional Interfaces in Java 8:** Java 8 introduced several built-in functional interfaces in the `java.util.function` package, such as `Function`, `Predicate`, `Consumer`, `Supplier`, `UnaryOperator`, and `BinaryOperator`.

Here's an example of a functional interface:

```java
@FunctionalInterface
interface MyFunctionalInterface {
    void doSomething();
}
```

With functional interfaces, you can use lambda expressions or method references to provide implementations:

```java
public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        // Using a lambda expression
        MyFunctionalInterface lambda = () -> System.out.println("Lambda expression");

        // Using a method reference
        MyFunctionalInterface methodRef = FunctionalInterfaceExample::printMessage;

        lambda.doSomething();   // Output: Lambda expression
        methodRef.doSomething(); // Output: Method reference
    }

    static void printMessage() {
        System.out.println("Method reference");
    }
}
```

In this example, `MyFunctionalInterface` is a functional interface with a single abstract method `doSomething()`. You can create instances of this interface using both lambda expressions and method references.

Functional interfaces play a crucial role in modern Java programming, facilitating the use of functional programming concepts and enabling more expressive and concise code.

# Static and default interfaces

In Java 8, default methods and static methods were introduced to enhance the functionality of interfaces without breaking backward compatibility. These features allow you to add new methods to interfaces without requiring all implementing classes to provide implementations for these methods.

1. **Default Methods:**
   A default method is a method defined within an interface that provides a default implementation. If a class implements the interface and does not provide its own implementation for the default method, it will automatically inherit and use the default implementation defined in the interface.

   ```java
   interface MyInterface {
       default void myDefaultMethod() {
           System.out.println("Default implementation");
       }
   }
   ```

   Default methods are useful for adding new methods to existing interfaces without forcing all implementing classes to provide implementations for these new methods.

2. **Static Methods:**
   A static method within an interface is a method that belongs to the interface itself rather than any specific instance of a class implementing the interface. These methods can be invoked using the interface name itself, without the need for an instance of a class that implements the interface.

   ```java
   interface MyInterface {
       static void myStaticMethod() {
           System.out.println("Static method");
       }
   }
   ```

   Static methods within interfaces are used to provide utility methods or factory methods related to the interface.

Here's an example that demonstrates the use of default and static methods in interfaces:

```java
interface MyInterface {
    default void defaultMethod() {
        System.out.println("Default method implementation");
    }

    static void staticMethod() {
        System.out.println("Static method implementation");
    }
}

class MyClass implements MyInterface {
    // No need to provide an implementation for defaultMethod or staticMethod
}

public class DefaultAndStaticMethodsExample {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.defaultMethod();  // Output: Default method implementation

        MyInterface.staticMethod();  // Output: Static method implementation
    }
}
```

In this example, `MyInterface` defines a default method `defaultMethod` and a static method `staticMethod`. The `MyClass` class implements `MyInterface` but doesn't provide its own implementations for these methods. Default methods are automatically inherited, and static methods are accessed using the interface name itself.

Default and static methods in Java 8 allow for more flexible and extensible interfaces while maintaining backward compatibility with existing implementing classes.

# Optional class

The `Optional` class in Java is a container class introduced in Java 8 to handle situations where a value might be absent. It provides a more expressive and safer way to deal with null values, reducing the risk of null pointer exceptions and improving code readability.

Prior to Java 8, when a method could potentially return a null value, developers were required to explicitly check for null values before using the result. This could lead to verbose and error-prone code. The `Optional` class addresses this issue by providing a way to wrap a value that might be absent and offers methods to handle both the presence and absence of the value.

Key features of the `Optional` class:

1. **Null Safety:** `Optional` helps avoid null pointer exceptions by allowing you to explicitly check if a value is present or not.

2. **Expressive API:** `Optional` provides a set of methods that make code more readable when dealing with optional values, such as `orElse`, `orElseGet`, `orElseThrow`, etc.

3. **Encourages Defensive Programming:** By explicitly handling the absence of values, `Optional` encourages developers to consider and handle scenarios where a value might not be available.

4. **Avoids Explicit null Checks:** You can chain methods on `Optional` without the need for explicit null checks at each step.

Here's a simple example of how you might use `Optional`:

```java
import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        String value = "Hello, Optional!";

        Optional<String> optionalValue = Optional.ofNullable(value);

        if (optionalValue.isPresent()) {
            System.out.println("Value is present: " + optionalValue.get());
        } else {
            System.out.println("Value is absent.");
        }
    }
}
```

In this example, `Optional.ofNullable(value)` creates an `Optional` instance containing the value if it's not null, or an empty `Optional` if the value is null. The `isPresent()` method checks if the value is present, and `get()` retrieves the value if it's present.

You can also use various methods provided by `Optional` to handle values more effectively:

```java
Optional<String> optionalValue = Optional.ofNullable(value);

String result = optionalValue.orElse("Default Value");
// or
String result = optionalValue.orElseGet(() -> "Default Value");
// or
String result = optionalValue.orElseThrow(() -> new IllegalArgumentException("Value not present"));
```

Keep in mind that `Optional` is not meant to replace all null checks. It should be used selectively for cases where a value might be absent. Overuse of `Optional` can lead to unnecessary complexity in code.

# Stream API



