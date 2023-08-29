package oOPS;

// It is the mechanism in Java by which one class is allowed to inherit the features(fields and methods) of another class.

// Link : https://javahungry.blogspot.com/2019/12/inheritance-in-java.html

// 1. Single Level Inheritance

// In the case of Single Inheritance, only one child is derived from the parent class.

class Parent{
    int a;
    void display(){
        System.out.println("superclass");
    }
}

class Child extends Parent{
    int b;
    void display(){
        System.out.println("subclass");
    }
}

// ////////////////////////////////////////////////////////////////////

// 2. Multilevel Inheritance

// In the case of Multilevel Inheritance, one child class is derived from another child class.


class GrandParent{
    int a;
    void display(){
        System.out.println("superclass");
    }
}

class Parent1 extends GrandParent{
    int b;
    void display(){
        System.out.println("subclass");
    }
}

class child1 extends Parent1{
    int c;
    void display(){
        System.out.println("subclass");
    }
}

// ////////////////////////////////////////////////////////////////////

// 3. Multiple Inheritance

// Multiple Inheritance is not supported in Java.

class Parent2{
    int a;
    void display(){
        System.out.println("superclass");
    }
}

class Parent3{
    int b;
    void display(){
        System.out.println("superclass");
    }
}

// class child2 extends Parent3,parent2{ --> Does not support multiple inheritance
  
// }

// But we can achieve multiple inheritance using interface.
interface Parent4{
    int a=0;
    void display();
}

interface parent5{
    int b=0;
    void display();
}

class child2 implements Parent4,parent5{
    int c;
    public void display(){
        System.out.println("subclass");
    }
}


// ////////////////////////////////////////////////////////////////////

// 4. Hierarchical Inheritance

// Hierarchical inheritance is a type of inheritance in which a class is derived from more than one base class.

class parent6{
    int a;
    void display(){
        System.out.println("superclass");
    }
}

class child3 extends parent6{
    int b;
    void display(){
        System.out.println("subclass");
    }
}

class child4 extends parent6{
    int c;
    void display(){
        System.out.println("subclass");
    }
}

// 5. Hybrid Inheritance

// Hybrid Inheritance is a combination of multiple inheritance and single inheritance.

// DiamondProblem --> It is a problem of multiple inheritance.

class GrandParent1{
    int a;
    void display(){
        System.out.println("superclass");
    }
}

class parent7 extends GrandParent1{
    int b;
    void display(){
        System.out.println("subclass");
    }
}

class parent8 extends GrandParent1{
    int c;
    void display(){
        System.out.println("subclass");
    }
}

// class child   extends parent7,parent8{ -----------------> Does't work
//     int d;
//     void display(){
//         System.out.println("subclass");
//     }
// }


// ////////////////////////////////////////////////////////////////////

// Rules of inheritance in java

// 1. Private members of a class can’t be inherited by another class
// 2. A class can only extend one class.
// 3. Whenever there is confusion between members of the current class 
// and parent class, in such case we can use this keyword to refer to the members of the current class 
// and super keyword to refer to the members of the parent class. 
// 4. The constructor of the parent class can be called using the super() method 
// inside the constructor of the child class. The super() method must be the first line 
// inside the constructor of child class in order to call parent class’s constructor otherwise it may generate an error.

interface Animal {
    void eat();
}

interface Mammal {
    void breathe();
}

class Dog implements Animal, Mammal {
    @Override
    public void eat() {
        System.out.println("Dog is eating.");
    }

    @Override
    public void breathe() {
        System.out.println("Dog is breathing.");
    }
}



interface Engine {
    void start() ;
}

interface CarEngine {
    // void rotate() ;

    void start() ;
}

class Toyota implements Engine,CarEngine{

    // @Override
    // public void rotate() {

    //     throw new UnsupportedOperationException("Unimplemented method 'rotate'");
    // }

    @Override
    public void start() {

        throw new UnsupportedOperationException("Unimplemented method 'start'");
    }

}

class Car {


}





public class Inheritances {
    

    public static void main(String[] args) {
 
    }
}
