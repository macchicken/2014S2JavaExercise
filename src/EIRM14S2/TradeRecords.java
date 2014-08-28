package EIRM14S2;
import java.util.ArrayList;
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
	
	// the action for selling products
	public void processSellTrade(ArrayList<String> parameters,Inventory store){
		Product sellPro=tools.transDataToProduct(parameters);
		if (!"".equals(sellPro.getProductName().trim())&&sellPro.getQuantity()!=0
			&&sellPro.getSoldat()!=0&&sellPro.getSoldon()!=null){
			Product pro=null;
			if ((pro=store.updateStore(sellPro.getProductName(),sellPro))!=null){
				int soldQ=sellPro.getQuantity();
				float purchase=pro.getUnitPrice()*soldQ;
				float sold=pro.getSoldat();
				int qBegin=pro.getQuantity()+soldQ;
				Trade trade=new Trade();
				trade.doTrade(pro.getProductName(),qBegin,soldQ,purchase,sold,pro.getSoldon());
				LinkedList<Trade> tList=null;
				if ((tList=records.get(pro.getProductName()))==null){
					tList=new LinkedList<Trade>();
					records.put(pro.getProductName(),tList);
				}
				tList.add(trade);
			}
		}
	}
	
	// the action for buying products
	public void processBuyTrade(ArrayList<String> parameters,Inventory store){
		store.addProduct(parameters);
	}
	
	public String[] calculateRoa(Date begin,Date end){
		Iterator<Entry<String, LinkedList<Trade>>> it=records.entrySet().iterator();
		Entry<String, LinkedList<Trade>> cur;
		HashMap<String,Float> productProfits=new HashMap<String,Float>();
		HashMap<String,String> productQua=new HashMap<String,String>();
		while(it.hasNext()){
			cur=it.next();
			LinkedList<Trade> trades=cur.getValue();
			String proName=cur.getKey();
			for (Trade trade:trades){
				if (!trade.getTradeTime().before(begin)&&!trade.getTradeTime().after(end)){
					Float proProfit=productProfits.get(proName);
					if (proProfit==null){
						proProfit=Float.valueOf(trade.getProfit());
					}else{proProfit=Float.valueOf(proProfit.floatValue()+trade.getProfit());}
					productProfits.put(proName,proProfit);
					String quantities=productQua.get(proName);
					if (quantities==null){
						quantities=String.valueOf(trade.getQuantityBegin())
								+Constants.commonSeparator+String.valueOf(trade.getQuantityend());
					}else{
						quantities = quantities.split(Constants.commonSeparator)[0]
								+ Constants.commonSeparator+ String.valueOf(trade.getQuantityend());
					}
					productQua.put(proName,quantities);
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
			float roa=(pcur.getValue().floatValue()/(proQuaBegin+proQuaEnd))*2;
			productRoa[i]=productName+Constants.commonSeparator+String.valueOf(roa);
			i++;
		}
		return productRoa;
	}

	public float calculateTotalProfit(Date begin,Date end,Inventory store){
		java.util.Collection<LinkedList<Trade>> trades=records.values();
		float totalProfit=0;
		for (LinkedList<Trade> tradeList:trades){
			for (Trade trade:tradeList){
				if (!trade.getTradeTime().before(begin)&&!trade.getTradeTime().after(end)){
					totalProfit+=trade.getProfit();
				}
			}
		}
		return totalProfit;
	}
	
	//actions for system query profit for a period of time
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
			result.add(pro.getQuantity()+" of "+pro.getProductName()+
					" are out of date, with total cost $"+itemValue);
		}
		return result;
	}


}
