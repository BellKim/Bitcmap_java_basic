package Controller.dto;

public class coffeeMemberDto {
	private int memberIndex;
	private String id;
	private String pw;
	private String name;
	private int age;
	private int auth;
	
	


	
	
	public coffeeMemberDto(String id, String pw, String name, int age, int auth) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.age = age;
		this.auth = auth;
	}
	
	
	public coffeeMemberDto(int memberIndex, String id, String pw, String name, int age, int auth) {
		super();
		this.memberIndex = memberIndex;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.age = age;
		this.auth = auth;
	}


	public int getMemberIndex() {
		return memberIndex;
	}
	public void setMemberIndex(int memberIndex) {
		this.memberIndex = memberIndex;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}


	public int getAuth() {
		return auth;
	}


	public void setAuth(int auth) {
		this.auth = auth;
	}


	@Override
	public String toString() {
		return "coffeeMemberDto [memberIndex=" + memberIndex + ", id=" + id + ", pw=" + pw + ", name=" + name + ", age="
				+ age + ", auth=" + auth + "]";
	}
	
	

}//end class
