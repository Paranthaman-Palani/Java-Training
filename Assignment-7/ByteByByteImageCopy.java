package assignment7;

import java.io.*;

public class ByteByByteImageCopy {

    public static void main(String[] args) {
        // Define constant integer for end of file
        final int EOF = -1;
        try (
            // Create FileInputStream to read input image file
            FileInputStream fileInputStream = new FileInputStream("Netaji.jpeg");
            // Create FileOutputStream to write output image file, with second argument set to true for append mode
            FileOutputStream fileOutputStream = new FileOutputStream("copyNetaji.jpeg", true);
        ) {
            int n = 0;
            byte imageArray[] = new byte[1024];
            // Read input stream into byte array until end of file
            while ((n = fileInputStream.read(imageArray)) != EOF) {
                // Write byte array to output stream, starting at first byte and writing n bytes
                fileOutputStream.write(imageArray, 0, n);
            }
        } catch (IOException e) {
            // Print stack trace of any IOException that occurs
            e.printStackTrace();
        }
    }
}
