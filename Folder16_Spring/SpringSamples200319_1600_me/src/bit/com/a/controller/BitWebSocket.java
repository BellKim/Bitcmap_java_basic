package bit.com.a.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BitWebSocket {
	
	@RequestMapping(value = "chating.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String chating() {
		return "chating.tiles";
	}
}



