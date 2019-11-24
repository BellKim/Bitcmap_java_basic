package day05.chap02_Calendar;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

//D-day 계산기
public class Ex07 {
//	 사용자로부터 연월일을 입력받아서
//	오늘날자기준  d day를 계산해준다.
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("계산할 년 : ");
		int year = scanner.nextInt();
		System.out.println("계산할 월 : ");
		int month = scanner.nextInt();
		System.out.println("계산할 일: ");
		int day = scanner.nextInt();

		LocalDate dDay = LocalDate.of(year, month, day);
		LocalDate today = LocalDate.now();
		Period p = Period.between(today, dDay);
		System.out.println(dDay + "dDay까지"+p.toTotalMonths()+"일 남았습니다.");
		
		LocalDateTime dDayt = LocalDateTime.of(year, month, day,0,0);
		LocalDateTime todayt = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy년, M월 d일");
		Duration p1 = Duration.between(todayt, dDayt);
		System.out.println(dDayt + "dDay까지"+p1.toDays()+"일 남았습니다.");
		System.out.println(dDayt.format(DateTimeFormatter.BASIC_ISO_DATE) + "까지" + p1.toDays()+"일 남았습니다.");
		System.out.println(dDayt.format(dtf) + "까지" + p1.toDays()+"일 남았습니다.");
		
		
		
		
		
		scanner.close();
		

	}// main

}// class
