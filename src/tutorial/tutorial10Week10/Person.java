package tutorial.tutorial10Week10;

public class Person {

	protected String name;
	protected int yearOfBirth;
	
	public Person(String name, int yearOfBirth) {
		this.name = name;
		this.yearOfBirth = yearOfBirth;
	}

	public String getName() {
		return name;
	}

	public int getYearOfBirth() {
		return yearOfBirth;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", yearOfBirth=" + yearOfBirth + "]";
	}


}
