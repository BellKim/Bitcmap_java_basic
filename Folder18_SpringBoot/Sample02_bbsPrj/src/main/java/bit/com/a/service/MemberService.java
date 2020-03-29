package bit.com.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bit.com.a.dao.MemberDao;
import bit.com.a.model.MemberDto;

@Service
@Transactional
public class MemberService {

	@Autowired
	private MemberDao dao;
	
	public int getId(String id) {
		return dao.getId(id);
	}
	
	public boolean addmember(MemberDto dto) {
		int len = dao.addmember(dto);
		return len>0?true:false;
	}
	
	public MemberDto login(MemberDto dto) {
		
		return dao.login(dto);
	}
	
	
}//end of class






