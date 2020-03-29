package bit.com.a.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.com.a.dao.MemberDao;
import bit.com.a.model.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao  {
	@Autowired		// <- 객체 생성 (의존성)
	SqlSession sqlSession;
	
	String namespace = "Member.";

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
		MemberDto mem = sqlSession.selectOne(namespace + "login", dto);
		return mem;
	}

}
