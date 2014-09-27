/**
 * @author Barry
 * @since 2014-09-27
 */

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import tutorial.Animal;

@RunWith(Parameterized.class)
public class AnimalTest {

	@Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
        		{ "1",35.0,"Caracal",1000.0,70.0,true }, 
        		{ "2",15.0,"Serval",1010.0,30.0,false }, 
        		{ "3",10.0,"Fishing Cat",900.0,20.0,false },
        		{ "4",45.0,"Eurasian Lynx",3500.0,90.0,true }, 
        		{ "5",350.0,"Tiger",5000.0,700.0,true } });
    }
    private Animal a;
    @Parameter(0)
    public String id;
    @Parameter(1)
    public double appetite;
    @Parameter(2)
    public String name;
    @Parameter(3)
    public double initialCost;
    @Parameter(4)
    public double weight;
    @Parameter(5)
    public boolean tooHeavy;

    @Test
    public void testTooHeavy(){
    	a=new Animal(id, 0.0, name, initialCost);
    	a.weigh(weight);
    	assertTrue(tooHeavy==a.tooHeavy());
    }
}
