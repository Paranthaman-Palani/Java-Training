package assignment3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreading2 {

	public static void main(String[] args) {

		ExecutorService executeService = Executors.newFixedThreadPool(1);
		synchronized (AccessingThread.class) {
			executeService.execute(() -> {
				AccessingThread.display("[--------");
			});
		}
		synchronized (AccessingThread.class) {

			executeService.execute(() -> {
				AccessingThread.display("Message");
			});
		}
		synchronized (AccessingThread.class) {

			executeService.execute(() -> {
				AccessingThread.display("--------]");
			});
		}

		executeService.shutdown();

	}

}

class AccessingThread {
	static void display(String message) {

		System.out.print(message);

	}

}
