package NET;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

import view.ClientFrame;
import view.ID;

public class WriteClass {
	
	Socket socket;
	ClientFrame cf;
	
	String id;
	String msg;
	
	
	public WriteClass(ClientFrame cf) {
		this.cf= cf;
		this.socket = cf.socket;
		
	}
	
	public void sendMessage() {
		try {
			
			
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			
			//첫번재 전송 -> id 
			if(cf.isFirst ==true) {
				InetAddress iaddr = socket.getLocalAddress();
				String ip = iaddr.getHostAddress();
				id = ID.tf.getText();
				
				msg = "["+id+"]님 로그인("+ip+")";
				
			}else {
				msg = "["+cf.textF.getText()	+")"; 
			}
			pw.println(msg);
			pw.flush();
			
			
		} catch (IOException e) {

			e.printStackTrace();
		}
		
	}
	
	

}
