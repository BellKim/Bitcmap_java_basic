package dto;

import java.io.Serializable;
import java.util.Date;

public class PdsDto implements Serializable{
	private int seq;
	private String id;
	private String title;
	private String contetn;
	
	private String filename;
	private int readcount;
	private int downcount;
	private String regDate;
	
	public PdsDto() {
		// TODO Auto-generated constructor stub
	}





	public PdsDto(int seq, String id, String title, String contetn, String filename, int readcount, int downcount,
			String regDate) {
		super();
		this.seq = seq;
		this.id = id;
		this.title = title;
		this.contetn = contetn;
		this.filename = filename;
		this.readcount = readcount;
		this.downcount = downcount;
		this.regDate = regDate;
	}

	public PdsDto(String id, String title, String contetn, String filename) {
		super();
		this.id = id;
		this.title = title;
		this.contetn = contetn;
		this.filename = filename;
	}





	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContetn() {
		return contetn;
	}

	public void setContetn(String contetn) {
		this.contetn = contetn;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	public int getDowncount() {
		return downcount;
	}

	public void setDowncount(int downcount) {
		this.downcount = downcount;
	}



	public String getRegDate() {
		return regDate;
	}





	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}





	@Override
	public String toString() {
		return "PdsDto [seq=" + seq + ", id=" + id + ", title=" + title + ", contetn=" + contetn + ", filename="
				+ filename + ", readcount=" + readcount + ", downcount=" + downcount + ", regDate=" + regDate + "]";
	}





	
	
	
	

}
