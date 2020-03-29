package bit.com.a.controller;

import java.lang.reflect.Member;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bit.com.a.model.MemberDto;
import bit.com.a.service.MemberService;

@RestController	
public class MemberController {

	// service 추가
	@Autowired
	MemberService service;
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/getid")
	public String getId(String id){
		System.out.println("MemberController getId()");
		
		int count = service.getId(id);
		if(count > 0) {
			return "NO";
		}else {
			return "YES";
		}
	}
	
	@RequestMapping(value = "/account", method = RequestMethod.POST)
	public String account(MemberDto dto) {		
		System.out.println(dto.toString());
		
		boolean b = service.addmember(dto);
		if(b) {
			System.out.println("회원가입되었습니다 " + new Date());
			return "YES";
		}
		return "NO";
	}
	
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public MemberDto login(MemberDto dto) {		
		System.out.println(dto.toString());
		
		MemberDto mem = service.login(dto);
		
		return mem;
	}
	
	
	
	
	
}//end of class






