package bit.com.a.service;

import java.util.List;

import bit.com.a.model.PdsDto;
import bit.com.a.model.PollDto;
import bit.com.a.model.PollSubDto;

public interface PdsService {

	public List<PdsDto> getPdsList();	
	public boolean uploadPds(PdsDto dto);
	
	public PdsDto getPds(int seq);
	
	public boolean updatePds(PdsDto dto);
	

}
