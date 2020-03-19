package bit.com.a.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bit.com.a.model.Youtube;
import bit.com.a.model.YoutubeSave;
import bit.com.a.service.BitYoutubeService;
import bit.com.a.util.YoutubeParser;

@Controller
public class BitYoutubeController {
	
	@Autowired
	private YoutubeParser youtubeParser;
	
	@Autowired
	private BitYoutubeService service;
	
	
	@RequestMapping(value = "yutube.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String yutube(String s_keyword, Model model) {
		model.addAttribute("doc_title", "youtube");
		if(s_keyword != null && !s_keyword.equals("")) {
			ArrayList<Youtube> getTitles = youtubeParser.getTitles(s_keyword);		//getTitle(s_keyword);
			model.addAttribute("yulist", getTitles);
			model.addAttribute("s_keyword", s_keyword);
		}
		return "youtube.tiles";
	}//end of methods
	
	@ResponseBody
	@RequestMapping(value = "youtubesave.do", method= {RequestMethod.GET, RequestMethod.POST})
	public YoutubeSave yutube(YoutubeSave y) {
		service.writeYoutube(y);
		YoutubeSave ysave = service.getYoutube(y);
		return ysave;
		
	}//end of method
	
	
	@RequestMapping(value = "youtubesavelist.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String yutube(Model model) {
		model.addAttribute("doc_title", "youtube");
		System.out.println("저장된 유튜브 리스트 ");
		return "youtubesavelist.tiles";
	}//end of methods
	
	
	
	
	
}//end of class
