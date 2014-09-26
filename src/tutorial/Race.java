/**
 * 
 */
package tutorial;

import java.util.ArrayList;

import util.CarComparator;
import util.tools;

/**
 * A date model for racing the cars
 * <ul>
 * <li> cars - the list of the cars
 * <li> ranks - the final rank after the race
 * </ul>
 * @since 2014-09-26
 * @author Barry
 */
public class Race {

	private ArrayList<Car> cars=null;
	private Car[] ranks=null;
	
	/**
	 * A constructor for the race
	 * @param cars - the list of cars in the race
	 */
	public Race(ArrayList<Car> cars) {
		this.cars = cars;
	}

	/**
	 * @return the list of the cars in the race
	 */
	public ArrayList<Car> getCars() {
		return cars;
	}

	/**
	 * play the race and compute the ranks of the race
	 * @param time - the period of time for the race
	 * @return if there are two cars have the same name
	 */
	public void raced(double time){
		ranks=new Car[cars.size()];
		int index=0;
		String name=null;
		for (Car car:cars){
			if (car.getName().equals(name)) {
				System.out.println("must have unique name for each car");
				return;
			}
			name=car.getName();
			car.move(time);
			ranks[index]=car;
			index++;
		}
		tools.quickSort(ranks, 0, ranks.length-1, new CarComparator());
	}

	/**
	 * the longest distance car would be the last one of the list
	 * @return the ranks after the race
	 */
	public Car[] getRanks() {
		return ranks;
	}

	/**
	 * @return the name of the Champion
	 */
	public String getChampion(){
		return ranks[ranks.length-1].getName();
	}


}
