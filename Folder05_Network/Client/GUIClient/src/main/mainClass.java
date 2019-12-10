package main;

import java.io.IOException;
import java.net.Socket;

import NET.ReadThread;
import view.ClientFrame;
import view.ID;

public class mainClass {
	public static void main(String[] args) {
		
		try {
			
			Socket socket = new Socket("192.168.2.26",9000);
//			Socket socket = new Socket("192.168.2.40",9000);
			System.out.println("connection SSSucesss");
			ClientFrame cf = new ClientFrame(socket);
			new ReadThread(socket, cf).start();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
