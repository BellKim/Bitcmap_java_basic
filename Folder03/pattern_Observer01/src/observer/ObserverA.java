package observer;

import java.util.Observable;
import java.util.Observer;

public class ObserverA implements Observer{
	
	//alt shift s 통해서 오버라이드. update
	@Override
	public void update(Observable o, Object arg) {
		String str = (String)arg;
		System.out.println("감시자 A 입니다.\n 통지를 받음. " + str);
		
	}

	
	
	
}
