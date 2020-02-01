package Model.dao;

import Controller.dto.coffeeMemberDto;

public interface MemberDao {
	public coffeeMemberDto loginAf(String id, String pwd);

	public int idcheck(String id);
	
	public int addmemberIns(coffeeMemberDto dto );
	
	
	
}//end class
