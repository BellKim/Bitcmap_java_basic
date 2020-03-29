package bit.com.a.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.com.a.dao.MemberDao;
import bit.com.a.model.MemberDto;
import bit.com.a.service.MemberService;

@Service
public class MemberDaoServiceImpl implements MemberService {
	
	@Autowired
	MemberDao memberdao;

	@Override
	public MemberDto loginCheck(MemberDto memberdto) {
		return memberdao.loginCheck(memberdto);
	}
	
	

}//end of MemberDaoServiceImpl 
