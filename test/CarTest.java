import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import tutorial.Car;

@RunWith(Parameterized.class)
public class CarTest {

	@Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { { 0,0,0 }, { 10,100,10 }, { 20,400,20 },
            { 30,900,30 }, { 60,3600,60 } });
    }
    private Car testCar=null;
    @Parameter(0)
    public double ftime;
    @Parameter(1)
    public double fposition;
    @Parameter(2)
    public double fspeedTest;
    
    @Test
    public void testMove(){
    	testCar=new Car("Barry", 0, 0, 1, 0);
    	testCar.move(ftime);
    	assertEquals(fposition,testCar.getPosition(),0);
    }
 
    @Test
    public void testSpeed(){
    	testCar=new Car("Barry", 0, 0, 1, 0);
    	testCar.move(ftime);
    	assertEquals(fspeedTest, testCar.getSpeed(),0);
    }


}
