package EIRM14S2;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.NoSuchElementException;

import util.Constants;
import util.tools;



public class Instructions {
	
	private ArrayList<String> cmds=new ArrayList<String>();
	private HashMap<String,LinkedList<String>> cmdResult=new HashMap<String,LinkedList<String>>();
	private String defaultReport="output\\report.txt";
	private boolean instrsOk=false;
	

	
	//save the data of store file into the database
	public void readIntoStore(String inventoryfile,Inventory store){
		BufferedReader buff = null;
		try {
			buff=new BufferedReader(new InputStreamReader(new FileInputStream(inventoryfile)));
			String oneLine;
			ArrayList<String> parameters=new ArrayList<String>();
			try {
				while((oneLine=buff.readLine())!=null){
					oneLine=oneLine.trim();
					if (!oneLine.equals("")){
						processData(oneLine,parameters);
					}
					if (oneLine.equals("")){
						store.addProduct(parameters);
						parameters.clear();
					}
				}
				if (parameters.size()!=0) {store.addProduct(parameters);}
			}catch (ParseException e) {
				System.out.println("some date parse errors ocuur "+e.getMessage());
			}
		} catch (IOException e) {
			System.out.println("read products file errors "+e.getMessage());
		}finally{
			if (buff!=null) {try {
				buff.close();
			} catch (IOException e) {
				e.printStackTrace();
			}}
		}
	}
	
	//pre-build the date with a defined format,so can use easily afterwards
	private void processData(String data,ArrayList<String> parameters) throws ParseException{
		String key=data.split(Constants.valueSeparator)[0];
		Integer field=Constants.fieldMapping.get(key);
		if (field==null){
			System.out.println("invalid field found "+data);
			return;
		}
		switch(field){
			case 1: 
				data=data.substring(7).trim();
				if (Constants.nameP.matcher(data).matches()){
					parameters.add(key+Constants.keyValueSeparator+data);
				}
				break;
			case 2: 
				data=data.substring(8).trim();
				if (Constants.dateP.matcher(data).matches()){
					String result=tools.refineDateStr(data);
					parameters.add(key+Constants.keyValueSeparator+result);
				}
				break;
			case 3: 
				data=data.substring(6).trim();
				if (Constants.dateP.matcher(data).matches()){
					String result=tools.refineDateStr(data);
					parameters.add(key+Constants.keyValueSeparator+result);
				}
				break;
			case 4: 
				data=data.substring(5).trim();
				if (Constants.dateP.matcher(data).matches()){
					String result=tools.refineDateStr(data);
					parameters.add(key+Constants.keyValueSeparator+result);
				}
				break;
			case 5: 
				data=data.substring(8).trim();
				if (Constants.priceP.matcher(data).matches()){
					parameters.add(key+Constants.keyValueSeparator+data.substring(1));
				}
				break;
			case 6: 
				data=data.substring(6).trim();
				if (Constants.priceP.matcher(data).matches()){
					parameters.add(key+Constants.keyValueSeparator+data.substring(1));
				}
				break;
			case 7: 
				data=data.substring(8).trim();
				if (Constants.numP.matcher(data).matches()){
					parameters.add(key+Constants.keyValueSeparator+data);
				}
				break;
			default:
				System.out.println("invalid field value found "+data);
		}
	}

