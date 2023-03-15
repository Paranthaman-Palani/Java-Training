package assignment2;

import java.util.Scanner;

public class ExceptionEx8 {
	public static void main(String[] arg) {
		int mark, sum = 0;
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Enter any valid Integer: ");
			try {
				for(int i = 0;i < 10;i++) {
					mark = Integer.parseInt(scanner.next());
					sum += mark;
				}
				System.out.println("Average is: " + sum / 10);
				break;
			} 

			catch (NumberFormatException e) {
				System.out.println("NumberFormatException occurred");
			}
		}
	}
}
