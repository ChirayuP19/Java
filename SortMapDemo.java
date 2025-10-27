package mapCollection;

import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class SortMapDemo {
	public static void main(String[] args) {
		SortedMap<String, Integer> map = new TreeMap<>((a, b) -> b.compareTo(a));
		map.put("Kavya", 95);
		map.put("Neha", 86);
		map.put("Chirayu", 68);

		// In this sorting working based on keys...
		// a,b,c..... and 1,2,3,.....
//		System.out.println(map);
//		System.out.println(map.firstKey());
//		System.out.println(map.lastKey());
//		System.out.println(map.headMap("F"));
//		System.out.println(map.tailMap("M"));
//		System.out.println(map.containsValue(95));

		NavigableMap<Integer, String> navigableMap = new TreeMap<>();
		navigableMap.put(1, "Kavya");
		navigableMap.put(5, "Five");
		navigableMap.put(3, "Three");

		System.out.println(navigableMap);
		System.out.println(navigableMap.lowerKey(2));
		System.out.println(navigableMap.ceilingKey(3));
		System.out.println(navigableMap.higherKey(4));

	}
}
