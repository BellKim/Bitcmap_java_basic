package model.service.impl;

import controller.dto.MemberDto;
import model.dao.MemberDao;
import model.dao.impl.MemberDaoImpl;
import model.service.MemberService;

public class MemberServiceImpl implements MemberService{
	MemberDao dao = new MemberDaoImpl();

	@Override
	public MemberDto login(String id, String pwd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addMember(MemberDto dto) {
		
		return dao.addMember(dto);
	}



	

}
