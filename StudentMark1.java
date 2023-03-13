package assignment1;
class student {
	String name = "Paranthaman";
	int RollNo = 1002;
}

class exam extends student{
	int mark1=100;
	int mark2=100;
	int mark3=100;
}


class result extends exam{
		int result = mark1+mark2+mark3;
}

public class StudentMark1 {
	public static void main(String[] args) {		
// Creating object for result class 
		result obj = new result();
		System.out.println("Hello "+obj.name+" "+obj.RollNo+" "+"You Have Scored"+" "+obj.result);
	}

}
