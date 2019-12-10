package exercise;

public class Point implements Cloneable{
	private int xpos;
	private int ypos;
	
	public Point(int xpos, int ypos) {
		
		this.xpos = xpos;
		this.ypos = ypos;
	}
	
	public void changePos(int x, int y) {
		xpos = x;
		ypos = y;
	}
	
	
	public void showPosition() {
		System.out.printf("%d %d" , xpos, ypos);
		System.out.println();
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
	
	
	
}