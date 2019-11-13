package dto;
//댓글DTO
//id, 글번호(boardDTO.id), 작성자의 번호(MemberDTO.id),
//댓글내용, 입력한날짜, 수정한날짜

import java.util.Calendar;

public class CommentDTO {
	private int id;
	private int boardId;
	private int memberId;
	private String content;
	private Calendar writtenDate;
	private Calendar updatedDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Calendar getWrittenDate() {
		return writtenDate;
	}
	public void setWrittenDate(Calendar writtenDate) {
		this.writtenDate = writtenDate;
	}
	public Calendar getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Calendar updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	
	
	@Override
	public String toString() {
		return "CommentDTO [id=" + id + ", boardId=" + boardId + ", memberId=" + memberId + ", comment=" + content
				+ ", writtenDate=" + writtenDate + ", updatedDate=" + updatedDate + "]";
	}
	
	
	
	
	
	
}//end of class
