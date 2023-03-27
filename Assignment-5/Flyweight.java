package assignment5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Flyweight {
	public static void main(String[] args) {
		try (Scanner input = new Scanner(System.in)) {
			List<String> angryBird = Arrays.asList("blue", "green", "red", "yellow");
			System.out.println(angryBird);
			while (true) {
				System.out.println("Select A AngryBird:");
				String paintColor = input.next();
				ColorBrush colorBrush = (ColorBrush) PaintFactory.getColor(paintColor);
				colorBrush.fruitBasket();
			}
		}
	}
}

interface AngryBird {
	void fruitBasket();
}

class ColorBrush implements AngryBird {
	private String paintColor;

	public ColorBrush(String paintColor) {
		this.paintColor = paintColor;
	}
	public void fruitBasket() {
		System.out.println("Selected Angry Bird =" + paintColor);
	}
}

class PaintFactory {
	private static final HashMap<String, ColorBrush> colorMap = new HashMap<>();

	public static AngryBird getColor(String paintColor) {
		ColorBrush colorBrush = (ColorBrush) colorMap.get(paintColor);
		if (colorBrush == null) {
			colorBrush = new ColorBrush(paintColor);
			colorMap.put(paintColor, colorBrush);
			System.out.println("Angry Bird color : " + paintColor);
		}
		System.out.println("Angry Birds in Game= "+colorMap);
		return colorBrush;
	}

}
