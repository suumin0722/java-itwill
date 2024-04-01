package xyz.itwill.spring;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
//[*] ���Ϲ��ڸ� ����Ͽ� Spring Bean Configuration File ���� ����
// => [**] �������� 0�� �̻��� ���� ������ ǥ��
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@Slf4j
public class StudentControllerTest {
	//WebApplicationContext ��ü(������ �����̳�)�� �����޾� �ʵ忡 ����ǵ��� ������ ����
	@Autowired
	private WebApplicationContext context;

	//MockMvc ��ü�� �����ϱ� ���� �ʵ� �ۼ�
	// => MockMvc ��ü : ��û�� ������ �������� �����ϱ� ���� ��ü - Front Controller�� ��� ����
	private MockMvc mvc;
	
	//@Before : �׽�Ʈ �޼ҵ� ȣ�� ���� ����ǵ��� ȣ��� �޼ҵ忡 �����ϴ� ������̼� - �ʱ�ȭ �۾� 
	@Before 
	public void setup() {
		//MockMvcBuilders.webAppContextSetup(WebApplicationContext context)
		// => MockMvcBuilder ��ü�� �����Ͽ� ��ȯ�ϱ� ���� �޼ҵ�
		//MockMvcBuilder.build() : MockMvc ��ü�� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
		mvc=MockMvcBuilders.webAppContextSetup(context).build();
		log.info("MockMvc ��ü ����");
	}
	
	@Test
	public void testStudentDisplay() throws Exception {
		//MockMvcRequestBuilders.get(String url) : ��û URL �ּҸ� �Ű������� ���޹޾� Front
		//Controller���� GET ������� ��û�ϱ� ���� RequestBuilder ��ü�� ��ȯ�ϴ� ���� �޼ҵ�
		//MockMvc.perform(Builder requestBuilder) : Front Controller���� RequestBuilder ��ü��
		//����� ������ ����Ͽ� �������� ��û�ϴ� �޼ҵ� - ��û ó�� �޼ҵ� ȣ��
		// => ��û ó�� �޼ҵ��� ȣ������ ResultActions ��ü ��ȯ
		//ResultActions.andReturn() : ��û ó�� �޼ҵ��� �������� MvcResult ��ü�� ��ȯ�ϴ� �޼ҵ�
		// => MvcResult ��ü : ��û ó�� �޼ҵ忡 ���� ����� �Ӽ��� �� ���̸��� ����� ��ü
		MvcResult result=mvc.perform(MockMvcRequestBuilders.get("/student/display")).andReturn();
		
		log.info(result.getModelAndView().getViewName());
		log.info(result.getModelAndView().getModel().toString());
	}
}