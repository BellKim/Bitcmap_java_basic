package bit.com.a.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import bit.com.a.model.MemberDto;
import bit.com.a.service.MemberService;

@RestController	// == controller + Responsebody(Ajax) -> Restful
public class HelloController {

	//service 추가
	@Autowired
	MemberService service;
	
	
	
	@RequestMapping(value="/test", method= RequestMethod.GET)
	public String test() throws Exception{
		System.out.println("test()");
		
		return "test";
	}
	
	
	
	@RequestMapping(value="/member", method= RequestMethod.GET)
	public MemberDto getMember() throws Exception{
		System.out.println("getMember()");
		MemberDto dto = new MemberDto("아이디", "비번", "이름", "이메일", 3);
		
		
		return dto;
		
	}
	
	
	@RequestMapping(value="/dbtest", method= RequestMethod.GET)
	public List<MemberDto> dbtest() throws Exception{
		System.out.println("dbtest()");
		
		List<MemberDto> list = service.allMember();
		 
		System.out.println("출렭검ㄹ이ㅏㅓ"+list );
		
		return list;
		
	}
	
	@RequestMapping(value="/conn_param", method= RequestMethod.GET)
	public String conn_param(String title) throws Exception{
		System.out.println("conn_param()");
		
		System.out.println("title : " + title);
		
		
		return "통신 get success ss";
		
	}
	
	@RequestMapping(value="/conn_post_param", method= RequestMethod.POST)
	public String conn_post_param(String title, String content) throws Exception{
		System.out.println("conn_post_param()");
		
		System.out.println("title : " + title);
		System.out.println("content : " + content);
		
		
		return "통신 post succcesss";
		
	}
	
	
	
	
}//end of class
