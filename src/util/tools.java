package util;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import dto.Product;

public class tools {
	
	private static int partition(Object arr[],int left,int right,AbstractObjectComparator pc){
	      int i=left, j=right;
	      Object tmp;
	      Object pivot=arr[(left + right)/2];
	      while (i <= j) {
	    	  	while (pc.compare(arr[i], pivot)<0) i++;
	    	  	while (pc.compare(arr[j], pivot)>0) j--;
	            if (i<=j) {
	                  tmp=arr[i];
	                  arr[i]=arr[j];
	                  arr[j]=tmp;
	                  i++;
	                  j--;
	            }
	      };
	      return i;
	}
	
	//implement a quicksort for personalise re-ordering,would change the input array
	public static void quickSort(Object arr[],int left,int right,AbstractObjectComparator pc) {
	      int index = partition(arr,left,right,pc);
	      if (left<index-1){quickSort(arr,left,index-1,pc);}
	      if (index<right){quickSort(arr,index,right,pc);}
	}
	
	//append 20 or 2 to the front if year field value is 2-digit or 3-digit number
	public static String refineDateStr(String data){
		String[] temp=data.split("-");
		int year=Integer.parseInt(temp[2]);
		String head="";
		if (year>=10&&year<100){
			head="20";
		}else if (year>=100&&year<1000){
			head="2";
		}
		return temp[0]+"-"+temp[1]+"-"+head+temp[2];
	}
	
	public static Date formatDateString(String date) throws ParseException{
		if (Constants.dateP.matcher(date).matches()){
			return Constants.dateFormat.parse(refineDateStr(date));
		}else{
			throw new ParseException("not in the date format dd-MM-(yy)yy",0);
		}
	}
	
	public static Product transDataToProduct(ArrayList<String> parameters){
		Product product=new Product();
		for (String p:parameters){
			String[] fieldValues=p.split(Constants.keyValueSeparator);
			try {
				Constants.FieldMapping fm=Constants.FieldMapping.valueOf(fieldValues[0]);
				switch(fm){
					case product:
						product.setProductName(fieldValues[1]);
						break;
					case boughton:
						try {
							product.setBoughton(Constants.dateFormat.parse(fieldValues[1]));
						} catch (ParseException e) {
							System.out.println(e.getMessage());
						}
						break;
					case soldon:
						try {
							product.setSoldon(Constants.dateFormat.parse(fieldValues[1]));
						} catch (ParseException e) {
							System.out.println(e.getMessage());
						}
						break;
					case useby:
						try {
							product.setUseby(Constants.dateFormat.parse(fieldValues[1]));
						} catch (ParseException e) {
							System.out.println(e.getMessage());
						}
						break;
					case boughtat:
						product.setBoughtat(Float.parseFloat(fieldValues[1]));
						break;
					case soldat:
						product.setSoldat(Float.parseFloat(fieldValues[1]));
						break;
					case quantity:
						product.setQuantity(Integer.parseInt(fieldValues[1]));
						break;
					case serial:
						product.setSerialId(fieldValues[1]);
						break;
					case location:
						product.setLocation(fieldValues[1]);
						break;
					case price:
						product.setUnitPrice(Float.parseFloat(fieldValues[1]));
						break;
					default:
						System.out.println("invalid field value found "+fieldValues[0]);
				}
			} catch (IllegalArgumentException e) {
				System.out.println("invalid field found "+fieldValues[0]);
			}
		}
		return product;
	}

	/**
	 * pre-build the data with a defined format,so can use easily afterwards
	 * @param data - a line of data in the file
	 * @param parameters - attributes of a product
	 * @throws ParseException
	 */
	public static void processData(String data,ArrayList<String> parameters) throws ParseException{
		String key=data.split(Constants.valueSeparator)[0];
		try {
			Constants.FieldMapping fm=Constants.FieldMapping.valueOf(key);
			switch(fm){
				case product:
					data=data.trim().substring(7).trim();
					if (Constants.nameP.matcher(data).matches()){
						parameters.add(key+Constants.keyValueSeparator+data);
					}
					break;
				case boughton:
					data=data.trim().substring(8).trim();
					if (Constants.dateP.matcher(data).matches()){
						String result=tools.refineDateStr(data);
						parameters.add(key+Constants.keyValueSeparator+result);
					}
					break;
				case soldon:
					data=data.trim().substring(6).trim();
					if (Constants.dateP.matcher(data).matches()){
						String result=tools.refineDateStr(data);
						parameters.add(key+Constants.keyValueSeparator+result);
					}
					break;
				case useby:
					data=data.trim().substring(5).trim();
					if (Constants.dateP.matcher(data).matches()){
						String result=tools.refineDateStr(data);
						parameters.add(key+Constants.keyValueSeparator+result);
					}
					break;
				case boughtat:
					data=data.trim().substring(8).trim();
					if (Constants.priceP.matcher(data).matches()){
						parameters.add(key+Constants.keyValueSeparator+data.substring(1));
					}
					break;
				case soldat:
					data=data.trim().substring(6).trim();
					if (Constants.priceP.matcher(data).matches()){
						parameters.add(key+Constants.keyValueSeparator+data.substring(1));
					}
					break;
				case quantity:
					data=data.trim().substring(8).trim();
					if (Constants.numP.matcher(data).matches()){
						parameters.add(key+Constants.keyValueSeparator+data);
					}
					break;
				case serial:
					data=data.trim().substring(10).trim();
					if (Constants.idP.matcher(data).matches()){
						parameters.add(key+Constants.keyValueSeparator+data);
					}
					break;
				case location:
					data=data.trim().substring(9).trim();
					if (Constants.addressP.matcher(data).matches()){
						parameters.add(key+Constants.keyValueSeparator+data);
					}
					break;
				case price:
					data=data.trim().substring(5).trim();
					if (Constants.priceP.matcher(data).matches()){
						parameters.add(key+Constants.keyValueSeparator+data.substring(1));
					}
					break;
				default:
					System.out.println("invalid field value found "+data);
			}
		} catch (IllegalArgumentException e) {
			System.out.println("invalid field found "+data);
		}
	}


}
