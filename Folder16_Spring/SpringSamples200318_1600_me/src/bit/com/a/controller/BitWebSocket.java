package bit.com.a.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bit.com.a.model.MemberDto;
import bit.com.a.model.PollDto;

@Controller
public class BitWebSocket {
	
	@RequestMapping(value = "chatting.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String polllist(Model model, HttpServletRequest req) {
		
		return "chatting.tiles";
	}
	

}
