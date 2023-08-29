package collections;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class Concurrenthashmap {

    public static void main(String[] args) throws InterruptedException {
        // HashMap<Integer,String> hm=new HashMap<>();
        ConcurrentHashMap<Integer,String> hm=new ConcurrentHashMap<>();
        Thread t1=new Thread(()->{
            for(int i=0;i<1000;i++){
                hm.put(i, String.valueOf(i));
            }
        });

        Thread t2=new Thread(()->{
            for(int i=0;i<1000;i++){
                hm.put(i, String.valueOf(i));
            }
        });

        t1.start();
        t2.start();

        t1.join();t2.join();
        System.out.println(hm.size());

    }
    
}



 class HashMapExample {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                map.put(i, String.valueOf(i));
            }
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Size of HashMap: " + map.size());
    }
}




 class ConcurrentHashMapExample {
    public static void main(String[] args) {
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<Integer, String>();

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                map.put(i, String.valueOf(i));
            }
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Size of ConcurrentHashMap: " + map.size());
    }
}

