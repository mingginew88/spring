package kr.or.ddit.ioc.javaconfig;

import static org.junit.Assert.assertEquals;
import kr.or.ddit.ioc.dao.IocDao;
import kr.or.ddit.ioc.dao.IocDaoInf;
import kr.or.ddit.ioc.service.IocService;
import kr.or.ddit.ioc.service.IocServiceInf;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={})
public class JavaConfigTestBackup {
	
	private ApplicationContext context;

	@Before
	public void setup() {
		context = new AnnotationConfigApplicationContext(JavaConfig.class);
	}
	
	@Test
	public void test() {
		/***Given***/

		/***When***/
		IocDaoInf iocDao = context.getBean("iocDao", IocDao.class);
		IocServiceInf iocService = context.getBean("iocService", IocService.class);

		/***Then***/
		assertEquals(iocDao, iocService.getIocDao());
		assertEquals("sayHello", iocService.hello());
	}

}
