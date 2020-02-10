<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
<!--style-->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!--script-->
	<script type="text/javascript">
		$(document).ready(function(){
			//이미지 선택후 서브밋 가능하도록  함수 구성.  이미지 삽입 체크
			$('form').on('submit',function(){
				var str=$('#filepath').val();//인풋속성이기 때문에 value가 적용가능하다. 파일경로가 없으면 진행되지 않도록한다. 
				if(str.length<1){
					alert('이미지를선택하시죠 ');
					console.log(str);
					return false;
				}
			});/////////////////////////////////
			
			$('#filepath').on('change', function(){
				var str=$('#filepath').val();
				var patt=/(.jpg$|.gif$|.png$)/g; //$ 끝,  |~거나(or),  
				var result=str.match(patt);
				if(!result){
					alert('jpg, gif, png만 가능합니다. ');
					console.log(str);
					//형식에 맞지안헥 입력된 파일명 초기화시킴. 
					$('#filepath').val('');
					return false;
				}
				/* ArrayList List = new ArrayList();
				list && list.get(0); */
				if(this.files && this.files[0]){
					if(this.files[0].size>1000000){
						alert("1 MBBB 이하만 첨부할수 있습니다. ");
						$('#filepath').val('');
						return false;
					}
					//파일을 읽기 위한 filereader 객체 생성. 자바 아니야. 착각하지마
					var reader = new FileReader();
					//File내용을 읽어 dataURL 형식의 문자열로 저장. 
					reader.readAsDataURL(this.files[0]);
					
					//파일 읽어들이기를 성공했을 때 호출되는 이벤트 핸들러 
					reader.onload=function(e){
						//dlalwl tag의 src속성에 읽어들인 file 내용을 지정. 
						$('img').attr('src', e.target.result);
						
					}
					
				}
			});/////////////////////////////////
			
			
		});
	</script>
	</head>
	<body>
	<!-- input 요소의 type 속성의 값이 "file"이면 method="post" enctype="multipart/form-data" 로 설정해야한다. -->
		<form name="frm" action="insertMain" method="post" enctype="multipart/form-data">
		
		<!-- 추가 2번째 수업으로 넘어감. 서버로 보내기전에 프리뷰로 이미지를 보여준다. ㄴ-->
			<p>
				<img width="100" height="100" />
			</p>
			
		
		<!-- 인풋파입이 컴부파일이 있으면 멀티파트폼데이터로해야하고 메소드 속성은 포스트로 해줘야한다.  -->
			<p>
				<span> 파일 </span>
				<input type="file" name="filepath" id="filepath"/>
			</p>
			<input type="submit" value="commit"/>
			
		</form>
		
	</body>
</html>