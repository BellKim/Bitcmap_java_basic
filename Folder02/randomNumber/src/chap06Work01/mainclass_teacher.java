package chap06Work01;

import java.util.Scanner;

public class mainclass_teacher {

//	  몇명의 학생의 점수를 입력하는가 row(행)(가로라인) 2차원배열로 선언한다. String[학생들의 명수][항목의 갯수(4)] 1 홍길동
//	  90 85 100 2 홍길동 90 85 100 3 홍길동 90 85 100
//	  
//	  
//	  이름, 국어, 영어, 수학
//	  
//	  1. 각 학생의 총점을 구하라 2. 전체학생의 총점을 구하라. 3. 총점의 1등을 구하고 4. 총점의 꼴지를 구하라.
//	  
//	  각 학생의 총점 SUM 전체학생의 총점 ALLSUM 총점의 1등 MAX 총점을 꼴지 MIN
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// student[학생수][이름 과목1, 과목2, 과목3....]
		String student[][] = null;
		int count;

		// 1. 학생수 입력요구
		System.out.println("입력할 학생의 수를 입력해주세요 ");
		count = sc.nextInt();

		// 2. 학생수에 맞춰서 동적할당한다.
		student = new String[count][4];

		// 3. 이름과 성적을 입력받으시오.
		// 이름 국어 영어 수학
		for (int i = 0; i < student.length; i++) {
			// for문을 돌리기보다는 가독성을 위해서
			// 이름 국 영 수 는 0,1,2,3 을 입력 해야한다.
			System.out.print("이 름");
			String name = sc.next();

			System.out.print("국어");
			String kor = sc.next();

			System.out.print("영어");
			String eng = sc.next();

			System.out.print("수학");
			String math = sc.next();

			student[i][0] = name;
			student[i][1] = kor;
			student[i][2] = eng;
			student[i][3] = math;
		}

		// 4. 각 학생의 총점
		int sum[] = new int[student.length];
		for (int i = 0; i < student.length; i++) {
			for (int j = 1; j < student.length; j++) {
				// j=1부터 한 이유는, 국어부터 점수를 가산하기 위해서 1부터 시작함.
				sum[i] += Integer.parseInt(student[i][j]);
			}
		}

		// 5. 전체 학생의 총점
		int allSum = 0;
		for (int i = 0; i < student.length; i++) {
			for (int j = 1; j < student.length; j++) {
				allSum += Integer.parseInt(student[i][j]);
			}
		}
		//5-1 학생들의 총점의 평균점수
		double avg = 0.00;
		avg = (double)allSum / student.length;
		
		

		// 6. 총점의 1등 & 꼴지
		int findIndex = -1;//-1오로 셋팅한 이유는 검색을할때 검석어에 해당하는것을 못찾았을경우 -1을 리턴해서 -1없음을 표시해줌.
		int max = sum[0];//일단 sum[0]을 입력해서 
		for (int i = 0; i < sum.length; i++) {
			if(sum[i]>max) {
				findIndex = i;
			}
				
		}
		//각 학생의 총점 출력		
		for (int i = 0; i < sum.length; i++) {
			System.out.println((i+1)+"번째 학생의 총점 : " + sum[i]);
		}

		//전체학생의 총점
		System.out.println("전체 학생의 총점 : " + allSum);
		
		//학생 총점의 평균점수
		System.out.println("전체 총점의 평균점수" + avg);
		
		//총점의 1등과 꼴지
		//1등
		
		////////////////////추가작성필요.
		for (int i = 0; i < sum.length; i++) {
			System.out.println("학생들의 1등 : "+""+student[findIndex][i]);
		}
		

	}// end main

}
