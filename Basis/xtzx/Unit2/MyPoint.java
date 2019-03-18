package Java02;

import java.util.Scanner;

public class MyPoint {
	private double x;
	private double y;
	
	public MyPoint() {
		this(0.0,0.0);
	}
	public MyPoint(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double getD(MyPoint point) {
		return Math.sqrt(Math.pow(this.x - point.x,2) + Math.pow(this.y - point.y, 2));
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double x = in.nextDouble();
		double y = in.nextDouble();
		MyPoint a = new MyPoint(x,y);
		x = in.nextDouble();
		y = in.nextDouble();
		MyPoint b = new MyPoint(x,y);
		System.out.println(a.getD(b));
		
	}
}
