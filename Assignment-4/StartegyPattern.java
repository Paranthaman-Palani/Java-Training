package assignment4;

import java.util.Scanner;

/**
 * @author paranthaman
 *
 */
public class StartegyPattern {

	public static void main(String[] args) throws Exception {
		try (Scanner scanner = new Scanner(System.in)) {
			String input = scanner.next();
			Shop shop = new Shop();
			shop.counter = (CashCounter) Class.forName("assignment4." + input).getConstructor().newInstance();
			shop.getBill().paymentOption();
		}
	}
}

class Shop {
	CashCounter counter;

	public CashCounter getBill() {
		return counter;
	}
}

abstract class CashCounter {
	abstract void paymentOption();
}

class DebitCard extends CashCounter {
	public DebitCard() {
		// TODO Auto-generated constructor stub
	}

	@Override
	void paymentOption() {
		System.out.println("Payment Method : Debit Card");
	}

}

class CreditCard extends CashCounter {
	public CreditCard() {
		// TODO Auto-generated constructor stub
	}

	@Override
	void paymentOption() {
		System.out.println("Payment Method : Credit Card");

	}
}
