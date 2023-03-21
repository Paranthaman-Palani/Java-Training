package assignment4;

public class Visitor{
	public static void main(String[] args) throws Exception {
		Birds g = new FlyingBirds("Kuruvi");
		MyCapabalites ability = new Flying();
		g.visit(ability);

	}
}

abstract class Birds {
	String name;
	public Birds(String name) {
		this.name = name;
	}
	public abstract void visit(MyCapabalites bt);
}

class FlyingBirds extends Birds {
	

	public FlyingBirds(String name) {
		super(name);
		
	}
	public void visit(MyCapabalites bt) {
		bt.whatIdo(this);
	}
}

class FligthLessBirds extends Birds {
	public FligthLessBirds(String name) {
		super(name);
	}
	public void visit(MyCapabalites bt) {
		bt.whatIdo(this);
	}

}

interface MyCapabalites {
	public abstract void whatIdo(Birds bird);
}

class Flying implements MyCapabalites {
	@Override
	public void whatIdo(Birds bird) {
		System.out.println("I Can Fly.......");
	}
}

class NonFlying implements MyCapabalites {
	@Override
	public void whatIdo(Birds bird) {
		System.out.println("I Can't Fly.......");
	}
}



