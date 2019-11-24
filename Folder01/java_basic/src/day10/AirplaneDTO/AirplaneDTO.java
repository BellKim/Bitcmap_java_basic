package day10.AirplaneDTO;

import java.util.Calendar;

public class AirplaneDTO {
	private int id;
	private int startCityId;
	private int endCityId;
	private Calendar departTime;
	private Calendar arrivalTime;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStartCityId() {
		return startCityId;
	}
	public void setStartCityId(int startCityId) {
		this.startCityId = startCityId;
	}
	public int getEndCityId() {
		return endCityId;
	}
	public void setEndCityId(int endCityId) {
		this.endCityId = endCityId;
	}
	public Calendar getDepartTime() {
		return departTime;
	}
	public void setDepartTime(Calendar departTime) {
		this.departTime = departTime;
	}
	public Calendar getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(Calendar arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	
	
}
