package assignment7;

import java.io.*;

public class ByteByByteImageCopy {

	public static void main(String[] args) {
		final int EOF = -1;
		try (FileInputStream fileInputStream = new FileInputStream("Netaji.jpeg");
				FileOutputStream fileOutputStream = new FileOutputStream("copyNetaji.jpeg", true);) {
			int n = 0;
			byte imageArray[] = new byte[1024];
			while ((n = fileInputStream.read(imageArray)) != EOF) {
				fileOutputStream.write(imageArray, 0, n);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}