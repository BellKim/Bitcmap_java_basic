package sample11_example;

import java.io.Serializable;

public class InfoDto implements Serializable{ //시리얼라이즈어블 직렬화 라고 한다.
	private String name;
	private String age;
	private String chk_gend;
	private String hobby;
	
	
	
	public InfoDto(String name, String age, String chk_gend, String hobby) {
		super();
		this.name = name;
		this.age = age;
		this.chk_gend = chk_gend;
		this.hobby = hobby;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getChk_gend() {
		return chk_gend;
	}
	public void setChk_gend(String chk_gend) {
		this.chk_gend = chk_gend;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	@Override
	public String toString() {
		return "InfoDto [name=" + name + ", age=" + age + ", chk_gend=" + chk_gend + ", hobby=" + hobby + "]";
	}
	
	
	
}//end class
