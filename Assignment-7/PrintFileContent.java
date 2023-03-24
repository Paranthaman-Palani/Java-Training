package assignment7;

import java.io.File;
import java.util.Scanner;

public class PrintFileContent {
	public static void main(String[] args) throws Exception {

		File file = new File("Hello.txt");
		Scanner scanner = new Scanner(file);

		while (scanner.hasNextLine())
			System.out.println(scanner.nextLine());
	}
}