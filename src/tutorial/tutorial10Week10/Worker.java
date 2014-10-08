package tutorial.tutorial10Week10;

public class Worker {

	protected String name;
	protected double rate;
	
	public Worker(String name, double rate) {
		this.name = name;
		this.rate = rate;
	}

	public String getName() {
		return name;
	}

	public double getRate() {
		return rate;
	}
	
	/**
	 * computes the weekly pay for every worker
	 * @param hours - working hours of a week
	 * @return weekly pay
	 */
	public double computePay (int hours){
		return rate*hours;
	}

	@Override
	public String toString() {
		return "Worker [name=" + name + ", rate=" + rate + "]";
	}

}
