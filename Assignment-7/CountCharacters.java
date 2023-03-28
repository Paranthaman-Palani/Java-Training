package assignment7;

import java.util.Scanner;

class CountCharacters {
    public static void main(String[] args) {
        // Create a scanner object to read input from the console
        try (Scanner scanner = new Scanner(System.in)) {
            // While there is more input to read from the console
            while (scanner.hasNext()) {
                // Read the next line of input from the console
                String word = scanner.nextLine();
                
                // Print the length of the line to the console
                System.out.println(word.length());
            }
        }
        // If there is an error with the scanner, print the stack trace to the console
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
