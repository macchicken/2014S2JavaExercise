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
		put("quantity",7);}
	};
	
	public static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	public static DateFormat datef=DateFormat.getDateInstance(DateFormat.LONG,java.util.Locale.UK);
	public static Pattern nameP = Pattern.compile("[a-z A-Z_0-9]+");
	public static Pattern dateP = Pattern.compile("[0-9]{1,2}-[0-9]{1,2}-[0-9]{2,4}");
	public static Pattern priceP = Pattern.compile("[$]([1-9][0-9]*|[0-9])([.][0-9]+|[.]{0})");
	public static Pattern numP = Pattern.compile("[1-9][0-9]*|[0-9]");
	
	public static String defaultReport="output\\report.txt";
	public static String defaultOuptput="output\\output.txt";
	
	public static final String commonSeparator=";";
	public static final String valueSeparator=" ";
	public static final String keyValueSeparator=":";
	
}
