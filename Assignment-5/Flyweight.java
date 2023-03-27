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
				String angrybirdColor = input.next();
				Color color = (Color) PaintFactory.getColor(angrybirdColor);
				color.fruitBasket();
			}
		}
	}
}

interface AngryBird {
	void fruitBasket();
}

class Color implements AngryBird {
	private String paintColor;

	public Color(String paintColor) {
		this.paintColor = paintColor;
	}
	public void fruitBasket() {
		System.out.println("Selected Angry Bird =" + paintColor);
	}
}

class PaintFactory {
	private static final HashMap<String, Color> colorMap = new HashMap<>();

	public static AngryBird getColor(String paintColor) {
		Color color = (Color) colorMap.get(paintColor);
		if (color == null) {
			color = new Color(paintColor);
			colorMap.put(paintColor, color);
			System.out.println("Angry Bird color : " + paintColor);
		}
		System.out.println("Angry Birds in Game= "+colorMap);
		return color;
	}

}
