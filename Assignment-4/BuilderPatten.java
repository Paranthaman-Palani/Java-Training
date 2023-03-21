package assignment4;

/**
 * @author paranthaman
 *
 */

public class BuilderPatten {
	public static void main(String[] args) {
		College veltech = new College.AttendancePortal().studentLogin(new Student()).facultyLogin(null)
				.applicationStart();
	}
}

class College {
	Student student;
	Faculty faculty;

	public College(Student student, Faculty faculty) {
		this.student = student;
		this.faculty = faculty;
	}

	static class AttendancePortal {
		Student student;
		Faculty faculty;

		public AttendancePortal studentLogin(Student student) {
			this.student = student;
			return this;
		}

		public AttendancePortal facultyLogin(Faculty faculty) {
			this.faculty = faculty;
			return this;
		}

		public College applicationStart() {
			return new College(student, faculty);
		}
	}
}

class Student {
	public Student() {
		System.out.println("Student Logged in........");
	}
}

class Faculty {
	public Faculty() {
		System.out.println("Faculty Logged in........");
	}
}