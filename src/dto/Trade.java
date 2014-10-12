package dto;

import java.util.Date;

public class Trade {
	

	private String tradeProduct;
	private String productSerialID;
	private Date tradeTime;
	private int quantityBegin=0;
	private int quantityend=0;
	private float profit=0;
	private float purchase=0;

	public String getTradeProduct() {
		return tradeProduct;
	}
	public Date getTradeTime() {
		return tradeTime;
	}
	public int getQuantityBegin() {
		return quantityBegin;
	}
	public int getQuantityend() {
		return quantityend;
	}
	public float getProfit() {
		return profit;
	}
	public float getPurchase() {
		return purchase;
	}
	
	public String getProductSerialID() {
		return productSerialID;
	}

	/**
	 * save the trade detail
	 * @param tradeProduct - product name
	 * @param productSerialID
	 * @param quantityBegin - quantity before selling
	 * @param soldQuantity - amount of item for selling
	 * @param purchase - purchase price
	 * @param sold - sold price
	 * @param tradeTime
	 */
	public void doTrade(String tradeProduct, String productSerialID, int quantityBegin,
			int soldQuantity, float purchase, float sold, Date tradeTime) {
		this.profit = sold - purchase;
		this.purchase = purchase;
		this.quantityBegin = quantityBegin;
		this.quantityend = quantityBegin-soldQuantity;
		this.tradeTime = tradeTime;
		this.tradeProduct = tradeProduct;
		this.productSerialID = productSerialID;
	}

}
