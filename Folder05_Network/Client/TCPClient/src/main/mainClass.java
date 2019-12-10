package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class mainClass {
	/*
	 	1. 접속을 해야 할 server IP(주소)를 설정 - socket
	 	2. Socket 생성 
	 	3. 접속 connect
	 	
	 	4. packet전송
	 	
	 
	 
	 */
	public static void main(String[] args) {
		InetSocketAddress sockAddr = new InetSocketAddress("192.168.2.26", 9000);
		Scanner sc = new Scanner(System.in);
		
		Socket socket = new Socket();
		
		//server 접속
		
		
		try {
			socket.connect(sockAddr, 10000);
			
			

				InetAddress inetAddr;
				if((inetAddr = socket.getInetAddress()) != null) {
					System.out.println("서버 연결(접속) ㅅ 성공" + inetAddr);
					
				}else {
					System.out.println("서버 연결 실패 .");
				}
				
				System.out.println("전송할 데이터 입력 ");
				String str = sc.next();
				
				//1. send
				PrintWriter writer = new PrintWriter(socket.getOutputStream());
				writer.println(str);	//실질적 전송
				writer.flush();
				
				//2. recv 
				BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				
				str = reader.readLine();
				System.out.println("서버로부터 받은 메시지 : " + str);
				
	
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
