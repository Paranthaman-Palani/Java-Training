package assignment1;
import java.util.Scanner;

public class CheckingNumberType6B {
	
	static boolean isArmstrongNumber(int n) {
		int m  = n;
		int temp = 0;
		
		while(n > 0) {
			int r = n % 10;
			temp=temp + (r * r * r);
			n /= 10;
		}
		
		return temp == m;
		
	}
	
	static boolean isPerfectNumber(int n) {
		
		int m = n;
		
		int temp = 0;
		int i = 1;
		while(i <= n / 2) {
			if(n%i == 0) {
				temp+=i;
			}
			i++;	
		}
		return temp==m;
	}

	static boolean isPalindroimeNumber(int n) {
		int m  = n;
		int temp=0;
		
		while(n > 0) {
			int r = n % 10;
			temp=(temp * 10) + r;
			n/=10;
		}
		
		return temp==m;
	}
	
		
	public static void main(String[] args) {	
			Scanner scanner  = new Scanner(System.in);
			System.out.println("Enter a Number: ");
			int a = scanner.nextInt();
			System.out.printf("Enter Your Choice to check \n 1.Astrong Number \n 2.Prefect Number \n 3.Palindrome Number \n");
			int choice = scanner.nextInt();
			
			switch(choice) {
				case 1: 
						if(isArmstrongNumber(a)) {
							System.out.println(a + " is an ArmStrong Number");
						}
						else {
							System.out.println(a + " is not an ArmStrong Number");
						}
						break;
				case 2: 
						if(isPerfectNumber(a)) {
							System.out.println(a + " is an Perfect Number");
						}
						else {
							System.out.println(a + " is not an Perfect Number");
						}
						break;
				case 3: 
						if(isPalindroimeNumber(a)) {
							System.out.println(a + " is an Palindrome Number");
						}
						else {
							System.out.println(a + " is not an Palindrome Number");
						
						}
						break;
				
			}
			
	}
}
