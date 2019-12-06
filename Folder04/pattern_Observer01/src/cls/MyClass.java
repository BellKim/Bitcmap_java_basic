package cls;

import java.util.Observable;
//observable 이라는 감시용 클래스를 추가한다. 
public class MyClass extends Observable{
	
	private String  preArg = null;


//ctrl + alt + s 
	@Override
	public void notifyObservers(Object arg) {
		
		String str = (String)arg;
		
		//변화가 없을떄. 
		if(str.equals(preArg)) return;
		
		//변화가 감지되었을때
		preArg = str;
		setChanged(); 	//상속받은 메소드이다.(부모클레스 메소드)
		
		super.notifyObservers(arg);
		clearChanged();//변경
		
	}//이 메소드에서 변화가 감지되면 감시를 날려준다. 
	
	
	
}
