package day03;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarEx {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yy년 MM월 dd일");
		cal.add(Calendar.DAY_OF_YEAR, 5);
		System.out.println(sdf.format(cal.getTime()));
	}
}
