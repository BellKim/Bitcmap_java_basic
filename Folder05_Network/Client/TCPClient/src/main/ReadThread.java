package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReadThread extends Thread {
	
	Socket socket;
	
	public ReadThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run(){
		// TODO Auto-generated method stub
		super.run();
		
		try {
		//2. recv 
			while(true) {
				BufferedReader reader
				= new BufferedReader(new InputStreamReader(socket.getInputStream()));
				
				String str = reader.readLine();
				
				
				
				System.out.println("서버로부터 받은 메시지 : " + str);
				Thread.sleep(300);
			}
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
	}//end run
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}//end read Thread
