package Multithredingnsynchronization;

import java.util.ArrayList;


class Storage{
    ArrayList<Integer> list=new ArrayList<>();

    public synchronized void adder(Integer i){
        list.add(i);
    }

    public int getsize(){
        return list.size();
    }
}
public class Synchronization {
    
    public static void main(String[] args) {


        Storage s=new Storage();
        Thread t1=new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                s.adder(i);
            } 
        });
     
        Thread t2=new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                s.adder(i);
            } 
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println(s.getsize());
        
    }
}

