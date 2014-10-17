/**
 * 
 */
package tutorial;

import java.util.Date;
import java.util.LinkedList;

/**
 * @author Barry
 * @since 2014-09-26
 */
public class Animal {


	private double weight;
	private String name;
	private String species;
	private double initialCost;
	private String id;
	private double bookValue;
	private double appetite;
	private String dateOfBirth;
	private LinkedList<Food> feedRecord=new LinkedList<Food>();
	private LinkedList<String> ondutyKeepers=new LinkedList<String>();
	
	public Animal(String id, double appetite, String name,double initialCost) {
		this.id = id;
		this.name = name;
		this.appetite=appetite;
		this.initialCost = initialCost;
		this.bookValue = initialCost;
	}


	public double getWeight() {
		return weight;
	}

	public String getName() {
		return name;
	}


	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}


	public double getInitialCost() {
		return initialCost;
	}

	public String getId() {
		return id;
	}

	public void setAppetite(double appetite) {
		this.appetite = appetite;
	}

	public double getAppetite() {
		return appetite;
	}
	
	public double getBookValue() {
		return bookValue;
	}

	public double getUpKeep() {
		return bookValue-initialCost;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void weigh(double weight){
		this.weight=weight;
	}

	public boolean tooHeavy(){
		try {
			return util.Constants.aniamlWeight.valueOf(
					name.replace(" ", "").toUpperCase()).getValue() <= weight;
		} catch (IllegalArgumentException e) {
			return false;
		}
	}

	public void feed(Food food){
		double amountOfFood=food.getAmountOfFood();
		if (appetite>=amountOfFood&&amountOfFood!=0) {
			appetite -= amountOfFood;
			double cost = food.calcFeedCost();
			feedRecord.add(food);
			bookValue += cost;
		}
	}

	public double getTotalcostToDate(Date date){
		double totalCost = 0;
		for (Food food:feedRecord){
			if (!date.before(food.getFeedDate())){
				totalCost+=food.getFeedCost();
			}
		}
		return totalCost;
	}

	public void addKeeper(String id){
		if (!ondutyKeepers.contains(id)) {
			ondutyKeepers.add(id);
		}
	}

	public LinkedList<String> getKeepers(){
		return ondutyKeepers;
	}
	
	public String toString(){
		return "id: "+id+";name: "+name+";weight: "+weight+";book value: "+bookValue;
	}


}