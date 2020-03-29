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
	MemberService memberService;
	

	private static Logger logger = LoggerFactory.getLogger(MemberController.class);

	@RequestMapping(value = "test.do", method=RequestMethod.GET)
	public String test(Model model) {
		logger.info("MemberController test " + new Date());			
		
		return "test";
	}
	
	
	@RequestMapping(value = "login.do", method=RequestMethod.GET)
	public String allmember(Model model) {
		logger.info("MemberController login " + new Date());			
		
		return "login.tiles";
	}
	
	@RequestMapping(value = "logout.do", method=RequestMethod.GET)
	public String logout(Model model, HttpServletRequest req ) {
		logger.info("MemberController logout " + new Date());	
		
		// session out
		req.getSession().removeAttribute("login");
		
		
		return "login.tiles";
	}
	
	@RequestMapping(value="loginAf.do", method=RequestMethod.POST)
	public String loginAf(MemberDto dto, HttpServletRequest req, Model model) {
		logger.info("MemberController loginAf " + new Date());
	//	logger.info(dto.toString());
		System.out.println("들어온 dto 출력 :::::::: " + dto);
		// service -> id, pwd		
		MemberDto login = memberService.login(dto);
		System.out.println("login 출력 :::::::: " + login);
		
		if(login != null && login.getId().equals("") == false) {
			logger.info("login success! " + new Date());
			// login success
			req.getSession().setAttribute("login", login);
			req.getSession().setMaxInactiveInterval(60 * 60 * 365);
			
			
//			model.addAttribute("message", "1");
			return "redirect:/bbslist.do";			
//			return "MessageAlert";
		}else {
			return "redirect:/login.do";
		}
	}
	
	
	
	
	@RequestMapping(value = "regi.do", method=RequestMethod.GET)
	public String regi() {
		logger.info("MemberController regi " + new Date());			
		
		return "regi.tiles";
	}
	
	
	

	
	
}





