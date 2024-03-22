package xyz.itwill03.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessagePrintApp {
	public static void main(String[] args) {
		/*
		HelloMessageObject object=new HelloMessageObject();
		MessagePrintObject print=new MessagePrintObject();
		//�Ű������� ��ü�� �����Ͽ� �ʵ忡 ���� - ���԰��� �ϼ�
		print.setObject(object);
		print.messagePrint();
		*/
		
		//ApplicationContext ��ü : ������ �����̳�(Spring Container) ����� �����ϱ� ���� ��ü
		// => Spring Bean Configuration File(XML)�� �����޾� ��ü(Spring Bean)�� �����Ͽ� ����	
		ApplicationContext context=new ClassPathXmlApplicationContext("03_message.xml");
		
		//������ �����̳ʿ��� �ʿ��� ��ü(Spring Bean)�� �����޾� ����
		MessagePrintObject print=(MessagePrintObject)context.getBean("messagePrintObject");
		
		print.messagePrint();
		
		//ApplicationContext ��ü ���� - ������ �����̳� �Ҹ�
		// => ������ �����̳ʰ� �����ϴ� ��� ��ü(Spring Bean) �Ҹ�
		((ClassPathXmlApplicationContext)context).close();
	}
}