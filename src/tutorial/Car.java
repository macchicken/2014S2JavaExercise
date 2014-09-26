package tutorial;

/**
 * A Class for a data model of car
 * <ul>
 * <li> speed - the speed of the car
 * <li> accelerationPower - acceleration power of the car
 * <li> brakePower - brake power of the car
 * <li> acceleratorOn - whether the accelerator of the car is on
 * <li> brakeOn - whether the brake of the car is on
 * <li> position - position of the car
 * <li> name - name of the car
 * <li> lowerSpeedLimit - the lower bound for speed limit
 * <li> upperSpeedLimit - the upper bound for speed limit
 * </ul>
 * @author Barry
 * @since 2014-9-25
 */
public class Car {
	private double speed;
	private double accelerationPower;
	private double brakePower;
	private boolean acceleratorOn;
	private boolean brakeOn;
	private double position;
	private String name;
	private static double lowerSpeedLimit = 80.0;
	private static double upperSpeedLimit = 110.0;

	/**
	 * A constructor for a car
	 * @param n - name of a car
	 * @param s - speed of a car
	 * @param p - position of a car
	 * @param a - acceleration power of a car
	 * @param b - brake power of a car
	 */
	public Car(String n, double s, double p, double a, double b) {
		name = n;
		position = p;
		accelerationPower = a;
		brakePower = b;
		speed = 0.0;
		acceleratorOn = true;
		brakeOn = false;
	}

	/**
	 * @return the current position of this specific car
	 */
	public double getPosition() {
		return position;
	}

	/**
	 * @return the current speed of this specific car
	 */
	public double getSpeed() {
		return speed;
	}

	/**
	 * @return the name of this specific car
	 */
	public String getName() {
		return name;
	}

	/**
	 * compare the current speed of this specific car with predefined highest speed limit
	 * @return true of higher than highest speed limit
	 */
	private boolean tooFast() {
		return (speed > upperSpeedLimit);
	}

	/**
	 * compare the current speed of this specific car with predefined lowest speed
	 * @return true if lower than lowest speed
	 */
	private boolean tooSlow() {
		return (speed < lowerSpeedLimit);
	}

	/**
	 * calculate the position of this specific car after a time
	 * @param time - a period of time
	 */
	public void move(double time) {
		if (tooSlow()) {
			acceleratorOn = true;
			brakeOn = false;
		}
		if (tooFast()) {
			brakeOn = true;
			acceleratorOn = false;
		}
		double a = 0.0;
		if (acceleratorOn)
			a += accelerationPower;
		if (brakeOn)
			a -= brakePower;
		speed = speed + time * a;
		position += time * speed;
	}


}
