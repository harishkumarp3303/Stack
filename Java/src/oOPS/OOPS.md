## Encapsulation

Encapsulation is one of the four fundamental concepts of object-oriented programming (OOP), along with inheritance, abstraction, and polymorphism. It refers to the practice of bundling data (attributes) and methods (functions) that operate on the data into a single unit called a class. Encapsulation restricts direct access to the internal state of an object and provides controlled access through methods, ensuring data integrity and promoting modularity.

Here's an example of encapsulation in Java:

```java
public class Student {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Invalid name.");
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 0 && age <= 120) {
            this.age = age;
        } else {
            System.out.println("Invalid age.");
        }
    }
}
```

In this example, the `Student` class encapsulates the data (name and age) and provides methods to access and modify the data. The attributes are marked as `private` to prevent direct access from outside the class. Instead, the methods (`getName`, `setName`, `getAge`, and `setAge`) control the access and modification of the attributes.

Here's how encapsulation benefits this code:

1. **Data Integrity:** By providing controlled methods to set attributes (`setName`, `setAge`), we can enforce validation rules. This ensures that only valid data is stored.

2. **Abstraction:** Encapsulation hides the internal implementation details of the class. Other parts of the program can interact with the class using its methods without needing to know how the data is managed.

3. **Flexibility:** If the implementation of the class needs to change in the future (e.g., additional validation or logging), you can do so without affecting other parts of the code that use the class.

4. **Modularity:** Encapsulation allows the class to be treated as a self-contained unit. This promotes code organization and simplifies maintenance.

Usage of the `Student` class:

```java
public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Alice");
        student.setAge(20);

        System.out.println("Name: " + student.getName());
        System.out.println("Age: " + student.getAge());

        student.setName("");
        student.setAge(150);
    }
}
```

By encapsulating the data and providing controlled methods, you ensure that the state of the `Student` object remains consistent and valid, even when interacting with it from different parts of your program.

## Abstraction

Abstraction is a fundamental concept in object-oriented programming that allows you to represent complex real-world entities as simplified models in your code. It focuses on capturing the essential characteristics of an object while hiding unnecessary details. Abstraction helps you manage complexity, create more modular code, and create a higher level of understanding.

In Java, abstraction is implemented using abstract classes and interfaces. An abstract class cannot be instantiated directly; it serves as a blueprint for creating concrete classes. An interface is a contract that defines a set of methods that implementing classes must provide.

Here's an example of abstraction using both abstract classes and interfaces in Java:

```java
// Abstract class
abstract class Shape {
    abstract double calculateArea();
    abstract double calculatePerimeter();
}

// Concrete classes
class Circle extends Shape {
    private double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}

class Rectangle extends Shape {
    private double length;
    private double width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double calculateArea() {
        return length * width;
    }

    @Override
    double calculatePerimeter() {
        return 2 * (length + width);
    }
}

// Interface
interface Sound {
    void makeSound();
}

// Concrete classes implementing the interface
class Dog implements Sound {
    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }
}

class Cat implements Sound {
    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }
}
```

In this example, `Shape` is an abstract class that defines the common methods `calculateArea` and `calculatePerimeter`. The concrete classes `Circle` and `Rectangle` extend `Shape` and provide their own implementations of these methods.

The `Sound` interface defines the method `makeSound`. The classes `Dog` and `Cat` implement the `Sound` interface by providing their own implementations of `makeSound`.

By using abstraction, you can create a hierarchy of classes and interfaces that represent real-world entities and behaviors in a clean and organized way. You can work with higher-level concepts without worrying about low-level implementation details.

## Constructor types

In Java, constructors are used to create and initialize objects. There are several types of constructors, each serving a specific purpose. Let's explore the different types of constructors with examples:

1. **Default Constructor:**
A default constructor is one that doesn't take any parameters. If you don't provide any constructors in your class, Java automatically generates a default constructor.

```java
public class Person {
    private String name;

    // Default constructor (implicitly generated if not provided)
    public Person() {
        name = "Unknown";
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        Person person = new Person(); // Using the default constructor
        System.out.println(person.getName()); // Output: Unknown
    }
}
```

2. **Parameterized Constructor:**
A parameterized constructor accepts one or more parameters that are used to initialize instance variables.

