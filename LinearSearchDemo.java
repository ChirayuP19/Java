package DSA;

public class LinearSearchDemo {
	public static void main(String[] args) {
		int[] num = { 23, 58, 49, 63, 25, 87, 14, 6, 15, 2, 9, 8, 55, 47 };
		int target = 15;
		int ans = linner(num, target);

		System.out.println("Index number: " + ans + " for " + target);
	}
	// search in the Array return the index if item found or else return -1;

	static int linner(int[] arr, int target) {
		if (arr.length == 0) {
			return -1;
		}

		for (int index = 0; index < arr.length; index++) {
			// check for element for ever index.
			int element = arr[index];
			if (element == target) {
				return index;
			}
		}
		return -1;
	}

}
