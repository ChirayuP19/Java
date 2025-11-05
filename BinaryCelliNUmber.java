package leetCode;

public class BinaryCelliNUmber {
	public static void main(String[] args) {
		int[] array = { 0, 1, 15, 19, 25, 29, 30, 35, 39, 42, 47, 58, 62, 69, 70, 75, 79, 88, 91, 101, 158, 159, 174,
				198, 220, 250 };
		int target = 8;
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
		return start;
	}
}
