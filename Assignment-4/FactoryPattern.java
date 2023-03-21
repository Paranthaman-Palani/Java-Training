package assignment4;

public class FactoryPattern {
	public static void main(String[] args) throws Exception {
		PhoneManufacturer phone = new PhoneManufacturer();
		MobileFactory google = new RedmiPhone();
		phone.setPhoneFactory(google);
		Mobile mobile = phone.getPhone();
		System.out.println(mobile);
	}
}

interface Manufacturer {
}

class PhoneManufacturer implements Manufacturer {
	private MobileFactory phoneFactory;
	private Mobile mobile;

	public void setPhoneFactory(MobileFactory phoneFactory) {
		this.phoneFactory = phoneFactory;
	}

	public Mobile getPhone() {
		this.mobile = phoneFactory.makePhone();
		return mobile;
	}
}

interface Factory {
}

abstract class MobileFactory implements Factory {
	public abstract Mobile makePhone();
}

class RealmePhone extends MobileFactory {
	

	public Realme makePhone() {
		return new Realme();
	}
}

class OnePlusPhone extends MobileFactory {

	public OnePlus makePhone() {
		return new OnePlus();
	}
}

class RedmiPhone extends MobileFactory {

	public Redmi makePhone() {
		return new Redmi();
	}
}

abstract class Mobile {
}

class Realme extends Mobile {
}

class OnePlus extends Mobile {
}

class Redmi extends Mobile {
}



