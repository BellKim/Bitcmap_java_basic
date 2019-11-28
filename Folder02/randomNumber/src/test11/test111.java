package test11;



class Cake{
	public int size;
	public Cake(int sz) {
		size = sz;
	}
	public void showCakeSize() {
		System.out.println(" 그냥 케이크 사이즈 위 :  " + size);
	}

}

class CheeseCake extends Cake{
	public int size;
	public CheeseCake(int sz1, int sz2) {
		super(sz1);
		size = sz2;
	}
	public void showCakeSize() {
		System.out.println("super.size d아래 = " + super.size);
		System.out.println("cheese ounce " + size);
		}

}




public class test111 {

	public static void main(String[] args) {
		Cake ca1 = new CheeseCake(5,7);
//		Cake ca2 = ca1;
		System.out.println(ca1.size);
		
//		ca1.showCakeSize();
//		ca2.showCakeSize();
//		System.out.println(ca2.size);
//		ca2.showCakeSize();
		

	}//end main

}//end class
