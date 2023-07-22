package collections.collectionsclass;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;


public class CollectionsClass {
	
	public static void main(String[] args) {
		
		//////////////////////////
		
		// Error we cannot create object of Collections class
//		because constructor is private 
		
		// Suppresses default constructor, ensuring non-instantiability.
//	    private Collections() {
//	    }
		
//		Collections c=new Collections();  ------ Error
		
		/////////////////////////////
		// Collections class is a utility class that provides a number of static methods for manipulating collections.

		// Collection class
		List<Integer> alist=new ArrayList<>();
		Set<String> set=new HashSet<>();
		Queue<Integer> pqueue=new PriorityQueue<>();
		Stack<String> stack=new Stack<>();

		// Map Class
		Map<Integer, String> m=new HashMap<>();
		m.put(2, "hii");
		
		
		
//		Here are some of the commonly used methods available in the Collections class:

//			1. public static <T> boolean addAll(Collection<? super T> c, T... elements): Adds all elements from the specified array to the given collection.

			Collections.addAll(alist,5,4,3,2,1);
			Collections.addAll(set,"raj","harish","kumar","raj");
			Collections.addAll(pqueue, 5,1,2,4,3);
			Collections.addAll(stack,"Vinay","harish","kumar","raj","raj");
			System.out.println("Adding elements to the list.....................");
			System.out.println("Adding elements to list"+alist);
			System.out.println("Adding elements to set"+set);
			System.out.println("Adding elements to queue"+pqueue);
			System.out.println("adding elements to stack"+stack);
			System.out.println();
			
//			2. public static <T> void sort(List<T> list): Sorts the elements of the specified list into ascending order using their natural ordering.
			
			Collections.sort(alist);
			
			// To sort set we have 2 ways can be done

			TreeSet<String> ts=new TreeSet<>(set);
			// or
			ArrayList<String> al=new ArrayList<>(set);
		
			Collections.sort(al);

			// Queue and Stack cannot be sorted but it can be sorted by converting to list
			ArrayList<Integer> alist1=new ArrayList<>(pqueue);
			Collections.sort(alist1);
			ArrayList<String> alist2= new ArrayList<>(stack);
			Collections.sort(alist2);
			System.out.println("Sorting......................");
			System.out.println("Sorting elements of list"+alist);
			System.out.println("SOrted elements of set by converting to arraylist"+al);
			System.out.println("Sorted elements of set by converting to treeset"+ts);
			System.out.println("Sort elements of queue"+alist1);
			System.out.println("Sorting elements of stack"+alist2);
			System.out.println();

//			3. public static <T> void sort(List<T> list, Comparator<? super T> c): Sorts the elements of the specified list according to the order induced by the specified comparator.
			
			Collections.sort(alist,new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					return o2.compareTo(o1);
				} 
				
			});

			System.out.println("Sorting elements of list in reverse order"+alist);

//			4. public static <T> int binarySearch(List<? extends Comparable<? super T>> list, T key): Searches the specified list for the specified object using the binary search algorithm.

			 int index=Collections.binarySearch(alist, 6);
			 if (index >= 0) {
				System.out.println("Element found at index: " + index);
			} else {
				System.out.println("Element not found. Insertion point: " + (-(index + 1)));
			}
			 
//			5. public static <T> int binarySearch(List<? extends T> list, T key, Comparator<? super T> c): Searches the specified list for the specified object using the binary search algorithm with the specified comparator.

//			6. public static <T> int frequency(Collection<?> c, Object o): Returns the number of occurrences of the specified element in the specified collection.


			System.out.println("Frequency......................");
			System.out.println("Frequency of element 3 in list "+Collections.frequency(alist,3));
			System.out.println("Frequency of element raj in set "+Collections.frequency(set, "raj"));
			System.out.println("Frequency of element 3 in queue "+Collections.frequency(pqueue, 3));
			System.out.println("Frequency of element raj in stack "+Collections.frequency(stack, "raj"));
			System.out.println();
			
//			6. public static <T> boolean replaceAll(Collection<T> c, T oldVal, T newVal): Replaces each element of the specified collection with the specified new element (optional operation).

			Collections.replaceAll(alist, 3, 6);
			Collections.replaceAll(stack, "raj", "harish");
			System.out.println("After replacing all elements of list with 6 and stack with harish "+alist);
			System.out.println("After replacing all elements of list with 6 and stack with harish "+stack);

//			7. public static <T> boolean disjoint(Collection<? extends T> c1, Collection<? extends T> c2): Returns true if the two specified collections have no elements in common.

			System.out.println(Collections.disjoint(alist,pqueue));
//			8. public static <T> T max(Collection<? extends T> coll): Returns the maximum element of the given collection, according to the natural ordering of its elements.

			System.out.println("Max of list "+Collections.max( alist));
			System.out.println("Max of Set "+Collections.max( set));
//			9. public static <T> T max(Collection<? extends T> coll, Comparator<? super T> comp): Returns the maximum element of the given collection, according to the specified comparator.

			System.out.println("Max with compator "+Collections.max( alist,new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {

					return o2.compareTo(o1);
				} 
				
			}));
//			10. public static <T> T min(Collection<? extends T> coll): Returns the minimum element of the given collection, according to the natural ordering of its elements.

			System.out.println("Min "+Collections.min( alist));
//			11. public static <T> T min(Collection<? extends T> coll, Comparator<? super T> comp): Returns the minimum element of the given collection, according to the specified comparator.
			System.out.println("Min with comparator "+Collections.min( alist,new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
				
					return o2.compareTo(o1);
				} 
				
			}));
//			12. public static <T> void reverse(List<T> list): Reverses the order of the elements in the specified list.
			Collections.reverse(alist);
			System.out.println("After reversing....................."+alist);
			

//			13. public static <T> void shuffle(List<T> list): Randomly permutes the elements in the specified list.
			System.out.println("Before shuffling...................."+alist);
			Collections.shuffle(alist);
			System.out.println("After shuffling....................."+alist);
//			14. public static <T> void shuffle(List<T> list, Random rnd): Randomly permutes the elements in the specified list using the specified random number generator.

//			15. public static <T> Set<T> unmodifiableSet(Set<? extends T> s): Returns an unmodifiable view of the specified set.

//			16. public static <K, V> Map<K, V> synchronizedMap(Map<K, V> m): Returns a synchronized (thread-safe) map backed by the specified map
			Collections.synchronizedMap(m);
			System.out.println("Synchronized map "+m);
//			17. public static <T> List<T> synchronizedList(List<T> list): Returns a synchronized (thread-safe) list backed by the specified list.
			Collections.synchronizedList(alist);
			System.out.println("Synchronized list ");
//			18. public static <T> Set<T> synchronizedSet(Set<T> s): Returns a synchronized (thread-safe) set backed by the specified set.

//			19. public static <T> Collection<T> synchronizedCollection(Collection<T> c): Returns a synchronized (thread-safe) collection backed by the specified collection.

//			20. public static <T> Queue<T> synchronizedQueue(Queue<T> q): Returns a synchronized (thread-safe) queue backed by the specified queue.

//			21. public static <T> Deque<T> synchronizedDeque(Deque<T> d): Returns a synchronized (thread-safe) deque backed by the specified deque.
//////////////////////////////////////////////////////////////////////////
		
		
		
		
		
		
		
		
	}

}
