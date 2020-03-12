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
import bit.com.a.model.BbsParam;
import bit.com.a.service.BbsService;


@Controller
public class BbsController {	
	private static Logger logger = LoggerFactory.getLogger(BbsController.class);

	@Autowired
	BbsService bbsService;
	/*
	@RequestMapping(value = "bbslist.do", method=RequestMethod.GET)
	public String bbslist(Model model) {
		logger.info("BbsController bbslist " + new Date());
		
		List<BbsDto> list = bbsService.getBbsList();
		model.addAttribute("bbslist", list);
		
		return "bbslist";
	}
	*/
	@RequestMapping(value = "bbslist.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String bbslist(Model model, BbsParam param) {
		logger.info("BitBbsController bbslist " + new Date());
		
		model.addAttribute("doc_title", "글목록");
		
		// paging 처리
		int sn = param.getPageNumber();	// 0 1 2	현재 페이지
		int start = sn * param.getRecordCountPerPage() + 1; // 1, 11, 21
		int end = (sn + 1) * param.getRecordCountPerPage();	// 10, 20, 30
		
		//DB에 넣기 위한 작업수행
		param.setStart(start);
		param.setEnd(end);
				
		List<BbsDto> bbslist = bbsService.getBbsList(param);
		
		//글의 총  수
		int totalRecordCount = bbsService.getBbsCount(param);
		
		model.addAttribute("bbslist", bbslist);
		
		model.addAttribute("pageNumber", sn);
		model.addAttribute("pageCountPerScreen", 10);
		model.addAttribute("recordCountPerPage", param.getRecordCountPerPage());
		model.addAttribute("totalRecordCount", totalRecordCount);
		
		
		
		//기존
//		List<BbsDto> bbslist = bbsService.getBbsList();
		
//		for (BbsDto bbsDto : bbslist) {
//			System.out.println("bbslist 중 " + bbsDto);
//		}
		
		model.addAttribute("bbslist", bbslist);
		
		return "bbslist.tiles";
	}

	@RequestMapping(value = "bbswrite.do", method = {RequestMethod.GET,	RequestMethod.POST})
	public String bbswrite(Model model, BbsDto bbsdto) {
		logger.info("BbsController bbswrite "+ new Date());
		System.out.println("bbs write in now!!!!!");
		
		return "bbswrite.tiles";
	}

	@RequestMapping(value = "bbswriteAf.do", method = RequestMethod.POST)
//	@RequestMapping(value = "bbswriteAf.do", method = {RequestMethod.GET,	RequestMethod.POST})
	public String bbswriteAf(BbsDto bbs, Model model) {
		logger.info("BbsController bbswriteAf! "+ new Date());
		
		System.out.println( "들어온 bbs 데이터  :  " + bbs);
		
		boolean res = bbsService.writeBbs(bbs);
		
		System.out.println("결과 출력 : " + res );
		
		if(res==true) {
			return "redirect:bbslist.do";
		}else {
			return "bbslist.tiles";
		}
		
	}
	
<<<<<<< HEAD
	@RequestMapping(value = "bbswrite.do", method = {RequestMethod.GET,	RequestMethod.POST})
	public String bbswrite(Model model, BbsDto bbsdto) {
		logger.info("BbsController bbswrite "+ new Date());
		System.out.println("bbs write in now!!!!!");
		
		return "bbswrite.tiles";
	}
	
//	@RequestMapping(value = "bbswriteAf.do", method = RequestMethod.POST)
//	public String bbswriteAf(BbsDto bbs, Model model) {
//		logger.info("BbsController bbswriteAf! "+ new Date());
//		bbsService.writeBbs(bbs);
//		return "redirect:/bbslist.do";
//	}
//	
//	@RequestMapping(value = "bbsdetail.do", method = {RequestMethod.GET, RequestMethod.POST})
//	public String bbsdetail(int seq, Model model) {
//		logger.info("BbsController bbsdetail! "+ new Date());
=======
	@RequestMapping(value = "bbsdetail.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String bbsdetail(int seq, Model model) {
		logger.info("BbsController bbsdetail! "+ new Date());
		BbsDto bbs=bbsService.getBbs(seq);
		System.out.println("bbsdetail 의 seq 값 = " + seq);
		model.addAttribute("bbs", bbs);
		
		return "bbsdetail.tiles";
	}
	
	
	
	@RequestMapping(value = "bbsupdate.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String bbsupdate(int seq, Model model) {
		logger.info("BbsController bbsupdate! "+ new Date());
>>>>>>> origin/class01
//		BbsDto bbs=bbsService.getBbs(seq);
		System.out.println("bbsdetail 의 seq 값 = " + seq);
//		model.addAttribute("bbs", bbs);
		
		return "bbsdetail.tiles";
	}
	
	@RequestMapping(value = "bbsdelete.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String bbsdelete(int seq, Model model) {
		logger.info("BbsController bbsdetail! "+ new Date());
//		BbsDto bbs=bbsService.getBbs(seq);
		System.out.println("bbsdelete 의 seq 값 = " + seq);
//		model.addAttribute("bbs", bbs);
		
		return "bbsdetail.tiles";
	}
	
		
	
//	@RequestMapping(value = "answer.do", method = {RequestMethod.GET, RequestMethod.POST})
//	public String answer(int seq, Model model) throws Exception {
//		logger.info("BbsController answer! "+ new Date());
//		BbsDto bbs = bbsService.getBbs(seq);
//		model.addAttribute("_bbs", bbs);
//		return "answer";
//	}
//	
//	@RequestMapping(value = "answerAf.do", method = {RequestMethod.GET, RequestMethod.POST})
//	public String answerAf(BbsDto bbs, Model model) throws Exception {
//		logger.info("BbsController answer! "+ new Date());
//		bbsService.reply(bbs);		
//		return "redirect:/bbslist.do";
//	}
	
}







