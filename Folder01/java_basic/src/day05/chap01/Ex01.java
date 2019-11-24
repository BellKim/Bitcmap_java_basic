package day05.chap01;

import java.util.Random;

public class Ex01 {

	public static void main(String[] args) {
//		로또번호 조건 1~45, 6개의 숫자, 중복 x 오름차순
		Random random = new Random();
		int[] lottoNumbers = new int[6];
		for (int i = 0; i < lottoNumbers.length; i++) {
			lottoNumbers[i] = random.nextInt(54) + 1;// 로또번호 45까지 나옴.

		}
		System.out.println("============중복제거전============");

		for (int i : lottoNumbers) {
			System.out.println(i);
		}
		System.out.println("===========중복변경됨=============");

		for (int i = 0; i < lottoNumbers.length; i++) {
			for (int j = 0; j < lottoNumbers.length; j++) {
				if (lottoNumbers[i] == lottoNumbers[j] && i != j) {
					lottoNumbers[i] = random.nextInt(45) + 1;
					System.out.println(i + " 번 " + lottoNumbers[i]);
					j = -1;
					
				}

			}

		}

		System.out.println("============중복제거후============");

		for (int i : lottoNumbers) {
			System.out.println(i);
		}

		System.out.println("============정렬시작  ============");
//		System.out.println(lottoNumbers[6]);
		for (int i = 0; i < lottoNumbers.length - 1; i++) {// 0~4ㄲㅏ지. 01,2,3,4,5번쨰일때 6일때 비교를하니
			if (lottoNumbers[i] > lottoNumbers[i + 1]) {
				int temp = lottoNumbers[i];
				lottoNumbers[i] = lottoNumbers[i + 1];
				lottoNumbers[i + 1] = temp;
				i = 1;

			}
		}
		System.out.println("============정=렬후============");

		for (int i : lottoNumbers) {
			System.out.println(i);
		}

	}// end main

}// end class
