package assignment7;

import java.util.Scanner;

public class CountWords {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String inputString = scanner.nextLine();
		String word[] = inputString.split("\\s+");
		System.out.println(word.length);

	}
}
