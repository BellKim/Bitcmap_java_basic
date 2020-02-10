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
			
			
			
			$('.form').on('submit', function(){
				
				var fid = $('#fid');
				//alert(this + " " + fid);
				//alert(this.files + " " + fid[0].files);
				alert($('.filepath')[0].files[0]+" "+
						$('.filepath')[1].files[0]);
				
				if(this.files && this.files[0]){
					
				}
				
				/*javascript API 참조. */
				
			/* https://developer.mozilla.org/en-US/docs/Web/API/FileList 
			    // get item
			    file = files.item(i);
			    //or
			    file = files[i];

			    alert(file.name);
			}
			 부분 찾아보기 꼭꼮꼭
			
			*/
			});/////////////////////////////////
			
			
		});
	</script>
	</head>
	<body>
	<!-- input 요소의 type 속성의 값이 "file"이면 method="post" enctype="multipart/form-data" 로 설정해야한다. -->
		<form name="frm" action="insertMain" method="post" enctype="multipart/form-data">
			<input type="text" name="fid" id="fid"/>
		
		<!-- 추가 2번째 수업으로 넘어감. 서버로 보내기전에 프리뷰로 이미지를 보여준다. ㄴ-->
			<p>
				<img width="100" height="100" />
			</p>
			
		
		<!-- 인풋파입이 컴부파일이 있으면 멀티파트폼데이터로해야하고 메소드 속성은 포스트로 해줘야한다.  -->
			<p>
				<span> 파일 </span>
				<input type="file" name="filepath" class="filepath"/>
				<input type="file" name="filepath" class="filepath"/>
				
			</p>
			<input type="submit" value="commit"/>
			
		</form>
		
	</body>
</html>