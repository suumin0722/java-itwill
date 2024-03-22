package xyz.itwill06.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmailSendApp {
	public static void main(String[] args) throws Exception {
		ApplicationContext context=new ClassPathXmlApplicationContext("06-4_email.xml");
		EmailSendBean bean=context.getBean("emailSendBean", EmailSendBean.class);
		System.out.println("==============================================================");
		bean.sendEmail("suumin0722@naver.com", "���� ���� �׽�Ʈ"
				,"<h1>JavaMail ����� ����Ͽ� ���޵� �̸����Դϴ�.</h1>");
		System.out.println("==============================================================");
		((ClassPathXmlApplicationContext)context).close();			
	}
}