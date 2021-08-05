package ru.stqa.jvaprj.sandbox;

import java.sql.SQLOutput;

public class MyFirstProgram {
	public static void main(String[] args) {
		hello("world");
		hello("user");


		double l = 5;
		System.out.println("Площадь квадрата со стороной " + l + " = " + area(l));


		double a = 4;
		double b = 6;
		System.out.println("Площадь прямоугольника со сторонами " + a + " и "+ b + " = " + area(a, b));
		System.out.println("Разница между площадью квадрата со стороной "+ l +" и площадью прямоугольника со сторонами "+ a + " и " + b+ " = "+(area(l)-area(a,b)));


	}
	public static void hello(String somebody) {
		System.out.println("Hello, " + somebody + "!");

	}
	public static double area (double l) {
		return l*l;
	}
	public static double area (double a, double b){
		return a*b;
	}

}