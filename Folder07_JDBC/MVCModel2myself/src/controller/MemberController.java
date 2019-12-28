package controller;

import controller.dto.MemberDto;
import model.service.MemberService;
import model.service.impl.MemberServiceImpl;
import view.loginView;

public class MemberController {
	//서비스와 대화한다.
	
	MemberService memServ = new MemberServiceImpl();
	
	public void login() {
		new loginView();
	}
	
	
	public void loginAf(String id, String pwd, String name, String email) {
		//회원가입시 넘겨받을 데이터. 넘겨받을것을 DB에 넣어줘야한다.
		boolean b = memServ.addMember(new MemberDto(id, pwd, name, email, 3));
		
		
		
	}//end loginAf

}//end class
