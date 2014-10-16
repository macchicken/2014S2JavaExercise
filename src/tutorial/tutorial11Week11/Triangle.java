package tutorial.tutorial11Week11;

public class Triangle implements Shape {

	// coordinates of those three points
	private double x;
	private double y;
	private double x1;
	private double y1;
	private double x2;
	private double y2;
	
	public Triangle(double x, double y, double x1, double y1, double x2, double y2) {
		this.x=x;
		this.y=y;
		this.x1=x1;
		this.y1=y1;
		this.x2=x2;
		this.y2=y2;
	}


	@Override
	public double getX() {
		return x;
	}

	@Override
	public double getY() {
		return y;
	}

	public double getX1() {
		return x1;
	}
	
	public double getY1() {
		return y1;
	}

	public double getX2() {
		return x2;
	}
	
	public double getY2() {
		return y2;
	}

	@Override
	public String toString() {
		return "Triangle has 3 points ("+x+","+y+") ("+x1+","+y1+") ("+x2+","+y2+")";
	}


	@Override
	public double area() {
		double a = Math.sqrt(((x-x1)*(x-x1) + (y-y1)*(y-y1)));
		double b = Math.sqrt(((x-x2)*(x-x2) + (y-y2)*(y-y2)));
		double c = Math.sqrt(((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1)));
		double s = 0.5*(a+b+c);
		return Math.sqrt(s*(s-a)*(s-b)*(s-c));
	}


	@Override
	public double perimeter() {
		double a = Math.sqrt(((x-x1)*(x-x1) + (y-y1)*(y-y1)));
		double b = Math.sqrt(((x-x2)*(x-x2) + (y-y2)*(y-y2)));
		double c = Math.sqrt(((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1)));
		return a+b+c;
	}

}
