package assignment2;

class Sample1{
	public void mth1() {
		mth2();
		System.out.println("caller");
	}
	public void mth2() {
		try {
			System.exit(0);
		}
		catch(Exception e) {
			System.out.println("catch-mth2");
		}
		finally {
			System.out.println("finally-mth2");
		}
	}
}



public class ExceptionEx3 {

	public static void main(String[] args) {
		Sample1 s = new Sample1();
		s.mth1();
	}

}