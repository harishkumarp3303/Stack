package java8.StreamAPI;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Intermediate
 */
public class Intermediate {

    public static void main(String[] args) {
        
        List<String> list = List.of("A", "B", "C", "D", "E");

        ListIterator<String> itr=list.listIterator();

        while(itr.hasNext()){
            System.out.println(itr.previous());
        
        }


    }
}