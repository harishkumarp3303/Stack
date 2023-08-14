package collections.list;

import java.util.ArrayList;
import java.util.Vector;


public class Vectors {

    public static void main(String[] args) throws InterruptedException {
        // Vector<Person> v=new Vector<>();
        // v.addAll(CollectionsUtitlity.getPersonsList());
        // Enumeration<Person> cap=v.elements();
        // System.out.println(cap.toString());
        // Iterator<Person> itr=v.iterator();

        // while (itr.hasNext()) {
        //     System.out.println(itr.next());
        // } 

        Vector<Integer> v=new Vector<>(); // vector is thread safe arraylist is not thread safe.

        ArrayList<Integer> al=new ArrayList<>();
        Thread t1=new Thread(()->{
            for (int i = 0; i < 100000; i++) {
                v.add(i);
                // al.add(i);
            }
        });
        Thread t2=new Thread(()->{
           for (int i = 0; i < 100000; i++) {
                v.add(i);
                // al.add(i);
            }
        });
        t1.start();
        t2.start();

        

        t1.join();
        t2.join();

        System.out.println(v.size());
        System.out.println(al.size());
        
        




    }
    
}
