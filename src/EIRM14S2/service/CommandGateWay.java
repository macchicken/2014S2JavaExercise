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
			return new BoughtProdcut();
		}
		if (command.startsWith("sell")){
			return new SoldProduct();
		}
		if (command.startsWith("discard")){
			return new DiscardedProdcut();
		}
		if (command.startsWith("query")){
			return new QueryData();
		}
		if (command.startsWith("sort")){
			return new SortRecords();
		}
		return null;
	}
}
