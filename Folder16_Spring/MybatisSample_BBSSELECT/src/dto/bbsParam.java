package dto;

public class bbsParam {
	private String s_category;	//제목, 내용,  작성자 인지를 선택하는 선택변수
	private String KeyWord;		//검색어
	
	
	public bbsParam() {
	
	}

	
	

	public bbsParam(String s_category, String keyWord) {
		super();
		this.s_category = s_category;
		KeyWord = keyWord;
	}




	public String gets_category() {
		return s_category;
	}


	public void sets_category(String s_category) {
		this.s_category = s_category;
	}


	public String getKeyWord() {
		return KeyWord;
	}


	public void setKeyWord(String keyWord) {
		KeyWord = keyWord;
	}




	@Override
	public String toString() {
		return "BbsParam [s_category=" + s_category + ", KeyWord=" + KeyWord + "]";
	}

	
	
	
	
	

}//end of class;
