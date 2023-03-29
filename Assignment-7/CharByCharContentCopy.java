package assignment7;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharByCharContentCopy {

    public static void main(String[] args) {
        // Define constant integer for end of file
        final int EOF = -1;
        try (
            // Create FileReader to read input file
            FileReader fileInput = new FileReader("Hello.txt");
            // Create FileWriter to write output file, with second argument set to true for append mode
            FileWriter fileOutput = new FileWriter("copyHello.txt", true);
        ) {
            int n = 0;
            char contentArray[] = new char[1];
            // Read input file character by character until end of file
            while ((n = fileInput.read(contentArray)) != EOF) {
                // Write character to output file
                fileOutput.write(contentArray, 0, n);
            }
        } catch (IOException e) {
            // Print stack trace of any IOException that occurs
            e.printStackTrace();
        }
    }

}
