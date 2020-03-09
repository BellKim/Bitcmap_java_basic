package bit.com.a.service.serviecImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.com.a.dao.BbsDao;
import bit.com.a.model.BbsDto;
import bit.com.a.service.BbsService;

@Service
public class bbsServiceImpl implements BbsService {

	@Autowired
	BbsDao bbsDao; // = new BbsDaoImpl();

	@Override
	public List<BbsDto> getBbsList() {		
		return bbsDao.getBbsList();
	}
	
	
}
	