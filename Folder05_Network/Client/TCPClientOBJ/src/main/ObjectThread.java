package main;

import java.net.Socket;

public class ObjectThread extends Thread {
	Socket socket;
	int MemberNum;
	
	public ObjectThread(Socket socket, int memberNum) {
		this.socket = socket;
		this.MemberNum = memberNum;
	}
	
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
	}
	
	
	
	

}//end class
