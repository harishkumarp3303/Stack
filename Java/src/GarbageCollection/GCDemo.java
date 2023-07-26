package GarbageCollection;

public class GCDemo {

    public static void main(String[] args) {

        // Garbage collection is a process of automatic deletion of unused objects or unreferenced objects.

        // 1.How objects can be unreferenced 

        // a. By nulling the reference
        GCDemo gcDemo=new GCDemo();
        gcDemo=null; // nulling the reference and making eligible for garbage collection

        // b. By assigning another reference to the object
        GCDemo gcDemo1=new GCDemo();
        GCDemo gcDemo2=new GCDemo();
        gcDemo2=gcDemo1; // now geDemo1 is garbage collected

        // c. By anonymous object
        new GCDemo(); 


        GCDemo obj = new GCDemo();
        obj = null;
        System.gc();
        System.out.println("End of main");
    
    }

    @Override
    protected void finalize() throws Throwable { // Method Belongs to GC Demo class
        System.out.println("Object is garbage collected---------"+hashCode()); 
    };
    }

// Output

// End of main
// Object is garbage collected---------684728244
// Object is garbage collected---------639104222
// Object is garbage collected---------573076676
// Object is garbage collected---------1730871013