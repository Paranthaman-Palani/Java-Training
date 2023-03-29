package assignment7;

import java.io.File;

public class ListFilesAndDirectories {
	public static void main(String[] args) {
		try {
			// Creating a File object with the specified directory path
			File myPath = new File("/Users/paranthaman");
			
			// Getting an array of file names and directory names in the specified directory
			String[] filesAndDirectories = myPath.list();
			
			// Looping through the array and printing each file/directory name
			for (String path : filesAndDirectories) {
				System.out.println(path);
			}
		} catch (Exception e) {
			// Catching any exception that might occur and printing an error message
			System.out.println("Error occurred: " + e.getMessage());
		}
	}
}
