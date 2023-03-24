package assignment7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CopyLineByLine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner scanner = new Scanner(new File("Hello.txt"));
			while (scanner.hasNextLine()) {
				System.out.println(scanner.nextLine());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
