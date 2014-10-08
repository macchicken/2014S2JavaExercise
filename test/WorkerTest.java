import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import tutorial.tutorial10Week10.HourlyWorker;
import tutorial.tutorial10Week10.SalariedWorker;
import tutorial.tutorial10Week10.Worker;

@RunWith(Parameterized.class)
public class WorkerTest {

	@Parameters
    public static Iterable<Object[]> data() {
    	Worker worker=new Worker("Barry", 1);
    	HourlyWorker worker2=new HourlyWorker("Scott", 3);
    	SalariedWorker worker3=new SalariedWorker("Gary", 5);
        return Arrays.asList(new Object[][] { { worker,30,30.0 },{ worker2,45,120+(5*3*1.5) },
        		{ worker3,60,200.0 },{worker2,30,90.0}});
    }

    @Parameter(0)
    public Worker worker=null;
    @Parameter(1)
    public int hours;
    @Parameter(2)
    public double fsalary;
    
	@Test
	public void test() {
		assertEquals(fsalary, worker.computePay(hours),0);
	}

}
