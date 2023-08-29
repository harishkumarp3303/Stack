## 1. Singleton

A singleton class in Java is a design pattern that restricts the instantiation of a class to only one instance and provides a global point of access to that instance. This pattern ensures that there is only one instance of the class throughout the application's lifecycle and provides a way to access that instance from any part of the code.

The singleton pattern is useful in scenarios where you want to ensure that a class has a single instance responsible for managing a shared resource or functionality, such as a configuration manager, a thread pool, a database connection pool, or a cache.

Here's an example of implementing a singleton class in Java:

```java
public class Singleton {
    // Private static instance variable
    private static Singleton instance;

    // Private constructor to prevent direct instantiation
    private Singleton() {
        // Initialization code, if any
    }

    // Public static method to provide access to the single instance
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    // Other methods and attributes of the singleton class
    public void printMessage() {
        System.out.println("Hello from Singleton!");
    }
}

public class SingletonExample {
    public static void main(String[] args) {
        // Get the singleton instance
        Singleton singletonInstance1 = Singleton.getInstance();
        Singleton singletonInstance2 = Singleton.getInstance();

        // Check if both instances are the same
        System.out.println(singletonInstance1 == singletonInstance2); // Output: true

        // Call a method on the singleton instance
        singletonInstance1.printMessage(); // Output: Hello from Singleton!
    }
}
```

In this example:

- The `Singleton` class has a private static instance variable `instance`, which holds the single instance of the class.
- The constructor of the `Singleton` class is made private to prevent direct instantiation from outside the class.
- The `getInstance()` method is a public static method that provides access to the single instance of the class. It initializes the instance if it's null, otherwise, it returns the existing instance.
- The `SingletonExample` class demonstrates how to obtain the singleton instance and call methods on it.

It's important to note that the above implementation of the singleton pattern is not thread-safe. If multiple threads attempt to access the `getInstance()` method simultaneously, they might create multiple instances of the singleton class. To make the singleton pattern thread-safe, you can use synchronization mechanisms like double-checked locking or initialize the instance using a static inner class.

```java
public class ThreadSafeSingleton {
    private static class Holder {
        private static final ThreadSafeSingleton INSTANCE = new ThreadSafeSingleton();
    }

    public static ThreadSafeSingleton getInstance() {
        return Holder.INSTANCE;
    }

    // Rest of the singleton class implementation
}
```

Using the singleton pattern provides a clean and organized way to manage shared resources and ensures that there is only one instance of a class throughout the application.

## 2. Prototype

## 3. Factory

The Factory Design Pattern is a creational pattern that provides an interface for creating objects in a super class but allows subclasses to alter the type of objects that will be created. This pattern is useful when you have a super class with multiple sub classes and you want to delegate the responsibility of object creation to the sub classes.

In Java, the Factory pattern is implemented using an interface or an abstract class that defines a method for creating objects. Each concrete sub class of the factory class provides its own implementation of the creation method. This allows clients to use the factory's method to create objects without being concerned about the specific class of objects being created.

Here's an example of the Factory pattern in Java:

```java
interface Shape {
    void draw();
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }
}

class ShapeFactory {
    public Shape createShape(String type) {
        if ("circle".equalsIgnoreCase(type)) {
            return new Circle();
        } else if ("rectangle".equalsIgnoreCase(type)) {
            return new Rectangle();
        } else {
            throw new IllegalArgumentException("Unsupported shape type");
        }
    }
}

public class FactoryExample {
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();

        Shape circle = factory.createShape("circle");
        circle.draw(); // Output: Drawing a Circle

        Shape rectangle = factory.createShape("rectangle");
        rectangle.draw(); // Output: Drawing a Rectangle
    }
}
```

In this example:

- The `Shape` interface defines a common method `draw()` that concrete shapes must implement.
- The `Circle` and `Rectangle` classes are concrete implementations of the `Shape` interface.
- The `ShapeFactory` class provides a method `createShape()` that takes a shape type as an argument and returns a corresponding concrete shape object.
- The `FactoryExample` class demonstrates how to use the factory to create shape objects without directly interacting with their concrete implementations.

The Factory pattern promotes loose coupling between the client code and the concrete classes being instantiated. If new types of shapes are added in the future, you only need to modify the factory class without affecting the rest of the code. This pattern is particularly useful in scenarios where you want to centralize object creation logic and encapsulate it from the client code.

## 4. Adaptor

## 5. 

