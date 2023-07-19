package java8.StreamAPI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Streams1 {
	
	public static void main(String[] args) {
		
		ArrayList<Integer> l1=new ArrayList<>();
		l1.add(10);
		l1.add(20);
		l1.add(30);
		List<Integer> l=l1.stream().peek((d)->System.out.println(d)).collect(Collectors.toList());
	}

}
