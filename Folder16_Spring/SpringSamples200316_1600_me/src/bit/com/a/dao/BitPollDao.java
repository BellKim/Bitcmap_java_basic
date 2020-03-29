package bit.com.a.dao;

import java.util.List;


import bit.com.a.model.PollDto;
import bit.com.a.model.PollSubDto;
import bit.com.a.model.Voter;

public interface BitPollDao {
	
	public List<PollDto> getPollAllList();
	
	public int isVote(Voter voter);//로그인한 사람이 투표를 했는지 여부 확인.
	
	public void makePoll(PollDto poll);
	public void makePollSub(PollSubDto pollsub);
}
