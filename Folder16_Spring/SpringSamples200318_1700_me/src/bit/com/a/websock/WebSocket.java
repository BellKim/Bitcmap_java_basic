package bit.com.a.websock;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class WebSocket extends TextWebSocketHandler {
	//웹소켓에는 세션으로 저장.
	
	private Map<String, WebSocketSession> users = new ConcurrentHashMap<String, WebSocketSession>();
	

	
	public WebSocket() {
		System.out.println("EchoHandler 생성됨.");
	}



	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
			//연결 된 후에 실행되는것. 
		System.out.println(" 연결됨 " + new Date());
		users.put(session.getId(), session);
		
	}//end of afterConnectionEstablished class



	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
			//연결 종료
		
		System.out.println(" 연결종 료  " + new Date());
		users.remove(session.getId());

		
	}



	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
			//메시지 수신되는부분.
		System.out.println(" 메시지 수신 " + new Date());
		//특정 사람들에게만 보내주기위해선 여기서 컨트롤 해준다.
		for(WebSocketSession s : users.values()) {
			s.sendMessage(message);
			
		}
		
	}



	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
			//예외발생시 출력되는부분.
		System.out.println(" 오류 발생  " + new Date());
		System.out.println(session.getId() + "에 Exception 발생됨 . " + new Date());
		
		
	}
	
	
	
	
	
	
	
	
	

}//end of class
