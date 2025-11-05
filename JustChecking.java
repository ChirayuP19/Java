package DSA;

public class JustChecking {
	public static void main(String[] args) {
		int[][] account = { { 9, 88, 64, 65, 6 }, { 99, 46, 46 }, { 55, 1, 44 }, { 99, 46, 66, 65, 56 }

		};

		int ans = maxValue(account);
		System.out.println(ans);
	}

	static int maxValue(int[][] a) {
		int max = 0;
		int row = -1;
		int i = 0;
		for (int[] x : a) {
			int sum = 0;

			for (int element : x) {
				sum += element;
			}
			if (sum > max) {
				max = sum;
				row = i;
			}

			i++;
		}

		System.out.println(row);
		return max;
	}

}
