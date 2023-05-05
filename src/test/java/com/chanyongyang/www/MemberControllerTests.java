package com.chanyongyang.www;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@WebAppConfiguration
@Log4j
public class MemberControllerTests {
	@Autowired
	private WebApplicationContext context;

	private MockMvc mockMvc;
	
	@Before
	public void init() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void testExist() {
		log.info(context);
		log.info(mockMvc);
	}
		
	@Test
	public void testLogin() throws Exception{
		RequestBuilder builder = MockMvcRequestBuilders
				.post("/member/login")
				.param("id", "id1111")
				.param("pw", "1234");
		String result = mockMvc.perform(builder).andReturn().getModelAndView().getViewName();
		
		log.info(result);
	}
	
	@Test
	public void testGet() throws Exception {
		RequestBuilder builder = MockMvcRequestBuilders
				.get("/member/get")
				.param("id", "id1111");
		ModelMap map = mockMvc.perform(builder).andReturn().getModelAndView().getModelMap();

		log.info(map.get("member"));
	}
}
