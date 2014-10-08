package tutorial.tutorial10Week10;

public class Instructor extends Person {

	private double salary;

	public Instructor(String name, int yearOfBirth, double salary) {
		super(name, yearOfBirth);
		this.salary = salary;
	}


	public double getSalary() {
		return salary;
	}

	@Override
	public String toString() {
		return "Instructor [salary=" + salary + ", name=" + name
				+ ", yearOfBirth=" + yearOfBirth + "]";
	}


}
