package assignment2;
class Base{
	Base(){
		int a = 5, b = 0;
		int c = b / a;
	}
}
class Derived extends Base{
	Derived() throws Exception{
		System.out.println("Arithmetic Exception");
	}
}

public class ExceptionEx6 {
	public static void main(String[] args) throws Exception {
		Base b =  new Derived();	
	}

}
