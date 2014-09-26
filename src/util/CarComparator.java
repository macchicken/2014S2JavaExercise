package util;

import tutorial.Car;

public class CarComparator extends AbstractObjectComparator {

	@Override
	public int compare(Object o1, Object o2) {
		Car c1=(Car) o1;
		Car c2=(Car) o2;
		return Double.compare(c1.getPosition(), c2.getPosition());
	}

}
