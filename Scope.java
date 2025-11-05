package DSA;

import java.util.Scanner;

public class Scope {

	public static void main(String[] args) {
		number();
	}

	static void number() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Software..");
		int i = sc.nextInt();
		int sum = 0;
		int original = i;
		int cube = 0;

		while (i > 0) {
			int digit = i % 10;
			cube = digit * digit * digit;
			sum += cube;
			i /= 10;
		}

		if (sum == original) {
			System.out.println("number is Armstrong number ");
		} else {
			System.out.println("Number is not Amstrong number ");
		}
	}
}
