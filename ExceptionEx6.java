package assignment2;

class Base {
	Base() {
		int a = 5, b = 0;
		int c = a / b;
	}
}

class Derived extends Base {
	Derived() throws Exception {
		System.out.println("Arithmetic Exception");
	}
}

public class ExceptionEx6 {
	public static void main(String[] args) throws Exception {
		Derived base = new Derived();
	}

}
