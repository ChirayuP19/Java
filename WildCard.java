package generics;

import java.util.ArrayList;

public class WildCard {
	public static void PrintList(ArrayList<?> list) {
		for (Object object : list) {
			System.out.println(object);
		}
	}

	public static void main(String[] args) {
		ArrayList<Integer> numbersArrayList = new ArrayList<>();
		numbersArrayList.add(87);
		numbersArrayList.add(1504);

		ArrayList<String> nameStrings = new ArrayList<>();
		nameStrings.add("chirayu");
		nameStrings.add("Kavya Birthday");

		PrintList(numbersArrayList);
		PrintList(nameStrings);

	}
}
