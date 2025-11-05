package leetCode;

/**
 * BinaryFloorNumber ----------------- This program demonstrates how to find the
 * **floor** of a given target value using the Binary Search algorithm.
 *
 * Floor definition: The floor of a number is the **greatest element** in the
 * array that is **less than or equal** to the target.
 *
 * Example: Array: [0, 1, 15, 19, 25] Target: 18 Floor: 15 → because 15 is the
 * largest number <= 18
 */

public class BinaryFloorNumber {
	public static void main(String[] args) {
		int[] array = { 0, 1, 15, 19, 25, 29, 30, 35, 39, 42, 47, 58, 62, 69, 70, 75, 79, 88, 91, 101, 158, 159, 174,
				198, 220, 250 };
		int target = 18;
		int ans = CellingNum(array, target);
		System.out.println(array[ans]);
	}

	static int CellingNum(int[] arr, int target) {
		int start = 0;
		int end = (arr.length) - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (target > arr[mid]) {
				start = mid + 1;
			} else if (target < arr[mid]) {
				end = mid - 1;
			} else {
				return mid;
			}
		}
		return start - 1;
	}

}