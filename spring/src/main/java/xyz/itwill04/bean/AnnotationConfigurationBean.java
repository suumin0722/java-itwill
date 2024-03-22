package xyz.itwill04.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration : ������ �����̳ʿ� ���� ������ ��ü�� �����ϴ� ����� ȯ�漳�� ���� Ŭ������ 
//����ϱ� ���� ������̼�
//=> Ŭ������ Spring Bean Configuration File�� ������ ����� �����ϵ��� �����ϴ� ������̼�
@Configuration
public class AnnotationConfigurationBean {
	//@Bean : Ŭ������ ��ü�� �����Ͽ� ��ȯ�ϴ� �޼ҵ忡 �����ϴ� ������̼�
		// => @Bean ������̼��� ����� �޼ҵ尡 ��ȯ�� ��ü(Spring Bean)�� ������ �����̳ʿ� ���� ����
		// => Spring Bean Configuration File�� bean ������Ʈ�� ������ ����� �����ϴ� ������̼�
		// => �޼ҵ��� �̸��� Spring Bean�� �ĺ���(BeanName)�� ���
		// => @Bean ������̼��� name �Ӽ��� �̿��Ͽ� �ĺ���(BeanName) ���� ����
	@Bean
	public AnnotationBean annotationBean() {
		return new AnnotationBean();
	}
}


