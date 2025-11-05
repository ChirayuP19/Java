package DSA;

public class ArraysDemo {
	public static void main(String[] args) {

		// data type and variable name and array bosy what you wantr to store.
//		int[] a = { 101, 102, 103, 104, 105 };
//		// all the type of the data should be the same.
//		System.out.println(Arrays.toString(a));

//		int[][] array2D = {
//
//				{ 1, 2, 3, 4 }, { 5, 6 }, { 7, 8, 9, 10 } };
//
//		for (int i = 0; i < array2D.length; i++) {
//			for (int j = 0; j < array2D[i].length; j++) {
//				System.out.print(array2D[i][j] + " ");
//			}
//			System.out.println();
//		}

		int[] array = { 1, 9, 6, 100, 4, 558, 98, 25, -74 };

		System.out.println(maxRange(array, -3, 2));
	}

	static int maxRange(int[] arra, int a, int b) {
		if (b < a) {
			System.out.println("Please enter Valid Input. ");
			return 0;
		}
		if (a < 0) {
			System.out.println("Araay have no Negative number ");
		}
		int maxValue = arra[a];
		for (int i = a; i <= b; i++) {
			if (maxValue < arra[i]) {
				maxValue = arra[i];
			}

		}
		return maxValue;
	}
}
