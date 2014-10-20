package EIRM14S2.service;

import java.util.ArrayList;

import util.Constants;
import util.tools;
import EIRM14S2.repository.Inventory;
import EIRM14S2.repository.TradeRecords;

public class SoldProduct implements CommandBus {

	private Inventory store;
	private TradeRecords tradeRecords;
	private static SoldProduct my;
	
	public static SoldProduct getInstance(){
		if (my==null){
			return my=new SoldProduct();
		}
		return my;
	}
	/**
	 * deal with a sell instruction
	 * @param cmd - an instruction
	 */
	@Override
	public void process(String cmd) {
		ArrayList<String> parameters=new ArrayList<String>();
		String[] data=cmd.substring(4).trim().split(Constants.commonSeparator);
		for (String p:data){
				tools.processData(p.trim(),parameters);
		}
		tradeRecords.processSellTrade(parameters, store);
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
