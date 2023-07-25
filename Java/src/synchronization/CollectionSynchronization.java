package synchronization;

import java.util.ArrayList;

class Counter{
    ArrayList<Integer>  count=new ArrayList<>();
    
    synchronized void counter(Integer i){
        count.add(i);
    }
}

public class CollectionSynchronization {
     
    public static void main(String[] args) throws InterruptedException {
        Counter c=new Counter();
        Thread t1=new Thread(new Runnable(){
            
            @Override
            public void run() {
                for (int i = 0; i < 2000; i++) {
                    c.counter(i);
                }
              
              System.out.println("Thread 1");
            }
            
        });
        Thread t2=new Thread(()->{
            for (int i = 0; i < 2000; i++) {
                c.counter(i);
            }
            
            System.out.println("Thread 2");
        });

        


        // we cannot run same thred twice bcz of its state
        // Exception in thread "main" java.lang.IllegalThreadStateException

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        
        System.out.println(c.count.size());
        

    }
}
