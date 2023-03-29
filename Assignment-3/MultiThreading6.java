package assignment3;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreading6 {
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(1);
		Scanner scanner = new Scanner(System.in);

		es.execute(() -> {
			while (true) {
				char a = scanner.next().charAt(0);
				try {
					CharacterChecking.readCharacter(a);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		es.shutdown();
	
	}
}

class CharacterChecking {
	public static void readCharacter(char word) throws Exception {

		if (!(Character.isAlphabetic(word))) {
			throw new Exception("The character found is non-alphabetic charcater");

		} else {
			System.out.println(word);
		}
	};

}