package leetCode;

/* This Code is asking in the amazon interview and little bit tricky but its easy and */

public class AmazonInfiniteArray {
	public static void main(String[] args) {
		int[] a = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 1920, 21, 22, 23, 24, 25, 26, 27, 28,
				29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54,
				55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81,
				82, 83, 84, 85, 86, 87, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100 };

		int ans = searchAns(a, 10);
		// expected ans= 10 index
		System.out.println(ans);
	}

	static int searchAns(int[] arr, int target) {
		int start = 0;
		int end = 1;
		try {
			while (target > arr[end]) {
				int temp = end + 1;
				end = end + (end - start + 1) * 2;
				start = temp;
			}
		} catch (Exception e) {
			System.out.println("Fatching More Data From Server.... ");
		}
		return serch(arr, target, start, end);
	}

	static int serch(int[] nums, int target, int start, int end) {

		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] < target) {
				start = mid + 1;
			} else if (nums[mid] > target) {
				end = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
}