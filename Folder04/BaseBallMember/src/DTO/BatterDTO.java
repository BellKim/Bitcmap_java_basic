package DTO;

public class BatterDTO extends HumanDTO{
	
	private int batCount;
	private int hitCount;
	private double batAvg;
	
	public BatterDTO() {
		// TODO Auto-generated constructor stub
	}

	public BatterDTO(int batCount, int hitCount, double batAvg) {
		super();
		this.batCount = batCount;
		this.hitCount = hitCount;
		this.batAvg = batAvg;
	}
	
	

	public BatterDTO(int number, String name, int age, int height, int batCount, int hitCount, double batAvg) {
		super(number, name, age, height);
		this.batCount = batCount;
		this.hitCount = hitCount;
		this.batAvg = batAvg;
	}

	public int getBatCount() {
		return batCount;
	}

	public void setBatCount(int batCount) {
		this.batCount = batCount;
	}

	public int getHitCount() {
		return hitCount;
	}

	public void setHitCount(int hitCount) {
		this.hitCount = hitCount;
	}

	public double getBatAvg() {
		return batAvg;
	}

	public void setBatAvg(double batAvg) {
		this.batAvg = batAvg;
	}

	@Override
	public String toString() {
		return "BatterDTO [batCount=" + batCount + ", hitCount=" + hitCount + ", batAvg=" + batAvg + "]";
	}
	
	
	
	
	
	

}//end of class
