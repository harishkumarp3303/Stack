package java8.defaultmethods;

public class Test1 {
	
	public static void main(String[] args) {
		Samsung s=new Samsung();
		s.call();
		
		Phone.PowerONorOFF(status.OFF);
		
		
		Iphone i=new Iphone();
		i.call();
		
		i.restart();
		
		keypadphone k=new jio();
		k.message();
		k.restart();
		
	}

}

// enum 
enum status{
	OFF,ON
}

// phone interface
interface Phone{
	
	// abstract methods
	void call();
	
	// default methods
	default void restart() {
		System.out.println("Restarting");
	}
	
	// static methods
	static void PowerONorOFF(status s ) {
		if(s.equals(status.OFF)){
			System.out.println("Phone is turning OFF");
		}else {
			System.out.println("Phone is turning ON");
		}
			
	}
	
}

abstract class keypadphone implements Phone{
	
	void message(){
		System.out.println("message from keypad phone");
	}
}

class jio extends keypadphone{

	@Override
	public void call() {
		System.out.println("calling from jio keypadphone");
		
	}
	
}

class Samsung implements Phone{

	@Override
	public void call() {
		System.out.println("Samsung phone is calling");
		
	}

	
	
}

class Iphone implements Phone{

	@Override
	public void call() {
		System.out.println("Iphone phone is calling");
		
	}
	
}


