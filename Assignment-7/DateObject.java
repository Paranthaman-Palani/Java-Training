package assignment7;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

public class DateObject {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		try(ObjectOutputStream outputStream =new ObjectOutputStream(new FileOutputStream("dateStore.txt"))){
			Date date=new Date();
			outputStream.writeObject(date);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		try(ObjectInputStream inputStream =new ObjectInputStream(new FileInputStream("dateStore.txt"))){
			Date date=(Date)inputStream.readObject();
			System.out.println(date);
			}catch(Exception e) {
				e.printStackTrace();
			
			
		}
	}

}