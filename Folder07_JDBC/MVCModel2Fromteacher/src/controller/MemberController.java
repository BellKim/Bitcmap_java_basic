package controller;

import javax.swing.JOptionPane;

import dto.MemberDto;
import service.MemberService;
import service.impl.MemberServiceImpl;
import singleton.Singleton;
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
	
	public void loginAf(String id, String  pwd) {
		System.out.println("id , pw " + id + "//" + pwd );
		
		MemberDto dto = memServ.login(id, pwd);
		if(dto==null) {
			JOptionPane.showMessageDialog(null, "id나 password가 틀렸습니다.");
			login();
		}else {
			JOptionPane.showMessageDialog(null, dto.getId()+"님 환영합니다.");
			//id 저장 => session 
			Singleton s = Singleton.getInstance();
			s.setLoginId(dto.getId());
			
			//bbs list controller 로 이동 
			s.bbsCtrl.getBbsList();
		}
	}
	
	public boolean idCheck(String id) {
		
		return memServ.getId(id);
	}
	
	

}//end class
