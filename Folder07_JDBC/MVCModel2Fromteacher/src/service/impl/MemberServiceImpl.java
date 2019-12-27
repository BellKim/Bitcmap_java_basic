package service.impl;

import controller.MemberDao;
import dao.impl.MemberDaoImpl;
import dto.MemberDto;
import service.MemberService;

///controller 와 dao의 중간역할자. 
public class MemberServiceImpl implements MemberService {
	
	MemberDao dao = new MemberDaoImpl();


	@Override
	public boolean getId(String id) {
		// TODO Auto-generated method stub
		return dao.getId(id);
	}


	@Override
	public boolean addMember(MemberDto dto) {
		// TODO Auto-generated method stub
		return dao.addMember(dto);
	}
	
	
	
	

}
