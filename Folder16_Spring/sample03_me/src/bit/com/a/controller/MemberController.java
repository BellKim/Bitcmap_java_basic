package bit.com.a.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bit.com.a.model.MemberDto;
import bit.com.a.service.MemberService;

@Controller
public class MemberController {
	
	private static Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value="allmember.do", method=RequestMethod.GET)
	public String allmember(Model model) {
		logger.info("MemberController allmember " + new Date());
		List<MemberDto> list = memberService.allMember();	
		
		model.addAttribute("memlist", list);
		
		
		return "allMember";
		
	}//end of allmember
	
	
	
	@RequestMapping(value="login.do", method=RequestMethod.GET)
	public String login(Model model) {
		logger.info("MemberController login " + new Date());
		
		return "login";
		
	}//end of allmember
	
	
	@RequestMapping(value="loginAf.do", method=RequestMethod.GET)
	public String loginAf(MemberDto dto) {
		logger.info("MemberController  loginAf " + new Date());
		
		System.out.println("loginAf 의  들어온 dto 의 값 : " + dto);
		
		//service -> id, pwd
		MemberDto login = memberService.login(dto);
				
				
		
		if(login != null && login.getId().equals("") == false) {
			
			
		}
		
		
		
		
		
//		boolean b = memberService.addmember(dto);

		
		
		return "allMember";
		
	}//end of allmember
	

	
	
	
	@ResponseBody	//ajax 를 사용할때는 반드시 붙혀야 한다. 빼고나서 실행하면 ajax 가 실행이 안된다.
	@RequestMapping(value="loginCheck.do", produces="application/String; charset=utf-8", method = RequestMethod.GET)
	public String loginCheck(HttpServletRequest req, HttpServletResponse resp) {
		logger.info("MemberController loginCheck" + new Date());
		
		
		//int res = memberService.logincheck(receiveId);
		String str = "데이터 넘어감";
		return str;
	}//end of loginCheck();;;;;

}//end of class
