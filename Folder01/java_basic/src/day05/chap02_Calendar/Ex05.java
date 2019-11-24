package day05.chap02_Calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

//calendar
public class Ex05 {
	public static void main(String[] args) {
//		java에서 날짜(시간)을 담당하는 클래스가 여럿있습니다.
//		java.util.DataTime, java.sql.DateTime, java.util.Calendar
//		근데 java.sql.DateTime 패키지이름만봐도 알수 있듯
//		sql의 DateTiem 데이터타입으로 쓰입니다.
//		그럼 우리가 일상적으로 쓰는 시간은 DateTime과 Calendar가 있습니다.
//		하지만 자바가 더이상 java.util.DateTime을 지원하지 않기때문에
//		우리는Calendar를 써야합니다.
		
//		Calendar calendar = new Calendar();		Calendar객체는 new로 초기화 하지 않는다.
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar);//	tiem = 1970년1월1일0시0분0초 이후로 측정된 초 
//		Calendar 객체의 필드들을 출력해 봅시다.
		System.out.println(calendar.get(Calendar.DATE));	//해당월의 "일"
		System.out.println(calendar.get(Calendar.DAY_OF_MONTH));//해당월의 "일"(date와 같음)
		System.out.println(calendar.get(Calendar.DAY_OF_WEEK));//무슨요일인지 int로 출력(일월화수목금토 순서)
		System.out.println(calendar.get(Calendar.DAY_OF_YEAR));//1년중 몇번째일지
		System.out.println(calendar.get(calendar.HOUR));//오전/오후 몇시인지  오후3시면 3으로 출력. 
		System.out.println(calendar.get(calendar.HOUR_OF_DAY));//24시 체계로 몇시인지.
		System.out.println(calendar.get(calendar.MINUTE));//몇 분 인지
		System.out.println(calendar.get(calendar.MILLISECOND));//지금시간 기준 몇 밀리초인지
		System.out.println(calendar.get(calendar.MONTH));//1년중 몇월인지(1월이 아니라 0월부터 시작)
		System.out.println(calendar.get(calendar.WEEK_OF_MONTH));//해당 월의 몇번째 주인지
		System.out.println(calendar.get(calendar.WEEK_OF_YEAR));//해당 년의 몇번째 주인지
		
//		지금 시간을
//		년 월 일 시 분 초로 표시하세요.
		System.out.println("\n\n");
		String timeString =
				calendar.get(calendar.YEAR)+"년"+
				calendar.get(calendar.MONTH)+"월"+
				calendar.get(calendar.DATE)+"일"+
				calendar.get(calendar.HOUR_OF_DAY)+"시";
		System.out.println(timeString);
		
		SimpleDateFormat sdf = new SimpleDateFormat("G yyyy년 MM월 dd일 hh시 mm분 ss초");
		System.out.println(sdf.format(calendar.getTime()));
				
		//RTFM은 "Read The
		sdf = new SimpleDateFormat("hh시mm분ss초");
//		calendar.setTimeInMillis(sdf.parse("3시5분45초").getTime()); //이거만 쓰면 오류
		
		try {
			System.out.print("내용출력 : ");
			calendar.setTimeInMillis(sdf.parse("3시5분45초").getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(calendar.get(calendar.HOUR));

		
				

	}//end main

}//end class
