package kr.or.ddit.mvc.web;

import javax.servlet.http.HttpServletRequest;

import kr.or.ddit.user.model.UserVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@RequestMapping("/login")
@Controller
public class LoginController {
	
	private Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping("/view")
	public String hello(Model model){
		
		return "login/login";

	}
	
	//로그인 처리
	//@RequestMapping("/loginProcess")
	public String loginProcess(HttpServletRequest request){
		
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
		//logger : userId, password
		logger.debug("{}", userId + " : " + password);
		
		//정상접속완료
		
		return "main";
	}
	
//	@RequestMapping("/loginProcess")
	public String loginProcess(UserVo userVo){
		
		//logger : userId, password
		logger.debug("{}", userVo.getUserId() + " : " + userVo.getPassword());
		
		//정상접속완료
		
		return "main";
	}
	
	
	@RequestMapping("/loginProcess")
	public ModelAndView loginProcess2(UserVo userVo){
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main");		//return "main";
		
		mav.addObject("from", "modelAndView");
		
		//logger : userId, password
		
		logger.debug("{}", "return ModelAndView");
		logger.debug("{}", userVo.getUserId() + " : " + userVo.getPassword());
		
		//정상접속완료
		
		return mav;
	}
	
	
	
	
	
	
	
	
	

}
