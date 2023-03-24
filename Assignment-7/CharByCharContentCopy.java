package assignment7;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharByCharContentCopy {

	public static void main(String[] args) {
		final int EOF = -1;
		try (FileReader fileInput = new FileReader("Hello.txt");
				FileWriter fileOutput = new FileWriter("copyHello.txt", true);) {
			int n = 0;
			char contentArray[] = new char[1];
			while ((n = fileInput.read(contentArray)) != EOF) {
				fileOutput.write(contentArray, 0, n);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
