package observer;

import java.util.Observable;
import java.util.Observer;

public class ObserverB implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		String str = (String)arg;
		System.out.println("감시자 B 입니다.\n 통지를 받음. " + str);
	}
	
	
	
	
	
	

}
