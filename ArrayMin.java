package DSA;

public class ArrayMin {
	public static void main(String[] args) {
		int[] arr = { 10, 15, 47, 2, 63, 25, -41, 22, 3, 66, 58, 59, 21, 47, 32, 39, 25 };
		int ans = min(arr, 0, 15);
		System.out.println(ans);
	}

	static int min(int[] a, int start, int end) {

		int min = a[start];

		if (a.length == 0 || end > a.length) {
			return -1;
		}
		for (int i = start; i <= end; i++) {
			if (min > a[i]) {
				min = a[i];
			}
		}
		return min;
	}

}
