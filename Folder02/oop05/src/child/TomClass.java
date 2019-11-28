package child;

import parents.ParentsClass;

public class TomClass extends ParentsClass{

	public void ParentMethod() {	//over Ride Method
		System.out.println(" TomCLass ParentMethod() ");
	}//end parentMethod
	
	public void func() {
		System.out.println("Tomclass func() ------");
	}
}
