package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.Matches;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@WebMvcTest(DemoController.class)
public class DemoApplicationTests {

	@Autowired
	private MockMvc mockMVC;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testIndex()throws Exception{
//		mockMVC.perform(MockMvcRequestBuilders.get("/")).andExpect(MockMvcResultMatchers.status().isOk());
		/*mockMVC.perform(get("/"))
				.andExpect(MockMvcResultMatchers.status().isOk());*/
//				.andExpect(MockMvcResultMatchers.model());
		/*mockMVC.perform(MockMvcRequestBuilders.post("/sayHello").param("email","nie.luyuan@gmail.com"))
		.andExpect(MockMvcResultMatchers.status().isOk());*/
		this.mockMVC.perform(get("/")).andDo(print()).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().string(containsString("luyuan")));
	}
}
