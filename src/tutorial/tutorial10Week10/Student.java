package tutorial.tutorial10Week10;

public class Student extends Person {

	private String major;

	public Student(String name, int yearOfBirth, String major) {
		super(name, yearOfBirth);
		this.major = major;
	}

	public String getMajor() {
		return major;
	}

	@Override
	public String toString() {
		return "Student [major=" + major + ", name=" + name + ", yearOfBirth="
				+ yearOfBirth + "]";
	}


}
