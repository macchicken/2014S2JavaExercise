package EIRM14S2.service;

import java.text.ParseException;
import java.util.ArrayList;

import util.Constants;
import util.tools;
import EIRM14S2.Inventory;
import EIRM14S2.TradeRecords;

public class SoldProduct implements CommandBus {

	private Inventory store;
	private TradeRecords tradeRecords;


	/**
	 * deal with a sell instruction
	 * @param cmd - an instruction
	 */
	@Override
	public void process(String cmd) {
		ArrayList<String> parameters=new ArrayList<String>();
		String[] data=cmd.substring(4).trim().split(Constants.commonSeparator);
		for (String p:data){
			try {
				tools.processData(p.trim(),parameters);
			} catch (ParseException e) {
				e.printStackTrace();
			}
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
