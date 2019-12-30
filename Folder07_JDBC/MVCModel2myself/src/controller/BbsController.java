package controller;

import java.util.List;

import controller.dto.BbsDto;
import model.service.BbsService;
import model.service.impl.BbsServiceImpl;
import view.BbsListView;


public class BbsController {
	//서비스와 대화한다.
	
	BbsService bbsServ = new BbsServiceImpl();
	
	public BbsController() {
		
		
	}
	
	
	//로그인 직후 글 리스트를 보여준다. 
	public void showBbsList() {
		new BbsListView();
	}

	public List<BbsDto> getBbsList(){
		
		return bbsServ.getBbsList();
	}
	
	
	


}//end class
