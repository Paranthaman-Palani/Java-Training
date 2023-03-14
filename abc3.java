package assignment1;

class A{
	A(){
		System.out.println("You are in A");
	}
}

class B{
	B(){
		System.out.println("You are in B");
	}
}

class C extends A{
	B object1 = new B();
}

public class  ABC3 {
	
	public static void main(String[] args) {
		C object2 = new C();
	}
}
