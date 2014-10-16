package EIRM14S2.repository;

import java.util.HashMap;
import java.util.LinkedList;

public class CommandResult {

	private HashMap<String,LinkedList<String>> results;
	private static CommandResult my;
	
	public static CommandResult getInstance(){
		if (my==null){
			return my=new CommandResult();
		}
		return my;
	}

	public CommandResult() {
		results=new HashMap<String,LinkedList<String>>();
	}

	public HashMap<String, LinkedList<String>> getResults() {
		return results;
	}

	public void addResult(String key,LinkedList<String> result){
		results.put(key, result);
	}


}
