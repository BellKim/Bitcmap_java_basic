package controller;

import dto.MemberDto;

public interface MemberDao {
	
	public boolean getId(String id);
	
	public boolean addMember(MemberDto dto);
	
	
	


}
