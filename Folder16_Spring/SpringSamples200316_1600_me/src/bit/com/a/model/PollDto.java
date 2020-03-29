package bit.com.a.model;

import java.io.Serializable;
import java.util.Date;

/*

DROP TABLE POLL
CASCADE CONSTRAINTS;


DROP SEQUENCE POLL_SEQ;

CREATE TABLE POLL(
	POLLID NUMBER NOT NULL,
	ID VARCHAR2(50) NOT NULL,
	QUESTION VARCHAR2(1000) NOT NULL,
	SDATE DATE NOT NULL,
	EDATE DATE NOT NULL,
	ITEMCOUNT NUMBER NOT NULL,
	POLLTOTAL NUMBER NOT NULL,
	REGDATE DATE NOT NULL,
	CONSTRAINT POLL_PK PRIMARY KEY(POLLID)--PK로 안해주면 고유키라도 설정해 줘야하한다. 
);

CREATE SEQUENCE POLL_SEQ
START WITH 1
INCREMENT BY 1;

ALTER TABLE POLL ADD CONSTRAINT POLL_FK
FOREIGN KEY(ID)
REFERENCES MEMBER(ID);


*/

public class PollDto implements Serializable{
	
	private int pollid;			//sequence	1 2 3 4 5 
	private String id;			//투표를 만든 사람의 ID
	private String question;	//투표항목(질문내용) 좋아하는 과일, 사람 등등
	private Date sdate;			//투표시작일
	private Date edate;			//투표종료일
	private int itemcount;		//보기의 갯수
	private int polltotal;		//질문된(투표된) 항목의 투표한사람 총 수
	private Date regdate;		//질문 등록일
	//(위)투표를 만든사람이 넣어줘야하는 항목들
	//(아래) 자동입력되어야 하는 사항
	private boolean vote;		//투표를 했는지? 안했는지? 알아볼수 있는 항목 
	
	
	public PollDto() {
		// TODO Auto-generated constructor stub
	}


	public PollDto(int pollid, String id, String question, Date sdate, Date edate, int itemcount, int polltotal,
			Date regdate, boolean vote) {
		super();
		this.pollid = pollid;
		this.id = id;
		this.question = question;
		this.sdate = sdate;
		this.edate = edate;
		this.itemcount = itemcount;
		this.polltotal = polltotal;
		this.regdate = regdate;
		this.vote = vote;
	}


	public PollDto(String id, String question, Date sdate, Date edate, int itemcount, int polltotal) {
		super();
		this.id = id;
		this.question = question;
		this.sdate = sdate;
		this.edate = edate;
		this.itemcount = itemcount;
		this.polltotal = polltotal;
	}


	public PollDto(String id, String question, int itemcount) {
		super();
		this.id = id;
		this.question = question;
		this.itemcount = itemcount;
	}


	public int getPollid() {
		return pollid;
	}


	public void setPollid(int pollid) {
		this.pollid = pollid;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getQuestion() {
		return question;
	}


	public void setQuestion(String question) {
		this.question = question;
	}


	public Date getSdate() {
		return sdate;
	}


	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}


	public Date getEdate() {
		return edate;
	}


	public void setEdate(Date edate) {
		this.edate = edate;
	}


	public int getItemcount() {
		return itemcount;
	}


	public void setItemcount(int itemcount) {
		this.itemcount = itemcount;
	}


	public int getPolltotal() {
		return polltotal;
	}


	public void setPolltotal(int polltotal) {
		this.polltotal = polltotal;
	}


	public Date getRegdate() {
		return regdate;
	}


	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}


	public boolean isVote() {
		return vote;
	}


	public void setVote(boolean vote) {
		this.vote = vote;
	}


	@Override
	public String toString() {
		return "PollDto [pollid=" + pollid + ", id=" + id + ", question=" + question + ", sdate=" + sdate + ", edate="
				+ edate + ", itemcount=" + itemcount + ", polltotal=" + polltotal + ", regdate=" + regdate + ", vote="
				+ vote + "]";
	}
	
	
	
	
}//end of PollDto class//
