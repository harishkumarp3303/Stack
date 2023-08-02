package oOPS;

// final class cannot be extended

final class B{
    public void run(){
        System.out.println("running");
    }
}


// // final class C extends B{   
//     public void run(){
//         System.out.println("running");
//     }
// }

// Class c cannot inherit from final class B because is class B is final

//--------------------------------------------------------------

// final method cannot be overridden

class D{
    final public void run(){
        System.out.println("running");
    }
}

// class E extends D{
//     public void run(){
//         System.out.println("running");
//     }
// }

// method cannot be overridden because is method is final
//--------------------------------------------------------------

// final variable cannot be re-assigned

class A{
    final int speedlimit=0;
    A(){
        
    }
    A(int speedlimit){
        // this.speedlimit=speedlimit;  // error because speedlimit is final it cannot be initialized using constructor also
    }
    public void run(){
        System.out.println(speedlimit);
    }
}
//--------------------------------------------------------------
// final method cannot be declared as static

class F{
    public final static  void run(){
        System.out.println("running");
    }
}
//--------------------------------------------------------------

// final class cannot be declared as abstract

// final abstract class  G{

// }

// The class G can be either abstract or final, not both bcz it should in extended

//--------------------------------------------------------------


// final method cannot be declared as synchronized

// final class cannot be declared as private
// final class cannot be declared as protected
// final class cannot be declared as public
// final class cannot be declared as static
// final class cannot be declared as transient
// final class cannot be declared as volatile
// final class cannot be declared as synchronized
// final class cannot be declared as strictfp
// final class cannot be declared as native
// final class cannot be declared as anonymous
// final class cannot be declared as local class
// final class cannot be declared as anonymous class
// final class cannot be declared as enum
// final class cannot be declared as record
// final class cannot be declared as interface
// final class cannot be declared as annotation




// final class cannot be extended






// final keyword is used to make a variable constant or unchangeable



public class FinalKeyword {

   public static void main(String[] args) {
    A a=new A();
    // a.speedlimit=10;  // error because speedlimit is final it cannot be initialized using constructor also
   }

   public void start(){
    A a=new A();
    a.run();
   }
    
}
