package bit.com.a.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bit.com.a.model.PdsDto;
import bit.com.a.service.PdsService;

@Controller
public class BitPdsController {

	@Autowired
	PdsService service;
	
	@RequestMapping(value = "pdslist.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String pdslist(Model model) {
		model.addAttribute("doc_title", "자료실 목록");
		
		List<PdsDto> list = service.getPdsList();
		model.addAttribute("pdslist", list);
		
		return "pdslist.tiles";		
	}
	
}







