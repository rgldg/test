package com.example.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloWorldControlerTests {
	private MockMvc mvc;
	@Before
	public void setUp() throws Exception{
		mvc = MockMvcBuilders.standaloneSetup(new 
		HelloWorldControlerTests()).build();
				
	}
	@Test
	public void getHello() throws Exception{
		mvc.perform(MockMvcRequestBuilders.get("/hello")
		.accept(org.springframework.http.MediaType
		.APPLICATION_JSON)).andExpect(MockMvcResultMatchers
		.status().isOk()).andDo(MockMvcResultHandlers.print())
		.andReturn();
	}
}
