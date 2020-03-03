package bit.com.a.dao;

import java.util.List;

import bit.com.a.model.MemberDto;

public interface MemberDao {
	public List<MemberDto> allMember();

	public int logincheck(String receiveId);
	
	public boolean addmember(MemberDto memberdto);
	
	public MemberDto login(MemberDto memberdto);
	
	

}
