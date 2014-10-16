package EIRM14S2;

import EIRM14S2.repository.Inventory;
import EIRM14S2.repository.TradeRecords;


public class EIRM {

	public static void main(String[] args) {
		String inventoryfile=args[0];
		String instrFile=args[1];
		String outputFile=args[2];
		String reportFile=args[3];
		Inventory store = Inventory.getInstance();
		TradeRecords tradeRecords=TradeRecords.getInstance();
		Instructions instrs=new Instructions();

		System.out.println("---process Inventory file---");
		instrs.readIntoStore(inventoryfile,store);
		System.out.println("---finish Inventory file---");
		
		/*the buy and sell action of same product should be group in a ascending order of bought on
		  and sold on date, otherwise the quantity of product in the system would be inconsistent,
		if the system would have to deal with that situation, it would get complicated,
		also the rule of ordering the actions are not clear as well,
		or maybe just ignore those actions*/
		System.out.println("---process instructions file---");
		instrs.readInstrs(instrFile);
		System.out.println("---finish instructions file---");
		
		System.out.println("---process saved instructions---");
		instrs.processCmds(store,tradeRecords);
		System.out.println("---finish instructions---");
		
		instrs.exportToFile(reportFile);//write the query results to a file
		store.saveToFile(outputFile);//save store info to a file
	}

}
