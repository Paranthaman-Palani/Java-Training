package assignment4;

import java.util.Scanner;

public class VisitorPattern {
	public static void main(String[] args) throws Exception {
		Child baby = new Child();
		Dog tiger = new Dog();
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the item classname..:");
		String itemclass = scan.next();
		Item item = (Item) Class.forName(itemclass).newInstance();
		baby.playWithDog(tiger, item);
	}
}

class Dog {
	public Dog() {
		System.out.println("tiger is born....");
	}

	public void play(Item item) throws DogException {
		item.execute();
	}
}

abstract class Item {
	public abstract void execute() throws DogException;
}

class Stick extends Item {
	@Override
	public void execute() throws DogException {
		throw new DogBiteException("You beat I bite...");
	}
}

class Ball extends Item {
	@Override
	public void execute() throws DogException {
		throw new DogPlayException("you throw I catch....");
	}
}

class Stone extends Item {
	@Override
	public void execute() throws DogException {
		throw new DogBarkException("you throw I bark....");
	}
}

class Child {
	public Child() {
		System.out.println("the baby is born...");
	}

	public void playWithDog(Dog dog, Item item) {
		try {
			dog.play(item);
		} catch (DogException d) {
			d.printStackTrace();
			d.visit();
		}
	}
}

class Handler911 {
	public void handle(DogBiteException dbe) {
		System.out.println("take the child to hospital......ambulance on the way...");
	}

	public void handle(DogPlayException dpe) {
		System.out.println("enjoy........................");
	}

	public void handle(DogBarkException dpe) {
		System.out.println("dont throw stones...it will not bark........................");
	}
}

abstract class DogException extends Exception {
	String msg;

	public abstract void visit();
}

class DogBiteException extends DogException {

	public DogBiteException(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "Exception is..............:" + this.msg;
	}

	@Override
	public void visit() {
		new Handler911().handle(this);
	}
}

class DogPlayException extends DogException {
	public DogPlayException(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "Exception is..............:" + this.msg;
	}

	@Override
	public void visit() {
		new Handler911().handle(this);
	}
}

class DogBarkException extends DogException {
	public DogBarkException(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "Exception is..............:" + this.msg;
	}

	@Override
	public void visit() {
		new Handler911().handle(this);
	}
}