package kr.or.ddit.mvc.web;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;

import kr.or.ddit.util.FileUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


@SessionAttributes("boardList")
@RequestMapping("/mvc")
@Controller("mvcController")
public class MvcController {
	
	private Logger logger = LoggerFactory.getLogger(MvcController.class);
	
	@ModelAttribute("boardList")
	public List<String> boardList() {
		
		logger.debug("{}", "boardList");
		
		//db에서 조회한 보드 리스트
		List<String> boardList = new ArrayList<String>();
		boardList.add("자유게시판");
		boardList.add("Q&A");
		boardList.add("공지사항");
		
		return boardList;
	}
	
	
	//localhost:8280/mvc/view
	//mvc 어노테이션을 테스트할 view
	@RequestMapping(value="/view", method=RequestMethod.GET)
	public String view(){
		
		return "mvc/view";
	}
	
	@RequestMapping(value="/view2", method=RequestMethod.GET)
	public String view2(){
		
		return "mvc/view2";
	}
	
	// @RequestParam : 특정 이름의 파라미터를 메서드 인자에서 받을 수 있다.
	@RequestMapping(value="/requestParam", method=RequestMethod.GET)
	public String requestParam(@RequestParam("userId") String param) {
		
		logger.debug("{}", "param : " + param);
		
		return "mvc/view";
	}
	
	
	//@PathVariable Test
	//localhost:8180/mvc/pathvariable/35
	@RequestMapping(value="/pathvariable/{boardNum}")
	public String pathvariable(@PathVariable("boardNum") String boardNum, Model model){
		
		model.addAttribute("boardNum", boardNum);
		
		return "mvc/view";
	}
	
	
	//multipart test용 view
	@RequestMapping("/multipart/view")
	public String multipartView(){
		
		return "mvc/multipartView";
	}
	
	
	//multipart upload 처리
	@RequestMapping("/multipart/upload")
	public String multipartUpload(@RequestParam("userId") String userId,
								  @RequestPart("uploadFile") MultipartFile file,
								  FileVo files,
								  MultipartHttpServletRequest request,
								  Model model){
		
		for (MultipartFile f : files.getFiles()) {
			logger.debug("{}", "f.getOriginalFilename() : " + f.getOriginalFilename());
		}
		
		
		logger.debug("{}", "userId : " + userId);
		model.addAttribute("userId", userId);
		
		logger.debug("{}", "file.getName() : " + file.getName());
		logger.debug("{}", "file.getOriginalFilename() : " + file.getOriginalFilename());
		
		String path = FileUtil.fileUploadPath;
		String fileName = UUID.randomUUID().toString();
		
		File uploadFile = new File(path + File.separator + fileName);
		
		try {
			file.transferTo(uploadFile);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		logger.debug("{}","userId : " + request.getParameter("userId"));
		
		try {
			request.getPart("uploadFile");
			request.getParts();
		} catch (IOException | ServletException e) {
			e.printStackTrace();
		}
		
		
		return "mvc/multipartView";
	}
	

}
