package chap10.methodClass;

import java.time.LocalDate;
import java.util.Calendar;

public class chap04_234Example {
	 static String date;

	public static void main(String[] args) {
		LocalDate nDate = LocalDate.now();
		date = nDate.toString();
		System.out.println(date);
		
		
		System.out.println("오늘날자 \n"+Calendar.getInstance());
		
		
//		static Calendar nowDate1 = Calendar.getInstance();
		
		
		

	}

}
