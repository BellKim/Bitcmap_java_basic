package chap07Function.Exercise_teacher;

public class exercise01T {

	public static void main(String[] args) {
		
		double dis = getDistance(1, 1, 2, 2);
		System.out.println(dis);

	}// end main

	static double getDistance(int x, int y, int x1, int y1) {
		double dx, dy;
		double result;

		dx = Math.pow(x1 - x, 2);
		dy = Math.pow(y1 - y, 2);
		
		result = Math.sqrt(dy + dx);
		
		return result;
		/*

			


		 * */
	}
}
