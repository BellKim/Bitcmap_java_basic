package exercise;

public class Rectangle implements Cloneable{
	private Point upperleft;
	private Point lowerRight;
	
	
	public Rectangle(int x1, int y1, int x2, int y2) {
		upperleft = new Point(x1,  y1);
		lowerRight = new Point(x2, y2);
	}
	
	public void changePos(int x1, int y1, int x2, int y2 ) {
		upperleft.changePos(x1, y1);
		lowerRight.changePos(x2, y2);
		
	}
	

/*
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	*/
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
 		//Object클래스의 clone 메소드 호출을 통한 복사본 생성
	Rectangle copy = (Rectangle)super.clone();
	
	//깊은 복사의 형태로 복사본을 완성
	copy.upperleft = (Point)upperleft.clone();
	copy.lowerRight = (Point)lowerRight.clone();
	
	//완성된 복사본의 참조 값 변환
	
	return copy;
	}
	
	
	/*


	 */
	
	public void showPosition() {
		System.out.println("좌측 상단 : ");
		upperleft.showPosition();
		System.out.println("우측하단");
		lowerRight.showPosition();
		System.out.println();
	}
	
	

}
