package sample01;

import java.io.Serializable;

public class human implements Serializable{

	private int num;
	private String name;
	
	public human() {
		
	}

	public human(String name, int num) {
		super();
		this.num = num;
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
