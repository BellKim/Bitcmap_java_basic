package model.service.impl;

import java.util.List;

import controller.dto.BbsDto;
import model.dao.BbsDao;
import model.dao.impl.BbsDaoImpl;
import model.service.BbsService;

public class BbsServiceImpl implements BbsService{
	BbsDao bbsdao = new BbsDaoImpl();

	@Override
	public List<BbsDto> getBbsList() {
		List<BbsDto> list = bbsdao.getBbsListDao();
//		for (BbsDto bbsDto : list) {
//			System.out.println(" bbsDao 내의 "+bbsDto);
//		}
		
		return list;
	}
	
	
	

}
