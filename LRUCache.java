package mapCollection;

import java.util.LinkedHashMap;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {

	public LRUCache(int capacity) {
		super(capacity, 0.75f, true);
		this.capacity = capacity;
	}

	private int capacity;

	public static void main(String[] args) {
		// 3 entry when 4 add remove 1st entry

		LRUCache<String, Integer> studentMap = new LRUCache<>(3);
		studentMap.put("Kavya", 100);
		studentMap.put("Chirayu", 87);
		studentMap.put("Neha", 74);
		studentMap.get("Chirayu");
		System.out.println(studentMap);
	}

	@Override
	protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
		return size() > capacity;
	}

}

