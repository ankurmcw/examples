package com.test1;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class CollectionTest {

	public static void main(String[] args) {
		List<String> l = new ArrayList<>();
		l.add("A");
		List<String> m = new ArrayList<>();
		m.add("A");
		System.out.println(l.equals(m));
		l.add("B");
		l.add("C");
		/*Collections.swap(l, 1, 2);
		System.out.println(l);
		Collections.shuffle(l);
		System.out.println(l);*/
		l.add("D");
		l.add("E");
		
		ListIterator<String> i = l.listIterator(l.size());
		while(i.hasPrevious()) {
			System.out.println(i.previous());
		}
		
		String a = new String("Ankur");
		String b = "Ankur";
		System.out.println(a==b);
		System.out.println(a.equals(b));
	}

}
