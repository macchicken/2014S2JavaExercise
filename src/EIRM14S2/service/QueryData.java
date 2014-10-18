package EIRM14S2.service;

import java.text.ParseException;
import java.util.Date;
import java.util.LinkedList;
import java.util.NoSuchElementException;

import util.Constants;
import util.tools;
import EIRM14S2.repository.CommandResult;
import EIRM14S2.repository.Inventory;
import EIRM14S2.repository.TradeRecords;

public class QueryData implements CommandBus {

	private Inventory store;
	private TradeRecords tradeRecords;


	/**
	 * deal with query
	 * @param cmd - an instruction
	 */
	@Override
	public void process(String cmd) {
		java.util.Scanner cmdSc=new java.util.Scanner(cmd);
		cmdSc.next();
		String parameter;
		CommandResult cmdResult=CommandResult.getInstance();
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
				cmdResult.addResult("queryAvailable", store.queryProductbyDate(date));
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
				String words;
				LinkedList<String> result=new LinkedList<String>();
				if (best) {words = "best sales";
				}else{words = "worst sales";}
				words += " product of time peroid " + Constants.datef.format(begin) + " - "
						+ Constants.datef.format(end) + " is " + productName+ " with ROA " + roa;
				result.add(words);
				cmdResult.addResult("queryroa",result);
			}
		}else if (parameter.equals("profit")){
			try {
				Date begin=tools.formatDateString(cmdSc.next());
				Date end=tools.formatDateString(cmdSc.next());
				LinkedList<String> result=tradeRecords.queryProfit(begin, end, store);
				cmdResult.addResult("queryprofit", result);
			} catch (ParseException e) {
				System.out.println("for profit query please enter 2 dates in format dd-MM-yyyy");
			} catch (NoSuchElementException nf){
				System.out.println("for profit query please enter 2 dates in format dd-MM-yyyy");
			}
			finally{cmdSc.close();}
		}
	}

	@Override
	public void setStore(Inventory store) {
		this.store=store;
	}

	@Override
	public void setTradeRecords(TradeRecords tradeRecords) {
		this.tradeRecords=tradeRecords;
	}

}
