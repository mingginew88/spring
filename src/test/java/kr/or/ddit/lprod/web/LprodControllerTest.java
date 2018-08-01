package kr.or.ddit.lprod.web;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.List;

import kr.or.ddit.lprod.model.LprodVo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:kr/or/ddit/config/spring/root-context.xml",
								 "classpath:kr/or/ddit/config/spring/servlet-context.xml"})
@WebAppConfiguration
public class LprodControllerTest {
	
	@Autowired
	private WebApplicationContext context;
	
	private MockMvc mvc;
	
	@Before
	public void setup(){
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void lprodListTest() throws Exception {
		/***Given***/
		MvcResult result = mvc.perform(get("/lprod/list")
									.param("page", "1")
									.param("pageSize", "5")).andReturn();

		/***When***/
		ModelAndView mav = result.getModelAndView();
		
		/***Then***/
		assertEquals("lprod/list", mav.getViewName());
		assertTrue((Integer)mav.getModel().get("totLprod") > 3);
		List<LprodVo> lprodList = (List<LprodVo>) mav.getModel().get("pageList");
		assertEquals(5, lprodList.size());
	}
	

}
