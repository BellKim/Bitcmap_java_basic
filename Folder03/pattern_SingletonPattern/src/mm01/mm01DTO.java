package mm01;

public class mm01DTO {
	private String name;
	private int num;
	public mm01DTO() {
		// TODO Auto-generated constructor stub
	}
	

	public mm01DTO(String name, int num) {
		super();
		this.name = name;
		this.num = num;
	}



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}


	@Override
	public String toString() {
		return "mm01DTO [name=" + name + ", num=" + num + "]";
	}
	
	
	
	
	

}
