package bit.com.a.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {

	private static Logger logger = LoggerFactory.getLogger(MemberController.class);

	@RequestMapping(value = "login.do", method=RequestMethod.GET)
	public String allmember(Model model) {
		logger.info("MemberController login " + new Date());			
		
		return "login.tiles";
	}
	
	
}





