package java8.StreamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Collectors;

public class Streams2 {

	public static void main(String[] args) {
		String s="harish kumar";
		
		char[] c=s.toCharArray();
		ArrayList<Character> l=new ArrayList<>();
		for (char e : c) {
			l.add(e);
		}
		Map<String, Integer> a=
		l.stream().map(d->d).collect(Collectors.toMap(d->String.valueOf(d),e->Integer.valueOf(e)));
		
		System.out.println(a);
		
//		System.out.println(res);
	}
}
