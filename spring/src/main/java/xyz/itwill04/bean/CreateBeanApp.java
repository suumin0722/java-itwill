package xyz.itwill04.bean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

//Spring �����ӿ�ũ������ BeanFactory ��ü �Ǵ� ApplicationContext ��ü�� ������ �����̳�
//(Spring Container) ��� ����
// => ������ �����̳ʴ� ȯ�漳������(Spring Bean Configuration File - XML)�� Ŭ������ �����޾�
//��ü(Spring Bean)�� �����Ͽ� ����
@SuppressWarnings("deprecation")
public class CreateBeanApp {
	public static void main(String[] args) {
		System.out.println("1.BeanFactory ��ü�� �����Ͽ� ������ �����̳ʷ� ����ϴ� ���");
		System.out.println("=============== Spring Container �ʱ�ȭ �� ===============");
		//BeanFactory �������̽��� ��ӹ��� �ڽ�Ŭ������ ��ü ���� - BeanFactory ��ü
		// => BeanFactory ��ü�� ������ �� Spring Bean Configuration File�� �����޾� 
		//������ �����̳� ���� - ������ �����̳� �ʱ�ȭ �۾�
		// => BeanFactory ��ü�� Spring Bean Configuration File�� ��ϵ� Ŭ������ ��ü�� �̸�
		//�������� �ʰ� Spring Bean ������ ��û�� ��� ����
		BeanFactory factory=new XmlBeanFactory
				(new FileSystemResource("src/main/resources/04-1_beanCreate.xml"));
		System.out.println("=============== Spring Container �ʱ�ȭ �� ===============");
		//BeanFactory.getBean(String beanName) : �Ű������� Spring Bean�� �����ϱ� ���� �ĺ���
		//(BeanName)�� ���޹޾� ������ �����̳ʷκ��� ��ü(Spring Bean)�� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
		// => Object Ÿ���� ��ü�� ��ȯ�ϹǷ� �ݵ�� ����� ��ü ����ȯ ���
		// => �Ű������� ���޹��� �ĺ���(BeanName)�� Spring Bean�� ���� ��� NoSuchBeanDefinitionException �߻�
		CreateBean bean1=(CreateBean)factory.getBean("createBean");
		bean1.display();
		System.out.println("==========================================================");
		System.out.println("2.ApplicationContext ��ü�� �����Ͽ� ������ �����̳ʷ� ����ϴ� ���");
		System.out.println("=============== Spring Container �ʱ�ȭ �� ===============");
		//ApplicationContext �������̽��� ��ӹ��� �ڽ�Ŭ������ ��ü ���� - ApplicationContext ��ü
		// => ApplicationContext ��ü�� ������ �� Spring Bean Configuration File�� �����޾� 
		//������ �����̳� ���� - ������ �����̳� �ʱ�ȭ �۾�
		// => Ŭ������ ���� ������ ����(ClassPath)�� �ۼ��� Spring Bean Configuration File�� �����޾� ���
		// => ApplicationContext ��ü�� Spring Bean Configuration File�� ��ϵ� Ŭ������ ��ü�� �̸� ����
		ApplicationContext context=new ClassPathXmlApplicationContext("04-1_beanCreate.xml");
		System.out.println("=============== Spring Container �ʱ�ȭ �� ===============");
		//ApplicationContext.getBean(String beanName) : �Ű������� Spring Bean�� �����ϱ� ���� �ĺ���
		//(BeanName)�� ���޹޾� ������ �����̳ʷκ��� ��ü(Spring Bean)�� ��ȯ�ϴ� �޼ҵ�
		// => Object Ÿ���� ��ü�� ��ȯ�ϹǷ� �ݵ�� ����� ��ü ����ȯ ���
		// => �Ű������� ���޹��� �ĺ���(BeanName)�� Spring Bean�� ���� ��� NoSuchBeanDefinitionException �߻�
		//DL(Dependency Lookup) : ������ �����̳ʰ� �����ϴ� Spring Bean�� �˻��Ͽ� �����ϴ� ���
		CreateBean bean2=(CreateBean)context.getBean("createBean");
		bean2.display();
		
		//ClassPathXmlApplicationContext.close() : ApplicationContext ��ü�� �����ϴ� �޼ҵ�
		// => ������ �����̳� �Ҹ��� ������ �����̳ʿ� ���� �����Ǵ� ��� ��ü(Spring Bean)�� �ڵ� �Ҹ�
		((ClassPathXmlApplicationContext)context).close();
		System.out.println("==========================================================");
	}
}