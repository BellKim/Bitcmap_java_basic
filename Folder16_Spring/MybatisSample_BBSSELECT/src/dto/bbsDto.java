package dto;

public class bbsDto {
	private int SEQ;
	private String ID;
	private int REF;
	private int STEP;
	private int DEPTH;
	private String TITLE;
	private String CONTENT;
	private String WDATE;
	private int DEL;
	private int READCOUNT;
	
	
	public bbsDto() {
		// TODO Auto-generated constructor stub
	}


	public bbsDto(int sEQ, String iD, int rEF, int sTEP, int dEPTH, String tITLE, String cONTENT, String wDATE, int dEL,
			int rEADCOUNT) {
		super();
		SEQ = sEQ;
		ID = iD;
		REF = rEF;
		STEP = sTEP;
		DEPTH = dEPTH;
		TITLE = tITLE;
		CONTENT = cONTENT;
		WDATE = wDATE;
		DEL = dEL;
		READCOUNT = rEADCOUNT;
	}


	public int getSEQ() {
		return SEQ;
	}


	public void setSEQ(int sEQ) {
		SEQ = sEQ;
	}


	public String getID() {
		return ID;
	}


	public void setID(String iD) {
		ID = iD;
	}


	public int getREF() {
		return REF;
	}


	public void setREF(int rEF) {
		REF = rEF;
	}


	public int getSTEP() {
		return STEP;
	}


	public void setSTEP(int sTEP) {
		STEP = sTEP;
	}


	public int getDEPTH() {
		return DEPTH;
	}


	public void setDEPTH(int dEPTH) {
		DEPTH = dEPTH;
	}


	public String getTITLE() {
		return TITLE;
	}


	public void setTITLE(String tITLE) {
		TITLE = tITLE;
	}


	public String getCONTENT() {
		return CONTENT;
	}


	public void setCONTENT(String cONTENT) {
		CONTENT = cONTENT;
	}


	public String getWDATE() {
		return WDATE;
	}


	public void setWDATE(String wDATE) {
		WDATE = wDATE;
	}


	public int getDEL() {
		return DEL;
	}


	public void setDEL(int dEL) {
		DEL = dEL;
	}


	public int getREADCOUNT() {
		return READCOUNT;
	}


	public void setREADCOUNT(int rEADCOUNT) {
		READCOUNT = rEADCOUNT;
	}


	@Override
	public String toString() {
		return "bbsDto [SEQ=" + SEQ + ", ID=" + ID + ", REF=" + REF + ", STEP=" + STEP + ", DEPTH=" + DEPTH + ", TITLE="
				+ TITLE + ", CONTENT=" + CONTENT + ", WDATE=" + WDATE + ", DEL=" + DEL + ", READCOUNT=" + READCOUNT
				+ "]";
	}
	
	
	
	
	

}//end of bbsDto
