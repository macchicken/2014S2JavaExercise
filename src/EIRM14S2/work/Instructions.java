package EIRM14S2.work;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import util.tools;
import EIRM14S2.service.CommandBus;
import EIRM14S2.service.CommandGateWay;
import EIRM14S2.repository.CommandResult;
import EIRM14S2.repository.Inventory;
import EIRM14S2.repository.TradeRecords;



public class Instructions {
	
	private ArrayList<String> cmds=new ArrayList<String>();
	private String defaultReport="output\\report.txt";
	private boolean instrsOk=false;
	
	
	/**
	 * save the data of store file into the store
	 * @param inventoryfile - a products file
	 * @param store - the database of store
	 */
	public void readIntoStore(String inventoryfile,Inventory store){
		BufferedReader buff = null;
		try {
			buff=new BufferedReader(new FileReader(inventoryfile));
			String oneLine;
			ArrayList<String> parameters=new ArrayList<String>();
			try {
				while((oneLine=buff.readLine())!=null){
					oneLine=oneLine.trim();
					if (!oneLine.equals("")){
						tools.processData(oneLine,parameters);
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
	
	/**
	 * read and refine the instructions list into a collection of instructions
	 * @param instrFile - an instructions file
	 */
	public void readInstrs(String instrFile){
		BufferedReader buff = null;
		try {
			buff=new BufferedReader(new FileReader(instrFile));
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
	
	/**
	 * refine instructions if an instruction written in multiple lines
	 * @param data - a line of data in the file
	 * @param cmd - a line of command in the file
	 * @return an instruction
	 */
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
	
	/**
	 * process the command in the instruction file
	 * different command process is in the specific class
	 * @param store - the database of store
	 * @param tradeRecords - the database of trade records
	 */
	public void processCmds(Inventory store,TradeRecords tradeRecords){
		if (!instrsOk){System.out.println("some error occur while processing instrunction file");}
		else{
			CommandBus cb;
			CommandGateWay cgw=new CommandGateWay();
			for (String cmd:cmds){
				cb=cgw.commandService(cmd);
				if (cb!=null) {
					cb.setStore(store);
					cb.setTradeRecords(tradeRecords);
					cb.process(cmd);
				}else{System.out.println(cmd+" is not supported");}
			}
		}
	}
	
	/**
	 * write the query results to a file
	 * @param fileName - a report file
	 */
	public void exportToFile(String fileName){
		if (fileName==null||"".equals(fileName)){fileName=defaultReport;}
		FileOutputStream output=null;
		try {
			output=new FileOutputStream(fileName);
			CommandResult cmdResult=CommandResult.getInstance(); 
			Collection<LinkedList<String>> results=cmdResult.getResults().values();
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