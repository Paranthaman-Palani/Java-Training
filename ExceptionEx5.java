package assignment2;

public class ExceptionEx5 {
	
	public static void main(String[] args) throws Exception {
		 int firstValue = 5;
		 int secondValue =0;
		 try {
			 int result = firstValue/secondValue;
			 System.out.println(result);
		 }
		 finally {
			 System.out.println("Done Execption");
		 }
		
	}

}
