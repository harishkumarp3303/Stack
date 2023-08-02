# 1. Core java Basics.
### 1. List the features of the Java Programming language.
1. Platform Independence: Java programs can run on any platform with a Java Virtual Machine (JVM), providing "write once, run anywhere" (WORA) capability.
2. Object-Oriented: Java follows an object-oriented programming paradigm, supporting encapsulation, inheritance, polymorphism, and abstraction.
3. Garbage Collection: Java automatically manages memory allocation and deallocation through garbage collection, reducing the burden of memory management from developers.
4. Strongly Typed: Java is a strongly typed language, which means each variable must be declared with its data type, and type checking is performed during compilation. This helps catch type-related errors early in the development process.
5. Multi-threading and Concurrency: Java has built-in support for multi-threading and concurrency with its Thread class and java.util.concurrent package.

### 2. Differentiate between JDK, JRE, and JVM
#### 1. JDK (Java Development Kit):
1. JDK stands for Java Development Kit.
2. It is a software development kit provided by Oracle (previously Sun Microsystems) and other vendors to develop Java applications.
3. JDK includes the Java Compiler (javac) that converts Java source code (.java files) into bytecode (.class files) that can be executed by the Java Virtual Machine (JVM).
4. It also contains various tools and utilities, such as the Java Runtime Environment (JRE), debugger, profiler, and JavaFX development libraries.
5. JDK is used by developers for writing, compiling, and debugging Java applications.

#### 2. JRE (Java Runtime Environment):

1. JRE stands for Java Runtime Environment.
2. It is a runtime environment that provides the minimum resources required to run Java applications.
3. JRE includes the Java Virtual Machine (JVM) and core libraries (e.g., Java API classes) needed to execute Java bytecode.
4. Unlike JDK, JRE does not contain the Java Compiler (javac) and other development tools. It is solely focused on running Java applications.
5. JRE is required on the end-user's machine to run Java applications without any development capabilities.

#### 3. JVM (Java Virtual Machine):

1. JVM stands for Java Virtual Machine.
2. It is the cornerstone of the Java platform and acts as an abstract machine that enables Java bytecode to be executed on any operating system or hardware architecture.
3. JVM interprets the bytecode produced by the Java compiler or, in some cases, uses Just-In-Time (JIT) compilation to translate the bytecode into native machine code for improved performance.
4. JVM provides features like memory management, garbage collection, and security to ensure the safe and efficient execution of Java applications.
5. JVM is an integral part of both the JDK and JRE.

### 3. How is Java platform-independent? Explain the role of the Java Virtual Machine (JVM)

1. Compilation and Bytecode:
When you write Java code, it is first compiled by the Java compiler (part of the Java Development Kit - JDK) into an intermediate form called bytecode. Bytecode is a set of machine instructions for a theoretical computer known as the Java Virtual Machine Instruction Set.

2. JVM:
The JVM is a software-based virtual machine that emulates a computer system. It acts as an abstraction layer between the compiled Java bytecode and the underlying hardware and operating system. Each platform (e.g., Windows, macOS, Linux) has its own implementation of the JVM, tailored to the specific operating system.

3. Interpretation and Just-In-Time (JIT) Compilation:
When you run a Java application, the JVM interprets the bytecode and translates it into machine code specific to the underlying hardware and operating system. This process is known as interpretation. However, modern JVMs often use Just-In-Time (JIT) compilation techniques to further optimize the execution.

4. Platform Independence:
Since Java bytecode is platform-independent and the JVM provides an abstract environment for its execution, Java programs can run on any system with a compatible JVM installed. Developers don't need to recompile the code for each platform, as the same bytecode can be executed on different operating systems without modification.

5. Write Once, Run Anywhere (WORA):
The "Write Once, Run Anywhere" (WORA) concept is a result of the platform independence provided by the JVM. Developers can write Java code once on any platform, compile it to bytecode, and distribute the bytecode. End-users can run the application on their specific platforms using the JVM installed on their machines.

6. JVM Implementations:
Various vendors provide JVM implementations, each optimized for different operating systems and hardware architectures. Examples include Oracle HotSpot JVM, OpenJ9 JVM (from Eclipse Foundation), GraalVM (from Oracle), and more.

### 4. What is a ClassLoader?

A classloader in Java is a subsystem of Java Virtual Machine, dedicated to loading class files when a program is executed; ClassLoader is the first to load the executable file.

Java has Bootstrap, Extension, and Application classloaders.

