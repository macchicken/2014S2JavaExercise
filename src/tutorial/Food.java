/**
 * 
 */
package tutorial;

import java.util.Date;

/**
 * @author Barry
 * @since 2014-09-26
 */
public class Food {

	private String foodName;
	private String feedingKeeper;
	private double amountOfFood;
	private double unitPrice;
	private Date feedDate;
	private double feedCost;
	

	public Food(String feedingKeeper, String foodName, double amountOfFood,
			double unitPrice, Date feedDate) {
		this.feedingKeeper=feedingKeeper;
		this.foodName = foodName;
		this.amountOfFood = amountOfFood;
		this.unitPrice = unitPrice;
		this.feedDate = feedDate;
	}

	public String getFoodName() {
		return foodName;
	}

	public double getAmountOfFood() {
		return amountOfFood;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public Date getFeedDate() {
		return feedDate;
	}
	
	public double calcFeedCost(){
		return feedCost=amountOfFood*unitPrice;
	}

	public double getFeedCost() {
		return feedCost;
	}

	public String getFeedingKeeper() {
		return feedingKeeper;
	}


}