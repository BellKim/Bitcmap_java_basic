package bit.com.a.service;

import java.util.List;

import bit.com.a.model.BbsDto;
import bit.com.a.model.BbsParam;

public interface BbsService {
	

//	public List<BbsDto> getBbsList();
	public List<BbsDto> getBbsList(BbsParam param);
	
	public int getBbsCount(BbsParam param);

	boolean writeBbs(BbsDto bbs);
	
	public BbsDto getBbs(int seq);
	
	public void reply(BbsDto bbs) throws Exception;

	
}
