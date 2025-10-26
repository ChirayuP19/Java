package generics;

class pair<K, V> {
	private K key;
	private V value;

	public pair(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public void disply() {
		System.out.println("Key: " + key + " value: " + value);
	}
}

public class BoxExample {
	public static void main(String[] args) {
		pair<Double, String> pair = new pair<>(69.205, "Kavya");
		pair.disply();
	}
}