```java
public class Employee {
    private String name;
    private int employeeId;

    // Parameterized constructor
    public Employee(String name, int employeeId) {
        this.name = name;
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public static void main(String[] args) {
        Employee employee = new Employee("Alice", 123);
        System.out.println("Name: " + employee.getName());
        System.out.println("Employee ID: " + employee.getEmployeeId());
    }
}
```

3. **Copy Constructor:**
A copy constructor creates a new object by copying the values from an existing object of the same type. This is useful for creating a duplicate object with the same state.

```java
public class Address {
    private String street;
    private String city;

    // Copy constructor
    public Address(Address other) {
        this.street = other.street;
        this.city = other.city;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public static void main(String[] args) {
        Address original = new Address();
        original.street = "123 Main St";
        original.city = "Cityville";

        Address copy = new Address(original); // Using the copy constructor

        System.out.println("Copy Street: " + copy.getStreet());
        System.out.println("Copy City: " + copy.getCity());
    }
}
```

4. **Chained Constructors:**
Chained constructors allow one constructor to call another constructor from the same class using the `this()` keyword. This is useful for reusing common initialization code.

```java
public class Book {
    private String title;
    private String author;

    public Book(String title) {
        this(title, "Unknown");
    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public static void main(String[] args) {
        Book book1 = new Book("Java Programming"); // Using the first constructor
        System.out.println("Title: " + book1.getTitle());
        System.out.println("Author: " + book1.getAuthor());

        Book book2 = new Book("Python Programming", "Alice Smith"); // Using the second constructor
        System.out.println("Title: " + book2.getTitle());
        System.out.println("Author: " + book2.getAuthor());
    }
}
```

These are some of the common types of constructors in Java. Constructors play a crucial role in object creation and initialization, allowing you to customize objects based on your application's requirements.

# Keywords

### abstract

The `abstract` keyword in Java is used to declare abstract classes and abstract methods. Abstract classes are classes that cannot be instantiated directly and are meant to serve as base classes for other classes. Abstract methods are methods declared in an abstract class that don't have a method body and are meant to be implemented by subclasses.

Here are the key rules and concepts related to the `abstract` keyword:

1. **Abstract Classes:**
   - Abstract classes cannot be instantiated directly using the `new` keyword.
   - Abstract classes are meant to be extended by other classes, which provide concrete implementations for the abstract methods.

2. **Abstract Methods:**
   - Abstract methods are methods declared in an abstract class without a method body.
   - Subclasses of an abstract class must provide implementations for all inherited abstract methods.
   - Abstract methods in an interface are implicitly `abstract` and don't require the `abstract` keyword.

3. **Use of `abstract` Keyword:**
   - The `abstract` keyword is used to declare an abstract class or an abstract method.
   - An abstract class may have both abstract and non-abstract methods.
   - A class cannot be both `abstract` and `final`. An abstract class is meant to be extended, while a `final` class cannot be subclassed.

4. **Inheritance and Abstract Classes:**
   - Subclasses of an abstract class must either provide implementations for all inherited abstract methods or be declared as abstract themselves.
   - A concrete subclass (non-abstract subclass) of an abstract class must implement all inherited abstract methods to become a concrete class itself.

5. **Abstract Classes vs. Interfaces:**
   - Abstract classes can have fields (attributes) with initial values and non-abstract methods with implementations.
   - A class can extend only one abstract class, but it can implement multiple interfaces.
   - Interfaces can't have instance variables with initial values or method implementations until Java 8.

Here's an example illustrating the use of the `abstract` keyword:

```java
// Abstract class
abstract class Shape {
    abstract double calculateArea(); // Abstract method
    abstract double calculatePerimeter(); // Abstract method

    void displayInfo() {
        System.out.println("Area: " + calculateArea());
        System.out.println("Perimeter: " + calculatePerimeter());
    }
}

// Concrete subclasses
class Circle extends Shape {
    private double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}

class Rectangle extends Shape {
    private double length;
    private double width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double calculateArea() {
        return length * width;
    }

    @Override
    double calculatePerimeter() {
        return 2 * (length + width);
    }
}

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        circle.displayInfo();

        Rectangle rectangle = new Rectangle(4, 6);
        rectangle.displayInfo();
    }
}
```

In this example, the `Shape` class is abstract and defines two abstract methods `calculateArea` and `calculatePerimeter`. The concrete subclasses `Circle` and `Rectangle` provide implementations for these methods. The `displayInfo` method in the `Shape` class demonstrates the use of abstract methods in non-abstract methods.

