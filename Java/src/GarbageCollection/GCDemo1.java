package GarbageCollection;

class car{

    public void finalize(){
        System.out.println("Car is destroyed");
    }

}
public class GCDemo1 {

    public static void m(){
        car c=new car();
        car c1=new car();
        car c2=new car();
        
    }
    
    public static void main(String[] args) throws InterruptedException {
        
      car c=new car();
        m();
        
        System.gc();
    }
}
