package tutorial;

// Tutorial5 Week6

/*
 * Define a Staff class so that the staff receives
 * their biweekly salary based on their hourly rates and
 * how many hours they worked.
 */
public class Staff {
	
	private String name; // name of the staff
	private double hours;// working hours of one week
	private double hourlyRate; // hourly rate of one week 


	public Staff(String name, double hours, double hourlyRate) {
		this.name = name;
		this.hours = hours;
		this.hourlyRate = hourlyRate;
	}


	public String getName() {
		return name;
	}

	public double getHours() {
		return hours;
	}

	public void setHours(double hours) {
		this.hours = hours;
	}


	public double getHourlyRate() {
		return hourlyRate;
	}

	/*
	 * If they worked more than 40 hours per week,
	 * they are paid at 150% of their regulate
	 * rates for their extra working hours.
	 * calculate the salary of one week
	 */
	public double getSalary(){
		double extraHours=hours-40;
		if (extraHours>0){
			return extraHours*(hourlyRate*1.5)+40*hourlyRate;
		}else{
			return hours*hourlyRate;
		}
	}


}
