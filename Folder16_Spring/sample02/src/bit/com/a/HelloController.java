package bit.com.a;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {

	private static Logger logger = LoggerFactory.getLogger(HelloController.class);

	@RequestMapping("hello") // GET
	public String hello() {
		logger.info("HomeController hello " + new Date());

		return "hello"; // hello.jsp
	}

	@RequestMapping(value = "home.do", method = RequestMethod.GET)
	public String home(Model model) { // java(controller) -> web

		logger.info("HomeController home " + new Date());

		String name = "홍길똥";
		model.addAttribute("name", name); // setAttribute(request, session, application);과 비슷함.
											// 이 셋은 내장객체이며, 값을 전달하는 방법은 3가지이다.

		return "home";
	}

	@RequestMapping(value = "world.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String world(int age, String email) {
		logger.info("hoemcontroller world.do" + new Date());

		logger.info("age = " + age);
		logger.info("email = " + email);

		return "world";
	}// end world

	
	  @RequestMapping(value="func.do", method= {RequestMethod.GET,
	  RequestMethod.POST}) public String func(member mem) { 
		  // 기본생성자 안만들면func(Member mem) {에서 에러난다. 
		  logger.info("home controoller func.do " + new Date());
		  logger.info(mem.toString()); return "home";
	  
	  }//end func();
	 

//	@RequestMapping(value = "func.do", method = { RequestMethod.GET, RequestMethod.POST })
//	public String func(member mem) {
//		logger.info("HomeController func.do " + new Date());
//		logger.info(mem.toString());
//
//		return "home";
//
//	}

}// end helloController
