package assignment7;

import java.io.File;
import java.util.Scanner;

public class PrintFileContent {
	public static void main(String[] args) throws Exception {
		// Creating a File object to represent the file
		File file = new File("Hello.txt");
		
		// Using try-with-resources to auto-close Scanner
		try (Scanner scanner = new Scanner(file)) {
			// Looping through each line of the file and printing it
			while (scanner.hasNextLine())
				System.out.println(scanner.nextLine());
		}
	}
}