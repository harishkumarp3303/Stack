## Exception

In Java, an exception is an event that occurs during the execution of a program and disrupts the normal flow of instructions. Exceptions are used to handle unexpected or exceptional situations that can occur while a program is running. These situations might include errors, such as division by zero, accessing an array index that doesn't exist, or attempting to open a file that doesn't exist.

### 1. Difference between Error and Exception

**Exceptions:**
Exceptions are unexpected or exceptional events that occur during the execution of a program but are recoverable. 

**Errors:**
Errors are exceptional conditions that typically cannot be handled by a normal Java program. They indicate serious problems that are usually beyond the control of the programmer. Examples of errors include `OutOfMemoryError`, `StackOverflowError`, and `LinkageError`. 

To summarize:

- **Exceptions** are unexpected events during program execution that can be recovered from through proper handling. They can be checked or unchecked.
- **Errors** are exceptional conditions that generally indicate unrecoverable issues at the application or system level. They are typically not meant to be handled by the program.


### 2. Exception heirarchy



```
java.lang.Object
    |
java.lang.Throwable
    |
 +-----------------------+
 |                       |
Error                Exception
    |                    |
 JVM/System Errors    +--------------+
                    |              |
              RuntimeException     Other Exceptions
                                    |
                           +---------------+
                           |               |
                     Unchecked         Checked Exceptions
                    (Runtime) Exceptions
```

Here's a breakdown of the hierarchy:

1. **`Throwable`:** The root class for all exceptions and errors in Java.

2. **`Error`:** Represents serious errors that are typically caused by problems outside the control of the program, such as JVM crashes or severe system failures. Errors are not meant to be caught or handled by regular application code.

3. **`Exception`:** The main class for all exceptions that are meant to be caught and handled by the program.

   a. **`RuntimeException` and its Subclasses:** Unchecked exceptions, also known as runtime exceptions, represent programming errors or conditions that can be avoided by proper coding. They are not required to be caught or declared. Examples include `NullPointerException`, `IndexOutOfBoundsException`, and `IllegalArgumentException`.

   b. **Other Exception Subclasses:** Checked exceptions, subclasses of `Exception` that are not `RuntimeException` or its subclasses. They must be caught or declared using `throws`. Examples include `IOException`, `SQLException`, and `ClassNotFoundException`.

## 3. Types of Exceptions in java


1. **Checked Exceptions:**
Checked exceptions are exceptions that the compiler requires you to handle using `try-catch` blocks or declare in the method signature using the `throws` keyword. They typically represent external conditions or resources that your code interacts with, such as files, databases, or network connections. Checked exceptions are subclasses of the `java.lang.Exception` class (excluding `RuntimeException` and its subclasses).

Some common examples of checked exceptions include:

- `java.io.IOException`: Represents various I/O-related errors, such as file not found or input/output issues.
- `java.sql.SQLException`: Represents database-related errors.
- `java.text.ParseException`: Thrown when a parsing operation encounters an error.

2. **Unchecked Exceptions (Runtime Exceptions):**
Unchecked exceptions, also known as runtime exceptions, represent programming errors or conditions that can be avoided by proper coding practices. Unlike checked exceptions, they are not required to be caught or declared using `throws`. Unchecked exceptions are subclasses of the `java.lang.RuntimeException` class.

Common examples of unchecked exceptions include:

- `java.lang.NullPointerException`: Thrown when attempting to access a method or field on a null object reference.
- `java.lang.IndexOutOfBoundsException`: Thrown when accessing an index that's out of bounds in an array or collection.
- `java.lang.IllegalArgumentException`: Thrown when an inappropriate argument is passed to a method.


## try catch and finally block

Certainly! In Java, `try`, `catch`, and `finally` are keywords used to handle exceptions and control the flow of execution when exceptions occur.

**1. `try` Block:**
The `try` block is used to enclose a section of code where an exception might occur. The code within the `try` block is monitored for exceptions, and if an exception occurs, the normal flow of the program is disrupted, and control is transferred to the appropriate `catch` block (if available).

```java
try {
    // Code that might throw an exception
} catch (ExceptionType e) {
    // Code to handle the exception
}
```

**2. `catch` Block:**
The `catch` block is used to specify the type of exception you want to handle. If an exception of the specified type occurs within the corresponding `try` block, the control is transferred to the associated `catch` block. You can have multiple `catch` blocks to handle different types of exceptions.

