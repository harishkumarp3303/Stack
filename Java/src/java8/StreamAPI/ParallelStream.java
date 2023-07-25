package java8.StreamAPI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ParallelStream {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }

        long start=System.currentTimeMillis();
        
        int res=Collections.binarySearch(list, 459);

        long end=System.currentTimeMillis();
        System.out.println(res);
        System.out.println(end-start);

        LinkedList<Integer> ll = new LinkedList<>();
        for (int i = 0; i < 1000; i++) {
            ll.add(i);
        }

        

        long start1=System.currentTimeMillis();
        
        int res1=Collections.binarySearch(ll, 459);

        long end1=System.currentTimeMillis();

        System.out.println(res1);
        System.out.println(end1-start1);
        
    }
}
