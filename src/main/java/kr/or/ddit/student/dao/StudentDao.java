package kr.or.ddit.student.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.mybatis.SqlMapSessionFactory;
import kr.or.ddit.student.model.StudentVo;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class StudentDao implements StudentDaoInf {
	
	private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();

//	SqlSession session = sqlSessionFactory.openSession();  
//	==> 공유하면 안된다. 각 메서드내에서 실행되어야한다. 가지고오는 시점에서 트랜잭션이 시작하는데 여러명일경우에는 문제가생긴다.
	
	/**
	* Method : selectAllStudents
	* 최초작성일 : 2018. 7. 9.
	* 작성자 : PC17
	* 변경이력 :
	* @return
	* Method 설명 : 전체 학생 정보를 조회한다.
	*/
	@Override
	public List<StudentVo> selectAllStudents() {
		SqlSession session = sqlSessionFactory.openSession();
		List<StudentVo> studentList = session.selectList("student.selectAllStudents");
		session.close();
		
		return studentList;
	}

	
	/**
	* Method : getStudent
	* 최초작성일 : 2018. 7. 10.
	* 작성자 : PC17
	* 변경이력 :
	* @param id
	* @return
	* Method 설명 : id에 맞는 학생 정보 조회
	*/
	@Override
	public StudentVo getStudent(int id) {
		SqlSession session = sqlSessionFactory.openSession();
		StudentVo studentVo = session.selectOne("student.getStudent", id);
		session.close();
		
		return studentVo;
	}

	
	/**
	* Method : getStudent2
	* 최초작성일 : 2018. 7. 10.
	* 작성자 : PC17
	* 변경이력 :
	* @param studentVo
	* @return
	* Method 설명 : id와 이름에 맞는 학생 정보 조회
	*/
	@Override
	public StudentVo getStudent2(StudentVo studentVo) {
		SqlSession session = sqlSessionFactory.openSession();
		StudentVo studentInfo = session.selectOne("student.getStudent", studentVo);
		session.close();
		
		return studentInfo;
	}

	
	/**
	* Method : getStudentList
	* 최초작성일 : 2018. 7. 10.
	* 작성자 : PC17
	* 변경이력 :
	* @param map
	* @return
	* Method 설명 : 학생 페이지 리스트 조회
	*/
	@Override
	public List<StudentVo> getStudentList(Map<String, Integer> map) {
		SqlSession session = sqlSessionFactory.openSession();
		List<StudentVo> studentList = session.selectList("student.getStudentList", map);
		session.close();
		
		return studentList;
	}


	/**
	* Method : getStudentTotCnt
	* 최초작성일 : 2018. 7. 11.
	* 작성자 : PC17
	* 변경이력 :
	* @return
	* Method 설명 : 전체 학생 수 조회
	*/
	@Override
	public int getStudentTotCnt() {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = session.selectOne("student.getStudentTotCnt");
		session.close();
		
		return cnt;
	}


	/**
	* Method : studentUpdate
	* 최초작성일 : 2018. 7. 17.
	* 작성자 : PC17
	* 변경이력 :
	* @param studentVo
	* @return
	* Method 설명 : 학생정보 업데이트
	*/
	@Override
	public int studentUpdate(StudentVo studentVo) {
		SqlSession session = sqlSessionFactory.openSession();
		int updateCnt = session.update("student.studentUpdate", studentVo);
		session.commit();
		session.close();
		return updateCnt;
	}
	
	
	
	
	

}
