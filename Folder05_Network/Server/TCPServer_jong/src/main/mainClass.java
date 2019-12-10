package main;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class mainClass {

	public static void main(String[] args) {
		Socket clientSocket = null;
		List<Socket> list = new ArrayList<Socket>();
		
		
		try {
		
			ServerSocket sersocket =new ServerSocket(9000);
			System.out.println(sersocket);
			
			
			System.out.println(" 접속대기중");
			clientSocket = sersocket.accept();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
		
		

	}

}
