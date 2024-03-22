package xyz.itwill04.bean;

import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanNameAware;

//Spring Bean���� ��ϵ� Ŭ������ �پ��� �������̽��� ��ӹ޾� �߻�޼ҵ带 �������̵� ���� ����
// => �������̵� ����� �޼ҵ�� ��ü ���� �� �Ǵ� �Ҹ� �� �ڵ� ȣ��Ǿ� �ʱ�ȭ �� ������ �۾� ���� 
public class InitDestroyMethodBean implements BeanNameAware, BeanClassLoaderAware {
	public InitDestroyMethodBean() {
		System.out.println("### InitDestroyMethodBean Ŭ������ �⺻ ������ ȣ�� ###");
	}
	
	public void init() {
		System.out.println("*** InitDestroyMethodBean Ŭ������ init() �޼ҵ� ȣ�� ***");
	}
	
	public void destroy() {
		System.out.println("*** InitDestroyMethodBean Ŭ������ destroy() �޼ҵ� ȣ�� ***");
	}
	
	public void display() {
		System.out.println("*** InitDestroyMethodBean Ŭ������ display() �޼ҵ� ȣ�� ***");
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("*** InitDestroyMethodBean Ŭ������ setBeanName() �޼ҵ� ȣ�� ***");
	}

	@Override
	public void setBeanClassLoader(ClassLoader classLoader) {
		System.out.println("*** InitDestroyMethodBean Ŭ������ setBeanClassLoader() �޼ҵ� ȣ�� ***");
	}
}