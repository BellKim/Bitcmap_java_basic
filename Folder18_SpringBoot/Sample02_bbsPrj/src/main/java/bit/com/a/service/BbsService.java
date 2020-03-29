package bit.com.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bit.com.a.dao.BbsDao;
import bit.com.a.model.BbsDto;
import bit.com.a.model.BbsParam;

@Service
@Transactional
public class BbsService {
	@Autowired
	BbsDao dao;
	
	public List<BbsDto> getBbsList(BbsParam param){
		return dao.getBbsList(param);
	}
	
	//글의 총수
	public int getBbsCount(BbsParam param) {
		return dao.getBbsCount(param);
	}
	
	
}//end of class
