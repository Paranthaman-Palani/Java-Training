package assignment2;

class SampleTryCatch {
	public void mth1() {
		mth2();
		System.out.println("caller");
	}

	public void mth2() {
		try {
			// int c = 6/0;
			// System.out.println(c);
			return;
		} catch (Exception e) {
			System.out.println("catch-mth2");
		} finally {
			System.out.println("finally-mth2");
		}
	}
}

public class ExceptionEx2 {

	public static void main(String[] args) {
		SampleTryCatch sample = new SampleTryCatch();
		sample.mth1();
	}

}
