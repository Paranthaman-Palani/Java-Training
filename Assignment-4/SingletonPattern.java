package assignment4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author paranthaman
 *
 */
public class SingletonPattern {
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(4);
		es.execute(() -> {
			MySingleton.getInstance();
		});
		es.execute(() -> {
			MySingleton.getInstance();
		});
		es.execute(() -> {
			MySingleton.getInstance();
		});
		es.execute(() -> {
			MySingleton.getInstance();
		});
		es.shutdown();

	}
}

class MySingleton {
	private static MySingleton object;

	private MySingleton() {
		System.out.println("Singleton Object is created");
	}

	synchronized public static MySingleton getInstance() {
		if (object == null) {
			object = new MySingleton();
		}
		return object;
	}
}