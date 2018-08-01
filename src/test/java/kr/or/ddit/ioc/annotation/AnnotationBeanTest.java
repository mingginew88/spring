package kr.or.ddit.ioc.annotation;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanTest {
	
	private ApplicationContext context;
	
	//spring container 생성 (application-annotation.xml)
	@Before
	public void setup(){
		context = new ClassPathXmlApplicationContext("kr/or/ddit/ioc/application-annotation.xml");
	}
	
	
	@Test
	public void annotationTest() {
		/***Given***/
		//spring container 생성

		/***When***/
		//annotationBean DL
		AnnotationBean annotationBean =  (AnnotationBean) context.getBean("annotationBean");

		/***Then***/
		//name 속성 비교
		assertEquals("brown", annotationBean.getName());

	}

}
