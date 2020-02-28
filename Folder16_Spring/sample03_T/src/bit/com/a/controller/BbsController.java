package bit.com.a.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bit.com.a.model.BbsDto;
import bit.com.a.service.BbsService;

@Controller
public class BbsController {
	
	private static Logger logger = LoggerFactory.getLogger(BbsController.class);
	
	@Autowired
	BbsService bbsService;

	@RequestMapping(value="bbslist.do", method=RequestMethod.GET)
	public String bbslist(Model model) {
		logger.info("bbsController bbslist + " + new Date());
		
		List<BbsDto> list = bbsService.getBbsList();
		model.addAttribute("bbslist", list);
		
		
		return "bbslist";

	}//end bbslist

	
	@RequestMapping(value="bbsdetail.do", method=RequestMethod.GET)
	public String bbsdetail(Model model) {
		logger.info("bbsController bbsdetail + " + new Date());
		
		List<BbsDto> list = bbsService.getBbsList();
		model.addAttribute("bbslist", list);
		
		
		return "bbslist";

	}//end bbslist

	
	
	
	
	
	
	
	

}//end of BbsController
