package generics;

import java.util.ArrayList;

public class IntergerPrinter {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("Kavya Good MOrning ");
		list.add("hy from my side are you ok ? ");

		for (String e : list) {
			System.out.println(e.toUpperCase());
		}
	}
}
