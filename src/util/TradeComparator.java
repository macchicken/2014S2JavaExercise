package util;

import java.util.Date;

import dto.Trade;

public class TradeComparator extends MyObjectComparator {


	public TradeComparator() {
		this.key="tradeTime";
	}

	@Override
	public int compare(Object o1, Object o2) {
		if ("tradeTime".equals(this.key)) {
			Trade no1=(Trade) o1;
			Trade no2=(Trade) o2;
			Date date1 = no1.getTradeTime(), date2 = no2.getTradeTime();
			if (date1 == null) {
				if (date2 != null) {return 1;}
				return 0;
			}
			if (date1 != null && date2 == null) {return -1;}
			return date1.compareTo(date2);
		}
		return 0;
	}


}
