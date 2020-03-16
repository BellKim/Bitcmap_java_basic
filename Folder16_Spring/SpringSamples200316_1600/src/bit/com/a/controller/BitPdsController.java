package bit.com.a.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import bit.com.a.model.PdsDto;
import bit.com.a.service.PdsService;
import bit.com.a.util.FUpUtil;

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
	
	@RequestMapping(value = "pdswrite.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String pdswrite(Model model) {
		model.addAttribute("doc_title", "자료 올리기");
		
		return "pdswrite.tiles";
	}
	
	@RequestMapping(value = "pdsupload.do", method= RequestMethod.POST)
	public String pdsupload(PdsDto pdsdto, 
				@RequestParam(value = "fileload", required = false)MultipartFile fileload,
					HttpServletRequest req) {
		
		// filename 취득
		String filename = fileload.getOriginalFilename();	
		pdsdto.setFilename(filename);
		
		// upload 경로 설정
		// tomcat
		String fupload = req.getServletContext().getRealPath("/upload");
		
		// 폴더
	//	String fupload = "d:\\tmp";
		
		System.out.println("fupload:" + fupload); // 업로드 위치
		
		// file명을 변경
		String f = pdsdto.getFilename();
		String newfilename = FUpUtil.getNewFileName( f );
		
		pdsdto.setFilename(newfilename);
		
		File file = new File(fupload + "/" + newfilename);
		
		try {
			// 실제 파일 업로드 되는 부분
			FileUtils.writeByteArrayToFile(file, fileload.getBytes());
			
			// db 저장
			service.uploadPds(pdsdto);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/pdslist.do";
	}
	
	@RequestMapping(value = "pdsdetail.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String pdsdetail(int seq, Model model) {
		model.addAttribute("doc_title", "자료 보기");
		
		// readcount
		
		// dto 취득
		PdsDto pdsdto = service.getPds(seq);
		model.addAttribute("pds", pdsdto);
		
		return "pdsdetail.tiles";
	}
	
	@RequestMapping(value = "fileDownLoad.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String fileDownLoad(String filename, int seq, HttpServletRequest req, Model model) {
	
		// download 경로
		// tomcat
		String fupload = req.getServletContext().getRealPath("/upload");
		
		// 폴더
		// String fupload = "d:\\tmp";
		
		File downloadFile = new File(fupload + "/" + filename);
		
		model.addAttribute("downloadFile", downloadFile);
		model.addAttribute("seq", seq);
		
		return "downloadView";		
	}
	
	
}







