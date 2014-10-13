package tutorial.tutorial.tutorial11Week11;

import tutorial.Animal;
import tutorial.Speakable;

public class Dog extends Animal implements Speakable {

	public Dog(String id, double appetite, String name, double initialCost) {
		super(id, appetite, name, initialCost);
		this.setSpecies("Dog");
	}

	@Override
	public String speak() {
		return "woof, my name is бн "+this.getName();
	}


}