package bit.com.a.dao;

import java.util.List;

import bit.com.a.model.BbsDto;
import bit.com.a.model.BbsParam;

public interface BbsDao {
	
//	public List<BbsDto> getBbsList();
	
	public List<BbsDto> getBbsList(BbsParam param);
	
	public int  getBbsCount(BbsParam param);
	
	public boolean writeBbs(BbsDto bbsdto);
	
	public BbsDto getBbs(int seq);
	
	
	
}
