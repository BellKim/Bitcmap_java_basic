package bit.com.a.model;

import java.io.Serializable;

/*

ㅜ DROP TABLE POLLSUB
CASCADE CONSTRAINTS;

DROP SEQUENCE POLLSUB_SEQ;

CREATE TABLE POLLSUB(
	POLLSUBID NUMBER NOT NULL,
	POLLID NUMBER NOT NULL,
	ANSWER VARCHAR2(1000) NOT NULL,
	ACCOUNT NUMBER NOT NULL,
	CONSTRAINT POLLSUB_PK PRIMARY KEY(POLLSUBID)
);


CREATE SEQUENCE POLLSUB_SEQ
START WITH 1
INCREMENT BY 1;

ALTER TABLE POLLSUB ADD CONSTRAINT POLLSUB_FK
FOREIGN KEY(POLLID)
REFERENCES POLL(POLLID);

*/
//보기DTO
public class PollSubDto implements Serializable{
	private int pollsubid;				//sequence 1 2 3 4 
	private int pollid;					//질문(외래키로 설정)
	private String answer; 				//보기명	사과 배 귤 
	private int acount;					//이 보기를 선택한 사람수 
	
	public PollSubDto() {
		// TODO Auto-generated constructor stub
	}

	public PollSubDto(int pollsubid, int pollid, String answer, int acount) {
		super();
		this.pollsubid = pollsubid;
		this.pollid = pollid;
		this.answer = answer;
		this.acount = acount;
	}

	public int getPollsubid() {
		return pollsubid;
	}

	public void setPollsubid(int pollsubid) {
		this.pollsubid = pollsubid;
	}

	public int getPollid() {
		return pollid;
	}

	public void setPollid(int pollid) {
		this.pollid = pollid;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getAcount() {
		return acount;
	}

	public void setAcount(int acount) {
		this.acount = acount;
	}

	@Override
	public String toString() {
		return "PollSubDto [pollsubid=" + pollsubid + ", pollid=" + pollid + ", answer=" + answer + ", acount=" + acount
				+ "]";
	}
	
	
	
	
	
	

}//end pollSubdto
