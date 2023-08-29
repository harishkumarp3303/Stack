package Multithredingnsynchronization;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.Collections;

/**
 * WaitnSleep
 */
 public class Multithreading1 {

    public static void main(String[] args) throws InterruptedException {
        List<Integer> l1=new ArrayList<>();
        List<Integer> l2=Collections.synchronizedList(new ArrayList<>());
        CopyOnWriteArrayList<Integer> l3=new CopyOnWriteArrayList<Integer>();

        

        Thread t1=new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                l1.add(i);
            }

        });

        Thread t2=new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                l1.add(i);
            }

        });

        Thread t3=new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                l2.add(i);
            }

        });
        Thread t4=new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                l2.add(i);
            }

        });
        Thread t5=new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                l3.add(i);
            }

        });
        Thread t6=new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                l3.add(i);
            }

        });


        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();


        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();
        t6.join();
        System.out.println(l1.size());
        System.out.println(l2.size());
        System.out.println(l3.size());

    }

    

}