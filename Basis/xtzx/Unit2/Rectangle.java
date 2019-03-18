package Java02;

import java.util.Scanner;

public class Rectangle {
	
	private int height;
	private int width;
	
	public Rectangle(int x, int y) {
		this.height = x;
		this.width = y;
	}
	
	public int getArea() {
		return height * width;
	}
	
	public int getPerimeter() {
		return 2 * (height + width);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int x = in.nextInt();
		int y = in.nextInt();
		
		Rectangle r = new Rectangle(x,y);
		System.out.print(r.getArea() + " ");
		System.out.println(r.getPerimeter());
		
	}


	
}
