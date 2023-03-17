package assignment3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreading3 {
	public static void main(String[] args) {
		Inventory store = new Inventory();

		ExecutorService es = Executors.newFixedThreadPool(2);

		es.execute(() -> {
			Thread.currentThread().setName("Producer");
			synchronized (store) {
				store.add();
			}
		});

		es.execute(() -> {
			Thread.currentThread().setName("Consumer");
			synchronized (store) {
				store.take();
			}
		});

	}
}

class Inventory {
	boolean flag;

	synchronized public void add() {
		if (flag) {
			try {
				wait();
			} catch (Exception e) {
			}
		}
		System.out.println("Add One Product in Inventroy....");
		flag = true;
		notify();
	}

	synchronized public void take() {
		if (!flag) {
			try {
				wait();
			} catch (Exception e) {
			}
		}
		System.out.println("Take One Product form Inventory...");
		flag = false;
		notify();
	}

}