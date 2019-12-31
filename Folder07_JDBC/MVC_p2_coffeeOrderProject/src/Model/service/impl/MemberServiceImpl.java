package Model.service.impl;

import java.util.Iterator;

import Controller.dto.coffeeMemberDto;
import Model.dao.MemberDao;
import Model.dao.impl.MemberDaoImpl;
import Model.service.MemberService;

public class MemberServiceImpl implements MemberService{
	
	MemberDao memDao = new MemberDaoImpl();

	@Override
	public coffeeMemberDto login(String id, String pwd) {

		return memDao.loginAf(id, pwd);
	}

	@Override
	public boolean idcheck(String id) {
		int res = memDao.idcheck(id);
		if(res > 0 ) {
			return true;
		}else {
			return false;
		}
		

	}

	@Override
	public boolean addMember(coffeeMemberDto dto) {
		System.out.println("입력된 데이터 출력 ");
		System.out.println(dto.toString());
		
		
	
		
			if(memDao.addmemberIns(dto) != 0) {
				return true;
			} else {
				return false;
			}
	}

//	@Override
//	public boolean loginAf() {
//		
//		return memDao.logAf(String id);
//	}



}
