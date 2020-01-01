package Controller.dto;

import View.OrderList_03_ShowAll;

public class orderList {
	private String Name;
	private int nameNumber;
	private String size;
	private String syrup;
	private boolean addShot;
	private boolean whiping;
	private int amount;
	
	public orderList() {
	
	}

	public orderList(String name, String size, String syrup, boolean addShot, boolean whiping, int amount) {
		super();
		Name = name;
		this.size = size;
		this.syrup = syrup;
		this.addShot = addShot;
		this.whiping = whiping;
		this.amount = amount;
	}

	public orderList(String name, int nameNumber, String size, String syrup, boolean addShot, boolean whiping,
			int amount) {
		super();
		Name = name;
		this.nameNumber = nameNumber;
		this.size = size;
		this.syrup = syrup;
		this.addShot = addShot;
		this.whiping = whiping;
		this.amount = amount;
	}

	public int getNameNumber() {
		return nameNumber;
	}

	public void setNameNumber(int nameNumber) {
		this.nameNumber = nameNumber;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getSyrup() {
		return syrup;
	}

	public void setSyrup(String syrup) {
		this.syrup = syrup;
	}

	public boolean isAddShot() {
		return addShot;
	}

	public void setAddShot(boolean addShot) {
		this.addShot = addShot;
	}

	public boolean isWhiping() {
		return whiping;
	}

	public void setWhiping(boolean whiping) {
		this.whiping = whiping;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "orderList [Name=" + Name + ", nameNumber=" + nameNumber + ", size=" + size + ", syrup=" + syrup
				+ ", addShot=" + addShot + ", whiping=" + whiping + ", amount=" + amount + "]\n";
	}

	

}//end classs
