package mm01;

import mmSingleton.mmSingleton;

public class mm01 {
	mm01DTO dto = new mm01DTO("김철수", 170);
	
	public void passToM2() {
		mmSingleton ms = mmSingleton.getInstance();
//		ms.mm01dto1 = dto;
	}
	
	
	
	
	
	
}
