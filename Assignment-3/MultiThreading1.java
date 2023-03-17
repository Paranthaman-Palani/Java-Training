package assignment3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreading1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OddEvenExecution object = new OddEvenExecution();
		ExecutorService es = Executors.newFixedThreadPool(2);
		es.execute(() -> {
			object.oddNumbers();
		});

		es.execute(() -> {
			object.evenNumbers();
		});

		es.shutdown();
	}

}

class OddEvenExecution {

	synchronized public void oddNumbers() {
		// TODO Auto-generated method stub
		System.out.println("Odd Numbers:");
		for (int i = 1; i < 100; i = i + 2) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	synchronized public void evenNumbers() {
		// TODO Auto-generated method stub
		System.out.println("\nEven Numbers:");
		for (int i = 2; i < 100; i = i + 2) {
			System.out.print(i + " ");
		}
	}
}