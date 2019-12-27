package controller;

import java.util.List;

import dto.BbsDto;
import service.BbsService;
import service.impl.BbsServiceImpl;

public class BbsController {
	//서비스가 생성된다.
	BbsService bbsServ = new BbsServiceImpl();
	
	public void getBbsList() {
		List<BbsDto> list = bbsServ.getBbsList();
	}
	
	
	
	

}
