package day09.chap01;

import com.google.gson.Gson;

//JSON 직접 ㅏㄴ들어보기
//JAVASCRIPT OBJECT Nottion
public class Car {
	private int id;
	private String plateNumber;
	private String type;
	private String color;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPlateNumber() {
		return plateNumber;
	}
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
//	@Override
//	public String toString() {
////		JSON객체는 {} 으로 묶인다.
////		스트링벨류값은 "" 으로 묵는다.
////		필드의 이름을 key라고 부르고 실제들어오는 값을 value라고 칭한ㄷ.
////		key는 항상 String이고 "" 으로 묶는다.
////		value는 int 나 String이 될 수 있고 String일때는 "" 로 묶는다.
////		https://mvnrepository.com/
//		
////		return "{\"id\":"+id+", "+
////		"\"plateNumber\":\""+plateNumber+"\", " + 
////		"\"type\":\""+type+"\", "+
////		"\"color\":\""+color+"\"}";
//		
//		Gson g = new Gson();
//		return g.toJson(this).toString();
//	}
	
	
	
	
	
	
	

}
