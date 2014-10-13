import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Assume;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import tutorial.tutorial.tutorial11Week11.Rectangle;
import tutorial.tutorial.tutorial11Week11.Shape;
import tutorial.tutorial.tutorial11Week11.Circle;
import tutorial.tutorial.tutorial11Week11.SortShapes;
import tutorial.tutorial.tutorial11Week11.Triangle;

@RunWith(Parameterized.class)
public class ShapeTester {


	Shape s = new Rectangle(100, 100, 100, 200);
	Shape s2= new Circle(100, 100, 100);
	Shape s3= new Triangle(100, 100, 100, 200, 200, 200);
	@Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] { 
        		{ "area","area","Triangle","Circle" }, 
        		{ "perimeter","perimeter","Triangle","Circle" }});
    }

    @Parameter(0)
    public String sortKey;
    @Parameter(1)
    public String exsortKey;
    @Parameter(2)
    public String smallest;
    @Parameter(3)
    public String biggest;
    
	@Test
	public void testSmallest() {
		SortShapes ss=new SortShapes(sortKey);
		ss.addShape(s);
		ss.addShape(s2);
		ss.addShape(s3);
		Assume.assumeTrue(exsortKey.equals(ss.getSortKey()));
		Shape[] result=ss.sort();
		assertEquals(smallest, result[0].getClass().getSimpleName());
	}
	@Test
	public void testBiggest() {
		SortShapes ss=new SortShapes(sortKey);
		ss.addShape(s);
		ss.addShape(s2);
		ss.addShape(s3);
		Assume.assumeTrue(exsortKey.equals(ss.getSortKey()));
		Shape[] result=ss.sort();
		assertEquals(biggest, result[result.length-1].getClass().getSimpleName());
	}

}
