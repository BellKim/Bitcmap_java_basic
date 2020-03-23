package bit.com.a.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController		// ==controller + Responsebody(AJAX) -> RESTFUL
public class MemberController {
	
//	@Autowired
	
	
	@RequestMapping(value="/login", method= RequestMethod.GET)
	public String login(String id, String pwd) throws Exception{
		System.out.println("test()");
		
		System.out.println("id" + id);
		System.out.println("pwd" + pwd);
		
		return "id="+id + "\npw="+ pwd +" 들어옴";
	}

}
