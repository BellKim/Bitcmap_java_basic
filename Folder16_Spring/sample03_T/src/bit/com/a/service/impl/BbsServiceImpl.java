package bit.com.a.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.com.a.dao.BbsDao;
import bit.com.a.model.BbsDto;
import bit.com.a.service.BbsService;

@Service
public class BbsServiceImpl implements BbsService, BbsDao {
	
	@Autowired
	BbsDao bbsDao;

	@Override
	public List<BbsDto> getBbsList() {
		return bbsDao.getBbsList();
	}
	
	
	
	
	
	
	

}//end of BbsServiceImpl
