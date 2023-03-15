package assignment1;
import java.util.Arrays;

public class PassByValAndRef7 {
	
	static int passByValue(int n) {
		n = 6;
		return n;
	}
	
	static int[] passByReference(int a[]) {
		a[2] = 9;
		return a;
	}

	public static void main(String[] args) {
		int a = 5;
		System.out.println(a);
		System.out.println(passByValue(a));

		int arr[]= {1,2,3,4,5};
	    System.out.println(Arrays.toString(arr));
	    
	    passByReference(arr);

		System.out.println(Arrays.toString(arr));
	}

}
