package DSA;

public class SearchInRange {
	public static void main(String[] args) {
		int[] arr = { 24, 65, 41, 22, 15, 19, 86, 36, 44, 625, 55, 34, 12, 546, 651, 6554 };
		int ans = linerSearch(arr, 0, 9, 12);
		System.out.println(ans);
	}

	static int linerSearch(int[] a, int start, int end, int target) {

		try {
			if (end > a.length) {
				return -1;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			Thread.currentThread().interrupt();
		}

		if (a.length == 0) {
			return -1;
		}

		for (int index = start; index <= end; index++) {
			int e = a[index];
			if (e == target) {
				return index;

			}
		}
		// hence if element is not found in the system then
		// return -1 same as error that this element is not found in the system.
		return -1;
	}
}
