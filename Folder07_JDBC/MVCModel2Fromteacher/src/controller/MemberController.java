package controller;

import javax.swing.JOptionPane;

import dto.MemberDto;
import service.MemberService;
import service.impl.MemberServiceImpl;
import view.accountView;
import view.loginView;


//서비스와 대화한다. 
public class MemberController {
	
	MemberService memServ = new MemberServiceImpl();
	//싱글턴으로 접근. 
	
	public void login() {
		new loginView();
	}
	
	public void regi() {
		new accountView();
	}
	
	public void regiAf(String id, String pwd, String name, String email) {
		//회원가입시 넘거받을 데이터.
//		넘겨 받은것을 DB에 넣어줘야한다. 
		boolean b =  memServ.addMember(new MemberDto(id, pwd, name, email, 3));
		if(b) {
			JOptionPane.showMessageDialog(null, "회원가입 성공 ");
			login();//성공후 로그인해준다. 
		}else {
			JOptionPane.showMessageDialog(null, "회원가입실패 ㅇㅇㅇㅇㅇㅇㅇ ");
			regi();//다시 가입하도록 한다.
		}
		
	}
	
	public boolean idCheck(String id) {
		
		return memServ.getId(id);
	}
	
	

}//end class
