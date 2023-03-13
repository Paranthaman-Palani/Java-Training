package assignment1;
import java.util.Scanner;

public class areaVolumeCalcualte {

	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		
		System.out.printf("Enter Your Choice: \n 1.Square \n 2.Circle \n 3.Triangle \n 4.Sphere \n 5.Cuboid" );
		int n = sc.nextInt();

		switch(n) {
		
		case 1:
			System.out.println("Enter the side value: \n");
			int a  = sc.nextInt();
			CalcArea sa = new shapes();
			System.out.println("Area of Square : "+sa.squareArea(a));
			break;
			
		case 2:
			System.out.println("Enter the Radius value: \n");
			double r  = sc.nextDouble();
			CalcArea ca = new shapes();
			System.out.println(ca.circleArea(r));
			break;
			
		case 3:
			System.out.println("Enter the base & height value of Traingle: \n");
			int b  = sc.nextInt();
			int h  = sc.nextInt();
			CalcArea ta = new shapes();
			System.out.println(ta.triangleArea(b,h));
			break;
			
		case 4:
			System.out.println("Enter the Radius value of Sphere: \n");
			Double sr  = sc.nextDouble();
			CalcVolume sha = new shapes();
			System.out.println("Volume of Sphere : "+sha.sphereVolume(sr));
			break;
		
		case 5:
			System.out.println("Enter the side value of cuboid: \n");
		    int side  = sc.nextInt();
			CalcVolume cua = new shapes();
			System.out.println("Volume of Square : "+cua.cuboidVolume(side));
			break;
		
		}
		
		

	}

}



interface CalcArea{
	public int squareArea(int a);
	public double circleArea(double r);
	public int triangleArea(int b,int h);
	
}
interface CalcVolume{

	public double sphereVolume(double r);
	public int cuboidVolume(int a);
	
}


  class shapes implements CalcArea,CalcVolume{
	@Override
	public int squareArea(int a){
	
		return a*a;
	}

	@Override
	public double circleArea(double r) {
		// TODO Auto-generated method stub
		return 3.14*r*r;
	}

	@Override
	public int triangleArea(int b, int h) {
		// TODO Auto-generated method stub
		return 1/2*b*h;
	}

	@Override
	public double sphereVolume(double r) {
		// TODO Auto-generated method stub
		return (4/3)*3.14*r*r*r;
	}

	@Override
	public int cuboidVolume(int a) {
		// TODO Auto-generated method stub
		return a*a*a;
	}
	
  }