	//read and refine the instructions list into a collection of instructions
	public void readInstrs(String instrFile){
		BufferedReader buff = null;
		try {
			buff=new BufferedReader(new InputStreamReader(new FileInputStream(instrFile)));
			String oneLine;
			String cmd="";
			while((oneLine=buff.readLine())!=null){
				oneLine=oneLine.trim();
				cmd=refineInstrs(oneLine,cmd);
			}
			if (!"".equals(cmd)){cmds.add(cmd);}
		} catch (IOException e) {
			System.out.println("some file io errors ocuur "+e.getMessage());
			instrsOk=false;
		}finally{
			if (buff!=null) {
				try {
					buff.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		instrsOk=true;
	}
	
	private String refineInstrs(String data,String cmd){
		boolean validCmd=data.startsWith("buy")||data.startsWith("sell")||
				data.startsWith("sort")||data.startsWith("discard")||data.startsWith("query");
		boolean appendPrev=cmd.startsWith("buy")||cmd.startsWith("sell")||
				cmd.startsWith("sort")||cmd.startsWith("discard")||cmd.startsWith("query");
		if (validCmd){
			if (!"".equals(cmd)){cmds.add(cmd);}
			cmd=data;
		}
		if (appendPrev&&!validCmd){cmd=cmd.concat(data);}
		return cmd;
	}
	
	private void buy(String cmd,Inventory store,TradeRecords tradeRecords){
		ArrayList<String> parameters=new ArrayList<String>();
		String[] data=cmd.substring(3).trim().split(Constants.commonSeparator);
		for (String p:data){
			try {
				processData(p.trim(),parameters);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		tradeRecords.processBuyTrade(parameters, store);
	}
	
	private void sell(String cmd,Inventory store,TradeRecords tradeRecords){
		ArrayList<String> parameters=new ArrayList<String>();
		String[] data=cmd.substring(4).trim().split(Constants.commonSeparator);
		for (String p:data){
			try {
				processData(p.trim(),parameters);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		tradeRecords.processSellTrade(parameters, store);
	}
	
	private void discard(String cmd,Inventory store){
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
	
	private void query(String cmd,Inventory store,TradeRecords tradeRecords){
		java.util.Scanner cmdSc=new java.util.Scanner(cmd);
		cmdSc.next();
		String parameter="";
		try {
			parameter = cmdSc.next();
		} catch (NoSuchElementException e1) {
			System.out.println("for query,must be a date string following");
			cmdSc.close();
			return;
		}
		if (Constants.dateP.matcher(parameter).matches()){
			cmdSc.close();
			try {
				Date date=Constants.dateFormat.parse(tools.refineDateStr(parameter));
				cmdResult.put("queryAvailable",store.queryProductbyDate(date));
			} catch (ParseException e) {
				System.out.println("not in the date format dd-MM-(yy)yy");
				return;
			}
		}else if (parameter.equals("bestsales")||parameter.equals("worstsales")){
			Date begin = null,end = null;
			boolean best=false;
			try {
				if (parameter.equals("bestsales")){best=true;}
				begin=tools.formatDateString(cmdSc.next());
				end=tools.formatDateString(cmdSc.next());
			}catch (ParseException e) {
				System.out.println("for bestsales or worstsales query please enter the date in format dd-MM-yyyy");
				return;
			}catch (NoSuchElementException nf){
				System.out.println("for bestsales or worstsales query please enter the 2 dates");
				return;
			}
			finally{cmdSc.close();}
			String[] productRoa=tradeRecords.calculateRoa(begin,end);
			if (productRoa.length!=0){
				String[] pair=productRoa[0].split(Constants.commonSeparator);
				float roa=Float.parseFloat(pair[1]);
				String productName=pair[0];
				for (int i=1;i<productRoa.length;i++){
					pair=productRoa[i].split(Constants.commonSeparator);
					if (best){
						if (roa<=Float.parseFloat(pair[1])){
							roa=Float.parseFloat(pair[1]);
							productName=pair[0];
						}
					}else{
						if (roa>=Float.parseFloat(pair[1])){
							roa=Float.parseFloat(pair[1]);
							productName=pair[0];
						}
					}
				}
				String words = "";
				LinkedList<String> result=new LinkedList<String>();
				if (best) {words = "best sales";
				}else{words = "worst sales";}
				words += " product of time peroid " + Constants.datef.format(begin) + " - "
						+ Constants.datef.format(end) + " is " + productName+ " with ROA " + roa;
				result.add(words);
				cmdResult.put("queryroa",result);
			}
		}else if (parameter.equals("profit")){
			try {
				Date begin=tools.formatDateString(cmdSc.next());
				Date end=tools.formatDateString(cmdSc.next());
				LinkedList<String> result=tradeRecords.queryProfit(begin, end, store);
				cmdResult.put("queryprofit", result);
			} catch (ParseException e) {
				System.out.println("for profit query please enter 2 dates in format dd-MM-yyyy");
			} catch (NoSuchElementException nf){
				System.out.println("for profit query please enter 2 dates in format dd-MM-yyyy");
			}
			finally{cmdSc.close();}
		}
	}
	
	//print the sort result to the console
	private void sort(String cmd,Inventory store){
		String key=cmd.substring(4).trim();
		if (Constants.fieldMapping.containsKey(key)){
			ArrayList<String> sortResult=store.sort(key);
			for (String words:sortResult){
				System.out.println(words);
				System.out.println();
			}
		}
	}

	public void processCmds(Inventory store,TradeRecords tradeRecords){
		if (!instrsOk){System.out.println("some error occur while processing instrunction file");}
		else{
			for (String cmd:cmds){
				if (cmd.startsWith("buy")){
					buy(cmd,store, tradeRecords);
					continue;
				}
				if (cmd.startsWith("sell")){
					sell(cmd,store,tradeRecords);
					continue;
				}
				if (cmd.startsWith("discard")){
					discard(cmd,store);
					continue;
				}
				if (cmd.startsWith("query")){
					query(cmd,store,tradeRecords);
					continue;
				}
				if (cmd.startsWith("sort")){
					sort(cmd,store);
					continue;
				}
			}
		}
	}
	
	//write the query results to a file
	public void exportToFile(String fileName){
		if (fileName==null||"".equals(fileName)){fileName=defaultReport;}
		FileOutputStream output=null;
		try {
			output=new FileOutputStream(fileName);
			Collection<LinkedList<String>> results=cmdResult.values();
			int i=0;
			for (LinkedList<String> result:results){
				if (i>0){output.write("---\n".getBytes());}
				for (String words:result){output.write((words+".\n").getBytes());}
				i++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if (output!=null){output.close();}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


}