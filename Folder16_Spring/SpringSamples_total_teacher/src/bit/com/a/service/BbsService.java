package bit.com.a.service;

import java.util.List;

import bit.com.a.model.BbsDto;

public interface BbsService {

	public List<BbsDto> getBbsList();
	
	public boolean writeBbs(BbsDto bbs);
	
	public BbsDto getBbs(int seq);
	
	public void updateBbs(BbsDto bbs);
	
	public void deleteBbs(int seq);
}