### 5. What are the Memory Allocations available in JavaJava?
Java has five significant types of memory allocations.

1. Class Memory
2. Heap Memory
3. Stack Memory
4. Program Counter-Memory
5. Native Method Stack Memory

### 6. What are the differences between Heap and Stack Memory in Java?

#### 1. Purpose:

1. Heap Memory: It is used for dynamic memory allocation and management of objects at runtime. Objects created using the new keyword are stored in the heap.
2. Stack Memory: It is used for storing method frames and local variables, including references to objects in the heap. Each thread in a Java application has its own stack memory.
#### 2. Data Storage:

1. Heap Memory: The heap stores objects, arrays, and their instance variables. It is a shared memory space accessible to all threads in a Java application.
2. Stack Memory: The stack stores method frames, which contain local variables, method arguments, and return addresses. Each thread in a Java application has its own stack, and it is not shared among threads.
#### 3. Lifetime:

1. Heap Memory: Objects in the heap exist as long as they are reachable and not explicitly garbage collected.
1. Stack Memory: Variables in the stack have a limited lifetime that corresponds to the method's execution. When a method completes its execution, its stack frame is removed, and the local variables are no longer accessible.
#### 4. Allocation and Deallocation:

1. Heap Memory: The memory for objects in the heap is allocated dynamically at runtime and is managed by the Java Virtual Machine (JVM) through garbage collection. The JVM automatically deallocates memory for objects that are no longer reachable.
1. Stack Memory: Memory allocation and deallocation in the stack memory are done in a last-in-first-out (LIFO) manner. When a method is invoked, a new stack frame is created, and when the method returns, its stack frame is removed, releasing the associated memory.
#### 5. Size:

1. Heap Memory: The heap size is generally larger than the stack size, as it needs to accommodate all dynamically allocated objects and their instance variables.
1. Stack Memory: The stack size is typically smaller, as it only needs to store method frames and local variables.
#### 6. Concurrency:

1. Heap Memory: Being a shared memory space, heap memory is accessible to all threads in a Java application. This makes it suitable for data shared between multiple threads.
1. Stack Memory: Each thread has its own stack memory, making it thread-safe for method execution and local variable storage.

### 7. Will the program run if we write static public void main?
Yes, the program will successfully execute if written so. Because, in Java, there is no specific rule for the order of specifiers

### 8. Why is the main method static in Java?

### 9. What happens if there are multiple main methods inside one class in Java?

### 10. What is JIT compiler?
Just-In-Time(JIT) compiler: It is used to improve the performance. JIT compiles parts of the bytecode that have similar functionality at the same time, and hence reduces the amount of time needed for compilation. Here the term “compiler” refers to a translator from the instruction set of a Java virtual machine (JVM) to the instruction set of a specific CPU.

### 11. List down methods present in the Object class

1. clone() : this method is used to create a clone of the object. 

#### [click here ](https://www.youtube.com/watch?v=ANApEG7imgU&t=24s) -> for deep copy and shallow copy explanation.
```java
protected native Object clone() throws CloneNotSupportedException;
// ex :
Customer c4=(Customer) c3.clone();
```


2. Equals() : method is used to check equality of an object.without implementing it will comapre with references of the object to comapre with ***content*** comparrision override the equals method.
```java
 public boolean equals(Object obj) {
        return (this == obj);
    }
```

3. hashcode() : A unique ***ID*** that is assigned to an object is called hashcode of the object.(Assigned by JVM)
```java
    public native int hashCode();
```
4. tostring() : This method Used to return a String representation of the object 
```java 
    public String toString()
```
5. wait()
6. notify()
7. notifyall()
8. finalize() : this method is called by garbage collector on an object when garbage colllection determines that there are no more references to the object.
[click here](https://youtube.com/shorts/vQmzLmAGIA4?feature=share)
```java 
protected void finalize() throws Throwable { }
```

## 12. What is marker interface

No methods: A marker interface does not define any methods. It is empty and serves as a tag or label for the implementing classes.
Some common examples of marker interfaces in Java include 
1. Serializable
2. Cloneable

# 2. Strings

# 3. Object-Oriented Programming (OOP):
# 4. Exception Handling
# 5. Java Collections Framework
# 6. Multithreading and Concurrency & synchronization
# 7. Java 8+ Features
# 8. Java Generics and Wrapper classes
# 9. Serialization and Deserialization
# 10. Garbage Collection

