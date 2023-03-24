package assignment5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Flyweight {
	public static void main(String[] args) {
		try (Scanner input = new Scanner(System.in)) {
			List<String> fruitBasket = Arrays.asList("Apple", "Mango", "Bannan", "Grapes");
			System.out.println(fruitBasket);
			while (true) {
				System.out.println("Take Fruits:");
				String paintColor = input.next();
				ColorBrush colorBrush = (ColorBrush) PaintFactory.getColor(paintColor);
				colorBrush.fruitBasket();
			}
		}
	}
}

interface Brush {
	void fruitBasket();
}

class ColorBrush implements Brush {
	private String paintColor;

	public ColorBrush(String paintColor) {
		this.paintColor = paintColor;
	}
	public void fruitBasket() {
		System.out.println("Picked Fruit =" + paintColor);
	}
}

class PaintFactory {
	private static final HashMap<String, ColorBrush> colorMap = new HashMap<>();

	public static Brush getColor(String paintColor) {
		ColorBrush colorBrush = (ColorBrush) colorMap.get(paintColor);
		if (colorBrush == null) {
			colorBrush = new ColorBrush(paintColor);
			colorMap.put(paintColor, colorBrush);
			System.out.println("Taken Fruit : " + paintColor);
		}
		System.out.println("Fruits Basket = "+colorMap);
		return colorBrush;
	}

}
