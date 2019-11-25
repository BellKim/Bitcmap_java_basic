package chap06Work01;

import java.util.Scanner;

public class mainclass_me {
	/*
	 * 성적통계 프로그램
	 * 
	 * 몇명의 학생의 점수를 입력하는가 row(행)(가로라인) 2차원배열로 선언한다. String[학생들의 명수][항목의 갯수(4)] 1 홍길동
	 * 90 85 100 2 홍길동 90 85 100 3 홍길동 90 85 100
	 * 
	 * 
	 * 이름, 국어, 영어, 수학
	 * 
	 * 1. 각 학생의 총점을 구하라 2. 전체학생의 총점을 구하라. 3. 총점의 1등을 구하고 4. 총점의 꼴지를 구하라.
	 * 
	 * 각 학생의 총점 SUM 전체학생의 총점 ALLSUM 총점의 1등 MAX 총점을 꼴지 MIN
	 * 
	 */
	public static void main(String[] args) {
//		선언부
		Scanner sc = new Scanner(System.in);
		int inputstatus = 0;
		int studentCount = 0;
		String inputTxt;
		String stuInfo[][];
//		String outPutInfo[] = new String[4];
		String outPutInfo1[] = { "이름", "국어", "영어", "수학" };

		int SUM = 0; // 각 학생의 총점
		int ALLSUM = 0; // 전체학생의 총점
		int MAX = 0; // 총점의 1등.
		int MIN = 0; // 총점을 꼴지

//		입력부
//		몇명의 학생정보를 입력하시겠습니까
		System.out.println("몇명의 학생정보를 입력하시겠습니까 ");
		studentCount = sc.nextInt();
//		2차원 배열을 동적할당한다. [학생수][자료수]
		stuInfo = new String[studentCount][4];
//		학생명 국어점수 영어점수 수학점수 순으로 입력함.
		sc.nextLine();
		for (int i = 0; i < stuInfo.length; i++) {
			for (int j = 0; j < stuInfo[0].length; j++) {
				System.out.println(outPutInfo1[j] + " : ");
				stuInfo[i][j] = sc.nextLine();
			}
		}

//		입력된 자료를 출력한다.
		System.out.printf("%s\t %s\t %s\t %s\t\n", "이름", "국어", "영어", "수학");
		for (int i = 0; i < stuInfo.length; i++) {
			System.out.printf("%s\t %s\t %s\t %s\t", stuInfo[i][0], stuInfo[i][1], stuInfo[i][2], stuInfo[i][3]);
			System.out.println();
		}

//		추가정보를 설정해준다. (각 학생의 총점 SUM,  전체학생의 총점 ALLSUM, 총점의 1등 MAX, 총점을 꼴지 MIN)

//		각 학생의 총점 SUM
		int instanceNum = 0;
		String sum[][] = new String[studentCount][2];
		for (int i = 0; i < sum.length; i++) {
			for (int j = 0; j < sum[0].length; j++) {
				// sum[학생이름][학생총점]
				if (j == 0) {//학생이름을 입력한다.
					sum[i][j] = stuInfo[i][j];
				} else if (j == 1) {//해당 학생의 점수의 총점을 구한다.
					for (int j2 = 1; j2 < stuInfo[i].length; j2++) {
						instanceNum += Integer.parseInt(stuInfo[i][j2]);
					}
					//구한총점을 대입힌다.
					sum[i][j] = Integer.toString(instanceNum);
					instanceNum= 0;
				}
			}
		}
		
//		입력된 자료를 출력한다.
		System.out.printf("%s\t %s\t\n", "이름","전체총점");
		for (int i = 0; i < sum.length; i++) {
			System.out.printf("%s\t %s\t", sum[i][0], sum[i][1]);
			System.out.println();
		}
		

//		전체학생의 총점 ALLSUM		
		for (int i = 0; i < stuInfo.length; i++) {
			for (int j = 1; j < stuInfo[i].length; j++) {
				ALLSUM += Integer.parseInt(stuInfo[i][j]);
			}
		}
		System.out.println("점수 총합 = " + ALLSUM);
		
		int MaxMin[] = new int[studentCount];// 학생별 과목점수 총합 전체적으로 받아옴
		for (int i = 0; i < sum.length; i++) {
			for (int j = 1; j < sum[0].length; j++) {
				// sum[학생수][학생총점수]
				MaxMin[i]=Integer.parseInt(sum[i][j]);
			}
		}
		int temp=0;
		for (int i = 0; i < MaxMin.length; i++) {
			for (int j = 0; j < MaxMin.length; j++) {
				if(MaxMin[i] > MaxMin[j]) {
					temp=MaxMin[i];
					MaxMin[i]=MaxMin[j];
					MaxMin[j]=temp;
				}
			}
		}
//		for (int i = 0; i < MaxMin.length; i++) {
//			System.out.println("amxmin배열출력 "+i +" = " + MaxMin[i]);
//		}
		
		System.out.println("  " +"총점의1등 : "+ MaxMin[0]+ "\n총점의 꼴등 : " + MaxMin[(MaxMin.length)-1]);
		
		

//		총점의 1등 MAX
//		총점을 꼴지 MIN

//		추가정보를 포함한 결과출력

	}// end main

}// end class
