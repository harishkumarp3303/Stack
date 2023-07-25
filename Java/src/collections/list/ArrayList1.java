package collections.list;

import java.util.ArrayList;

public class ArrayList1 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

    // 1. add(E element): Appends the specified element to the end of the list.
        list.add(1);
        list.add(2);
        list.add(5);
        list.add(7);
        list.add(100);
        System.out.println("ArrayList after adding "+list);
    //2. add(int index, E element): Inserts the specified element at the specified position in the list. Shifts the subsequent elements to the right.
    
    list.add(4,9);
    System.out.println("ArrayList after adding at index 4 of 9 elements "+list);

    //3. get(int index): Returns the element at the specified index in the list.
        System.out.println(" getting element at index 4 is "+list.get(4));

    //4. set(int index, E element): Replaces the element at the specified index with the specified element.
        System.out.println(list.set(4, 10));
        System.out.println("setting element at index 4 to 10 "+list);

    //5. remove(int index): Removes the element at the specified index from the list.
        System.out.println("Removing element at index 1 "+list.remove(1));
       
    //6. remove(Object o): Removes the first occurrence of the specified element from the list, if present.
        System.out.println(list.remove(Integer.valueOf(10)));
        System.out.println("Arraylist after removing first occurance of object 10 "+list);

    //7. size(): Returns the number of elements in the list.
        System.out.println("returning size of arraylist "+list.size());

    //8. isEmpty(): Returns true if the list is empty, false otherwise.
        System.out.println(list.isEmpty());

    //9. contains(Object o): Returns true if the list contains the specified element, false otherwise.
        System.out.println(list.contains(10));
        System.out.println(list.contains(100));

    //10. indexOf(Object o): Returns the index of the first occurrence of the specified element in the list, or -1 if the element is not found.
        int indexof=list.indexOf(2);
        System.out.println(indexof);

    //11. lastIndexOf(Object o): Returns the index of the last occurrence of the specified element in the list, or -1 if the element is not found.
        int lastIndexOf=list.lastIndexOf(5);

    //12. clear(): Removes all elements from the list, making it empty.
        list.clear();
        System.out.println(list);

    //13. addAll(Collection<? extends E> c): Appends all elements from the specified collection to the end of the list.
        ArrayList<Integer> a=new ArrayList<>();
        a.add(10);
        a.add(20);
        list.addAll(a);
        System.out.println(list);

    //14. addAll(int index, Collection<? extends E> c): Inserts all elements from the specified collection into the list, starting at the specified index. Shifts the subsequent elements to the right.
        ArrayList<Integer> a1=new ArrayList<>();
        a1.add(10);
        a1.add(20);
        list.addAll(2,a1);
        System.out.println(list);

    //15. toArray(): Returns an array containing all the elements in the list.
        Object[] arr=list.toArray();
        System.out.println(arr.length);
        int[] arr3=new int[arr.length];
        for (int i = 0; i < arr3.length; i++) {
            arr3[i]=(int)arr[i];
        }
        for (int i : arr3) {
            System.out.println(i);
        }
        for (Object object : arr) {
            System.out.println(object);
        }
        
    //16. toArray(T[] a): Returns an array containing all the elements in the list, and the type of the returned array is the same as the type of the specified array.
        // Integer[] arr1=list.toArray();
}
}
