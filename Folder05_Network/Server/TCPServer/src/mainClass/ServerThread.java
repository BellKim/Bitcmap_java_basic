package mainClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerThread extends Thread {
	Socket socket;
	List<Socket> list;

	public ServerThread(Socket socket, List<Socket> list) {
		this.socket = socket;
		this.list = list;

	}

	@Override
	public void run() {

		super.run();

		try {
			while (true) {
				// 1. recv
				BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

				String str = reader.readLine();// 리드버퍼를 게속 체크해야한다.
				System.out.println("서버로부터 받은 메시지 : " + str);

				// 2. send

				for (Socket sock : list) {
					if(socket != sock) {
						PrintWriter writer = new PrintWriter(sock.getOutputStream());
						writer.println(str); // 실질적 전송
						writer.flush();
					}

				}
				Thread.sleep(300);// 30프레임.
			}

		} catch (InterruptedException e) {
			e.printStackTrace();

		} catch (Exception e) {
//			e.printStackTrace();//지워주고
			System.out.println("연결이 끊긴 IP 입니다. " + socket.getInetAddress());
			
			list.remove(socket);
			
			
			//남은 클라이언트 확인 
			for(Socket s : list) {
				System.out.println("접속 되어있는 IP : " + s.getInetAddress()
				+" PORT NUM : " + s.getPort()
				+" ");
			}
			try {
				socket.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}// end run

}
