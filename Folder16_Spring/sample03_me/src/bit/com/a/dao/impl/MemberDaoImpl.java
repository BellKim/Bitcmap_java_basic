package bit.com.a.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.com.a.dao.MemberDao;
import bit.com.a.model.MemberDto;


@Repository
public class MemberDaoImpl implements MemberDao{
	
	//DB와 통신
	@Autowired	//<--객체생성(의존성)
	SqlSession sqlsession;	//applicationContext.xml 의 <bean="id sqlsession 부분과 연결이 된다. 
							//autowired 로 연결해두면 자바 어디서든 사용 할 수 있다. //싱글톤처럼 사용할 수 있다. 
	String namespace = "Member.";//네임스페이스를 연결해서 나가게 된다. 

	@Override
	public List<MemberDto> allMember() {
		List<MemberDto> list = sqlsession.selectList(namespace + "allMember");
		
		
		return list;
		
	}

	@Override
	public int logincheck(String receiveId) {
		int res = sqlsession.selectOne(namespace+"duplicate_check", receiveId);
		return res;
	}//end logincheck();

	@Override
	public boolean addmember(MemberDto memberdto) {
		int res = sqlsession.insert(namespace+"addmember", memberdto);
		return res>0?true:false;
		
	}//end addmember

	@Override
	public MemberDto login(MemberDto memberdto) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	

}//end of memberdtoImpl()
