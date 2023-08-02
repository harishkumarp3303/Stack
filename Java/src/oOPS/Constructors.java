package oOPS;

// It is called when an instance of the class is created.
//  At the time of calling the constructor, memory for the object is allocated in the memory.
//   It is a special type of method that is used to initialize the object. 
//   Every time an object is created using the new() keyword, at least one constructor is called.

// Constructor is a special type of method that is used to initialize the object.
//  Constructor name must be same as the class name.
//  Constructor doesn't have any return type.

// Constructor overloading is not possible in Java.
//  Constructor overloading is not possible in Java.
//  Constructor overloading is not possible in Java.

// Constructor is called when an instance of the class is created.
//  Constructor is used to initialize the object.
//  Constructor is called automatically when an object is created.
//  Constructor is called automatically when an object is created.

// Constructor is used to initialize the object.
//  Constructor is used to initialize the object.
//  Constructor is used to initialize the object.
//  Constructor is used to initialize the object.
//  Constructor is used to initialize the object.
//  Constructor is used to initialize the object.
//  Constructor is used to initialize the object.
//  Constructor is used to initialize the object.
//  Constructor is used to initialize the object.
//  Constructor is used to

class Grandparent{
    public Grandparent(){
        System.out.println("This is grandparent class constructor");
    }

}
class Parent extends Grandparent{
    public Parent(){
        System.out.println("This is parent class constructor");
    }
}

class child extends Parent{
    public child(){
        System.out.println("This is child class constructor");
    }
}
public class Constructors {

    public static void main(String[] args) {

        Grandparent g=new Grandparent();
        System.out.println("------------------------------------------");

        Parent p1=new Parent();
        System.out.println("------------------------------------------");

        child c1=new child();
        System.out.println("------------------------------------------");
    }

}

// Q1. What is a constructor in Java?
// Ans:

// A constructor in Java is a special method used to initialize objects.


// Q2. Can a Java constructor be private?
// Ans:

// Yes, a constructor can be declared private. A private constructor is used in restricting object creation.