package spring.mvc.sample;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping("/start.do")
	public ModelAndView start() {
		System.out.println("start.do 요청 받음");
		
		ModelAndView m = new ModelAndView();
		m.addObject("message","점심은");
		m.addObject("name","짝꿍님");
		//m.setViewName("/WEB-INF/view/hello.jsp");
		//prefix 및 suffix 지정해놔서 hello라는 이름으로 접근 가능
		m.setViewName("hello");
		return m;
	}
}
