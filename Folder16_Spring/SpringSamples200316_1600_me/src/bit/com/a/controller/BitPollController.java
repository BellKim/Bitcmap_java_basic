package bit.com.a.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bit.com.a.model.PollBean;
import bit.com.a.model.PollDto;
import bit.com.a.service.BitPollService;

@Controller
public class BitPollController {
	/*
	투표항목 1. 좋아하는과일
	튜ㅜ표보기 		1. 사과 배 귤, 		2. 손예진 수지 등등
	투표자 
	*/
	@Autowired
	BitPollService pollService;
	
	@RequestMapping(value="polllist.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String polllist(Model model, HttpServletRequest req) {
		model.addAttribute("doc_title", "투표목록");
		
		String id = (String) req.getSession().getAttribute("name");
		
		List<PollDto> list=pollService.getPollAllList(id);
		model.addAttribute("plists", list);
		
		
		
		
		return "polllist.tiles";
		
	}
	
	@RequestMapping(value="pollmake.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String pollmake(Model model) {
		model.addAttribute("doc_title", "투표만들기");
		
		
		return "pollmake.tiles";
		
	}
	
	@RequestMapping(value="pollmakeAf.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String pollmakeAf(PollBean pbean) {
		pollService.makePoll(pbean);
		
		
		
		return "redirect:/polllist.do";
		
	}//end of pollmakeAf class
	

	
	
	
	

}//end of class
