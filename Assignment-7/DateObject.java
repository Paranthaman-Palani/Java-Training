package assignment7;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

public class DateObject {
    public static void main(String[] args) {
        // Try to write the date object to a file
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("dateStore.txt"))) {
            // Create a new date object
            Date date = new Date();
            
            // Write the date object to the file
            outputStream.writeObject(date);
        } 
        // If there is an error with the output stream, print the stack trace to the console
        catch (Exception e) {
            e.printStackTrace();
        }
        
        // Try to read the date object from the file
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("dateStore.txt"))) {
            // Read the date object from the file
            Date date = (Date)inputStream.readObject();
            
            // Print the date to the console
            System.out.println(date);
        } 
        // If there is an error with the input stream, print the stack trace to the console
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
