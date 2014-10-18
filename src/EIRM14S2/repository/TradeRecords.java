package EIRM14S2.repository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;

import util.Constants;
import util.ProductComparator;
import util.tools;
import dto.Product;
import dto.Trade;


public class TradeRecords {
	
	//{productName,list of corresponding product's trade}
	private HashMap<String,LinkedList<Trade>> records=new HashMap<String,LinkedList<Trade>>();
	private static TradeRecords my;
	

	public static TradeRecords getInstance(){
		if (my==null){
			return my=new TradeRecords();
		}
		return my;
	}
	
	/**
	 * the action for selling products,save the records
	 * @param parameters - a target item
	 * @param store - the database of store
	 */
	public void processSellTrade(ArrayList<String> parameters,Inventory store){
		Product sellPro=tools.transDataToProduct(parameters);
		if (sellPro.isValidProduct()&&sellPro.getSoldat()!=0&&sellPro.getSoldon()!=null){
			Product pro;
			if ((pro=store.updateStore(sellPro.getSerialId(),sellPro))!=null){
				int soldQ=sellPro.getQuantity();
				float purchase=pro.getUnitPrice()*soldQ;
				float sold=pro.getSoldat();
				int qBegin=pro.getQuantity()+soldQ;
				Trade trade=new Trade();
				trade.doTrade(pro.getProductName(),pro.getSerialId(),qBegin,soldQ,purchase,sold,pro.getSoldon());
				LinkedList<Trade> tList;
				if ((tList=records.get(pro.getSerialId()))==null){
					tList=new LinkedList<Trade>();
					records.put(pro.getSerialId(),tList);
				}
				tList.add(trade);
			}
		}
	}
	
	/**
	 * the action for buying products
	 * @param parameters - a target item
	 * @param store - the database of store
	 */
	public void processBuyTrade(ArrayList<String> parameters,Inventory store){
		store.addProduct(parameters);
	}
	
	/**
	 * calculate the return of asset(ROA) for a collection of items
	 * during a period of time
	 * @param begin - time
	 * @param end - time
	 * @return - a list of items with their ROA
	 */
	public String[] calculateRoa(Date begin,Date end){
		Collection<LinkedList<Trade>> tradesC=records.values();
		HashMap<String,Float> productProfits=new HashMap<String,Float>();
		HashMap<String,String> productQua=new HashMap<String,String>();
		for (LinkedList<Trade> trades:tradesC){
			for (Trade trade:trades){
				if (!trade.getTradeTime().before(begin)&&!trade.getTradeTime().after(end)){
					Float proProfit=productProfits.get(trade.getTradeProduct());
					if (proProfit==null){
						proProfit=trade.getProfit();
					}else{proProfit=proProfit+trade.getProfit();}
					productProfits.put(trade.getTradeProduct(),proProfit);
					String quantities=productQua.get(trade.getTradeProduct());
					if (quantities==null){
						quantities=String.valueOf(trade.getQuantityBegin())
								+Constants.commonSeparator+String.valueOf(trade.getQuantityend());
					}else{
						quantities = quantities.split(Constants.commonSeparator)[0]
								+ Constants.commonSeparator+ String.valueOf(trade.getQuantityend());
					}
					productQua.put(trade.getTradeProduct(),quantities);
				}
			}
		}
		String[] productRoa=new String[productProfits.size()];
		Iterator<Entry<String, Float>> prfit=productProfits.entrySet().iterator();
		Entry<String,Float> pcur;
		int i=0;
		while(prfit.hasNext()){
			pcur=prfit.next();
			String productName=pcur.getKey();
			String[] proQuantities=productQua.get(productName).split(Constants.commonSeparator);
			int proQuaBegin=Integer.parseInt(proQuantities[0]);
			int proQuaEnd=Integer.parseInt(proQuantities[1]);
			float roa=(pcur.getValue()/(proQuaBegin+proQuaEnd))*2;
			productRoa[i]=productName+Constants.commonSeparator+String.valueOf(roa);
			i++;
		}
		return productRoa;
	}

	/**
	 * calculate the total profit during a period of time
	 * @param begin - time
	 * @param end - time
	 * @param store - the database of store
	 * @return - total profit
	 */
	public float calculateTotalProfit(Date begin,Date end,Inventory store){
		Collection<LinkedList<Trade>> tradesC=records.values();
		float totalProfit=0;
		for (LinkedList<Trade> tradeList:tradesC){
			for (Trade trade:tradeList){
				if (!trade.getTradeTime().before(begin)&&!trade.getTradeTime().after(end)){
					totalProfit+=trade.getProfit();
				}
			}
		}
		return totalProfit;
	}
	
	/**
	 * actions for system query profit for a period of time
	 * @param begin - time
	 * @param end - time
	 * @param store - the database of store
	 * @return - a statement of query result
	 */
	public LinkedList<String> queryProfit(Date begin,Date end,Inventory store){
		float totalProfit=calculateTotalProfit(begin, end, store);
		LinkedList<Product> expiredL=store.queryExpiredProducts(end);
		Product[] products=new Product[expiredL.size()];
		int i=0;
		for (Product pro:expiredL){
			products[i]=pro;
			i++;
		}
		ProductComparator pc=new ProductComparator();
		pc.setKey("value");
		tools.quickSort(products, 0, products.length-1, pc);
		expiredL.clear();
		for (int j=products.length-1;j>=0;j--){
			expiredL.add(products[j]);
		}
		LinkedList<String> result=new LinkedList<String>();
		result.add("the net income gained during "
				+ Constants.datef.format(begin) + " - "
				+ Constants.datef.format(end) + " is $" + totalProfit);
		for (Product pro:expiredL){
			float itemValue=pro.getUnitPrice()*pro.getQuantity();
			String temp=pro.getQuantity()+" of "+pro.getProductName()+" with serial ID "+pro.getSerialId()+
					" are out of date, with total cost $"+itemValue;
			if (!"".equals(pro.getLocation())){temp+=" at "+pro.getLocation();}
			result.add(temp);
		}
		return result;
	}


}
