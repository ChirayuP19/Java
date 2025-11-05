package DSA;

public class BinarySearch {
	public static void main(String[] args) {

		int[] arr = { -10, -5, -2, 0, 1, 2, 6, 5, 8, 9, 12, 15, 18, 22, 25, 30, 33, 37 };
		int ans = BinarySearch(arr, 33);
		System.out.println(ans);
	}

	// return the index
	// return -1 if not found or exist.

	static int BinarySearch(int[] a, int target) {
		int start = 0;
		int end = (a.length) - 1;

		while (start <= end) {
			int middle = start + (end - start) / 2;

			if (target > a[middle]) {
				start = middle + 1;
			} else if (target < a[middle]) {
				end = middle - 1;
			} else {
				return middle;
			}
		}
		return -1;
	}
}
