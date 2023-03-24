package assignment7;

import java.util.Scanner;

class CountCharacters{
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
	
		while(scanner.hasNext())
		{
			String a = scanner.nextLine();
			System.out.println(a.length());
		}
	
	}
}