package mainClass;

public class mainClass {
	/* 
		window -> window
		방법1.
		close 		new		버튼액션리스너에 클릭시 dispose();로 전환하기.
		
		방법2.
		visible	
		false		true	//setvisible의 상태를 true, false 로 전환하기.

		
		방법3. 
		panel사용. 
		frame -> panel1 <-> panel2
		
		
	
	 */

	public static void main(String[] args) {
//		Singleton s = Singleton.getInstance();
		
		Singleton.getInstance().win1.setVisible(true);
		
		
		
		
		
	}

}
