package assignment3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreading7 {
	public static void main(String[] args) {
		Counting count = new Counting();
		ExecutorService es = Executors.newFixedThreadPool(2);
		es.execute(() -> {
			try {
				count.counter();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		es.execute(() -> {
			try {
				count.message();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		es.shutdown();

	}
}

class Counting {
	public void counter() throws InterruptedException {
		for (int i = 1; i <= 100; i++) {
			System.out.println(i);
			Thread.sleep(1000);
			
		}
	}
	public void message() throws InterruptedException {
		for (int i = 1; i <= 10; i++) {
			
			Thread.sleep(10000);
			
				System.out.println("Hello World");
		}
	}
}