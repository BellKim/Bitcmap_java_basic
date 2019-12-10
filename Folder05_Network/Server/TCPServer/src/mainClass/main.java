package mainClass;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class main {
	/*
		TCP : Transmission Controll protocol
				전송			제어			규칙
		Server: TCP, DB, WEB(tomcat) + Web socket
		
		종단시스템 : host 
				네트워크 상에서 더 연장되지 않는 기기. (pc, smartphone, pda scanner, printer)
		
		router : hardware
				host간의 상호 데이터를 교환할 수 잇도록 하는 장비
		
		interNetwork : 포괄적인 통신
		
		TCP - Transmission Controll Protocol
		UDP - User DataGram Protocol
		
		7 Layer
		1	physical layer 		물리
		2	DataLink layer		주소를 헤더에 첨부
		3	Network layer		네트워크IP -> address
		4	transport Layer 	네트워크 port
		5	session layer 		세션 부분을 동기화 하는레이어
		6	presentation layer	보안, 압축, 확장
		7	appliction layer	프로그램(소프트)
		
		TCP
			신사적인 프로토콜?
		전화 -> 상대방 -> 연결 -> 통신 start
		동기화 : 보낸다 -> 받는다.	처리순서가 일치해야 한다. 
		데이터의 경계가 없다.//보내다가 귾기면 처음부터 다시보낸다.
		1대1통신만가능
		채팅, object(class)
		
		UDP
		비연결형 protocol
		편지, 지상파방송과 같은 수신여부를 확인하지 않는 형태
		1대 1통신(unicast)
		1대 다 	(broadcast)
		다대 다 	(multicast)
		
		packet(묶음)
		제어정보, 데이터들이 결함된 형태로 전송이 되는 실제데이터
		IP, port, String : 1001-홍길동-서울시 
				  Object : DTO
				  
		IP : Internet Protocol = 주소
		
		IPV4 : XXX.XXX.XXX.XXX				XXX=000~255
		IPV6 : XXX.XXX.XXX.XXX.XXX.XXX		
		
		127.0.0.1	-> 자기 자신의 IP
		
		Port Number
		IP주소는 internet에 존재하는 host(PC)를 식별할 수 잇으나
		최종주체인 프로세스(프로그램)를 식별하지 못하기 때문에
		프로세스를 구별하기 위해서 지정된 수치(0~1024)
		
		socket --> 유닉스(file)
		
		
		IP, TCP/UDP
		
		통신순서
			Server						Client
		1. 	Socket버전확인					1.Client
		2.	Binding -> IP, PortNum설정	
		3.	Listen
		4. 	Accept(Client정보)	<--------2.connect
							접속성공시
			1)receve(read)	<------ 	send(write)
			2)send(write)	------> 	recv(read)
			
		
		
		
		
	
*/
	public static void main(String[] args) {
		Socket clientSocket = null;
		
		
		try {
			//문지기 소켓
			ServerSocket serSocket = new ServerSocket(9000);
			//자동으로 자신의 IP를 설정한다, binding, listen포함.
			
			List<Socket> list = new ArrayList<Socket>();
			
			while(true) {

				System.out.println("접속 대기중 ... ");
				clientSocket = serSocket.accept();//접석된 클라이언트만 받는다.(문지기)
				
				list.add(clientSocket);
				
				System.out.println("client IP : " + clientSocket.getInetAddress() + "\n port : " + clientSocket.getPort());
				
				new ServerThread(clientSocket, list).start();
				
				/*
				//ServerThread 클래스로 이동했다. (receive, send)
				//2. recv 
				BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				
				String str = reader.readLine();//리드버퍼를 게속 체크해야한다.
				System.out.println("서버로부터 받은 메시지 : " + str);
	
				str = "반갑습니다.";
				
				//1. send
				PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
				writer.print(str);	//실질적 전송
				writer.flush();
			*/
			}
			
			
//			clientSocket.close();
//			serSocket.close();
			
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
		//cmd console 에서 netstat -an 입력하면 오픈된 포트 잇는지 확인한다.

	}

}
