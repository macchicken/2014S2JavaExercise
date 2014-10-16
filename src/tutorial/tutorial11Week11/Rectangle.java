package tutorial.tutorial11Week11;

public class Rectangle implements Shape {

	private double x;
	private double y;
	private double width;
	private double height;
	
	public Rectangle(double x, double y, double width, double height) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
	}

	@Override
	public double getX() {
		return x;
	}

	@Override
	public double getY() {
		return y;
	}

	@Override
	public String toString() {
		return "Rectangle bottom L corner at ("+x+","+y+") with width "+width+" and height "+height;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

	@Override
	public double area() {
		return width*height;
	}

	@Override
	public double perimeter() {
		return 2*(width+height);
	}

}
