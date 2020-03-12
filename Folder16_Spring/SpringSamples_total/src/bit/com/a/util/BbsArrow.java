package bit.com.a.util;

public class BbsArrow {
	private int depth = 0;
	private String arrow;
	
	
	public void setDepth(int depth) {//들어옴
		this.depth = depth;
	}

	// 댓글의 여백과 이미지를 추가하는 함수
	public String getArrow(){//나감
		String rs = "<img src='./image/arrow.png' width='20px' height='20px'/>";
		String nbsp = "&nbsp;&nbsp;&nbsp;&nbsp;";
		
		String ts = "";
		for(int i = 0;i < depth; i++){
			ts += nbsp;
		}	
		return depth==0?"":ts + rs;
	}
	

}
