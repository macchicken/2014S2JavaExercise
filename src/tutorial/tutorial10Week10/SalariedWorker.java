package tutorial.tutorial10Week10;

public class SalariedWorker extends Worker {

	public SalariedWorker(String name, double rate) {
		super(name, rate);
	}

	@Override
	public double computePay(int hours) {
		return rate*40;
	}


}
