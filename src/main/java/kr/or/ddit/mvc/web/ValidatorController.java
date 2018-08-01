package kr.or.ddit.mvc.web;

import kr.or.ddit.mvc.model.ValidVo;
import kr.or.ddit.mvc.model.ValidVoValidator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/valid")
@Controller
public class ValidatorController {
	
	
	@RequestMapping("/view")
	public String view(){
		return "mvc/valid/view";
	}
	
	@RequestMapping("/submit")
	//bindingResult는 반드시 vo 객체 바로 뒤에 선언 되어야 한다. 
	public String submit(ValidVo validVo, 
						 BindingResult errors, 
						 Model model){
		
		new ValidVoValidator().validate(validVo, errors);
		
		if(errors.hasErrors()){
			model.addAttribute("errorMsg", "에러가 발생했습니다.");
		}
		
		model.addAttribute("validVo", validVo);
		
		return "mvc/valid/view";
	}
	
	
	
	
	
}
