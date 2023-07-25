package GarbageCollection;

public class GCDemo {

    public static void main(String[] args) {
        
        GCDemo obj = new GCDemo();
        obj = null;
        System.gc();
        System.out.println("End of main");
    
    }
    protected void finalize() throws Throwable { 
        System.out.println("Object is garbage collected"); 
    };
    }
