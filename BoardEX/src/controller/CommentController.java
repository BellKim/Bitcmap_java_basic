package controller;

import java.util.ArrayList;
import java.util.Calendar;

import dto.CommentDTO;

public class CommentController {
	ArrayList<CommentDTO> list;
	public CommentController() {
		list = new ArrayList<CommentDTO>();
		CommentDTO c1 = new CommentDTO();
		c1.setId(1);
		c1.setBoardId(1);
		c1.setMemberId(1);
		c1.setContent("댓글1");
		c1.setWrittenDate(Calendar.getInstance());
		c1.setUpdatedDate(Calendar.getInstance());
		
		
		list.add(c1);
				
		
		
	}
//	1. 댓글을 볼때 -> 그 글에 달린 댓글이 전부 나옴.
//	그러면 기본적으로 댓글을 볼때 selectAll할때
//	그 리스트를 반환할것이고, -> 그 댓글을 하나만 볼일이 없으니
//	SelectOne은 필요없을것이고 -> 작성자가 자기가 달은 댓글을 봐야하니까
//	메소드가 하나 더 필요할것이다.
	
	
	public ArrayList<CommentDTO> selectByBoardId(int boardId){
//		1. 해당 글에 대한 댓글들만 출력해 한다.
		ArrayList<CommentDTO> boardIDList = new ArrayList<CommentDTO>();
		for(CommentDTO c : list) {
			if(c.getBoardId() == boardId) {
				boardIDList.add(c);
			}
		}
		return boardIDList;
	}
	
	public void insert(CommentDTO c) {
		c.setId(list.get(list.size()-1).getId()+1);
		c.setWrittenDate(Calendar.getInstance());
		c.setUpdatedDate(Calendar.getInstance());
		list.add(c);
		
	}
	
	
	
	
}//end of class
