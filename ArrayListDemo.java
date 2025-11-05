package DSA;

import java.util.Arrays;

public class ArrayListDemo {
	public static void main(String[] args) {

		// this is called 2 pointer Method. but we can do also in very simple manner
		// also.
		int num[] = { 90, 87, 5, 64, 536, 93, 1, 23, 55, 6, -66, 36, 9, };
		// now i want to reverse this array.
		reverse(num);

		System.out.println(Arrays.toString(num));
		System.out.println(check(num, 1));

	}

	static void reverse(int b[]) {
		int index0 = 0;
		int indexN = (b.length) - 1;

		while (index0 < indexN) {
			swap(b, index0, indexN);
			index0++;
			indexN--;
		}
	}

	static void swap(int[] a, int s, int e) {
		int c = a[s];
		a[s] = a[e];
		a[e] = c;
	}

	static boolean check(int[] a, int c) {
		int x = c;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == x) {
				return true;
			}
		}
		return false;
	}

}
