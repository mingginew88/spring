package kr.or.ddit.ioc.collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CollectionBeanTest {
	
	private ApplicationContext context;
	
	//before annotation을 통해 스프링 ioc 컨테이너 생성
	@Before
	public void setup(){
		context = new ClassPathXmlApplicationContext("classpath:kr/or/ddit/ioc/application-collection.xml");
	}
	
	//spring container 정상 생성 확인
	@Test
	public void springContainerTest(){
		/***Given***/

		/***When***/

		/***Then***/
		assertNotNull(context);
		assertTrue(context.getBeanDefinitionCount() >= 1);
	}
	
	
	@Test
	public void listTest() {
		/***Given***/
		//spring ioc 컨테이너 생성(before)

		/***When***/
		//List객체 getter를 통해 list객체 받기
		CollectionBean collectionBean = (CollectionBean) context.getBean("collectionBean");
//		CollectionBean collectionBean = context.getBean("collectionBean", CollectionBean.class);  //이 방법도 가능
		List list = collectionBean.getLists();
		
		/***Then***/
		//List.get(0) == brown /List.get(1) == cony / List.get(2) == sally
		assertEquals("brown", list.get(0));
		assertEquals("cony", list.get(1));
		assertEquals("sally", list.get(2));
	}
	
	
	@Test
	public void setsTest(){
		/***Given***/

		/***When***/
		CollectionBean collectionBean = (CollectionBean) context.getBean("collectionBean");
		Set sets = collectionBean.getSets();
			
		/***Then***/
		assertTrue(sets.contains("cony"));
		assertTrue(sets.contains("brown"));
		assertTrue(sets.contains("sally"));
	}
	
	@Test
	public void mapsTest(){
		/***Given***/

		/***When***/
		CollectionBean collectionBean = (CollectionBean) context.getBean("collectionBean");
		Map maps = collectionBean.getMap();
		
		/***Then***/
		assertEquals("sally", maps.get("ranger1"));
		assertEquals("brown", maps.get("ranger2"));
		assertEquals("cony", maps.get("ranger3"));
	}
	
	//properties 주입 테스트
	@Test
	public void prosTest(){
		/***Given***/
		//spring container 생성 테스트
		/***When***/
		//CollectionBean DL
		//collectionBean의 pros속성 확인
		CollectionBean collectionBean = (CollectionBean) context.getBean("collectionBean");
		Properties pros = collectionBean.getPros();
		
		/***Then***/
		//pros의 값 확인
		assertEquals("brown", pros.get("ranger1"));
		assertEquals("cony", pros.get("ranger2"));
		assertEquals("sally", pros.get("ranger3"));
	}
	
	
	
	
	
	
	
	

}
