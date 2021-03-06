package EIRM14S2.service;

import java.text.ParseException;
import java.util.Date;

import util.Constants;
import util.tools;
import EIRM14S2.repository.Inventory;
import EIRM14S2.repository.TradeRecords;

public class DiscardedProdcut implements CommandBus {

	private Inventory store;

	private static class DiscardedProdcutHolder{
		private static final DiscardedProdcut my=new DiscardedProdcut(); 
	}
	public static DiscardedProdcut getInstance(){
		return DiscardedProdcutHolder.my;
	}

	private DiscardedProdcut(){}

	/**
	 * discard the items
	 * @param cmd - an instruction
	 */
	@Override
	public void process(String cmd) {
		String parameter=cmd.substring(7).trim();
		if (Constants.dateP.matcher(parameter).matches()){
			try {
				Date date=Constants.dateFormat.parse(tools.refineDateStr(parameter));
				store.discardProduct(date);
			} catch (ParseException e) {
				System.out.println("some date parse errors ocuur "+e.getMessage());
			}
		}
	}

	@Override
	public void setStore(Inventory store) {
		this.store=store;
	}

	@Override
	public void setTradeRecords(TradeRecords tradeRecords) {
		return;
	}

}
