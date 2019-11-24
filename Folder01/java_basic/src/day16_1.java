class Circle{
	int xpos, ypos, radius;
	
	Circle(){
		
	}
	Circle(int i, int j, int k){
		xpos=i;
		ypos=j;
		radius=k;
	}
	
	void showCircleInfo(){
		Point po = new Point(xpos, ypos);
		po.showPointInfo();
		System.out.println("반지름 : " + radius);
	}
	
	
	
}//end class



class Point{
	int xPos, yPos;
	public Point(int x, int y) {
		xPos = x;
		yPos = y;
	}
	public void showPointInfo() {
		System.out.println("[" + xPos + ", "+ yPos +"}");
		
	}
	
}

public class day16_1 {

	public static void main(String[] args) {
		Circle c = new Circle(2,2,4);
		c.showCircleInfo();

		
	}//end main
		
}//end class 
