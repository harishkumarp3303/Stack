An immutable object in Java is an object whose state (i.e., its instance variables) cannot be modified after the object is created. Once an immutable object is created, its internal values remain constant throughout its lifetime. This property ensures that the object's integrity is maintained and prevents unintended changes to its data.

Here's an example of an immutable class called `ImmutablePerson`:

```java
final class ImmutablePerson {
    private final String name;
    private final int age;

    public ImmutablePerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
```

Explanation of the `ImmutablePerson` class:

1. The `ImmutablePerson` class is marked as `final`, which prevents it from being subclassed.
2. The class has two private instance variables: `name` and `age`.
3. The constructor initializes these instance variables, and once they are set, they cannot be modified.
4. The class provides only getter methods (`getName()` and `getAge()`) to access the values of its fields. It does not provide any setter methods, so external code cannot modify the object's state.

Example usage:

```java
public class ImmutableExample {
    public static void main(String[] args) {
        ImmutablePerson person = new ImmutablePerson("Alice", 30);

        // Accessing object's fields
        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());

        // Attempting to modify the object's state (which is not possible)
        // This will result in a compilation error
        // person.setName("Bob");
        // person.setAge(25);
    }
}
```

In this example, the `ImmutablePerson` class demonstrates immutability by not allowing any changes to its internal state after an object is created. Once the `ImmutablePerson` object is instantiated, its `name` and `age` fields cannot be modified. This ensures that the object's data remains consistent and cannot be accidentally or intentionally altered.

Immutability is valuable for creating objects that are safe to share across multiple threads, are easy to reason about, and can be used in various situations without fear of unintended side effects.