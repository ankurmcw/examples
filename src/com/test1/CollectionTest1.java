package com.test1;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListMap;

public class CollectionTest1 {
	
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "ABC");
		map.put("2", "DEF");
		
		Set<String> set = map.keySet();
		for(String s: set) {
			System.out.println(s + " : " + map.get(s) );
		}
		Iterator<String> i = set.iterator();
		while(i.hasNext()) {
			String key = i.next();
			System.out.println(key + " : " + map.get(key));
		}
		
		Collection<String> list = map.values();
		System.out.println(list);
		
		for(Map.Entry<String, String> entryMap : map.entrySet()) {
			System.out.println(entryMap.getKey() + " : " + entryMap.getValue());
		}
		
		System.out.println("B".compareTo("A"));
		
		NavigableMap<Integer, String> nMap = new ConcurrentSkipListMap<>();
		nMap.put(3, "Three");
		nMap.put(5, "Five");
		nMap.put(2, "Two");
		nMap.put(1, "One");		
		System.out.println("CeilingKey: "+nMap.ceilingKey(4));
	}

}
