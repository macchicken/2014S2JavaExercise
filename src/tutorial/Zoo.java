/**
 * AnimalRest is a zoo, managed by an enthusiast who loves animals and doesn¡¯t
 * understand money.The Australian tax office (ATO) has decided that accounting standards mean
 * that the zoo must be able to track its assets properly: each animal must have a
 * book value, based on the initial cost plus the cost of all upkeep (food!). ATO
 * allows the use of a formula to determine cost of feeding, based on animals
 * weight and a typical feed proportional to the weight.
 * The zoo staff, called keepers, are assigned duties looking after one or more
 * animals from the collection: a keeper assigned to the animal can weigh it
 * and/or feed it. Each keeper may be expert in the needs of one or more species.
 */
package tutorial;

import java.util.HashMap;

/**
 * @author Barry
 * @since 2014-09-26
 */
public class Zoo {

	private HashMap<String,Keeper> keepers;
	private HashMap<String,Animal> animals;


	public Zoo() {
		this.keepers = new HashMap<String,Keeper>(40);
		this.animals = new HashMap<String,Animal>(90);
	}
	
	public void newKeeper(Keeper keeper){
		if (!keepers.containsKey(keeper.getKeeperId())){
			keepers.put(keeper.getKeeperId(), keeper);
		}
	}
	
	public void newAnimal(Animal animal){
		if (!animals.containsKey(animal.getId())){
			animals.put(animal.getId(), animal);
		}
	}

	public Keeper retriveKeeper(String id){
		return keepers.get(id);
	}
	
	public Animal getAnimal(String id){
		return animals.get(id);
	}

	public void displayAllKeepers(){
		for (Keeper keeper:keepers.values()){
			System.out.println(keeper);
		}
	}
	
	public void displayAllAnimals(){
		for (Animal animal:animals.values()){
			System.out.println(animal);
		}
	}


}