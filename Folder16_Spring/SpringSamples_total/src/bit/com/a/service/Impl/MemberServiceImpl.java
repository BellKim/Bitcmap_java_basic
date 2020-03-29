package bit.com.a.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.com.a.dao.MemberDao;
import bit.com.a.model.MemberDto;
import bit.com.a.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberDao memberDao;

	@Override
	public List<MemberDto> allMember() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getId(MemberDto mem) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean addmember(MemberDto mem) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public MemberDto login(MemberDto dto) {
		return memberDao.login(dto);
	}

}//end of class MemberServiceImpl
