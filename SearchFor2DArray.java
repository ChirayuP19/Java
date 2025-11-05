package DSA;

public class SearchFor2DArray {
	public static void main(String[] args) {

		int[][] num = { { 9, 8, 47, 65 }, { 45, 63, 99, 88 }, { 21, 45 }, { 6, 30, 3 }, { 54, 259, 55 } };
		int ans = check(num);
		System.out.println(ans);
	}
	// how we search in 2D array.

	static int check(int[][] a) {
		if (a.length == 0) {
			return -1;
		}

		int max = a[0][0];
		for (int row = 0; row < a.length; row++) {
			for (int coloum = 0; coloum < a[row].length; coloum++) {
				if (a[row][coloum] > max) {
					max = a[row][coloum];
				}
			}
		}
		return max;
	}

}
