package EIRM14S2.service;

import java.util.ArrayList;

import util.Constants;
import util.tools;
import EIRM14S2.repository.Inventory;
import EIRM14S2.repository.TradeRecords;

public class BoughtProdcut implements CommandBus {

	private Inventory store;
	private TradeRecords tradeRecords;
	private static BoughtProdcut my;

	public static BoughtProdcut getInstance(){
		if (my==null){
			return my=new BoughtProdcut();
		}
		return my;
	}
	/**
	 * deal with a buy instruction
	 * @param cmd - an instruction
	 */
	@Override
	public void process(String cmd) {
		ArrayList<String> parameters=new ArrayList<String>();
		String[] data=cmd.substring(3).trim().split(Constants.commonSeparator);
		for (String p:data){
				tools.processData(p.trim(),parameters);
		}
		tradeRecords.processBuyTrade(parameters, store);
	
	}

	@Override
	public void setStore(Inventory store) {
		this.store=store;
	}

	@Override
	public void setTradeRecords(TradeRecords tradeRecords) {
		this.tradeRecords=tradeRecords;
	}

}
