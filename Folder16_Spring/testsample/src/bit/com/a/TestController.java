package bit.com.a;


import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller		//annotation 지시문, 주석문
public class TestController {
	
	private static Logger logger = LoggerFactory.getLogger(TestController.class);
	
	
	
	@RequestMapping("hello")
	public ModelAndView hello() {
		//System.out.println("TestController hello()");//무겁기 때문에 스프링 전용 디버깅 콘솔이 있다.
		logger.info("TestController hello()" + new Date());
		
		
		
		ModelAndView view = new ModelAndView();
		view.setViewName("hello");
		return view;
	}
	
	
//	@RequestMapping(value="home", method= {RequestMethod.GET, RequestMethod.POST})
	@RequestMapping(value="home", method= RequestMethod.GET)
	
	//이 이름으로 링크를 건다 (서블릿처럼)
	public String home(Model model, Locale local) {	//model -> OBJECT전송용. 보낸 데이터를 받을때 사용. 
		//System.out.println("TestController home");
		logger.info("TestController home");
		
		
		//시간설정
		Date date = new Date();
		DateFormat dateformat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, local);// .getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, local);
		String formattedDate = dateformat.format(date);
		
		
		//짐싸
		model.addAttribute("serverTime", formattedDate);
		
		return "home";
		
		
	}
	

}//end TestController 
