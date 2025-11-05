package leetCode;

public class OddFinder {
	public static void main(String[] args) {
		int[] a = { 5, 87, 65, 4125, 358, 963, 1, 256, 3, 36, 67, 95, 98, 91, 93 };
		int ans = checkOdd(a);
		System.out.println(ans);
	}

	static int checkOdd(int[] a) {
		int count = 0;
		for (int i : a) {
			if (isOdd(i)) {
				count++;
			}

		}
		return count;
	}

	/* In this we check that each element is Odd. */
	static boolean isOdd(int n) {
		int x = digit(n);
		if (x % 2 != 0) {
			return true;
		}
		return false;
	}

	/*
	 * here we are just counting digit that the elemet hsve how much total digit in
	 * the element.
	 */
	static int digit(int n) {
		int count = 0;
		while (n > 0) {
			n /= 10;
			count++;
		}
		return count;
	}
}
