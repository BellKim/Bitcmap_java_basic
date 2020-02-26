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

import bit.com.a.model.MemberDto;
import bit.com.a.service.MemberService;

@Controller
public class MemberController {
	
	private static Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	MemberService memberservice;
	
	@RequestMapping(value="allmember.do", method=RequestMethod.GET)
	public String allmember(Model model, HttpSession sees) {
		
		logger.info("MemberController allmember" + new Date());
			
		List<MemberDto> list = memberservice.allMember();
//		/memlist
		
		model.addAttribute("memlist", list);
		
		
		return "allMember";
		
	}//end of allmember
	
	
	
	@RequestMapping(value="loginCheck.do", method = RequestMethod.GET)
	public int loginCheck(HttpServletRequest req, HttpServletResponse resp) {
		logger.info("MemberController loginCheck" + new Date());
		String receiveId = req.getParameter("id");
		
		int res = memberservice.logincheck(receiveId);
		
		return 1;
	}//end of loginCheck();;;;;

}//end of class
