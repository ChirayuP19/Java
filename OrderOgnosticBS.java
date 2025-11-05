package DSA;

public class OrderOgnosticBS {
	public static void main(String[] args) {

//		int[] array = { -80, -77, -25, -1, 0, 1, 26, 65, 542, 5897, 6521, 7895, 8520, 8632, 9201, 9999 };
		int[] array = { 100, 98, 65, 32, 21, 15, 11, 10, 5, 3, 2, -5, -47, -999, -99999, -888888 };
		int ans = orderAgnosticBS(array, -99999);
		System.out.println(ans);
	}

	static int orderAgnosticBS(int[] a, int target) {
		int start = 0;
		int end = (a.length) - 1;

		// find that array is inn acceding order or descending order.

		boolean isAccending = a[start] < a[end];

		while (start <= end) {
			int m = start + (end - start) / 2;

			if (a[m] == target) {
				return m;
			}

			if (isAccending) {
				if (target < a[m]) {
					end = m - 1;
				} else {
					start = m + 1;
				}
			} else {
				if (target < a[m]) {
					start = m + 1;
				} else {
					end = m - 1;
				}
			}
		}
		return -1;
	}
}
