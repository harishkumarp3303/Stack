



public class Main {
	public static void main(String[] args) {
//		old method using anonymous inner classes
		Summer s=new Summer() {

			@Override
			public int sum(int a, int b) {
				// TODO Auto-generated method stub
				return a+b;
			}
			
		};
		
//		using java 8 functional interface lambda expression
		Summer f=( a, b)->{
			return a+b;
		};
		
		
		
		System.out.println(f.sum(1, 2));
		System.out.println(s.sum(10, 20));
		
		
//		Let�s understand with classic example of Runnable:
//			When we need to create a Thread and pass an anonymous Runnable interface, we can do it as follow.
		
		// Using anonymous class
		Thread t1=new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					System.out.println("aaaa");
				}
				
			}
		});
		
		
		t1.start();
		
//		using Java 8 Lambda Expression
		
		Thread t2=new Thread(()->{
			for (int i = 0; i < 100; i++) {
				System.out.println("byeee");
			}
			
		});
		
		t2.start();
		
		
		
		
}
}
