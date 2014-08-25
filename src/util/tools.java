package util;

import java.text.ParseException;
import java.util.ArrayList;

import dto.Product;

public class tools {
	
	private static int partition(Product arr[],int left,int right,MyObjectComparator pc){
	      int i=left, j=right;
	      Product tmp;
	      Product pivot=arr[(left + right)/2];
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
	public static void quickSort(Product arr[],int left,int right,MyObjectComparator pc) {
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
	
	public static Product transDataToProduct(ArrayList<String> parameters){
		Product product=new Product();
		for (String p:parameters){
			String[] fieldValues=p.split(Constants.keyValueSeparator);
			Integer key=Constants.fieldMapping.get(fieldValues[0]);
			switch(key){
				case 1:
					product.setProductName(fieldValues[1]);
					break;
				case 2:
					try {
						product.setBoughton(Constants.dateFormat.parse(fieldValues[1]));
					} catch (ParseException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 3:
					try {
						product.setSoldon(Constants.dateFormat.parse(fieldValues[1]));
					} catch (ParseException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 4:
					try {
						product.setUseby(Constants.dateFormat.parse(fieldValues[1]));
					} catch (ParseException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 5:
					product.setBoughtat(Float.parseFloat(fieldValues[1]));
					break;
				case 6:
					product.setSoldat(Float.parseFloat(fieldValues[1]));
					break;
				case 7:
					product.setQuantity(Integer.parseInt(fieldValues[1]));
					break;
				default:
					System.out.println("invalid field value found "+fieldValues[0]);
			}
		}
		return product;
	}


}
