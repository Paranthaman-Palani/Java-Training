package assignment7;

import java.util.Scanner;

public class CountWords {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Read the input string from the console
            String inputString = scanner.nextLine();
            
            // Split the input string into an array of words using the whitespace as a delimiter
            String[] words = inputString.split("\\s+");
            
            // Print the number of words to the console
            System.out.println("The number of words is: " + words.length);
        } 
        // If there is an error with the scanner, print the stack trace to the console
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
