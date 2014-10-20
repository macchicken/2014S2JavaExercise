package EIRM14S2.service;

public class CommandGateWay {

	/**
	 * create specific service to process the command
	 * return null if not specified
	 * @param command
	 * @return CommandBus service
	 */
	public CommandBus commandService(String command){
		if (command.startsWith("buy")){
			return BoughtProdcut.getInstance();
		}
		if (command.startsWith("sell")){
			return SoldProduct.getInstance();
		}
		if (command.startsWith("discard")){
			return DiscardedProdcut.getInstance();
		}
		if (command.startsWith("query")){
			return QueryData.getIntance();
		}
		if (command.startsWith("sort")){
			return SortRecords.getInstance();
		}
		return null;
	}
}
