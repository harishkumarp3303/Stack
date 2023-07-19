package java8.functionalInterface;

//https://java2blog.com/java-8-functional-interface-example/

//Functional interfaces are those interfaces which have only one abstract method, 
//it can have default methods, static methods and it can also override java.lang.Object class method.

//For example: Runnable , Comparable.

//You can implement functional interfaces using lambda expressions.

//Let’s understand with classic example of Runnable:

//When we need to create a Thread and pass an anonymous Runnable interface, we can do it as follow.


@FunctionalInterface
interface Summer {
	
	// only 1 one abstract method
	int sum(int a,int b);
	
	// default method
	default void decorateWithPaints()
	 {
	  System.out.println("Decorating using paints");
	 }
	
	// static method
	 static void decorateWithPainter()
	 {
	  System.out.println("Decorating using paints");
	 }
}

//Runnable –> This interface only contains the run() method.
//Comparable –> This interface only contains the compareTo() method.
//ActionListener –> This interface only contains the actionPerformed() method.
//Callable –> This interface only contains the call() method.


//Java SE 8 included four main kinds of functional interfaces which can be applied in multiple situations as mentioned below:
//
//Consumer
//Predicate
//Function 
//Supplier
