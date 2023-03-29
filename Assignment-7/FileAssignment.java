package assignment7;

import java.io.File;
import java.util.Scanner;

public class FileAssignment {
	public static void main(String[] args) throws Exception {
		FileOperations fileOperations = new FileOperations();
		
		// Create a Scanner object to get input from the user
		try (Scanner sc = new Scanner(System.in)) {
			// Get the operation that the user wants to perform
			String str = sc.nextLine();
			// Create an instance of the specified operation using reflection
			fileOperations.operation = (Operations) Class.forName("assignment7." + str).newInstance();
		}
		
		// Perform the specified operation
		fileOperations.getAction().action();

	}

}

class FileOperations {

	Operations operation;

	public Operations getAction() {
		return operation;
	}
}

// Abstract class for different file operations
abstract class Operations {
	Scanner sc = new Scanner(System.in);
	
	// Get the filename from the user
	String fileName = sc.nextLine();
	// Create a File object with the given filename
	File file = new File(fileName + ".txt");

	// Abstract method for performing file operation
	abstract void action();
}

// Class for deleting a file
class DeletFile extends Operations {

	public void action() {
		// Check if the file exists
		if (file.exists()) {
			// Delete the file
			file.delete();
		} else {
			System.out.println("File Not Found..");
		}
	}
}

// Class for renaming a file
class RenameFile extends Operations {

	public void action() {

		// Check if the file exists
		if (file.exists()) {
			// Get the new filename from the user
			String fileNewName = sc.nextLine();
			// Create a new File object with the new filename
			File file2 = new File(fileNewName + ".txt");
			// Rename the file
			file.renameTo(file2);
		} else {
			System.out.println("File Not Found..");
		}

	}
}

// Class for finding the size of a file
class FindFileSize extends Operations {

	public void action() {
		// Check if the file exists
		if (file.exists()) {
			// Print the size of the file
			System.out.println(file.length());
		} else {
			System.out.println("File Not Found..");
		}
	}
}
