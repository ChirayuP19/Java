package leetCode;

public class Q1672LeetCode {
	public static void main(String[] args) {
		int[][] account = { { 2, 8, 7, 80 }, { 98, 7, 1, 3 } };
		int ans = maxWealth(account);
		System.out.println(ans);
	}

	static int maxWealth(int a[][]) {

		// person is row and
		// Wealth is coloum.
		int max = 0; // assume max [0,0,0]numbe is zero
		for (int[] element : a) {
			int sum = 0;
			for (int element2 : element) {
				sum += element2;
			}

			// when you come here when you come here we have account here and overall answer
			// is ;

			if (sum > max) {
				max = sum;
			}
		}
		return max;
	}
}

/*
 * public class Q1672LeetCode { public static void main(String[] args) {
 * 
 * int[][] account = { { 1, 5 }, { 7, 3 }, { 3, 9 } };
 * System.out.println(count(account)); }
 * 
 * static int count(int a[][]) { int max = 0; for (int i = 0; i < a.length; i++)
 * { int balance = 0; for (int j = 0; j < a[i].length; j++) { balance +=
 * a[i][j]; if (balance > max) { max = balance; } } } return max; }
 * 
 * }
 */