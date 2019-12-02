package DTO;

public class PitcherDTO extends HumanDTO{
	
	private int win;
	private int lose;
	private double ratio;//승률
	
	public PitcherDTO() {
		super();
	}

	public PitcherDTO(int win, int lose, double ratio) {
		super();
		this.win = win;
		this.lose = lose;
		this.ratio = ratio;
	}
	
	

	public PitcherDTO(int number, String name, int age, int height, int win, int lose, double ratio) {
		super(number, name, age, height);
		this.win = win;
		this.lose = lose;
		this.ratio = ratio;
	}

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public int getLose() {
		return lose;
	}

	public void setLose(int lose) {
		this.lose = lose;
	}

	public double getRatio() {
		return ratio;
	}

	public void setRatio(double ratio) {
		this.ratio = ratio;
	}

	@Override
	public String toString() {
		return "PitcherDTO [win=" + win + ", lose=" + lose + ", ratio=" + ratio + "]";
	}
	

}//end of class
