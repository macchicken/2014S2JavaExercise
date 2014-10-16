package tutorial.tutorial11Week11;

import tutorial.Animal;
import tutorial.Speakable;

public class Cat extends Animal implements Speakable {

	public Cat(String id, double appetite, String name, double initialCost) {
		super(id, appetite, name, initialCost);
		this.setSpecies("Cat");
	}

	@Override
	public String speak() {
		return "meow, my name is бн " + this.getName();

	}


}