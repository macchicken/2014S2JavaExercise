package tutorial;

// Tutorial5 Week6

public class Rectangle {
	
	private double width; // width of the rectangle
	private double height; // height of the rectangle


	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}


	/*
	 * return the width of the rectangle
	 */
	public double getWidth() {
		return width;
	}

	/*
	 * return height of the rectangle
	 */
	public double getHeight() {
		return height;
	}
	
	/*
	 * return perimeter of the rectangle
	 */
	public double getPerimeter(){
		return (width+height)*2;
	}
	
	/*
	 * return area of the rectangle
	 */
	public double getArea(){
		return width*height;
	}
	
	/*
	 * return x coordinate of the centre for the rectangle
	 */
	public double getCentreXcoordinate(){
		return width/2;
	}
	
	/*
	 * return y coordinate of the centre for the rectangle
	 */
	public double getCenterYcoordinate(){
		return height/2;
	}


}
