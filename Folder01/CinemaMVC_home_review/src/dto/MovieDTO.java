package dto;
//dto CLASS!!
//영화번호, 영화이름, 영화길이
//dto는 필드와 겟터 셋터는 꼭넣어줘야 하고,  tostring은 선택적으로 들어가면 매우 좋고 안들어가도 무관하다.

public class MovieDTO {
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
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof MovieDTO)) {
			return false;
		}
		MovieDTO other = (MovieDTO) obj;
		if (id != other.id) {
			return false;
		}
		if (length != other.length) {
			return false;
		}
		return true;
	}
	@Override
	public String toString() {
		return "MovieDTO [id=" + id + ", title=" + title + ", length=" + length + "]";
	}
	
	
	
	
	



}//end of class
