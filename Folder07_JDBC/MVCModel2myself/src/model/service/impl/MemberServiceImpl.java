package model.service.impl;

import controller.dto.MemberDto;
import model.dao.MemberDao;
import model.dao.impl.MemberDaoImpl;
import model.service.MemberService;

public class MemberServiceImpl implements MemberService{
	MemberDao dao = new MemberDaoImpl();

	@Override
	public MemberDto login(String id, String pwd) {
		
		return dao.login(id, pwd);
	}

	@Override
	public boolean addMember(MemberDto dto) {
		
		int res  = dao.addMember(dto);
		if(res > 0) {
			return true;
		}else{
			return false;
		}
		
		
	}

	@Override
	public boolean idcheck(String id) {
		int res = dao.idCheck(id);
		if(res > 0 ) {
			return true;
		}else {
			return false;
		}
	}



	

}// end class
