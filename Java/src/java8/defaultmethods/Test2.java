package java8.defaultmethods;

interface I1{

    default void print(){
        System.out.println("I1 interface");
    }
}

interface I2{
     default void print() {
        System.out.println("I2 interface");
    }
}

// class C1 implements I1,I2{ // Error cannot implemnt bcz--> 

// Duplicate default methods named print with the parameters () and () are inherited from the types I2 and I1
// }
class Test2{
public static void main(String[] args) {
    
    // C1 c=new C1();
    // c.print();
}
	
}
