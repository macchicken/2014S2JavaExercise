import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import tutorial.Car;
import tutorial.Race;

@RunWith(Parameterized.class)
public class RaceTest {

	@Parameters
    public static Iterable<Object[]> data() {
    	ArrayList<Car> cars1=new ArrayList<Car>();
    	cars1.add(new Car("Barry", 0, 0, 1, 0));
    	cars1.add(new Car("Scott", 0, 0, 2, 0));
    	cars1.add(new Car("Gary", 0, 0, 0, 0));
    	ArrayList<Car> cars2=new ArrayList<Car>();
    	cars2.add(new Car("Barry", 0, 0, 0, 0));
    	cars2.add(new Car("Scott", 0, 0, 1, 0));
    	cars2.add(new Car("Gary", 0, 0, 3, 0));
    	ArrayList<Car> cars3=new ArrayList<Car>();
    	cars3.add(new Car("Barry", 0, 0, 0, 0));
    	cars3.add(new Car("Scott", 0, 0, 0, 0));
    	cars3.add(new Car("Gary", 0, 0, 0, 0));
    	ArrayList<Car> cars4=new ArrayList<Car>();
    	cars4.add(new Car("Barry", 0, 0, 0, 0));
    	cars4.add(new Car("Scott", 0, 0, 0, 0));
    	cars4.add(new Car("Gary", 0, 2, 0, 0));
    	ArrayList<Car> cars5=new ArrayList<Car>();
    	cars5.add(new Car("Barry", 0, 1, 0, 0));
    	cars5.add(new Car("Scott", 0, 3, 0, 0));
    	cars5.add(new Car("Gary", 0, 2, 0, 0));
        return Arrays.asList(new Object[][] { { cars1, "Scott" },{ cars2, "Gary" },
        		{ cars3, "Barry" },{ cars4, "Gary" }, { cars5, "Scott" } });
    }
    
    private Race race=null;
    @Parameter(0)
    public ArrayList<Car> cars;
    @Parameter(1)
    public String fchampion;
    
    @Test
    public void testRace(){
    	race=new Race(cars);
    	race.raced(10);//play a fixed time of race
    	assertEquals(fchampion,race.getChampion());
    }


}
