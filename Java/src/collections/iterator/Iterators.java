package collections.iterator;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;

public class Iterators {
    public static void main(String[] args) {
        
// A Java Cursor is an Iterator, which is used to iterate or 
// traverse or retrieve a Collection or Stream object’s elements one by one. 

// Types of Cursors in Java
// There are three cursors in Java as mentioned below:

// 1. Iterator
// 2. ListIterator

// 1. Iterator

// Iterators in Java are used in the Collection framework to retrieve 
// elements one by one. It is a universal iterator as we can 
// apply it to any Collection object. By using Iterator, we can perform 
// both read and remove operations.

// 1. boolean hasNext(): Returns true if the iteration has more elements, otherwise returns false.

// 2. E next(): Returns the next element in the iteration. This method advances the iterator to the next element.

// 3. void remove(): Removes from the underlying collection the last 
// element returned by the iterator (optional operation). It can be called only once per call to next().

        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        
        Iterator<String> it = list.iterator();
        

         while(it.hasNext()){
            System.out.println(it.next());
        } 

        // 2. ListIterator

        // It is only applicable for List collection implemented classes like ArrayList, LinkedList, etc. 
        //  provides bi-directional iteration. ListIterator must be used when we want to enumerate elements of List. 
        //  This cursor has more functionality(methods)than iterator. 
        //  ListIterator object can be created by calling listIterator() method present in the List interface.

        // 1. Forward direction
        //     1.1 hasNext(): Returns true if the iteration has more elements

        //              public boolean hasNext();

        //     1.2 next(): Same as next() method of Iterator. Returns the next element in the iteration. 

        //             public Object next(); 
        //     1.3 nextIndex(): Returns the next element index or list size if the list iterator is at the end of the list. 

        //             public int nextIndex();

        ArrayList<String> list1 = new ArrayList<>();
        list1.add("A");
        list1.add("B");
        list1.add("C");
        list1.add("D");
        list1.add("E");

        
        ListIterator<String> li= list1.listIterator();

        System.out.println(li.hasNext());
        System.out.println(li.next());
        System.out.println(li.nextIndex());

        // 2. Backward direction
        //     2.1 hasPrevious(): Returns true if the iteration has more elements while traversing backward.

        //     public boolean hasPrevious();
        //     2.2 previous(): Returns the previous element in the iteration and can throw NoSuchElementException if no more element present.

        //     public Object previous(); 
        //     2.3 previousIndex(): Returns the previous element index or -1 if the list iterator is at the beginning of the list, 

        //     public int previousIndex();

        System.out.println(li.hasPrevious());
        System.out.println(li.previous());
        System.out.println(li.previousIndex());

        
    }
}
