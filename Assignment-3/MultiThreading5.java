package assignment3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreading5 {
	public static void main(String[] args) {

		Thread thread = new Thread(() -> {
			System.out.print("Hello");
		});

		thread.start();
		thread.start();

	}
}
