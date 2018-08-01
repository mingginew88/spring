package kr.or.ddit.lprod.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import kr.or.ddit.lprod.dao.LprodDao;
import kr.or.ddit.lprod.dao.LprodDaoInf;
import kr.or.ddit.lprod.model.LprodVo;

@Service("lprodService")
public class LprodService implements LprodServiceInf {
	
	LprodDaoInf lprodDao = new LprodDao();
	

	/**
	* Method : selectAllLprod
	* 최초작성일 : 2018. 7. 11.
	* 작성자 : PC17
	* 변경이력 :
	* @return
	* Method 설명 : 모든 상품분류 조회
	*/
	@Override
	public List<LprodVo> selectAllLprod() {
		return lprodDao.selectAllLprod();
	}

	
	/**
	* Method : getCntOfLprod
	* 최초작성일 : 2018. 7. 11.
	* 작성자 : PC17
	* 변경이력 :
	* @return
	* Method 설명 : 모든 상품분류의 총 갯수 조회
	*/
	@Override
	public int getCntOfLprod() {
		return lprodDao.getCntOfLprod();
	}

	
	/**
	* Method : getPageLprodList
	* 최초작성일 : 2018. 7. 11.
	* 작성자 : PC17
	* 변경이력 :
	* @param map
	* @return
	* Method 설명 : 페이지처리 한 상품분류 조회
	*/
	@Override
	public Map<String, Object> getPageLprodList(Map<String, Integer> map) {
				
		LprodServiceInf lprodService = new LprodService();
		Map<String, Object> pageMap = new HashMap<String, Object>();
		
		//전체 상품분류 정보
		List<LprodVo> pageList = lprodDao.getPageLprodList(map);
		pageMap.put("pageList", pageList);
		
		int totLprod = 	lprodService.getCntOfLprod();	//전체 상품분류 갯수
		pageMap.put("totLprod", totLprod);
		
		int page 	  = map.get("page");			//페이지번호
		int pageSize  = map.get("pageSize");		//페이지크기
		
		int cnt = totLprod / pageSize;								//몫(페이지 수)
		int mod = totLprod % pageSize == 0 ? cnt : cnt++;			//나머지
		
		int prevPage = cnt == 1 ? 1 : page-1;						//이전페이지
		int nextPage = cnt == totLprod / pageSize ? cnt : page+1;	//다음페이지
		
		StringBuffer mapStrBuff = new StringBuffer();
		mapStrBuff.append("<li><a href=\"/lprod/list?page="+ prevPage + "&pageSize=" + pageSize +"\" aria-label=\"Previous\"><span aria-hidden=\"true\">&laquo;</span></a></li>") ;
	    
		for(int i = 1; i <= cnt; i++) {
			String active = "";
			if(i == page)
				active = " class=\"active\"";
			
			mapStrBuff.append("<li" + active + "><a href=\"/lprod/list?page="+ i + "&pageSize=" + pageSize + "\">" + i + "</a></li>") ;
		}
		mapStrBuff.append("<li><a href=\"/lprod/list?page="+ nextPage + "&pageSize=" + pageSize + "\" aria-label=\"Next\"><span aria-hidden=\"true\">&raquo;</span></a></li>");
		
		pageMap.put("pageResult", mapStrBuff.toString());
		
		return pageMap;
	}

}
