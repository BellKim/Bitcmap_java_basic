package bit.com.a;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	private static Logger logger = LoggerFactory.getLogger(HelloController.class);//계속 사용할 부분이니 가져다쓰자. 
	
	/* 1 */
	@RequestMapping(value="hello.do", method = RequestMethod.GET)
	public String hello(Model model) {
		logger.info("helloController hello" + new Date());
		
		MyClass cls = new MyClass(101, "일찌");
		
		model.addAttribute("mycls", cls);
		
		

		return "hello";		//hello.jsp로 이동
	}
	
	
	/* 2 controller -> controller */
	@RequestMapping(value="move.do", method=RequestMethod.GET)
	public String move() {
		logger.info("move Controller move" + new Date());
		
		//return "hello.do";// 이런식으로 이동시키면 메시지 /sampleAjax/WEB-INF/views/hello.do.jsp 로 잡힌다.
		
		//방법1
		//return "redirect:/hello.do";	//sendRedirect 하면된다. 
				//redirect :/이동할 컨트롤러명
		//방법2
		return "forward:/hello.do";		//forward	만약 컨트롤러->컨트롤러로 데이터를 넘겨줘야 할 경우 forward 를 통해서 넘겨주면 된다. 받는쪽에선 메소드 이름 옆에 변수로 받는다.
		
		
	}//end of move 
	
	@ResponseBody	//ajax 를 사용할때는 반드시 붙혀야 한다. 빼고나서 실행하면 ajax 가 실행이 안된다. 
	@RequestMapping(value="idcheck.do", produces="application/String; charset=utf-8")	//produces="application/String; charset=utf-8", 을 통해서 charset 을 맞출 수 있다. 
	public String idcheck(String id, HttpSession session) {//ajax 로 넘겨준건 이거 하나
		// HttpSession session 을 적어주면 세션에 접근이 된다. 프레임워크는 이것이 가능하고 프레임 워크의 의존성 이라고한다. 
		
		logger.info("id:"+id);
		
		String str = "오케이";
		
		return str; 
		
	}//end idcheck
	
	
	@ResponseBody	//ajax 를 사용할때는 반드시 붙혀야 한다. 빼고나서 실행하면 ajax 가 실행이 안된다.
	@RequestMapping(value="account.do", method=RequestMethod.POST,  produces="application/json; charset=utf-8")
	public Map<String, Object> account(Human my){
		logger.info("account HUMAN  HELLO Controller move" + new Date());
		logger.info(my.toString());
		
		//db접근
		
		Map<String, Object> rmap = new HashMap<String, Object>();
		rmap.put("msg", "메시지입니다.");
		rmap.put("name", "정수동");
		
		
		
		return rmap;
		
		
		
	}//end account
	
	
	@ResponseBody	//ajax 를 사용할때는 반드시 붙혀야 한다. 빼고나서 실행하면 ajax 가 실행이 안된다.
	@RequestMapping(value="updateUser.do", method=RequestMethod.POST,  produces="application/json; charset=utf-8")
	public Map<String,Object> updateUser( @RequestBody Map<String, Object> map){//이름 전화번호 이메일 생년월일이 키값
									//받는다는의미인 @requestbdy 해줘야 MAP으로 받을수 있다.
		
		logger.info("helloController updateUser " + new Date());
		
		logger.info(map.get("name") + " ");
		logger.info(map.get("tel") + " ");
		logger.info(map.get("email") + " ");
		logger.info(map.get("birth") + " ");
		
		Map<String, Object> rmap = new HashMap<String, Object>();
		rmap.put("name", "일지매");
		rmap.put("age", "33");
		
	return rmap;
	}
	
	
	
	
	
	
	

}//end of HelloController
