package Model.service;

import Controller.dto.coffeeMemberDto;

public interface MemberService {
	
	
	public boolean idcheck(String id);
	
	public coffeeMemberDto login(String id, String pw);
	
	public boolean addMember(coffeeMemberDto dto);
	
	
	
}//end class
