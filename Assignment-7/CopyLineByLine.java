package assignment7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CopyLineByLine {

    public static void main(String[] args) {
        // Create a scanner object outside the try block so it can be closed in the finally block
        Scanner scanner = null;
        
        try {
            // Create a new Scanner object to read the file
            scanner = new Scanner(new File("Hello.txt"));
            
            // While there are still more lines to read in the file
            while (scanner.hasNextLine()) {
                // Print the next line to the console
                System.out.println(scanner.nextLine());
            }
        } 
        // If the file is not found, print the stack trace to the console
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } 
        // Close the scanner in the finally block to free up system resources
        finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
