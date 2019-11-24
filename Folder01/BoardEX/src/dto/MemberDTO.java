package dto;

public class MemberDTO {
	private int id;
	private String userId;
	private String password;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean equls(Object o) {
		if(o instanceof MemberDTO) {
			MemberDTO m = (MemberDTO)o;
//			if(m.getId()==this.id) {
			if(m.getId()==m.id) {
				return true;
			}
		}
		return false;
	}//equals
	
	

}// end of class
