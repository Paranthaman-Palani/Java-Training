package assignment2;

public class ExceptionEx4 {

	public static void main(String[] args) {
		int firstValue = 5;
		int secondValue = 0;
		try {
			int result = firstValue / secondValue;
			System.out.println(result);
		} catch (ArithmeticException e) {
			e.printStackTrace();
		}

	}

}
