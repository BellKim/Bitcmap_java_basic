package model.dao;

import controller.dto.MemberDto;

public interface MemberDao {
	
	
	
	public MemberDto login(String id, String pwd);
	
	public int addMember(MemberDto dto);

	public int idCheck(String id);
	
//	public MemberDto deleteMember(MemberDto dto);

}
