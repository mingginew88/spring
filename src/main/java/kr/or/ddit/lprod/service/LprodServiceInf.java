package kr.or.ddit.lprod.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.lprod.model.LprodVo;

public interface LprodServiceInf {
	
	/**
	* Method : selectAllLprod
	* 최초작성일 : 2018. 7. 11.
	* 작성자 : PC17
	* 변경이력 :
	* @return
	* Method 설명 : 모든 상품분류 조회
	*/
	List<LprodVo> selectAllLprod();
	
	
	/**
	* Method : getCntOfLprod
	* 최초작성일 : 2018. 7. 11.
	* 작성자 : PC17
	* 변경이력 :
	* @return
	* Method 설명 : 모든 상품분류의 총 갯수 조회
	*/
	int getCntOfLprod();
	
	
	/**
	* Method : getPageLprodList
	* 최초작성일 : 2018. 7. 11.
	* 작성자 : PC17
	* 변경이력 :
	* @param map
	* @return
	* Method 설명 : 페이지처리 한 상품분류 조회
	*/
	Map<String, Object> getPageLprodList(Map<String, Integer> map);

}
