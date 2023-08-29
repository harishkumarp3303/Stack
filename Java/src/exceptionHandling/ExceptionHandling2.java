package exceptionHandling;

public class ExceptionHandling2 {
    public static void main(String[] args) {
        
        ExceptionHandling2 e=new ExceptionHandling2();

        try {
            e.A();
        } catch (Exception e1) {
            System.out.println("Error Occured       " + e1.getMessage());
        }

    }

    public void A() throws Exception{
        B();
        System.out.println("Method A");

    }

    public void B() throws Exception{
        c();
        System.out.println("Method B");
    }

    public void c() throws Exception{
       
            int i=10/0;
        
        System.out.println("Method C");
    }
}
