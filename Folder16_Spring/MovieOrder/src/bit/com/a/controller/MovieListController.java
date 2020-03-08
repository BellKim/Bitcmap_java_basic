package bit.com.a.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bit.com.a.service.MemberService;

@Controller
public class MovieListController {
	
	@Autowired
	MemberService memberservice;
	
	private  static Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@RequestMapping(value ="movieListUp.do", method=RequestMethod.GET)
	public String movieListUp() {
		System.out.println("movieListUp");
		logger.info("MemberController movieListUp " + new Date());
		
		return "loginNjoin/login";
	}
	

}
