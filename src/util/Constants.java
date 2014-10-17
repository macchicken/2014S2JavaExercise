package util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

public class Constants {
	
	
	public enum FieldMapping{
		product,boughton,soldon,
		useby,boughtat,soldat,
		quantity,serial,location,price;
	}

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
	
	public enum foodProportion{
		BANANA(4.0),APPLE(1.5),PIAPPLE(1.5),BEEF(1.0),PORK(1.1),
		SEAFOOD(2.0),VEGETABLE(7.0);
		
		private double value;
		private foodProportion(double value){
			this.value=value;
		}
		public double getValue() {
			return value;
		}
	}

	public enum aniamlWeight{
		CARACAL(60.0),SERVAL(40.0),BOBCAT(30.0),CHEETAH(125.0),FISHINGCAT(30.0),
		JAGUAR(225.0),LEOPARD(210.0),EURASIANLYNX(80.0),LION(425.0),TIGER(675.0),
		SNOWLEOPARD(100.0);
		
		private double value;
		private aniamlWeight(double value){
			this.value=value;
		}
		public double getValue() {
			return value;
		}
		
	}

}
