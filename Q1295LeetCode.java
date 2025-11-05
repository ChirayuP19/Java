package leetCode;

public class Q1295LeetCode {
	// https://leetcode.com/problems/find-numbers-with-even-number-of-digits/description/
	public static void main(String[] args) {
		int num[] = { 12, 345, 2, 6, 7896 };
		int ans = evenFind(num);
		System.out.println(ans);
		System.out.println(digits(401));
		System.out.println(digitUsingLog(258963));

	}

	static int evenFind(int[] a) {
		int count = 0;
		for (int i : a) {
			if (even(i)) {
				count++;
			}
		}
		return count;
	}

	// function check that array all element contains even digit or not
	static boolean even(int n) {
		int num = digits(n);
		if (num % 2 == 0) {
			return true;
		}
		return false;
	}

	// this method count total digit in the elements.
	static int digits(int num) {
		int count = 0;
		if (num == 0) {
			return 1;
		}
		while (num != 0) {
			count++;
			num /= 10;
		}

		return count;
	}

	static int digitUsingLog(int num) {
		return (int) (Math.log10(num) + 1);
	}

}
