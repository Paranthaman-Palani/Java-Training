package assignment2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionEx7 {
	 public static void main(String[] args) throws Exception {
		 Scanner scanner  = new Scanner(System.in);
		 boolean flag = true;
		 int numerator = 0;
		 int divisor = 0;
		 while(flag) {
			 try {
				 numerator = scanner.nextInt();
				 divisor = scanner.nextInt();
				 
				 int result = numerator / divisor;
				 System.out.println(result);
			 }
			 catch (InputMismatchException e){
					 System.exit(0); 
			 }
			 catch (ArithmeticException ex) {
				 System.out.println("Divded by Zero");
			 }
			
		 }
		
	}
}
