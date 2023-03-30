package assignment4;

import java.util.Scanner;

/**
 * @author paranthaman
 *
 */
class CommandPattern {
	public static void main(String[] args) {

		TubeLigth tubeLigth = new TubeLigth();
		NightLigth nigthLigth = new NightLigth();
		AC ac = new AC();
		Fan fan = new Fan();
		Windows window = new Windows();

		HomeAutomationRemote remote = new HomeAutomationRemote();

		remote.setCommand(1, new MorningTime(tubeLigth, nigthLigth, ac, fan, window));
		remote.setCommand(2, new NightTime(tubeLigth, nigthLigth, ac, fan, window));

		try (Scanner scanner = new Scanner(System.in)) {
			System.out.printf("Enter Buttons: \n1.Morning \n2.Night \n");
			int choice = scanner.nextInt();
			remote.executeCommand(choice);
		}
	}
}

class HomeAutomationRemote {
	Command command[] = new Command[3];

	public HomeAutomationRemote() {
		for (int i = 0; i < command.length; i++) {
			command[i] = new Command() {

				@Override
				public void execute() {
					// TODO Auto-generated method stub
					System.out.println("Please Enter Valid Buttons.....");

				}

			};
		}
	}

	public void setCommand(int i, Command executeCommand) {
		// TODO Auto-generated method stub

		command[i] = executeCommand;
	}

	public void executeCommand(int i) {
		// TODO Auto-generated method stub

		command[i].execute();
	}

}

abstract class Command {
	TubeLigth tubeLigth;
	NightLigth nightLigth;
	AC ac;
	Fan fan;
	Windows window;

	abstract void execute();

}

class MorningTime extends Command {

	public MorningTime(TubeLigth tubeLigth, NightLigth nigthLigth, AC ac, Fan fan, Windows window) {
		// TODO Auto-generated constructor stub
		this.tubeLigth = tubeLigth;
		this.nightLigth = nigthLigth;
		this.fan = fan;
		this.ac = ac;
		this.window = window;

	}

	@Override
	void execute() {
		// TODO Auto-generated method stub
		System.out.println("MorningTime Mode Initiated.......");
		tubeLigth.on();
		ac.off();
		window.open();
		fan.on();
		nightLigth.off();

	}

}

class NightTime extends Command {
	public NightTime(TubeLigth tubeLigth, NightLigth nigthLigth, AC ac, Fan fan, Windows window) {
		// TODO Auto-generated constructor stub
		this.tubeLigth = tubeLigth;
		this.nightLigth = nigthLigth;
		this.fan = fan;
		this.ac = ac;
		this.window = window;
	}

	@Override
	void execute() {
		// TODO Auto-generated method stub
		System.out.println("NigthTime Mode Initiated.......");
		tubeLigth.off();
		ac.on();
		window.close();
		fan.off();
		nightLigth.on();

	}

}

class TubeLigth {
	public void on() {
		System.out.println("TubeLigth On.......");
	}

	public void off() {
		System.out.println("TubeLiugth Off......");
	}
}

class NightLigth {
	public void on() {
		System.out.println("NigthLigth On.......");
	}

	public void off() {
		System.out.println("NigthLigth Off......");
	}

}

class AC {
	public void on() {
		System.out.println("AC On.......");
	}

	public void off() {
		System.out.println("AC Off......");
	}
}

class Fan {
	public void on() {
		System.out.println("Fan On.......");
	}

	public void off() {
		System.out.println("Fan Off......");
	}
}

class Windows {
	public void open() {
		System.out.println("Windows open.......");
	}

	public void close() {
		System.out.println("Windows Close......");
	}
}
