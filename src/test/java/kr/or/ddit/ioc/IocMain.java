package kr.or.ddit.ioc;

import static org.junit.Assert.*;
import kr.or.ddit.ioc.dao.IocDao;
import kr.or.ddit.ioc.dao.IocDaoInf;
import kr.or.ddit.ioc.service.IocService;
import kr.or.ddit.ioc.service.IocServiceInf;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IocMain {
	
	private ApplicationContext context;

	@Before
	public void setup(){
		//spring container를 생성
		context = new ClassPathXmlApplicationContext("classpath:kr/or/ddit/ioc/application-ioc.xml");
	}
	
	@Test
	public void test() {
		//iocDao를 주입받은 iocService 객체를 생성
		//iocDao가 필요, iocService 생성, 주입
		IocDaoInf iocDao = new IocDao();
		IocServiceInf iocService = new IocService(iocDao);
		String msg = iocService.hello();
		
		assertEquals("sayHello", msg);
	}
	
	@Test
	public void springIocTest(){
		/***Given***/
		
		/***When***/
		//spring container로 부터 스프링 빈을 요청
		IocServiceInf iocService = (IocServiceInf) context.getBean("iocService");	//spring bean을 정의할 때 입력한 id
		
		//스프링 빈을 사용
		String msg = iocService.hello();
		
		/***Then***/
		assertEquals("sayHello", msg);
	}
	
	//setter를 통한 스프링 빈 인젝션 테스트
	@Test
	public void setterDITest() {
		/***Given***/

		/***When***/
		//빈 구성 설정파일(복수개 가능)
		//setter를 사용하여 생성한 스프링 빈을 DL
		IocServiceInf iocService = (IocServiceInf) context.getBean("iocSetterService");
		
		String msg = iocService.hello();
		
		/***Then***/
		//DL을 통해 얻은 스프링 bean의 hello 메서드 호출 결과 비교
		assertEquals("sayHello", msg);
	}
	
	
	//spring bean singleton scope test
	@Test
	public void singletonTest() {
		//디자인 패턴의 싱글턴 : jvm안에서 해당 클래스의 객체를 하나만 생성
		/***Given***/
		//스프링 컨테이너 생성 --> setup에서 이미 생성됨

		/***When***/
		//spring bean iocDao, iocDao2 ==> IocDao의 객체
		//만약 디자인 패턴의 싱글턴이 적용된다면
		//IocDao 클래스의 객체인 iocDao, iocDao2는 같은 주소값을 가져야한다.
		IocDaoInf iocDao = (IocDaoInf) context.getBean("iocDao");
		IocDaoInf iocDao2 = (IocDaoInf) context.getBean("iocDao2");
		
		/***Then***/
		//객체 주소 비교
		assertNotEquals(iocDao, iocDao2);
	}
	
	
	//spring prototype bean scope test
	@Test
	public void prototypeTest(){
		/***Given***/
		//스프링 컨테이너(ioc 컨테이너) 생성

		/***When***/
		//prototype scope를 갖는 빈을 서로 다른 객체로 받는다
		//(id = iocPrototypeDao)
		//IocDaoInf iocDao1 = //dl(iocPrototypeDao)
		//IocDaoInf iocDao2 = //dl(iocPrototypeDao)
		IocDaoInf iocDao = (IocDaoInf) context.getBean("iocPrototypeDao");
		IocDaoInf iocDao2 = (IocDaoInf) context.getBean("iocPrototypeDao");
		
		/***Then***/
		//iocDao1, iocDao2 다르면 정상
		//(프로토타입의 경우 dl을 할 때 마다 새로운 객체를 리턴하기 때문에)
		assertEquals(iocDao, iocDao2);
	}
	
	
	//singleton 스프링 빈에 prototype 스프링 빈을 주입한 경우
	//prototype 정의에 따라 getter를 통해 리턴되는 빈이 매번 달라지는지 확인
	@Test
	public void singletonDIprototypeTest(){
		/***Given***/
		//스프링 컨테이너 생성

		/***When***/
		//IocService iocService = IocSingletonService(singleton scope) DL
		//IocDaoInf iocDao1 = iocService.getIocDao()  //prototype scope
		//IocDaoInf iocDao2 = iocService.getIocDao()  //prototype scope
		
		IocServiceInf iocService = (IocServiceInf) context.getBean("iocSingletonService");
		IocDaoInf iocDao1 = iocService.getIocDao();
		IocDaoInf iocDao2 = iocService.getIocDao();

		/***Then***/
		//prototype 정의에 따라 iocDao1, iocDao2는 달라야 한다
		assertEquals(iocDao1, iocDao2);

	}
	
	
	
	

}
