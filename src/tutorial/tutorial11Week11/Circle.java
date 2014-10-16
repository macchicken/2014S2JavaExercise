package tutorial.tutorial11Week11;

public class Circle implements Shape {

	private double x;// Centre coordinate of x
	private double y;// Centre coordinate of y
	private double radius;
	
	public Circle(double x, double y, double radius) {
		this.x=x;
		this.y=y;
		this.radius=radius;
	}

	@Override
	public double getX() {
		return x;
	}

	@Override
	public String toString() {
		return "Circle center at ("+x+","+y+") with radius "+radius;
	}

	@Override
	public double getY() {
		return y;
	}

	public double getRadius() {
		return radius;
	}

	@Override
	public double area() {
		return radius*radius*Math.PI;
	}

	@Override
	public double perimeter() {
		return radius*2*Math.PI;
	}

}
