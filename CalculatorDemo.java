package DSA;

import java.util.Scanner;

public class CalculatorDemo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to calculator");
		while (true) {
			System.out.println("Enter symbole or Press x to exit ");
			char ss = sc.next().trim().charAt(0);
			if (ss == '+' || ss == '-' || ss == '*' || ss == '/') {
				System.out.print("Enter numer one : ");
				int a = sc.nextInt();
				System.out.print("Enter numer Two : ");
				int b = sc.nextInt();

				if (ss == '+') {
					System.out.println(a + b);
				}
				if (ss == '-') {
					System.out.println(a - b);
				}
				if (ss == '*') {
					System.out.println(a * b);
				}
				if (ss == '/') {
					System.out.println(a / b);
				}
			}
			if (ss == 'x') {
				break;
			}

		}
		System.out.println("Thank You for Using..");
	}
}