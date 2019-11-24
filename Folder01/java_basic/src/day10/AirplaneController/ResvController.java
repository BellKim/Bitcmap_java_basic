package day10.AirplaneController;

import java.util.ArrayList;

import day10.AirplaneDTO.ResvDTO;

public class ResvController {
	ArrayList<ResvDTO> list;
	
	public ResvController() {
		list = new ArrayList<ResvDTO>();
		
		
	}//end
	
	public void insert(ResvDTO r) {
		if(list.size()==0) {
			r.setId(1);
			list.add(r);
		}else {
			r.setId(list.get(list.size()-1).getId()+1);
		}
		list.add(r);
		
	}
	

}
