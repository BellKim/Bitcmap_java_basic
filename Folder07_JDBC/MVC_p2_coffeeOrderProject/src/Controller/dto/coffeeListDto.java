package Controller.dto;
/*	
CREATE TABLE COFFEELIST(
	coffee_index NUMBER(4),
	coffeeName VARCHAR2(100),
	coffeeSize NUMBER(1),
	sizePrice NUMBER(5),
	CONSTRAINT PR_COFFEELIST_01 PRIMARY KEY(coffee_index)
);
 */

public class coffeeListDto {
	private int coffee_index;
	private String coffeeName;
	private int coffeeSize;
	private int sizePrice;
	
	
	
	public coffeeListDto(int coffee_index, String coffeeName, int coffeeSize, int sizePrice) {
		super();
		this.coffee_index = coffee_index;
		this.coffeeName = coffeeName;
		this.coffeeSize = coffeeSize;
		this.sizePrice = sizePrice;
	}
	
	public int getCoffee_index() {
		return coffee_index;
	}
	public void setCoffee_index(int coffee_index) {
		this.coffee_index = coffee_index;
	}
	public String getCoffeeName() {
		return coffeeName;
	}
	public void setCoffeeName(String coffeeName) {
		this.coffeeName = coffeeName;
	}
	public int getCoffeeSize() {
		return coffeeSize;
	}
	public void setCoffeeSize(int coffeeSize) {
		this.coffeeSize = coffeeSize;
	}
	public int getSizePrice() {
		return sizePrice;
	}
	public void setSizePrice(int sizePrice) {
		this.sizePrice = sizePrice;
	}

	@Override
	public String toString() {
		return "coffeeMember [coffee_index=" + coffee_index + ", coffeeName=" + coffeeName + ", coffeeSize="
				+ coffeeSize + ", sizePrice=" + sizePrice + "]";
	}
	
	
	

}//end class
