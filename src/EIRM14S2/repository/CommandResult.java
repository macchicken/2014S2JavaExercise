package EIRM14S2.repository;

import java.util.HashMap;
import java.util.LinkedList;

public class CommandResult {

	private HashMap<String,LinkedList<String>> results;
	private static class CommandResultHolder{
		private static final CommandResult my=new CommandResult();
	}
	
	public static CommandResult getInstance(){
		return CommandResultHolder.my;
	}

	private CommandResult() {
		results=new HashMap<String,LinkedList<String>>();
	}

	public HashMap<String, LinkedList<String>> getResults() {
		return results;
	}

	public void addResult(String key,LinkedList<String> result){
		results.put(key, result);
	}


}
