package util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.regex.Pattern;

public class Constants {
	
	public static HashMap<String,Integer> fieldMapping=new HashMap<String,Integer>(){
		{put("product",1);
		put("boughton",2);
		put("soldon",3);
		put("useby",4);
		put("boughtat",5);
		put("soldat",6);
		put("quantity",7);
		put("serial",8);
		put("location",9);
		put("price",10);
		}
	};
	
	public static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	public static DateFormat datef=DateFormat.getDateInstance(DateFormat.LONG,java.util.Locale.UK);
	public static Pattern nameP = Pattern.compile("[a-z A-Z_0-9]+");
	public static Pattern dateP = Pattern.compile("[0-9]{1,2}-[0-9]{1,2}-[0-9]{2,4}");
	public static Pattern priceP = Pattern.compile("[$]([1-9][0-9]*|[0-9])([.][0-9]+|[.]{0})");
	public static Pattern numP = Pattern.compile("[1-9][0-9]*|[0-9]");
	public static Pattern idP = Pattern.compile("[0-9]{4}[a-zA-Z]{2}");
	public static Pattern addressP = Pattern.compile("[^\\n\\x0B\f\r:]+");
	
	public static String defaultReport="output\\report.txt";
	public static String defaultOuptput="output\\output.txt";
	
	public static final String commonSeparator=";";
	public static final String valueSeparator=" ";
	public static final String keyValueSeparator=":";
	
	public static HashMap<String,Double> foodProportion=new HashMap<String,Double>(){
		{put("banana",4.0);
		put("apple",1.5);
		put("piapple",1.5);
		put("beef",1.0);
		put("pork",1.1);
		put("seaFood",2.0);
		put("vegetable",7.0);}
	};

	public static HashMap<String,Double> aniamlWeight=new HashMap<String,Double>(){
		{put("Caracal",60.0);
		put("Serval",40.0);
		put("Bobcat",30.0);
		put("Cheetah",125.0);
		put("Fishing Cat",30.0);
		put("Jaguar",225.0);
		put("Leopard",210.0);
		put("Eurasian Lynx",80.0);
		put("Lion",425.0);
		put("Tiger",675.0);
		put("Snow Leopard",100.0);
		}
	};

}
