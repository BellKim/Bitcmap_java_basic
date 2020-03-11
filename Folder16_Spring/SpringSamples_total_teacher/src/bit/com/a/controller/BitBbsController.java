package bit.com.a.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bit.com.a.model.BbsDto;
import bit.com.a.service.BbsService;

@Controller
public class BitBbsController {

	@Autowired
	BbsService bbsService;
	
	@RequestMapping(value = "bbslist.do", method=RequestMethod.GET)
	public String bbslist(Model model) {						
		model.addAttribute("doc_title", "글목록");
		
		List<BbsDto> bbslist = bbsService.getBbsList();			
		model.addAttribute("bbslist", bbslist);
		
		return "bbslist.tiles";
	}	
	
	@RequestMapping(value = "bbswrite.do", method = {RequestMethod.GET,	RequestMethod.POST})
	public String bbswrite(Model model) {		
		model.addAttribute("doc_title", "글쓰기");
		
		return "bbswrite.tiles";
	}
	
	@RequestMapping(value = "bbswriteAf.do", method = RequestMethod.POST)
	public String bbswriteAf(BbsDto bbs, Model model) throws Exception {
		if(bbs.getContent().equals("") || bbs.getTitle().equals("")){
			return "bbswrite.tiles";
		}
		bbsService.writeBbs(bbs);
		return "redirect:/bbslist.do";
	}
	
	@RequestMapping(value = "bbsdetail.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String bbsdetail(int seq, Model model) {		
		model.addAttribute("doc_title", "상세글 보기");
		
		BbsDto bbs=bbsService.getBbs(seq);
		model.addAttribute("bbs", bbs);
		return "bbsdetail.tiles";
	}
	
	@RequestMapping(value = "bbsupdate.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String bbsupdate(int seq, Model model){		
		
		BbsDto bbs=bbsService.getBbs(seq);		
		model.addAttribute("bbs", bbs);		
		return "bbsupdate.tiles";
	}
	
	@RequestMapping(value = "bbsupdateAf.do", 
			method = RequestMethod.POST)
	public String bbsupdateAf(BbsDto bbs,Model model) throws Exception {		
		bbsService.updateBbs(bbs);
		return "redirect:/bbslist.do";
	}
	
	@RequestMapping(value = "bbsdelete.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String deleteBbs(int seq, Model model) {		
		bbsService.deleteBbs(seq);
		return "redirect:/bbslist.do";		
	}
}












