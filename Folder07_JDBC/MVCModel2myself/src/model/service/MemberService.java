package model.service;

import controller.dto.MemberDto;

public interface MemberService {
	
	public MemberDto login(String id, String pwd);
	
	public boolean addMember(MemberDto dto);

	public boolean idcheck(String id);
	
	

}