### static keyword

The `static` keyword in Java is used to declare class-level members (variables and methods) that belong to the class itself rather than to instances of the class. Class-level members are shared among all instances of the class and can be accessed using the class name.

Here are the key rules and concepts related to the `static` keyword:

1. **Static Variables (Class Variables):**
   - A static variable is associated with the class itself rather than with instances of the class.
   - All instances of the class share the same copy of the static variable.
   - Static variables are created when the class is loaded and destroyed when the class is unloaded.
   - Static variables are often used for constants or for data that needs to be shared among all instances of the class.

2. **Static Methods:**
   - A static method belongs to the class rather than to instances of the class.
   - Static methods can only access other static members (variables or methods) of the class.
   - Static methods are called using the class name, not through instances of the class.
   - Common use cases for static methods include utility methods and factory methods.

3. **Static Blocks:**
   - A static block is a block of code enclosed within `static { ... }`.
   - Static blocks are executed when the class is loaded into memory, typically before any static variables or methods are accessed.
   - Static blocks are useful for initializing static variables or performing one-time setup operations for the class.

4. **Accessing Static Members:**
   - Static members can be accessed using the class name, followed by the dot operator (`ClassName.staticMember`).
   - Static members can also be accessed using an instance of the class, but this is not recommended because it might give the impression that the member is instance-specific.

5. **Static Members and Inheritance:**
   - Static members are not overridden in subclasses. Each class maintains its own copy of static members.
   - However, if a subclass defines a static member with the same name, it will hide the static member of the superclass.

Here's an example illustrating the use of the `static` keyword:

```java
class MathUtils {
    // Static variable
    static final double PI = 3.141592653589793;

    // Static method
    static int multiply(int a, int b) {
        return a * b;
    }

    // Static block
    static {
        System.out.println("MathUtils class loaded.");
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Value of PI: " + MathUtils.PI);
        System.out.println("Product: " + MathUtils.multiply(5, 10));
    }
}
```

In this example, the `MathUtils` class defines a static variable `PI`, a static method `multiply`, and a static block. The `Main` class accesses these static members using the class name. The static block is executed when the `MathUtils` class is loaded into memory.

## final keyword

In Java, the `final` keyword is used to indicate that a variable, method, class, or instance variable cannot be changed or overridden after it has been assigned or defined. The `final` keyword enforces immutability, prevents modification, and provides a level of security and predictability in your code. Here are the different ways `final` can be used:

1. **Final Variables:**
   - A final variable is a constant that cannot be reassigned once initialized.
   - It must be assigned a value either during declaration or within the constructor of the class.
   - Typically, final variables are written in uppercase with underscores to separate words.

```java
public class Constants {
    public static final int MAX_VALUE = 100;
    public static final String DEFAULT_NAME = "John";
}
```

2. **Final Methods:**
   - A final method in a class cannot be overridden by subclasses.
   - It's useful when you want to ensure that a specific behavior is not changed in subclasses.

```java
public class Parent {
    public final void doSomething() {
        // Implementation
    }
}

public class Child extends Parent {
    // This would be an error: cannot override final method
    // public void doSomething() { ... }
}
```

3. **Final Classes:**
   - A final class cannot be subclassed.
   - It's often used to prevent further extension of utility classes or classes that should not be modified or overridden.

```java
final class UtilityClass {
    // Class implementation
}
```

4. **Final Instance Variables:**
   - A final instance variable must be assigned a value when the object is constructed and cannot be modified afterward.
   - It ensures that the variable's value remains constant for the lifetime of the object.

```java
public class ImmutablePerson {
    private final String name;

    public ImmutablePerson(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
```

5. **Final Arguments:**
   - A final argument in a method parameter list cannot be modified within the method.
   - It's often used when you want to ensure that the value of the argument remains constant.

```java
public class MathOperations {
    public int add(final int a, final int b) {
        // Cannot modify the values of a and b here
        return a + b;
    }
}
```

Using the `final` keyword helps make your code more robust, maintainable, and less prone to unexpected changes or errors. It's especially useful for constants, ensuring that important values remain consistent and predictable throughout your codebase.

