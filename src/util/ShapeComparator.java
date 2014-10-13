package util;

import tutorial.tutorial.tutorial11Week11.Shape;

public class ShapeComparator extends AbstractObjectComparator {

	public ShapeComparator() {
		this.key="area";
	}

	@Override
	public int compare(Object o1, Object o2) {
		Shape s1=(Shape) o1;
		Shape s2=(Shape) o2;
		if ("area".equals(key)){
			double area1=s1.area();
			double area2=s2.area();
			return Double.compare(area1, area2);
		}else if ("perimeter".equals(key)){
			double perimeter1=s1.perimeter();
			double perimeter2=s2.perimeter();
			return Double.compare(perimeter1, perimeter2);
		}
		return 0;
	}

}
