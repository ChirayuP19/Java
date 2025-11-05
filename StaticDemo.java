package DSA;

import java.util.Arrays;

public class StaticDemo {
	public static void main(String[] args) {
		int[] array = { 1, 23, 5, 66, 88, 99, 9 };
		array[2] = -74;
		System.out.println(Arrays.toString(array));
		change(array);
		System.out.println(Arrays.toString(array));
	}

	static void change(int[] i) {
		i[0] = 99;
		i[2] = -88;
	}

}