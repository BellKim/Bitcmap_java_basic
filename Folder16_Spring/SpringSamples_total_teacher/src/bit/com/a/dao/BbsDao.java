package bit.com.a.dao;

import java.util.List;

import bit.com.a.model.BbsDto;

public interface BbsDao {
	
	public List<BbsDto> getBbsList();
	
	public boolean writeBbs(BbsDto bbs);
	
	public BbsDto getBbs(int seq);
	
	public void updateBbs(BbsDto bbs);
	
	public void deleteBbs(int seq);
}