### this keyword

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name; // Use 'this' to refer to the instance variable
        this.age = age;   // Use 'this' to refer to the instance variable
    }

    public void printDetails() {
        System.out.println("Name: " + this.name); // Use 'this' to refer to the instance variable
        System.out.println("Age: " + this.age);   // Use 'this' to refer to the instance variable
    }

    public void changeName(String newName) {
        this.name = newName; // Use 'this' to refer to the instance variable
    }

    public static void main(String[] args) {
        Person person = new Person("Alice", 25);
        person.printDetails(); // Output: Name: Alice, Age: 25

        person.changeName("Eve");
        person.printDetails(); // Output: Name: Eve, Age: 25
    }
}

### super keyword

The `super` keyword in Java is used to refer to the superclass of the current class. It is used to access superclass members (variables, methods, constructors) from a subclass. The `super` keyword is especially useful when dealing with method overriding and constructor chaining. Let's explore the `super` keyword with an example and the key rules associated with its usage:

```java
class Animal {
    protected String type;

    public Animal(String type) {
        this.type = type;
    }

    public void makeSound() {
        System.out.println("Animal makes a sound.");
    }
}

class Dog extends Animal {
    public Dog(String type) {
        super(type); // Call the superclass constructor using 'super'
    }

    public void makeSound() {
        super.makeSound(); // Call the superclass method using 'super'
        System.out.println("Dog barks.");
    }

    public void displayInfo() {
        System.out.println("Type: " + super.type); // Access superclass variable using 'super'
    }
}

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Mammal");
        dog.displayInfo(); // Output: Type: Mammal
        dog.makeSound();   // Output: Animal makes a sound. Dog barks.
    }
}
```

Here are the key rules and concepts related to using the `super` keyword:

1. **Accessing Superclass Members:**
   - The `super` keyword is used to access members (variables, methods, constructors) of the superclass.
   - It can be used in instance methods and constructors of the subclass.

2. **Constructor Chaining:**
   - The `super()` constructor call is used to call a constructor of the superclass from the constructor of the subclass.
   - It must be the first statement in the constructor, and if not explicitly called, the default parameterless constructor of the superclass is invoked.

3. **Method Overriding:**
   - The `super` keyword is used in a subclass to explicitly call the overridden method in the superclass.

4. **Accessing Superclass Variables:**
   - The `super` keyword can be used to access the superclass's instance variables from a subclass.

5. **`this` vs `super`:**
   - `this` refers to the current instance of the class, while `super` refers to the superclass.
   - `this` is used to resolve conflicts between instance variables and method parameters, while `super` accesses superclass members.

6. **Nested Classes:**
   - If a subclass contains an inner or nested class, using `super` within the inner class refers to the outer class instance, not the superclass.

Using the `super` keyword allows you to work with superclass members and handle method overrides and constructors more effectively in your Java code.

### Aggregation,composition and association 

In object-oriented programming and design, aggregation, association, and composition are concepts used to describe the relationships between different classes or objects. These relationships help define how objects interact and collaborate within a system.

1. **Composition:**
   Composition is a strong form of aggregation where the "whole" class is responsible for the lifecycle of its "parts." In composition, the parts are closely tied to the lifecycle of the whole, and if the whole is destroyed, the parts are also destroyed.

   Example: Consider a car and its components. A car is composed of an engine, wheels, and other parts. If the car is destroyed, its components are also no longer usable.

   ```java
   class Car {
       private Engine engine;
       private List<Wheel> wheels;

       // ...
   }

   class Engine {
       // ...
   }

   class Wheel {
       // ...
   }
   ```

2. **Aggregation:**
   Aggregation is a type of relationship between classes where one class is part of another class but can exist independently. In other words, it's a "has-a" relationship where one class contains objects of another class, but those objects can exist outside of the containing class.

   Example: Consider a university and its departments. A university "has" multiple departments. Departments can exist independently even if the university doesn't exist.

   ```java
   class University {
       private List<Department> departments;

       // ...
   }

   class Department {
       // ...
   }
   ```

3. **Association:**
   Association is a more general relationship where two classes are connected, but one class does not necessarily contain objects of the other class. It represents a "knows-about" relationship. Associations can be one-way or bidirectional.

   Example: Consider a library system with books and borrowers. A book and a borrower are associated in that a borrower borrows books. However, the borrower does not own the books.

   ```java
   class Book {
       // ...
   }

   class Borrower {
       private List<Book> borrowedBooks;

       // ...
   }
   ```



