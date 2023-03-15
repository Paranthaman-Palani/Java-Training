package assignment1;

class Student {
	String name = "Paranthaman";
	int RollNo = 1002;
}

class Exam extends Student {
	int mark1 = 100;
	int mark2 = 100;
	int mark3 = 100;
}

class Result extends Exam {
		int total = mark1 + mark2 + mark3;
}

public class StudentMark1 {
	public static void main(String[] args) {		
// Creating object for result class 
		Result result = new Result();
		System.out.println("Hello "+ result.name + " " + result.RollNo + " "+ "You Have Scored" + " " + result.total);
	}

}
