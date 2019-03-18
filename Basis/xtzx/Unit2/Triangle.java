package Java02;

import java.util.Scanner;

public class Triangle {
	public double a;
	public double b;
	public double c;
	
	public Triangle() {
		this(0.0,0.0,0.0);
	}
	
	public Triangle(double a) {
		this(a,a,a);
	}
	
	public Triangle(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public double getArea() {
		
		double p = (a + b + c) / 2;
		double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
		return s;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double a = in.nextDouble();
		double b = in.nextDouble();
		double c = in.nextDouble();
		Triangle san;
		if (a < 0 && b < 0 && c < 0) {
			san = new Triangle();
		}
		else if (a > 0 && b > 0 && c > 0 && (a + b > c) && (a + c > b) && (b + c > a)) {
			san = new Triangle(a,b,c);
		}
		else {
			double x = a;
			if (x < b)
				x = b;
			if (x < c)
				x = c;
			san = new Triangle(x);
		}
		System.out.println(san.getArea());		
	}	
}





