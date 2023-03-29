package assignment3;

public class MultiThreading5 {
	public static void main(String[] args) {

		Thread thread = new Thread(() -> {
			System.out.print("Hello");
		});

		thread.start();
		thread.start();

	}
}
