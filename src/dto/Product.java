package dto;

import java.util.Calendar;
import java.util.Date;

public class Product {
	
	private String productName="";
	private String serialId="";
	private int quantity=0;
	private Date boughton;
	private Date soldon;
	private Date useby;
	private float boughtat;
	private float soldat;
	private float unitPrice;
	private String location="";
	private boolean discarded=false;//logical deletion flag
	
	
	public Product() {
		super();
	}
	
	public Product copyProduct() {
		Product another=new Product();
		another.setProductName(this.productName);
		another.setSerialId(this.serialId);
		another.setQuantity(this.quantity);
		another.setBoughton(this.boughton);
		another.setSoldon(this.soldon);
		another.setUseby(this.useby);
		another.setBoughtat(this.boughtat);
		another.setSoldat(this.soldat);
		another.setUnitPrice(this.unitPrice);
		another.setLocation(this.location);
		another.setDiscarded(this.discarded);
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

	public String getSerialId() {
		return serialId;
	}

	public void setSerialId(String serialId) {
		this.serialId = serialId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String toString(){
		return "product: "+productName+"\nserial ID: "+serialId+"\nquantity: "+quantity+
				"\nboughton: "+boughton+"\nsoldon: "+soldon+"\nuseby: "+useby+
				"\nboughtat: $"+boughtat+"\nsoldat: $"+soldat+"\nprice: $"+unitPrice+
				"\nlocation: "+location;
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

	public boolean isValidProduct(){
		return !"".equals(productName)&&!"".equals(serialId);
	}

	public boolean isDiscarded() {
		return discarded;
	}

	public void setDiscarded(boolean discarded) {
		this.discarded = discarded;
	}


}
