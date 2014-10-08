package EIRM14S2;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;

import util.ProductComparator;
import util.tools;
import dto.Product;

public class Inventory {
	
	private HashMap<String,Product> store=new HashMap<String,Product>();
	private static Inventory my;
	private String defaultOuptput="output\\output.txt";
	
	public static Inventory getInstance(){
		if (my==null){
			return my=new Inventory();
		}
		return my;
	}

	public HashMap<String, Product> getStore() {
		return store;
	}
	
	// query the product with a product name
	public Product queryProductByKey(String key){
		Product pro=store.get(key);
		if (pro!=null){return pro.copyProduct();}
		return null;
	}

	//update only if existing product with enough quantity and before expire date
	//return a copy of result product if success
	public Product updateStore(String key,Product pro){
		Product temp=null;
		if ((temp=store.get(key))!=null){
			if (!temp.isExpiredByDate(pro.getSoldon())&&!temp.isDiscarded()){
				int q=temp.getQuantity();
				if (q>=pro.getQuantity()){
					temp.setQuantity(q-=pro.getQuantity());
					temp.setSoldat(pro.getSoldat());
					temp.setSoldon(pro.getSoldon());
					store.put(key, temp);
					return temp.copyProduct();
				}
			}
		}
		return null;
	}
	
	// add a specific product to store with pre-defined conditions
	public void addProduct(ArrayList<String> parameters){
		Product product=tools.transDataToProduct(parameters);
		if (product.isValidProduct()){
			int quantity=product.getQuantity();
			Product original=store.get(product.getSerialId());
			float curunitPrice = product.getUnitPrice();
			if (quantity!=0&&curunitPrice==0){curunitPrice=product.getBoughtat()/quantity;}
			float preUnitPrice=0;
			if (original!=null){
				quantity+=original.getQuantity();
				preUnitPrice=original.getUnitPrice();
			}
			float unitPrice;
			if (preUnitPrice != 0 && curunitPrice != 0&& preUnitPrice != curunitPrice) {
				unitPrice = (preUnitPrice + curunitPrice) / 2;
			}
			else{unitPrice=preUnitPrice==0?curunitPrice:preUnitPrice;}
			product.setUnitPrice(unitPrice);
			product.setQuantity(quantity);
			store.put(product.getSerialId(),product);
		}
	}
	
	//discard products according to a date
	public void discardProduct(Date date){
		Collection<Product> products=store.values();
		for (Product pro:products){
			if (pro.isExpiredByDate(date)){
				pro.setDiscarded(true);
			}
		}
	}
	
	//get a list of products available on a given date and sort by USEBY
	public LinkedList<String> queryProductbyDate(Date date){
		LinkedList<String> result=new LinkedList<String>();
		String temp="";
		result.add("On "+date.toString()+", following products would be available");
		Object[] objs=store.values().toArray();
		Product[] products=new Product[objs.length];
		int i=0;
		for (Object obj:objs){
			products[i]=((Product)obj).copyProduct();
			i++;
		}
		ProductComparator pc=new ProductComparator();
		pc.setKey("useby");
		tools.quickSort(products,0,products.length-1,pc);
		for (Product pro:products){
			if (!pro.isExpiredByDate(date)&&!pro.isDiscarded()){
				temp=pro.getQuantity()+" of "+pro.getProductName()+" with serial ID "+pro.getSerialId();
				if (pro.getUseby()!=null){temp+=" with a use-by date of "+pro.getUseby();}
				temp+=" are available";
				if (!"".equals(pro.getLocation())){temp+=" at "+pro.getLocation();}
				if (pro.getQuantity()<10){
					temp+=", the stock is nearly run out, you could wait for a few days if you request more";
				}
				result.add(temp);
			}
		}
		return result;
	}
	
	// query the products would be expired on a given date
	public LinkedList<Product> queryExpiredProducts(Date date){
		Collection<Product> products=store.values();
		LinkedList<Product> expiredL=new LinkedList<Product>();
		for (Product pro:products){
			if (pro.isExpiredByDate(date)){
				expiredL.add(pro.copyProduct());
			}
		}
		return expiredL;
	}
	
	/*	
	 * sort the products in the store with a specific field
	 * @param key field
	 * @return string representation of products
	 */
	public ArrayList<String> sort(String key){
		Collection<Product> products=store.values();
		int actualSize=0;
		for (Product pro:products){
			if (!pro.isDiscarded()){actualSize++;}
		}
		Product[] sortResult=new Product[actualSize];
		int i=0;
		for (Product pro:products){
			if (!pro.isDiscarded()) {
				sortResult[i] = pro.copyProduct();
				i++;
			}
		}
		ProductComparator pc=new ProductComparator();
		pc.setKey(key);
		tools.quickSort(sortResult,0,sortResult.length-1,pc);
		ArrayList<String> result=new ArrayList<String>(actualSize);
		for (Product pro:sortResult){result.add(pro.toString());}
		return result;
	}

	public void printStore(){
		for (Product pro:store.values()){
			System.out.println(pro);
			System.out.println();
		}
	}
	
	//save store info to a file
	public void saveToFile(String fileName){
		if (fileName==null||"".equals(fileName.trim())){
			fileName=defaultOuptput;
		}
		FileOutputStream output=null;
		try {
			output=new FileOutputStream(fileName);
			Collection<Product> products=store.values();
			for (Product pro:products){
				if (!pro.isDiscarded()) {
					output.write(pro.toString().getBytes());
					output.write("\n\n".getBytes());
				}
			}
		} catch (IOException e) {
			System.out.println("out put result store file error");
			e.printStackTrace();
		}finally{
			if (output!=null){
				try {output.close();
				}catch (IOException e) {e.printStackTrace();}
			}
		}
	}


}
