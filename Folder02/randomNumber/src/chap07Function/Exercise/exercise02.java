package chap07Function.Exercise;

public class exercise02 {
	
	
	public static void main(String[] args) {
		int []original= {1,2,3,4,5,6,7,8,9};
		System.out.println(java.util.Arrays.toString(original));
		
		int[] result = shuffle(original);
		System.out.println(java.util.Arrays.toString(result));
		
		
	}//end main

	
	static int [] shuffle(int []arr){
		int w, r;
		int randomPhase[] = new int[arr.length];
		int returnArray[] = new int[arr.length];
		int ranNum = (int)(Math.random()*9);
		boolean _switch[] = new boolean[arr.length];
		for (int i = 0; i < _switch.length; i++) {	// fffff fffff
			_switch[i] = false;
		}
		w=0;
		while(w<arr.length) {
			ranNum = (int)(Math.random()*arr.length);
//			System.out.println("렌번호 출력" + ranNum);
			if(_switch[ranNum] == false) {
				_switch[ranNum]=true;
				randomPhase[w]=ranNum;
				w++;
			}
		}
		int temp;
		for (int i = 0; i < arr.length; i++) {
			temp=arr[randomPhase[i]];
			returnArray[i] = temp;

		}

		
		
		
		return returnArray;
	}

}//end class
