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
				color.angryBirdGame();
			}
		}
	}
}

interface AngryBird {
	void angryBirdGame();
}

class Color implements AngryBird {
	private String angryBirdColor;

	public Color(String angryBirdColor) {
		this.angryBirdColor = angryBirdColor;
	}
	public void angryBirdGame() {
		System.out.println("Selected Angry Bird =" + angryBirdColor);
	}
}

class PaintFactory {
	private static final HashMap<String, Color> colorMap = new HashMap<>();

	public static AngryBird getColor(String angryBirdColor) {
		Color color = (Color) colorMap.get(angryBirdColor);
		if (color == null) {
			color = new Color(angryBirdColor);
			colorMap.put(angryBirdColor, color);
			System.out.println("Angry Bird color : " + angryBirdColor);
		}
		System.out.println("Angry Birds in Game= "+colorMap);
		return color;
	}

}