```java
try {
    // Code that might throw an exception
} catch (ExceptionType1 e1) {
    // Code to handle ExceptionType1
} catch (ExceptionType2 e2) {
    // Code to handle ExceptionType2
}
```

**3. `finally` Block:**
The `finally` block is used to enclose code that needs to be executed regardless of whether an exception occurred or not. This block is often used for cleanup operations like closing files, releasing resources, or finalizing operations. The code in the `finally` block is executed even if there's a `return` statement in the corresponding `try` or `catch` block.

```java
try {
    // Code that might throw an exception
} catch (ExceptionType e) {
    // Code to handle the exception
} finally {
    // Code that always executes, whether an exception occurred or not
}
```

Here's a more comprehensive example that illustrates the use of `try`, `catch`, and `finally`:

```java
import java.io.FileReader;
import java.io.IOException;

public class ExceptionHandlingExample {
    public static void main(String[] args) {
        FileReader reader = null;
        try {
            reader = new FileReader("example.txt");
            // Code that reads from the file
        } catch (IOException e) {
            System.out.println("An IO exception occurred: " + e.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println("Error closing the file: " + e.getMessage());
            }
        }
    }
}
```

In this example, the `try` block contains code that reads from a file. If an `IOException` occurs, it's caught in the `catch` block, and regardless of whether an exception occurred or not, the `finally` block ensures that the file is properly closed.

## Control flow

1. Control flow in try-catch clause OR try-catch-finally clause 
Case 1: Exception occurs in try block and handled in catch block
Case 2: Exception occurs in try-block is not handled in catch block
Case 3: Exception doesn’t occur in try-block

Absolutely, I'll provide explanations for each of the cases you've mentioned in both the `try-catch` and `try-catch-finally` clauses.

**Case 1: Exception Occurs in `try` Block and Handled in `catch` Block**

In this case, an exception is thrown within the `try` block, and there's a corresponding `catch` block to handle that specific type of exception.

```java
public class TryCatchExample {
    public static void main(String[] args) {
        try {
            int result = divide(10, 0); // This will throw ArithmeticException
            System.out.println("Result: " + result);
        } catch (ArithmeticException ex) {
            System.out.println("Caught exception: " + ex.getMessage());
        }
        System.out.println("Program continues...");
    }

    public static int divide(int a, int b) {
        return a / b;
    }
}
```

**Output:**
```
Caught exception: / by zero
Program continues...
```

**Case 2: Exception Occurs in `try` Block and Not Handled in `catch` Block**

In this case, an exception is thrown within the `try` block, but there's no corresponding `catch` block to handle that specific type of exception.

```java
public class TryCatchExample {
    public static void main(String[] args) {
        try {
            int result = divide(10, 0); // This will throw ArithmeticException
            System.out.println("Result: " + result);
        } catch (NullPointerException ex) {
            System.out.println("Caught exception: " + ex.getMessage());
        }
        System.out.println("Program continues...");
    }

    public static int divide(int a, int b) {
        return a / b;
    }
}
```

**Output:**
```
Exception in thread "main" java.lang.ArithmeticException: / by zero
    at TryCatchExample.divide(TryCatchExample.java:15)
    at TryCatchExample.main(TryCatchExample.java:7)
```

In this case, since the thrown `ArithmeticException` is not caught by a matching `catch` block, the program terminates with an exception stack trace.

**Case 3: No Exception Occurs in `try` Block**

In this case, no exception is thrown within the `try` block.

```java
public class TryCatchExample {
    public static void main(String[] args) {
        try {
            int result = divide(10, 2); // No exception occurs
            System.out.println("Result: " + result);
        } catch (ArithmeticException ex) {
            System.out.println("Caught exception: " + ex.getMessage());
        }
        System.out.println("Program continues...");
    }

    public static int divide(int a, int b) {
        return a / b;
    }
}
```

**Output:**
```
Result: 5
Program continues...
```

In this case, since no exception occurs within the `try` block, the program continues to execute normally after the `try-catch` block.

**Control Flow in `try-catch-finally` Clause:**

In the case of the `try-catch-finally` clause, the control flow works similarly to the `try-catch` clause with an added `finally` block. The `finally` block is executed regardless of whether an exception occurred or not, providing a way to perform cleanup operations.

```java
public class TryCatchFinallyExample {
    public static void main(String[] args) {
        try {
            int result = divide(10, 0); // This will throw ArithmeticException
            System.out.println("Result: " + result);
        } catch (ArithmeticException ex) {
            System.out.println("Caught exception: " + ex.getMessage());
        } finally {
            System.out.println("Finally block executed");
        }
        System.out.println("Program continues...");
    }

    public static int divide(int a, int b) {
        return a / b;
    }
}
```

