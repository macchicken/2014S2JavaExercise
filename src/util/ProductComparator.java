/**
 * a personalise comparator for Product DTO
 */
package util;

import java.util.Date;

import dto.Product;

/**
 * @author Barry
 * @since 2014-8-22
 */
public class ProductComparator extends MyObjectComparator {
	

	public ProductComparator() {
		this.key="product";
	}

	@Override
	public int compare(Object o1, Object o2) {
		Product no1=(Product)o1;
		Product no2=(Product)o2;
		if ("product".equals(this.key)){
			return no1.getProductName().compareToIgnoreCase(no2.getProductName());
		}
		if ("quantity".equals(this.key)){
			return Integer.compare(no1.getQuantity(),no2.getQuantity());
		}
		if ("boughton".equals(this.key)||"soldon".equals(this.key)
			||"useby".equals(this.key)){
			Date date1,date2;
			if ("boughton".equals(this.key)){
				date1=no1.getBoughton();date2=no2.getBoughton();
			}else if ("soldon".equals(this.key)){
				date1=no1.getSoldon();date2=no2.getSoldon();
			}else{
				date1=no1.getUseby();date2=no2.getUseby();
			}
			if (date1==null){
				if (date2!=null){return 1;}
				return 0;
			}
			if (date1!=null&&date2==null){return -1;}
			return date1.compareTo(date2);
		}
		if ("boughtat".equals(this.key)||"soldat".equals(this.key)){
			float b1,b2;
			if ("boughtat".equals(this.key)) {
				b1=no1.getBoughtat();b2=no2.getBoughtat();
			}else{
				b1=no1.getSoldat();b2=no2.getSoldat();
			}
			return Float.compare(b1,b2);
		}
		if ("value".equals(this.key)){//the total value of current available no of items
			float value1=no1.getUnitPrice()*no1.getQuantity();
			float value2=no1.getUnitPrice()*no2.getQuantity();
			return Float.compare(value1,value2);
		}
		return 0;
	}


}
