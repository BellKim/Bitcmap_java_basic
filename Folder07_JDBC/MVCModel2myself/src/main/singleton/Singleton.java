package main.singleton;

import controller.BbsController;
import controller.MemberController;
import controller.dto.BbsDto;

public class Singleton {
	
	private String loginId = null;	//로그인정보
	
	private BbsDto bbsbdto = null;
	
	
	private static Singleton s = null;
	
	public MemberController memCtrl = null;
	public BbsController bbsCtrl = null;
	
	
	
	
	public Singleton() {
		memCtrl = new MemberController();
		bbsCtrl = new BbsController();
	}
	
	
	
	public static Singleton getInstance() {
		if(s == null) {
			s = new Singleton();
		}
		return s;
	}



	public String getLoginId() {
		return loginId;
	}
	



	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}


	
	

	public BbsDto getBbsbdto() {
		System.out.println(bbsbdto.getSeq());
		System.out.println(bbsbdto.getId());
		System.out.println(bbsbdto.getTitle());
		System.out.println(bbsbdto.getContent());
		System.out.println(bbsbdto.getWdate());
		System.out.println(bbsbdto.getDel());
		System.out.println(bbsbdto.getReadcount());
		return bbsbdto;
	}



	public void setBbsbdto(BbsDto bbsbdto) {
		this.bbsbdto = bbsbdto;

	}



	




//	public BbsDto sendDto(BbsDto bbsDto) {
//		return bbsDto;
//	}
//	

	

}//end class
