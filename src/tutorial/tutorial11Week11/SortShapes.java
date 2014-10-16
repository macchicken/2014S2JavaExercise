package tutorial.tutorial11Week11;

import java.util.ArrayList;

import util.ShapeComparator;
import util.tools;

public class SortShapes {

	private String sortKey="area";
	private ArrayList<Shape> shapes=new ArrayList<Shape>();
	
	public SortShapes(String sortKey) {
		if (sortKey!=null&&!"".equals(sortKey)) {
			this.sortKey = sortKey;
		}
	}

	public String getSortKey() {
		return sortKey;
	}

	public boolean addShape(Shape s){
		return shapes.add(s);
	}

	public Shape[] sort(){
		ShapeComparator sc=new ShapeComparator();
		sc.setKey(sortKey);
		Shape[] result=new Shape[shapes.size()];
		int c=0;
		for (Shape shape:shapes){
			result[c]=shape;
			c++;
		}
		tools.quickSort(result, 0, c-1, sc);
		for (Shape s:result){
			System.out.println(s);
		}
		return result;
	}

}
