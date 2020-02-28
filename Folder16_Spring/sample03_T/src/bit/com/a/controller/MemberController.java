package bit.com.a.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
	
	@RequestMapping(value = "allmember.do", method=RequestMethod.GET)
	public String allmember(Model model) {
		logger.info("MemberController allmember " + new Date());
		
		List<MemberDto> list = memberService.allMember();	
		
		model.addAttribute("memlist", list);		
		
		return "allMember";
	}
	
	@RequestMapping(value = "login.do", method=RequestMethod.GET)
	public String login() {
		logger.info("MemberController login " + new Date());
		return "login";
	}
	
	@RequestMapping(value = "regi.do", method=RequestMethod.GET)
	public String regi() {
		logger.info("MemberController regi " + new Date());
		return "regi";
	}
	
	@ResponseBody
	@RequestMapping(value="idcheck.do", method=RequestMethod.POST)
	public String idcheck(MemberDto mem) {
		logger.info("KhMemberController getId " + new Date());
		
		int count = memberService.getId(mem);
		
		logger.info("count = " + count);
		String msg = "";
		if(count > 0) {
			msg = "NO";
		}else {
			msg = "YES";
		}
		return msg;
	}
	
	@RequestMapping(value = "regiAf.do", method=RequestMethod.POST)
	public String regiAf(MemberDto dto) {
		logger.info("MemberController regiAf " + new Date());
		
		boolean b = memberService.addmember(dto);
		if(b) {
			logger.info("회원 가입되었습니다 " + new Date());
			return "login";
		}
		logger.info("가입되지 않았습니다 " + new Date());
		return "regi";
	}
	
	@RequestMapping(value = "loginAf.do", method=RequestMethod.POST)
	public String loginAf(MemberDto dto, HttpServletRequest req) {//id, pw만 넘어옴. 
		logger.info("MemberController loginAf " + new Date());
		logger.info("dto.tostring()" + dto.toString());
		
		//service -> id, pwd
		MemberDto login = memberService.login(dto);
		
		logger.info("login memberdto().tostring " + login.toString());
		if(login != null && login.getId().equals("") == false) {
			//login success
			req.getSession().setAttribute("login", login);
			req.getSession().setMaxInactiveInterval(60*60*365);
			logger.info("login success");
			return "redirect:/bbslist.do";
			
		}else {
			//login false
			return "login";
			//혹은
			//return "redirect:/login";
			//사용가능
			
		}

		
	}
	
	
	
}





