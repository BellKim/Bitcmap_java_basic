package dto;
/*
DROP TABLE MEMBERDTO;

CREATE TABLE MEMBERDTO(
	ID VARCHAR2(50) PRIMARY KEY,
	PWD VARCHAR2(50) NOT NULL,
	EMAIL VARCHAR2(50) NOT NULL
);
 
 */
public class memberDto {
	
	private String id;
	private String pwd;
	private String email;
	
	
	public memberDto() {
		// TODO Auto-generated constructor stub
	}


	public memberDto(String id, String pwd, String email) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.email = email;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "MemberDto [id=" + id + ", pwd=" + pwd + ", email=" + email + "]";
	}
	
	
	
	
	
	

}//end of class
