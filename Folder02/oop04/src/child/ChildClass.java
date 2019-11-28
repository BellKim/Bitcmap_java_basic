package child;

import parents.parentsClass;

public class ChildClass extends parentsClass {
	
	private String name;
	
	public ChildClass() {
//		super();
		System.out.println("childclass 의 기본생성자 childclass");
	}
	
	
	public ChildClass(String name, int num) {
//		super(3);
		this.name = name;
		System.out.println("childClass childclass(string name ) ");
	}
	
	
	

}//end of clas
