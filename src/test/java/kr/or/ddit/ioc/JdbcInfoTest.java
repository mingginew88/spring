package kr.or.ddit.ioc;

import static org.junit.Assert.assertEquals;

import kr.or.ddit.ioc.placeholder.JdbcInfo;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcInfoTest {
	
	private ApplicationContext context;
	
	@Before
	public void setup() {
		context = new ClassPathXmlApplicationContext("kr/or/ddit/ioc/application-placeholder.xml");
	}

	@Test
	public void jdbcTest() {
		/***Given***/

		/***When***/
		JdbcInfo jdbcInfo = (JdbcInfo) context.getBean("jdbcInfo");
		
		/***Then***/
		assertEquals("jdbc:oracle:thin:@127.0.0.1:xe", jdbcInfo.getUrl());
		assertEquals("oracle.jdbc.driver.OracleDriver", jdbcInfo.getDriver());
		assertEquals("pc17", jdbcInfo.getUsername());
		assertEquals("java", jdbcInfo.getPassword());

	}

}
