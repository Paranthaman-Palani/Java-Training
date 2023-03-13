package assignment1;
import java.util.Scanner;
public class PrimeNumberRange6A {
	
	public class primeNo {
		
		static boolean isPrime(int n) {
			if(n==1 || n==0) {
				return false;
			}
			else {
				for(int i=2;i<=n/2;i++) {
					if(n%i==0) {
						return false;
					}
				}
			}
			return true;
		}	
		
	public static void main(String[]args) {
		Scanner sc  = new Scanner(System.in);
		int start = sc.nextInt();
		int end = sc.nextInt();
		for(int i=start;i<=end;i++) {
		if(isPrime(i)) {
			System.out.print(i+" ");
		}
		
	      }

      }
	}

}