package mm02;

import mm01.mm01DTO;
import mmSingleton.mmSingleton;

public class mm02 {
	mm01DTO mm01dto;
	
	
	public mm02() {
		// TODO Auto-generated constructor stub
	}
	
	public void receiveData() {
//		mmSingleton si = mmSingleton.getInstance();
//		mm01dto = si.mm01dto1;
		System.out.println(mm01dto.getName());
		System.out.println(mm01dto.getNum());
		
		
		
	}
	
	

}//end class
