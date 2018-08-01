package kr.or.ddit.mvc.web;

import javax.annotation.Resource;

import kr.or.ddit.ioc.service.IocServiceInf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/hello")   //모듈명
@Controller
public class HelloController {
	
	@Resource(name="iocAnnotationService")
	private IocServiceInf iocService;
	
	//return : view 이름
	//localhost:8180/hello/view
	@RequestMapping("/view")
	public String hello(Model model){
		
		//BoardServiceInfo boardService = new BoardService(); 
		//hello()메서드의 리턴값을 hello.jsp에서 출력
		String msg = iocService.hello();
		model.addAttribute("msg", msg);
		
		//default : forward
		//redirect: hello
		return "hello";
		// prefix : /WEB-INF/views/
		// suffix : .jsp
		// --> /WEB-INF/views/hello.jsp
	}

}