**Output:**
```
Caught exception: / by zero
Finally block executed
Program continues...
```

In the `try-catch-finally` block, the `finally` block is executed after the `catch` block (if an exception was caught) or after the `try` block (if no exception occurred). It ensures that any cleanup or finalization tasks are performed, regardless of whether an exception occurred or not.

2. try-finally clause 
Case 1: Exception occurs in try block
Case 2: Exception doesn’t occur in try-block

Certainly, I'll explain the control flow in the `try-finally` clause for the two cases you mentioned.

**Case 1: Exception Occurs in `try` Block**

In this case, an exception is thrown within the `try` block. Whether the exception is caught or not, the code in the `finally` block is executed.

```java
public class TryFinallyExample {
    public static void main(String[] args) {
        try {
            System.out.println("Before exception");
            int result = divide(10, 0); // This will throw ArithmeticException
            System.out.println("After exception, result: " + result);
        } finally {
            System.out.println("Finally block executed");
        }
        System.out.println("Program continues...");
    }

    public static int divide(int a, int b) {
        return a / b;
    }
}
```

**Output:**
```
Before exception
Finally block executed
Exception in thread "main" java.lang.ArithmeticException: / by zero
    at TryFinallyExample.divide(TryFinallyExample.java:18)
    at TryFinallyExample.main(TryFinallyExample.java:8)
```

In this case, even though an exception occurs and the `catch` block is not present, the `finally` block is executed after the `try` block.

**Case 2: No Exception Occurs in `try` Block**

In this case, no exception is thrown within the `try` block. The code in the `finally` block is still executed.

```java
public class TryFinallyExample {
    public static void main(String[] args) {
        try {
            System.out.println("Before exception");
            int result = divide(10, 2); // No exception occurs
            System.out.println("After exception, result: " + result);
        } finally {
            System.out.println("Finally block executed");
        }
        System.out.println("Program continues...");
    }

    public static int divide(int a, int b) {
        return a / b;
    }
}
```

**Output:**
```
Before exception
After exception, result: 5
Finally block executed
Program continues...
```

In this case, since no exception occurs in the `try` block, the code in the `finally` block is still executed.

**Summary:**

In both cases of the `try-finally` block:
- The code within the `finally` block is executed, regardless of whether an exception occurred in the `try` block or not.
- The `finally` block is often used for cleanup operations, releasing resources, or ensuring certain tasks are performed, regardless of exceptions.



## Throw and Throws

Certainly! In Java, `throw` and `throws` are keywords related to exception handling. They allow you to either create and throw custom exceptions (`throw`) or declare that a method may throw certain types of exceptions (`throws`). Let's explore each concept in detail:

**1. `throw` Statement:**
The `throw` statement is used to manually throw an exception. You can use it to create and throw your own custom exceptions or to propagate exceptions that have already been caught. The syntax is as follows:

```java
throw ThrowableInstance;
```

Here's an example of using the `throw` statement to throw a custom exception:

```java
class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}

public class ThrowExample {
    public static void main(String[] args) {
        try {
            int value = 10;
            if (value < 20) {
                throw new CustomException("Value is too small");
            }
        } catch (CustomException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}
```

In this example, the `throw` statement is used to create and throw a `CustomException` when the condition is met. The exception is caught in the `catch` block.

**2. `throws` Clause:**
The `throws` clause is used to declare that a method might throw certain types of exceptions. This provides information to callers of the method about what exceptions they should be prepared to handle or propagate further. Methods can declare multiple exceptions using a comma-separated list.

```java
ReturnType methodName(ParameterList) throws ExceptionType1, ExceptionType2, ... {
    // Method implementation
}
```

Here's an example of using the `throws` clause in a method signature:

```java
import java.io.IOException;

public class ThrowsExample {
    public static void main(String[] args) {
        try {
            readFile();
        } catch (IOException e) {
            System.out.println("Caught IOException: " + e.getMessage());
        }
    }

    public static void readFile() throws IOException {
        // Code that reads from a file
    }
}
```

In this example, the `readFile` method declares that it might throw an `IOException`. When calling this method, the caller must either catch the `IOException` or declare that it may propagate the exception.

