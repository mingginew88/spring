package kr.or.ddit.student.dao;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.student.model.StudentVo;

import org.junit.Before;
import org.junit.Test;

public class StudentDaoTest {
	
	private StudentDaoInf studentDao;
	
	//테스트코드 실행 순서  -- @Before @Test @After순으로..
	//테스트 메서드안에 중복되는 내용 : StudentDao 구현체에 대한 생성 로직
	// --> @Before 어노테이션이 붙은 setup메서드에 위임
	//모든 테스트 메서드에서 StudentDao객체를 참조할 수 있게끔 클래스 변수로 생성할 필요가 있고 (O)
	//클래스 변수를 setup메서드에서 초기화하는 로직이 필요 (O)
	//테스트 메서드에서 StudentDao를 생성하는 로직은 삭제
	
	@Before
	public void setup() {
		studentDao = new StudentDao();
	}
	
	/**
	* Method : selectAllStudentstest
	* 최초작성일 : 2018. 7. 10.
	* 작성자 : PC17
	* 변경이력 :
	* Method 설명 : 전체 학생 정보를 조회한다.
	*/
	@Test
	public void selectAllStudentstest() {
		/***Given***/

		/***When***/
		List<StudentVo> studentList = studentDao.selectAllStudents();
		
		/***Then***/
		for (StudentVo studentVo : studentList) {
			System.out.print(studentVo.getId() + " ");
			System.out.println(studentVo.getName());			
		}
		assertEquals(25, studentList.size());
	}
	
	
	/**
	* Method : getStudent
	* 최초작성일 : 2018. 7. 10.
	* 작성자 : PC17
	* 변경이력 :
	* @param id
	* @return
	* Method 설명 : ID에 일치하는 학생 정보 조회
	*/
	@Test
	public void getStudentTest() {
		/***Given***/
		int id = 1;

		/***When***/
		StudentVo studentVo	= studentDao.getStudent(id);
		
		/***Then***/
		assertEquals(id, studentVo.getId());
		assertEquals("김마음", studentVo.getName());	
	}
		
	
	/**
	* Method : getStudent2
	* 최초작성일 : 2018. 7. 10.
	* 작성자 : PC17
	* 변경이력 :
	* @param studentVo
	* @return
	* Method 설명 : studentVo에서 id를 가지고 학생 정보 조회
	*/
	@Test
	public void getStudent2Teset() {
		/***Given***/
		StudentVo studentVo = new StudentVo();
		studentVo.setId(1);

		/***When***/
		StudentVo student = studentDao.getStudent2(studentVo);
		
		/***Then***/
		assertEquals(1, student.getId());
		assertEquals("김마음", student.getName());
	}
	
	
	/**
	* Method : getStudentList
	* 최초작성일 : 2018. 7. 10.
	* 작성자 : PC17
	* 변경이력 :
	* Method 설명 : 학생 페이지 리스트 조회 테스트
	*/
	@Test
	public void getStudentList() {
		/***Given***/
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("page", 1);
		map.put("pageSize", 10);

		/***When***/
		List<StudentVo> studentList = studentDao.getStudentList(map);

		/***Then***/
		for (StudentVo studentVo : studentList) {
			System.out.print(studentVo.getId() + " ");
			System.out.println(studentVo.getName());
		}
		
		assertEquals(10, studentList.size());
		assertEquals("강병관", studentList.get(0).getName());
	}
	
	/**
	* Method : getStudentTotCnt
	* 최초작성일 : 2018. 7. 11.
	* 작성자 : PC17
	* 변경이력 :
	* Method 설명 : 전체 학생 수 조회
	*/
	@Test
	public void getStudentTotCnt() {
		/***Given***/

		/***When***/
		int cnt = studentDao.getStudentTotCnt();
		System.out.println(cnt);

		/***Then***/
		assertEquals(25, cnt);
	}
	
	
	/**
	* Method : studentUpdate
	* 최초작성일 : 2018. 7. 17.
	* 작성자 : PC17
	* 변경이력 :
	* Method 설명 : 학생정보 업데이트
	*/
	@Test
	public void studentUpdate() {
		/***Given***/
		StudentVo studentVo = new StudentVo();
		studentVo.setId(2);
		studentVo.setName("강병관");
		studentVo.setAddr1("대전광역시 중구 중앙로 76");
		studentVo.setAddr2("영민빌딩 2층 대덕인재개발원");
		studentVo.setZipcd("34940");
		studentVo.setPic("moon.png");
		studentVo.setPicpath("D:\\A_TeachingMaterial\\7.JspSrpgin\\fileUpload");
		studentVo.setPicname("04f86c08-e713-4403-a1b7-d3c6102fe22d");		

		/***When***/
		int updateCnt = studentDao.studentUpdate(studentVo);

		/***Then***/
		assertEquals(1, updateCnt);
	}
	
	

}
