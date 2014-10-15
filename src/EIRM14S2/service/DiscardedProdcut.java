package EIRM14S2.service;

import java.text.ParseException;
import java.util.Date;

import util.Constants;
import util.tools;
import EIRM14S2.Inventory;
import EIRM14S2.TradeRecords;

public class DiscardedProdcut implements CommandBus {

	private Inventory store;


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
				e.printStackTrace();
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
