package com.example.demo;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

// RunWith是一个运行器
// SpringRunner.class表示使用 Spring Test 进行单元测试
// 其中 SpringRunner 继承类 SpringJUnit4ClassRunner
@RunWith(SpringRunner.class)
@SpringBootTest	// 启动整个spring boot工程
@WebAppConfiguration	// Web项目，Junit需要模拟ServletContext
// 进行接口API测试，通过代码实现模拟http请求
@AutoConfigureMockMvc
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Before
	public void init() {
		System.out.println("开始测试-----------------");
	}

	@After
	public void after() {
		System.out.println("测试结束-----------------");
	}

	@Autowired
	private MVCController mvcController;

	@Test
	// 针对业务层测试
	public void findUser() {
		User user = (User) mvcController.getUser();
		System.out.println(user.getName());
		Assert.assertEquals("melody", user.getName());
	}

	@Autowired
	private MockMvc mockMvc;

	@Test
	// 针对接口测试
	public void readingListTest() throws  Exception {
		String url = "/readingList";

		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(url))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andReturn();
		MockHttpServletResponse response = mvcResult.getResponse();

		System.out.println(response.getStatus());
		System.out.println(response.getContentAsString());
	}

}
