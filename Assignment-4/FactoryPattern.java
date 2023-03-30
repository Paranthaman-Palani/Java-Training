package assignment4;

public class FactoryPattern {
	public static void main(String[] args) throws Exception {
		PhoneManufacturer redmi = new PhoneManufacturer();
		OSFactory osFactory = new AndroidOSFactory();
		redmi.setOSFactory(osFactory);
		OS os = redmi.getOS();
		System.out.println(os);
	}
}


class PhoneManufacturer {
	private OSFactory osFactory;
	private OS os;

	public void setOSFactory(OSFactory osFactory) {
		this.osFactory = osFactory;
	}

	public OS getOS() {
		this.os = osFactory.makeOS();
		return os;
	}
}



abstract class OSFactory {
	public abstract OS makeOS();
}

class iOSFactory extends OSFactory {
	iOSFactory() {
	}

	public iOS makeOS() {
		return new iOS();
	}
}

class AndroidOSFactory extends OSFactory {
	public AndroidOSFactory() {
	}

	public AndroidOS makeOS() {
		return new AndroidOS();
	}
}

class WindowsOSFactory extends OSFactory {
	public WindowsOSFactory() {
	}

	public WindowsOS makeOS() {
		return new WindowsOS();
	}
}


abstract class OS {
}

class iOS extends OS {
}

class AndroidOS extends OS {
}

class WindowsOS extends OS {
}


