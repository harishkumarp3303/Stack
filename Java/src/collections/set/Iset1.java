package collections.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
public class Iset1 {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> linkedHashSet = new LinkedHashSet<>();
        Set<Integer> treeset = new TreeSet<>();

        linkedHashSet.add(3);
        linkedHashSet.add(6);
        linkedHashSet.add(2);
        linkedHashSet.add(1);
        linkedHashSet.add(5);

        Iterator<Integer> itr=set.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

        // linkedHashSet.addAll(set);

        Iterator<Integer> itr1=linkedHashSet.iterator();
        System.out.println();
        while(itr1.hasNext()){
            System.out.println(itr1.next());
        }


       
    }
}