**Summary:**
- `throw` is used to manually throw an exception, creating a new instance of an exception class and passing it to the JVM.
- `throws` is used in method signatures to declare the types of exceptions a method may throw, allowing callers to handle or propagate those exceptions.

Both `throw` and `throws` are essential in building a robust exception-handling mechanism in Java programs. They allow you to handle various exceptional situations effectively and maintain code reliability.

## Final vs Finally vs Finalize

`final`, `finally`, and `finalize` are three concepts in Java that serve different purposes. Let's explore each one:

**1. `final`:**
The `final` keyword in Java is used to declare that a class, method, or variable cannot be further extended, overridden, or modified. Here's how it is used:

- `final` variable: Once a variable is declared `final`, its value cannot be changed after initialization.
- `final` method: A `final` method cannot be overridden by any subclass.
- `final` class: A `final` class cannot be extended by any other class.

Example:

```java
final class FinalClass {
    final int finalVariable = 10;

    final void finalMethod() {
        // Method implementation
    }
}
```

**2. `finally`:**
The `finally` block is used in exception handling to ensure that a specific block of code is executed, regardless of whether an exception occurs or not. It is often used for cleanup operations like closing files or releasing resources.

```java
try {
    // Code that might throw an exception
} catch (Exception e) {
    // Code to handle the exception
} finally {
    // Code that always executes, whether an exception occurred or not
}
```

**3. `finalize`:**
The `finalize` method is a special method provided by the `Object` class that allows an object to perform cleanup operations before it is garbage collected. However, it's generally recommended to use other mechanisms like explicit resource management (`close()`, `AutoCloseable`) instead of relying on `finalize`.

Example:

```java
class MyObject {
    @Override
    protected void finalize() throws Throwable {
        // Cleanup operations before the object is garbage collected
    }
}
```

In summary:
- `final`: Used to make classes, methods, and variables unchangeable or unextendable.
- `finally`: Used in exception handling to execute code that needs to run regardless of exceptions.
- `finalize`: A method used for object cleanup before garbage collection, but its use is discouraged in favor of other resource management techniques.

These concepts serve different purposes and are used in different contexts in Java programming.

## User defined exceptions

Creating a user-defined exception in Java involves creating a custom class that extends one of the existing exception classes, such as `Exception` or its subclasses. Here's how you can create a user-defined exception:

1. **Create the Custom Exception Class:**
   Decide on the name of your custom exception and create a Java class for it. The class should extend an appropriate existing exception class, such as `Exception`. You can also provide constructors to initialize the exception message.

2. **Constructors and Superclass:**
   In your custom exception class, create constructors that call the constructors of the parent exception class (using `super`) and pass the exception message. This way, you can set the error message for your custom exception.

3. **Usage:**
   You can throw and catch instances of your custom exception just like any other exception. You can include additional methods and fields in your custom exception class to provide more information or context for handling the exception.

Here's an example of creating and using a user-defined exception:

```java
class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}

public class UserDefinedExceptionExample {
    public static void main(String[] args) {
        try {
            validateAge(-5); // This will throw CustomException
        } catch (CustomException e) {
            System.out.println("Caught custom exception: " + e.getMessage());
        }
    }

    public static void validateAge(int age) throws CustomException {
        if (age < 0) {
            throw new CustomException("Age cannot be negative");
        }
        System.out.println("Age: " + age);
    }
}
```

In this example, we create a custom exception class `CustomException` that extends `Exception`. We use this custom exception class to handle the case when the age is negative in the `validateAge` method. When a negative age is passed, a `CustomException` is thrown and caught in the `main` method, where we print the error message.

By creating your own custom exception classes, you can provide more meaningful error messages and context for exceptional situations in your code, making it easier to debug and maintain.

## Exception handling with method Overriding
https://www.geeksforgeeks.org/exception-handling-with-method-overriding-in-java/

1. Problem 1:  If The SuperClass doesn’t declare an exception

In this problem, two cases that will arise are as follows:

Case 1: If SuperClass doesn’t declare any exception and subclass declare checked exception -> Error
Case 2: If SuperClass doesn’t declare any exception and SubClass declare Unchecked exception -> No error

2. Problem 2: If The SuperClass declares an exception

Case 1: If SuperClass declares an exception and SubClass declares exceptions other than the child exception of the SuperClass declared Exception. -> Error
Case 2: If SuperClass declares an exception and SubClass declares a child exception of the SuperClass declared Exception. -> No error
Case 3: If SuperClass declares an exception and SubClass declares without exception. -> No Error






