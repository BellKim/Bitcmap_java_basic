package bit.com.a.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bit.com.a.dao.BitPollDao;
import bit.com.a.model.PollBean;
import bit.com.a.model.PollDto;
import bit.com.a.model.PollSubDto;
import bit.com.a.model.Voter;
import bit.com.a.service.BitPollService;

@Service
public class BitPollServiceImpl implements BitPollService {
	
	@Autowired
	BitPollDao pollDao;

	@Override
	public List<PollDto> getPollAllList(String id) {
		//모든 투표 목록을 갖고 온다.
		List<PollDto> list = pollDao.getPollAllList();
		//편집을 통해서 투표가 가능한지 설정해서 넘겨줌. 
		List<PollDto> plist = new ArrayList<PollDto>();
		for(PollDto poll : list) {
			int pollid = poll.getPollid();
			
			int count = pollDao.isVote(new Voter(pollid, -1, id));
			if(count == 1) {
				poll.setVote(true);
			}else {
				poll.setVote(false);
			}
			
		}
		
		
		
		return plist;
	}

	@Override
	public void makePoll(PollBean pbean) {
		
		//투표 질문
		PollDto poll = new PollDto(pbean.getId(), 
				pbean.getQuestion(), 
				pbean.getSdate(), 
				pbean.getEdate(), 
				pbean.getItemcount(),
				0);
//		PollDto poll = new PollDto(id, question, sdate, edate, itemcount, polltotal)

		pollDao.makePoll(poll);
		
		
		//보기들 
		String answer[] = pbean.getPollnum();
		for(int i=0; i<pbean.getItemcount(); i++) {
			PollSubDto pollsub = new PollSubDto();
			pollsub.setAnswer(answer[i]);
			pollDao.makePollSub(pollsub);
		}
		
		
	}
	
	

}
