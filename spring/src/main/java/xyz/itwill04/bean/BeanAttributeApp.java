package xyz.itwill04.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanAttributeApp {
	public static void main(String[] args) {
		System.out.println("=============== Spring Container �ʱ�ȭ �� ===============");
		ApplicationContext context=new ClassPathXmlApplicationContext("04-2_beanAttribute.xml");
		System.out.println("=============== Spring Container �ʱ�ȭ �� ===============");
		//ApplicationContext.getBean(String beanName) : �Ű������� Spring Bean�� �����ϱ� ���� �ĺ���
		//(BeanName)�� ���޹޾� ������ �����̳ʷκ��� ��ü(Spring Bean)�� ��ȯ�ϴ� �޼ҵ�
		// => Object Ÿ���� ��ü�� ��ȯ�ϹǷ� �ݵ�� ����� ��ü ����ȯ ���
		//InitDestroyMethodBean bean=(InitDestroyMethodBean)context.getBean("initDestroyMethodBean");

		//ApplicationContext.getBean(String beanName, Class<T> clazz) : ������ �����̳ʷκ���
		//�Ű������� BeanName�� Spring Bean�� Class ��ü�� ����ȯ�Ͽ� ��ȯ�ϴ� �޼ҵ�
		InitDestroyMethodBean bean=context.getBean("initDestroyMethodBean", InitDestroyMethodBean.class);
		
		//bean ������Ʈ�� ����Ͽ� ��ü�� ������ �Ŀ� �޼ҵ尡 �ڵ� ȣ��ǵ��� ���� ����
		//bean.init();//��ü�� �ʱ�ȭ ó���� ���� �޼ҵ�
		
		bean.display();
				
		//bean ������Ʈ�� ����Ͽ� ��ü�� �Ҹ�Ǳ� ���� �޼ҵ尡 �ڵ� ȣ��ǵ��� ���� ����
		//bean.destroy();//��ü�� ������ ó���� ���� �޼ҵ�
		System.out.println("==========================================================");
		context.getBean("lazyInitBean", LazyInitBean.class);
		System.out.println("==========================================================");
		ScopeBean bean1=context.getBean("singletonBean", ScopeBean.class);
		ScopeBean bean2=context.getBean("singletonBean", ScopeBean.class);
		ScopeBean bean3=context.getBean("singletonBean", ScopeBean.class);
		System.out.println("bean1 = "+bean1);
		System.out.println("bean2 = "+bean2);
		System.out.println("bean3 = "+bean3);
		System.out.println("==========================================================");
		ScopeBean bean4=context.getBean("prototypeBean", ScopeBean.class);
		ScopeBean bean5=context.getBean("prototypeBean", ScopeBean.class);
		ScopeBean bean6=context.getBean("prototypeBean", ScopeBean.class);
		System.out.println("bean4 = "+bean4);
		System.out.println("bean5 = "+bean5);
		System.out.println("bean6 = "+bean6);
		System.out.println("==========================================================");
		((ClassPathXmlApplicationContext)context).close();
		System.out.println("==========================================================");
	}
}