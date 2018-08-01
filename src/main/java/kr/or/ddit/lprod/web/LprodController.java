package kr.or.ddit.lprod.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.ddit.lprod.service.LprodServiceInf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/lprod")
@Controller("lprodController")
public class LprodController {
	
	@Resource(name="lprodService")
	private LprodServiceInf lprodService;
	
	@RequestMapping("/list")
	public String LprodList(@RequestParam(value="page", defaultValue="1") 	  int page,
							@RequestParam(value="pageSize", defaultValue="5") int pageSize,
							Model model){
		
		Map<String, Integer> pageMap = new HashMap<String, Integer>();
		pageMap.put("page", page);
		pageMap.put("pageSize", pageSize);
		
		Map<String, Object> lprodMap = lprodService.getPageLprodList(pageMap);
		model.addAllAttributes(lprodMap);
		
		return "lprod/list";
	}

}
