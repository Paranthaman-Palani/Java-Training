package assignment1;
import java.util.Scanner;

public class AreaVolumeCalcualtion{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.printf("Enter Your Choice: \n 1.Square \n 2.Circle \n 3.Triangle \n 4.Sphere \n 5.Cuboid" );
		int choice = scanner.nextInt();
		switch(choice) {
			case 1:
				System.out.println("Enter the side value: \n");
				int side = scanner.nextInt();
				CalcArea square = new Square();
				System.out.println("Area of Square : "+square.area(side));
				break;
				
			case 2:
				System.out.println("Enter the Radius value: \n");
				int radius  = scanner.nextInt();
				CalcArea circle = new Circle();
				System.out.println(circle.area(radius));
				break;
				
			case 3:
				System.out.println("Enter the base & height value of Traingle: \n");
				int breath  = scanner.nextInt();
				int height  = scanner.nextInt();
				TriangleShape triangle = new Triangle();
				System.out.println(triangle.area(breath,height));
				break;
				
			case 4:
				System.out.println("Enter the Radius value of Sphere: \n");
				radius = scanner.nextInt();
				CalcVolume sphere = new Sphere();
				System.out.println("Volume of Sphere : "+sphere.volume(radius));
				break;
			
			case 5:
				System.out.println("Enter the side value of cuboid: \n");
			    side  = scanner.nextInt();
				CalcVolume cuboid = new Cuboid();
				System.out.println("Volume of Square : "+cuboid.volume(side));
				break;
		}
	}
}

interface CalcArea{
	int area(int side);
	
}
interface CalcVolume{
	int volume(int side);
}
interface TriangleShape{
	int area(int breath, int height);
}

class Circle implements CalcArea{
	@Override
	public int area(int side) {
		return (int) (3.14 * side * side);
	}
}
class Square implements CalcArea{
	@Override
	public int area(int side) {
		return (side * side);
	}	
}
class Triangle implements TriangleShape{

	@Override
	public int area(int breath, int height) {
		return (int)(0.5 * breath * height);
	}
}
class Sphere implements CalcVolume{
	@Override
	public int volume(int side) {
		return (int)((4/3) * 3.14 * side * side * side);
	}
}
class Cuboid implements CalcVolume{
	@Override
	public int volume(int side) {
		return side * side * side;
	}
}






