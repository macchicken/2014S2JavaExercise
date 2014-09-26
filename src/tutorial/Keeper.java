package tutorial;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

/**
 * @author Barry
 * @since 2014-09-26
 */
public class Keeper {

	private HashMap<String,Animal> dutyAnimals=null;
	private String keeperName;
	private String keeperId;

	public Keeper(String keeperName,String keeperId) {
		this.keeperName=keeperName;
		this.keeperId=keeperId;
		this.dutyAnimals = new HashMap<String,Animal>();
	}


	public ArrayList<Animal> getDutyAnimals() {
		ArrayList<Animal> result=new ArrayList<Animal>(dutyAnimals.size()+10);
		for (Animal a:dutyAnimals.values()){
			result.add(a);
		}
		return result;
	}

	public void assignedAniaml(Animal a){
		if (!dutyAnimals.containsKey(a.getId())){
			dutyAnimals.put(a.getId(), a);
			a.addKeeper(keeperId);
		}
	}
	
	public void feedAnimal(String id,String foodName,double unitPrice,double weight) {
		Animal a;
		if ((a = dutyAnimals.get(id)) != null) {
			Calendar now = Calendar.getInstance();
			a.weigh(weight);
			if (!a.tooHeavy()) {
				double w=util.Constants.aniamlWeight.get(a.getName())-weight;
				double amountOfFood = w*(util.Constants.foodProportion.get(foodName));
				Food food=new Food(keeperId,foodName, amountOfFood, unitPrice, now.getTime());
				a.feed(food);
			}
		}
	}


	public String getKeeperName() {
		return keeperName;
	}


	public String getKeeperId() {
		return keeperId;
	}

	public String toString(){
		return "keeper id: "+keeperName+";keeper name: "+keeperName;
	}


}