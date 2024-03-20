package xyz.itwill07.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//DataSource ��ü : �ټ��� Connection ��ü�� �̸� �����Ͽ� ������ ��ü - DBCP(DataBase Connection Pool)
// => Spring Bean Configuration File���� DataSource �������̽��� ��ӹ��� �ڽ�Ŭ������
//Spring Bean���� ����Ͽ� �ʿ�� ������ �����̳ʿ��� �����޾� ���
//DataSource �������̽��� ��ӹ��� �ڽ�Ŭ������ spring-jdbc ���̺귯���� ���� ó���ϸ� ��� ���� - ���̺� ��� : pom.xml
// => DataSource ���� ���̺귯���ܿ� Driver ���� ���̺귯��(ojdbc ���̺귯��)�� ������Ʈ�� ���� ó��

//������ �����̳ʷκ��� DataSource ��ü�� �����޾� DataSource ��ü�� ����� Connection ��ü�� ����ϴ� ���α׷� 
public class DataSourceApp {
	public static void main(String[] args) throws SQLException {
		ApplicationContext context=new ClassPathXmlApplicationContext("07_dao.xml");
		System.out.println("==============================================================");
		DataSource dataSource=context.getBean("dataSource", DataSource.class);
		System.out.println("dataSource = "+dataSource);
		Connection connection=dataSource.getConnection();
		System.out.println("connection = "+connection);
		connection.close();
		System.out.println("==============================================================");
		((ClassPathXmlApplicationContext)context).close();	
	}
}








