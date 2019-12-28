package model.dao;

import controller.dto.MemberDto;

public interface MemberDao {
	
	
	
	public MemberDto login(String id, String pwd);
	
	public boolean addMember(MemberDto dto);
	
//	public MemberDto deleteMember(MemberDto dto);

}
