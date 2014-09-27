/**
 * @author Barry
 * @since 2014-09-27
 */
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import tutorial.Food;

@RunWith(Parameterized.class)
public class FoodTest {

	private static Date now=Calendar.getInstance().getTime();
	@Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
        		{ "banana","Barry",35.0,1.0,now,35.0 }, 
        		{ "apple","Scott",15.0,2.0,now,30.0 }, 
        		{ "beef","Felix",10.0,0.5,now,5.0 },
        		{ "seaFood","Gary",45.0,5.0,now,225.0 }, 
        		{ "vegetable","Laurie",350.0,5000.0,now,1750000.0 } });
    }
    private Food food;
    @Parameter(0)
    public String foodName;
    @Parameter(1)
	public String feedingKeeper;
    @Parameter(2)
	public double amountOfFood;
    @Parameter(3)
	public double unitPrice;
	@Parameter(4)
	public Date feedDate;
	@Parameter(5)
	public double feedCost;

	@Test
	public void testcalcFeedCost(){
		food=new Food(feedingKeeper, foodName, amountOfFood, unitPrice, feedDate);
		food.calcFeedCost();
		assertEquals(feedCost,food.getFeedCost(),0);
	}

}
