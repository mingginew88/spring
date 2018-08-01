package kr.or.ddit.lprod.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.mybatis.SqlMapSessionFactory;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

@Repository("lprodDao")
public class LprodDao implements LprodDaoInf {
	
	private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();

	/**
	* Method : selectAllLprod
	* 최초작성일 : 2018. 7. 11.
	* 작성자 : PC17
	* 변경이력 :
	* @return
	* Method 설명 : 모든 상품분류 검색
	*/
	@Override
	public List<LprodVo> selectAllLprod() {
		SqlSession session = sqlSessionFactory.openSession();
		List<LprodVo> lprodList	= session.selectList("lprod.selectAllLprod");
		session.close();
		
		return lprodList;
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
		SqlSession session = sqlSessionFactory.openSession();
		int cnt	= session.selectOne("lprod.getCntOfLprod");
		session.close();
		
		return cnt;
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
	public List<LprodVo> getPageLprodList(Map<String, Integer> map) {
		SqlSession session = sqlSessionFactory.openSession();
		List<LprodVo> lprodList	= session.selectList("lprod.getPageLprodList", map);
		session.close();
		
		return lprodList;
	}

}
