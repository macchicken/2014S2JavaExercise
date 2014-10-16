package EIRM14S2.service;

import EIRM14S2.repository.Inventory;
import EIRM14S2.repository.TradeRecords;

public interface CommandBus {

	public void process(String cmd);
	
	public void setStore(Inventory store);
	
	public void setTradeRecords(TradeRecords tradeRecords);
}
