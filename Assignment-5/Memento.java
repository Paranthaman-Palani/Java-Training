package assignment5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Memento {
	public static void main(String[] args) throws Exception {
		MemoryFile file = new MemoryFile();
		System.out.println("the size of File.." + file.size);

		ObjectOutputStream firstDestination = new ObjectOutputStream(new FileOutputStream("memoryFile.txt"));

		firstDestination.writeObject(file);
		file.size = 5;
		System.out.println("the size of File..:" + file.size);
		System.out.println("To restore the old File...");

		ObjectInputStream secondDestionation = new ObjectInputStream(new FileInputStream("memoryFile.txt"));
		file = (MemoryFile) secondDestionation.readObject();
		System.out.println("back in time...File size..:" + file.size);

	}
}

class MemoryFile implements Serializable {
	int size = 10;
}
