package Controller.dto;

import java.sql.Date;

public class coffeeOrderDto {
	private int ORDER_INDEX;
	private int MEMBERINDEX;
	private int coffee_index;
	private Date order_date;
	private int coffee_size;
	private boolean SYRUP;
	private boolean ADDSHOT;
	private boolean	ADDWHIPING;
	private int AMOUNT;
	
	
	public coffeeOrderDto() {
		// TODO Auto-generated constructor stub
	}

	
	public coffeeOrderDto(int oRDER_INDEX, int mEMBERINDEX, int coffee_index, Date order_date, int coffee_size,
			boolean sYRUP, boolean aDDSHOT, boolean aDDWHIPING, int aMOUNT) {
		super();
		ORDER_INDEX = oRDER_INDEX;
		MEMBERINDEX = mEMBERINDEX;
		this.coffee_index = coffee_index;
		this.order_date = order_date;
		this.coffee_size = coffee_size;
		SYRUP = sYRUP;
		ADDSHOT = aDDSHOT;
		ADDWHIPING = aDDWHIPING;
		AMOUNT = aMOUNT;
	}


	public int getORDER_INDEX() {
		return ORDER_INDEX;
	}


	public void setORDER_INDEX(int oRDER_INDEX) {
		ORDER_INDEX = oRDER_INDEX;
	}


	public int getMEMBERINDEX() {
		return MEMBERINDEX;
	}


	public void setMEMBERINDEX(int mEMBERINDEX) {
		MEMBERINDEX = mEMBERINDEX;
	}


	public int getCoffee_index() {
		return coffee_index;
	}


	public void setCoffee_index(int coffee_index) {
		this.coffee_index = coffee_index;
	}


	public Date getOrder_date() {
		return order_date;
	}


	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}


	public int getCoffee_size() {
		return coffee_size;
	}


	public void setCoffee_size(int coffee_size) {
		this.coffee_size = coffee_size;
	}


	public boolean isSYRUP() {
		return SYRUP;
	}


	public void setSYRUP(boolean sYRUP) {
		SYRUP = sYRUP;
	}


	public boolean isADDSHOT() {
		return ADDSHOT;
	}


	public void setADDSHOT(boolean aDDSHOT) {
		ADDSHOT = aDDSHOT;
	}


	public boolean isADDWHIPING() {
		return ADDWHIPING;
	}


	public void setADDWHIPING(boolean aDDWHIPING) {
		ADDWHIPING = aDDWHIPING;
	}


	public int getAMOUNT() {
		return AMOUNT;
	}


	public void setAMOUNT(int aMOUNT) {
		AMOUNT = aMOUNT;
	}


	@Override
	public String toString() {
		return "coffeeOrderDto [ORDER_INDEX=" + ORDER_INDEX + ", MEMBERINDEX=" + MEMBERINDEX + ", coffee_index="
				+ coffee_index + ", order_date=" + order_date + ", coffee_size=" + coffee_size + ", SYRUP=" + SYRUP
				+ ", ADDSHOT=" + ADDSHOT + ", ADDWHIPING=" + ADDWHIPING + ", AMOUNT=" + AMOUNT + "] \n";
	}



}//end class
