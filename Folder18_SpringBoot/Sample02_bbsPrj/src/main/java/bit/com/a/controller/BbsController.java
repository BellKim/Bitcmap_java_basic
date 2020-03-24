package bit.com.a.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bit.com.a.model.BbsDto;
import bit.com.a.model.BbsParam;
import bit.com.a.model.MemberDto;
import bit.com.a.service.BbsService;

@RestController
public class BbsController {
	
	// service 추가
	@Autowired
	BbsService service;
	
	
	@RequestMapping(value = "/getBbsPageList", method = RequestMethod.GET)
	public List<BbsDto> getBbsPageList(BbsParam param) {
		
		System.out.println("getBbsPageList get bbspagelist() ");
		System.out.println(param.toString());
		
		int sn = param.getPageNumber() - 1;	//0 1 2 
		int start = sn * param.getRecordCountPerPage() + 1;	// 1~ 11
		int end = (sn + 1) * param.getRecordCountPerPage();	//10 20
		
		param.setStart(start);
		param.setEnd(end);
		List<BbsDto> list = service.getBbsList(param);
		
		return list;
	}
	
	
	@RequestMapping(value = "/getBbsCount", method = RequestMethod.GET)
	public int getBbsCount(BbsParam param) {
		
		System.out.println("getBbsPageList get bbspagelist() ");
		System.out.println(param.toString());
		
		
		int count = service.getBbsCount(param);
		
		return count;
		
	}
	
	
	

}//end of class
