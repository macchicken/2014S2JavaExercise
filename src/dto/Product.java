package dto;

import java.util.Calendar;
import java.util.Date;

public class Product {
	
	private String productName="";
	private int quantity=0;
	private Date boughton;
	private Date soldon;
	private Date useby;
	private float boughtat;
	private float soldat;
	private float unitPrice;
	private boolean discarded=false;//logical deletion flag
	
	
	public Product() {
		super();
	}
	
	public Product copyProduct() {
		Product another=new Product();
		another.setProductName(this.getProductName());
		another.setQuantity(this.getQuantity());
		another.setBoughton(this.getBoughton());
		another.setSoldon(this.getSoldon());
		another.setUseby(this.getUseby());
		another.setBoughtat(this.getBoughtat());
		another.setSoldat(this.getSoldat());
		another.setUnitPrice(this.unitPrice);
		another.setDiscarded(this.isDiscarded());
		return another;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Date getBoughton() {
		return boughton;
	}
	public void setBoughton(Date boughton) {
		this.boughton = boughton;
	}
	public Date getSoldon() {
		return soldon;
	}
	public void setSoldon(Date soldon) {
		this.soldon = soldon;
	}
	public Date getUseby() {
		return useby;
	}
	public void setUseby(Date useby) {
		this.useby = useby;
	}
	public float getBoughtat() {
		return boughtat;
	}
	public void setBoughtat(float boughtat) {
		this.boughtat = boughtat;
	}
	public float getSoldat() {
		return soldat;
	}
	public void setSoldat(float soldat) {
		this.soldat = soldat;
	}
	
	public float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String toString(){
		return "product: "+productName+"\nquantity: "+quantity+
				"\nboughton: "+boughton+"\nsoldon: "+soldon+"\nuseby: "+useby+
				"\nboughtat: $"+boughtat+"\nsoldat: $"+soldat;
	}
	
	// whether item is expired by today
	public boolean isExpired(){
		if (this.useby==null){return false;}
		Calendar now=Calendar.getInstance();
		return isExpiredByDate(now.getTime());
	}
	
	// whether item is expired by a given date
	public boolean isExpiredByDate(Date date){
		if (this.useby==null){return false;}
		return this.useby.before(date);
	}

	public boolean isDiscarded() {
		return discarded;
	}

	public void setDiscarded(boolean discarded) {
		this.discarded = discarded;
	}


}
