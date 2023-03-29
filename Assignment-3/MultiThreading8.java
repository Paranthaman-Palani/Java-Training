package assignment3;

public class MultiThreading8 {

	public static void main(String[] args) {
		StringBuffer s = new StringBuffer("A");
		MyThreadClass a = new MyThreadClass(s);
		MyThreadClass b = new MyThreadClass(s);
		MyThreadClass c = new MyThreadClass(s);
		a.start();
		b.start();
		c.start();
	}

}

class MyThreadClass extends Thread {
	StringBuffer s;
     
	MyThreadClass(StringBuffer s) {
		this.s = s;
	}

	synchronized public void run() {
		for (int i = 1; i <= 100; i++) {
			System.out.print(s);
		}
		
		char c = s.charAt(0);

		s.setCharAt(0, ++c);

	}
}
