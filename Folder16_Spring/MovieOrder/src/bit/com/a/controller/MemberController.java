package bit.com.a.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bit.com.a.model.MemberDto;
import bit.com.a.service.MemberService;




@Controller
public class MemberController {
	
	@Autowired
	MemberService memberservice;
	
	private  static Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@RequestMapping(value ="login.do", method=RequestMethod.GET)
	public String login() {
		System.out.println("login");
		logger.info("MemberController login " + new Date());
		return "loginNjoin/login";
		
	}
	
	
	@RequestMapping(value ="logout.do", method=RequestMethod.GET)
	public String logout(HttpServletRequest req) {
		System.out.println("logout");
		logger.info("MemberController logout " + new Date());
		logger.info("로그인  화면으로 이동합니다. ");
		
		req.getSession().removeAttribute("login");
		logger.info(" session 삭제 ");
		
		return "loginNjoin/login";
		
	}//end of logout  
	
	@RequestMapping(value ="join.do", method=RequestMethod.GET)
	public String join() {
		System.out.println("join Member ");
		logger.info("MemberController login " + new Date());
		return "loginNjoin/join";
	}
	
	@RequestMapping(value ="loginCheck.do", method=RequestMethod.GET)
	public String loginCheck(MemberDto memberdto, HttpServletRequest req, Model model) {
		//파라미터 : id, password
		
		System.out.println("memberdto = " + memberdto);
		System.out.println("loginCheck Member ");
		logger.info("loginCheck login " + new Date());
		
		MemberDto login = memberservice.loginCheck(memberdto);
		
		if(memberdto.getId().equals(login.getId()) && memberdto.getPwd().equals(login.getPwd())  ) {
			System.out.println("일치");
			// login success
			req.getSession().setAttribute("login", login);
			req.getSession().setMaxInactiveInterval(60 * 60 * 365);
			return "../../main/main";
		} else {
			System.out.println("불일치");
			return "loginNjoin/login";
		}
	}
	
	
	@RequestMapping(value ="findpassword.do", method=RequestMethod.GET)
	public String findpassword() {
		System.out.println("findpassword Member ");
		logger.info("findpassword login " + new Date());
		return "loginNjoin/join";
	}
	
	
	
	
	

}//end of MemberController class
