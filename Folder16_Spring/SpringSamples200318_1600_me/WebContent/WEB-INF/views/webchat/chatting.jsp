<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<table class="list_table" style="width:85%;">
	<colgroup>
		<col style="width:200px"> <col style="width:500px;"> 
		
	</colgroup>

	<tbody>
		<tr>
			<td>채팅명</td>
			<td style="text-align:left;">
				<input type="text" id="name">
				<input type="button" id="enterBtn" value="입장" onclick="connect()">
				<input type="button" id="exitBtn" value="나가기" onclick="disconnect()">
				 
			</td>
			
		</tr>
		
		<tr>
			<td>아이디</td>
			<td style="text-align:left;">
				<input type="text" id="nickname" vlaue="${login.id }">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<textarea rows="10" cols="70" id="charMessageArea"></textarea>
			</td>
		</tr>
		
		<tr>
			<td colspan="2">
				<input type="text" id="message" size="20">
				<input type="button" id="sendBtn" value="전송">
			</td>
		</tr>
	</tbody>
</table>

<script>
	var wsocket;

	//입장버튼 클릭스 호출되는 함수. 
	function connect(){//접속시			
//										준비상태가 아닐때
		if(wsocket != undefined && wsocket.readyState != webSocket.CLOSED){
		//이미 소켓이 생성된 경우
			alert("이미 입장하셧습니다. ");
		return;
		}
		
		wsocket = new WebSocket("ws://localhost:8090/SpringSamiles/echo.do");
		alert("wsocket:" + wsocket);

		wsocket.onopen = onOpen;
		wsocket.onmessage=onMessage;
		wsocket.close=onclose;
		
			
	}


	

	function disconnect(){//접속 종료시
		wsocket.close();		
		location.href='chatting.do';
		
	}

	function onOpen(evt){//연결
		appendMessage("연결되었습니다." + "\n");
	}
	
	function onMessage(evt){//메시지 전송시
		var data = evt.data;
		if(data.substring(0,4)=="msg:"){
			appendMessage(data.substring(4));
		}
	}
	
function onClose(evt){	// 끊겼을 때	
	appendMessage("연결끊겼습니다");
}

function send(){
	var nickname = $("#nickname").val();
	var msg = $("#message").val();

	// 실제로 전송 부분
	wsocket.send("msg:" + nickname + ":" + msg);
	$("#message").val("");	
}

	function appendMessage(msg){
		//메시지를 추가하고 개행함. 
		$("#charMessageArea").append(msg+"\n");

		//스크롤을 구현하여 위로 올려준다.
		const top = $("#charMessageArea").prop('scrollHeight');
		$("#charMessageArea").scrollTop(top);
	}


	
</script>

