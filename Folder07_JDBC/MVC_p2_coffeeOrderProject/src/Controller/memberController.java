package Controller;

import javax.swing.JOptionPane;

import Controller.dto.coffeeMemberDto;
import Controller.dto.coffeeOrderDto;
import Model.service.MemberService;
import Model.service.impl.MemberServiceImpl;
import View.accountJoinView;
import View.loginView;
import main.singleton.Singleton;

public class memberController {
	
	MemberService memServ = new MemberServiceImpl();
	
	public boolean idCheck(String id) {
		
		return memServ.idcheck(id);
	}
	
	
	
	public void loginAf(String id, String  pwd) {
		System.out.println("id , pw " + id + "//" + pwd );
		
		coffeeMemberDto dto = memServ.login(id, pwd);
		if(dto==null) {
			JOptionPane.showMessageDialog(null, "id나 password가 틀렸습니다.");
			login();
		}else {
			JOptionPane.showMessageDialog(null, dto.getId()+"님 환영합니다.");
			//id 저장 => session 
			Singleton s = Singleton.getInstance();
			s.setLoginId(dto.getId());
			
			//bbs list controller 로 이동
			//로그인 후 다음페이지 이동 
//			s.bbsCtrl.showBbsList();
			s.orderCtrl.showOrderList();
		}
	}//loginAf
	
	public void regiAf(String id, String  pwd, String name, int age) {
		//회원가입시 넘거받을 데이터.
//		넘겨 받은것을 DB에 넣어줘야한다. 
		
		boolean b =  memServ.addMember(new coffeeMemberDto(id, pwd, name, age, 3));
		if(b) {
			JOptionPane.showMessageDialog(null, "회원가입 성공 ");
			login();//성공후 로그인해준다. 
		}else {
			JOptionPane.showMessageDialog(null, "회원가입실패 ㅇㅇㅇㅇㅇㅇㅇ ");
			regi();//다시 가입하도록 한다.
		}

		
	}//regiAf
	
	
	
	
	
	public void login() {
		new loginView();
	}
	
	public void regi() {
		new accountJoinView();
	}
	
	
	

}//end class
