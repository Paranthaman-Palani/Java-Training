package assignment7;

import java.io.File;
import java.util.Scanner;

public class FileAssignment {
	public static void main(String[] args) throws Exception {
		FileOperations fileOperations = new FileOperations();
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		fileOperations.operation = (Operations) Class.forName("assignment7." + str).newInstance();

		fileOperations.getAction().action();

	}

}

class FileOperations {

	Operations operation;

	public Operations getAction() {
		return operation;
	}
}

abstract class Operations {
	Scanner sc = new Scanner(System.in);
	String fileName = sc.nextLine();
	File file = new File(fileName + ".txt");

	abstract void action();
}

class DeletFile extends Operations {

	public void action() {
		if (file.exists()) {
			file.delete();
		} else {
			System.out.println("File Not Found..");
		}
	}
}

class RenameFile extends Operations {

	public void action() {

		if (file.exists()) {
			String fileNewName = sc.nextLine();
			File file2 = new File(fileNewName + ".txt");
			file.renameTo(file2);
		} else {
			System.out.println("File Not Found..");
		}

	}
}

class FindFileSize extends Operations {

	public void action() {
		if (file.exists()) {
			System.out.println(file.length());
		} else {
			System.out.println("File Not Found..");
		}
	}
}
