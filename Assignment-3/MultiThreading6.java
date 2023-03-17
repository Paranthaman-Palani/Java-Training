package assignment3;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreading6 {
	public static void main(String[] args) {
		CharacterChecking word = new CharacterChecking();
		ExecutorService es = Executors.newFixedThreadPool(1);
		Scanner scanner = new Scanner(System.in);
		String a = scanner.next();
		es.execute(() -> {
			try {

				for (int i = 0; i < a.length(); i++) {
					word.readCharacters(a.charAt(i));
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		es.shutdown();
	}
}

class CharacterChecking {
	synchronized public void readCharacters(char word) throws Exception {

		if (!(Character.isAlphabetic(word))) {
			throw new Exception("The character found is non-alphabetic charcater");

		} else {
			try {

				Thread.sleep(100);
			} catch (Exception e) {

			}
			System.out.println(word);
		}
	};

}