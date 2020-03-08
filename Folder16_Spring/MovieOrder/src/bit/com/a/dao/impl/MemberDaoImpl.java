package bit.com.a.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.com.a.dao.MemberDao;
import bit.com.a.model.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao {
	
	@Autowired
	SqlSession sqlsession;
	String namespace = "MemberList.";
	

	@Override
	public MemberDto loginCheck(MemberDto memberdto) {
		MemberDto res = sqlsession.selectOne(namespace+"loginCheck", memberdto);
		
		
		return res;
	}

}
