package EIRM14S2.service;

import EIRM14S2.repository.Inventory;
import EIRM14S2.repository.TradeRecords;
import util.Constants;

public class SortRecords implements CommandBus {

	private Inventory store;


	/**
	 * set the key for sorting, sort the records while exporting to file
	 * @param cmd - an instruction
	 */
	@Override
	public void process(String cmd) {
		String key=cmd.substring(4).trim();
		if ("serial ID".equals(key)){key="serial";}
		if (Constants.fieldMapping.containsKey(key)){
			/*ArrayList<String> sortResult=store.sort(key);
			for (String words:sortResult){
				System.out.println(words);
				System.out.println();
			}*/
			store.setSortKey(key);
		}else{
			System.out.println("invalid field for sorting "+key);
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