It's important to understand these concepts when designing object-oriented systems, as they help in modeling relationships accurately and in creating maintainable and understandable code. The choice between aggregation, association, and composition depends on the intended behavior of the system and the level of ownership and dependence between the classes involved.
## Upcasting and downcasting in java

Upcasting and downcasting are terms used to describe the casting or conversion of object references in Java. They are related to inheritance and class hierarchies, and they allow you to work with objects in a polymorphic manner.

1. **Upcasting:**
   Upcasting involves casting a reference of a subclass to a reference of its superclass. It's considered safe and doesn't require an explicit cast, as the subclass object can naturally fit into the type of the superclass. Upcasting is used to treat a subclass object as a more general superclass object.

   Example of upcasting:
   ```java
   class Animal {
       // Animal implementation
   }

   class Dog extends Animal {
       // Dog implementation
   }

   public class Main {
       public static void main(String[] args) {
           Dog dog = new Dog();
           Animal animal = dog; // Upcasting: Subclass reference to superclass reference
       }
   }
   ```

2. **Downcasting:**
   Downcasting involves casting a reference of a superclass to a reference of its subclass. It's more complex and potentially unsafe, as it's not guaranteed to work at runtime if the object being referred to is not actually an instance of the subclass. Downcasting must be done explicitly and can potentially result in a `ClassCastException` if done incorrectly.

   Example of downcasting:
   ```java
   class Animal {
       // Animal implementation
   }

   class Dog extends Animal {
       // Dog implementation
   }

   public class Main {
       public static void main(String[] args) {
           Animal animal = new Dog();
           Dog dog = (Dog) animal; // Downcasting: Superclass reference to subclass reference
       }
   }
   ```

   It's important to ensure that the object being downcasted is actually an instance of the subclass to avoid runtime errors. You can use the `instanceof` operator to check before attempting a downcast.

   ```java
   if (animal instanceof Dog) {
       Dog dog = (Dog) animal;
       // Perform operations on 'dog'
   }
   ```

In summary:

- **Upcasting:** Casting a subclass reference to a superclass reference. Generally safe and doesn't require explicit casting.
- **Downcasting:** Casting a superclass reference to a subclass reference. Requires explicit casting and can result in runtime errors if done incorrectly.

Upcasting and downcasting are commonly used in situations where you want to work with objects in a more general or specific manner based on their position in a class hierarchy.

## Singleton class in java

A Singleton class in Java is a class that is designed to have only one instance throughout the lifetime of an application. It ensures that a class has a single instance and provides a global point of access to that instance. Singleton classes are commonly used for resources that should be shared across the application, such as database connections, thread pools, configuration settings, etc.

Here's an example of implementing a Singleton class in Java:

```java
public class Singleton {
    // Private static instance variable
    private static Singleton instance;

    // Private constructor to prevent instantiation from other classes
    private Singleton() {
        // Initialization code, if needed
    }

    // Public static method to provide access to the instance
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton(); // Create the instance only if it doesn't exist
        }
        return instance;
    }

    // Other methods and fields of the Singleton class
    public void showMessage() {
        System.out.println("Hello from Singleton!");
    }
}

public class Main {
    public static void main(String[] args) {
        // Obtain the Singleton instance using getInstance() method
        Singleton singleton = Singleton.getInstance();
        singleton.showMessage(); // Output: Hello from Singleton!

        // Since the constructor is private, the following line would result in a compilation error
        // Singleton anotherInstance = new Singleton();
    }
}
```

In this example, the `Singleton` class follows the Singleton pattern. It has a private static instance variable `instance`, a private constructor to prevent external instantiation, and a public static method `getInstance()` to provide access to the single instance. The instance is created only if it doesn't exist already. This ensures that only one instance of the class exists throughout the application.

Key points about Singleton classes:

- Singleton classes are used to ensure that a class has only one instance.
- The Singleton pattern ensures lazy initialization (the instance is created only when needed).
- Multiple threads may attempt to create instances concurrently, so consider synchronization or other thread-safe approaches if necessary.
- Singleton pattern can be achieved using various techniques, such as using static initialization, synchronization, or the Bill Pugh Singleton pattern.

Singletons are widely used when you want to control access to resources, maintain a global state, or ensure that only one instance of a class exists to avoid unnecessary duplication.

