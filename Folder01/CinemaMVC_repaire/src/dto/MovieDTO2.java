package dto;
//dto CLASS!!

//영화번호, 영화이름, 영화길이
//dto는 필드와 겟터 셋터는 꼭넣어줘야 하고,  tostring은 선택적으로 들어가면 매우 좋고 안들어가도 무관하다.

public class MovieDTO2 {
	private int id;
	private String title;
	private int length;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", length=" + length + "]";
	}

//	public boolean equals(Object o) {
//	if(o instanceof MovieDTO2) {
//		MovieDTO2 m = (MovieDTO2)o;
//		if(this.id == m.id) {
//			return true;
//		}
//	}
//	return false;
//}//end equals

	/*
	 * equals 는 True or false 로 출력된다. 오버라이딩된 이퀄즈. o 라는 문구를 받아서 무엇을 체크해야 할까. NULL값
	 * 검사, movieDTO값인지 아닌지(같은 클래스 객체인지아닌지)
	 * 
	 */

	public boolean equals(Object o ) {
		if(o instanceof MovieDTO2) {
			MovieDTO2 m = (MovieDTO2)o;
			//자신의 어떤필드와 비교해야하는가
//			호출한 ID 값과, 변신시킨 아이디값과 같은지
			if(id == m.id) {
				return true;
			}
			
		}
		return false;
	}//end equals

}// end of class
