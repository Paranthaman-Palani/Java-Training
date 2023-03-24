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
		
		ObjectOutputStream output1 = new ObjectOutputStream(new FileOutputStream("memoryFile.txt"));
		
		
		output1.writeObject(file);
		file.size = 5;
		System.out.println("the size of File..:" + file.size);
		System.out.println("To restore the old File...");
		
		ObjectInputStream output2 = new ObjectInputStream(new FileInputStream("memoryFile.txt"));
		file = (MemoryFile) output2.readObject();
		System.out.println("back in time...File size..:" + file.size);
		
		output2 = new ObjectInputStream(new FileInputStream("memoryFile.txt"));
		MemoryFile laddu2 = (MemoryFile) output2.readObject();
		System.out.println(laddu2.size);
	}
}

class MemoryFile implements Serializable {
	int size = 10;
}
