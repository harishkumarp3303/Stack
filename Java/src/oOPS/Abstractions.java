package oOPS;

// In Java, abstraction is achieved by interfaces and abstract classes. 

// In Java, interfaces are used to achieve 100% abstraction.

// Abstraction is defined as a process of hiding the implementation details and showing only functionality to the user.

// Java Abstract classes and Java Abstract methods 

// 1. An abstract class is a class that is declared with an abstract keyword.
// 2. An abstract method is a method that is declared without implementation.
// 3. An abstract class may or may not have all abstract methods. Some of them can be concrete methods
// 4. A method-defined abstract must always be redefined in the subclass, thus making overriding compulsory or making the subclass itself abstract.
// 5. Any class that contains one or more abstract methods must also be declared with an abstract keyword.
// 6. There can be no object of an abstract class. That is, an abstract class can not be directly instantiated with the new operator.
// 7. An abstract class can have both abstract and non-abstract methods.
// 8. An abstract class can have both static and non-static methods.
// 9. An abstract class can have both final and non-final methods.
// 10. An abstract class can have both static and non-static fields.
// 11. An abstract class can have both final and non-final fields.
// 12. An abstract class can have both final and non-final static fields.
// 13. An abstract class can have both final and non-final static methods.
// 14. An abstract class can have both final and non-final instance fields.
// 15. An abstract class can have both final and non-final instance methods.
// 16. An abstract class can have both final and non-final static instance fields.
// 17. An abstract class can have both final and non-final static instance methods.
// 18. An abstract class can have both final and non-final instance fields and methods.
// 19. An abstract class can have both final and non-final instance methods and static fields.An abstract class can have parameterized constructors and the default constructor is always present in an abstract class.


interface Animal{
    void eat();
    void travel();
}

abstract class Dog implements Animal{

    void play(){
        System.out.println("hiii");
    }
}

// class Labrador extends Dog{

//     public void eat(){
        
//     }

// }
public class Abstractions {
    
    // public static void main(String[] args) {
    //     Labrador l=new Labrador();
    //     l.eat();
    // }
}
