package bit.com.a.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.com.a.dao.MemberDao;
import bit.com.a.model.MemberDto;
import bit.com.a.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	MemberDao memberdao;	//memberdao를 스프링프레임워크에서 넣어준다. 의존성 주입을 해준다. 

	@Override
	public List<MemberDto> allMember() {
		
		return memberdao.allMember();
	}//end of allMember

	@Override
	public int logincheck(String receiveId) {
		return memberdao.logincheck(receiveId);
	}

	@Override
	public boolean addmember(MemberDto memberdto) {
		
		
		return memberdao.addmember(memberdto);
	}

	@Override
	public MemberDto login(MemberDto memberdto) {
		
		return memberdao.login(memberdto);
	}
	
	

	
}//end of class



