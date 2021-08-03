package ru.stqa.jvaprj.sandbox;

public class MyFirstProgram {
	public static void main(String[] args) {
		hello("world");
		hello("user");

		Square s = new Square(5);
		System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

		Rectangle r = new Rectangle(4,6);
		System.out.println("Площадь прямоугольника со сторонами " + r.a + " и "+ r.b + " = " + r.area());
		System.out.println("Разница между площадью квадрата со стороной "+ s.l +" и площадью прямоугольника со сторонами "+ r.a + " и " + r.b+ " = "+(s.area()-r.area()));

		Point p1 = new Point(18, 30);

		Point p2 = new Point(15, 25);

		System.out.println("Расстояние между точками: "+
				"точка 1: х: "+p1.x+", у: "+ p1.y+"; " +
				"точка 2: х: "+p2.x +", У: "+p2.y +" = "+distance(p1,p2));


		double x1=16;
		System.out.println("Корень квадратный из "+x1+" = "+sqrt(x1));


	}
	public static void hello(String somebody) {
		System.out.println("Hello, " + somebody + "!");

	}
	public static double sqrt(double x1) {
		return Math.sqrt(x1);
	}
	public static double distance(Point p1, Point p2){
		double d = (p2.x- p1.x);
		double k  = (p2.y-p1.y);
		return Math.sqrt((d*d)+(k*k));
	}
}