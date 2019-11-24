package day05.chap02_Calendar;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Calendar;

public class Ex06 {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal.set(Calendar.HOUR,2);
		//무식방법
		System.out.println(cal2.getTimeInMillis() - cal.getTimeInMillis());
		
//		위의코드는
//		1/1000초 단위이기 때문에
//		우리가 분으로 표시하려면
//		나누기1000 나누기 60
//		시간으로 표시하려면
//		나누기1000 나누기60 나누기60
		
		System.out.println((cal2.getTimeInMillis() - cal.getTimeInMillis()) /1000/60/60);
		
//		Duration과 Period (1.8 이후 추가됨)
//		Duration : 시분초 단위의 차이		->시간
//		Period : 연월일 단위의 차이		->기간
//		얘네들은 calendar도 아닌 LocalDateTime이라는것을 사용한다.
		LocalDateTime ldt1 = LocalDateTime.of(2019, 11, 8, 16, 31);
		LocalDateTime ldt2 = LocalDateTime.now();
		System.out.println();
		System.out.println("ldt1 = "+ldt1);
		System.out.println("ldt2 = "+ldt2);
		ldt2 = ldt2.plusHours(-2);
		System.out.println("ldt1 = "+ldt1);
		System.out.println("ldt2 = "+ldt2);
		
		Duration d = Duration.between(ldt1, ldt2);
		System.out.println(d.toMinutes());
		
		
		
		
		
		
		
	}//main

}//classs
