package DSA;
import java.util.Scanner;

public class PrimeNumberChecker {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("********Welcome ***********");
		System.out.println("Kavya Please Enter Nuber");
		int a = sc.nextInt();
		System.out.println("Enter to find repeting ");
		int check = sc.nextInt();
		int reverseNum = 0;
		int count = 0;
		System.out.println(a);
		while (a > 0) {
			int digit = a % 10;
			reverseNum = reverseNum * 10 + digit;
			while (digit == check) {
				count++;
				break;
			}
			a /= 10;
		}
		System.out.println("Reverse is " + reverseNum);
		System.out.println(check + " come" + count + " in this number");
	}
}
