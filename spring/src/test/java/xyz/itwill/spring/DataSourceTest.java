package xyz.itwill.spring;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import lombok.extern.slf4j.Slf4j;

//SpringTest ����� ����Ͽ� ���(���� ���α׷� - ���۳�Ʈ)�� �˻��ϴ� �׽�Ʈ ���α׷� �ۼ��ϴ� ���
// => SpringMVC ���α׷����� ����ϴ� ��� : DAO Ŭ����, Service Ŭ����, Controller Ŭ���� ��
//1.junit ���̺귯���� spring-test ���̺귯���� ������Ʈ�� ���� ó�� - ���̺� : pom.xml
//2.�׽�Ʈ ���α׷����� ���� �α� ����ü�� ���� ȯ�漳������ ����
// => [src/test/resources] ��Ű�� ������ [log4j.xml] ������ ���� ����
//3.[src/test/java] ��Ű�� ������ ��Ű���� �׽�Ʈ Ŭ����(�׽�Ʈ ���α׷�) �ۼ�
// => junit ���̺귯���� spring-test ���̺귯���� scope �Ӽ��� �ּ� ó�� �� �׽�Ʈ Ŭ������ 
//�ۼ��Ͽ� �����ϰ� �׽�Ʈ ���� �� scope �Ӽ��� ������ �ּ� ����
//4.JUnit ���α׷��� ����Ͽ� �׽�Ʈ ���α׷� ���� - �׽�Ʈ Ŭ������ �׽�Ʈ �޼ҵ� �ڵ� ȣ�� 

//@RunWith : �׽�Ʈ Ŭ������ �����ϱ� ���� ���� Ŭ������ �����ϱ� ���� ������̼�
// => �׽�Ʈ Ŭ������ ��ü�� �����Ͽ� �׽�Ʈ �޼ҵ带 ȣ���Ͽ� �׽�Ʈ ��� ����
//value �Ӽ� : �׽�Ʈ Ŭ������ �����ϱ� ���� Ŭ����(Class ��ü)�� �Ӽ������� ����
// => value �Ӽ��ܿ� �ٸ� �Ӽ��� ���� ��� �Ӽ����� ���� ����
//SpringJUnit4ClassRunner Ŭ������ ����Ͽ� �׽�Ʈ Ŭ������ ������ �����̳�(ApplicationContext ��ü)�� �����Ͽ� ����
// => ������ �����̳ʴ� �׽�Ʈ Ŭ�������� ���� ��ü�� Spring Bean���� ����
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration : ������ �����̳��� ȯ�漳������(Spring Bean Configuration File)�� 
//�����ϱ� ���� ������̼�
//locations �Ӽ� : Spring Bean Configuration File�� ��θ� ��ҷ� ������ �迭�� �Ӽ������� ����
// => Spring Bean Configuration File�� ��δ� file ���λ縦 ����� ���� �ý��� ��η� ǥ���Ͽ� ����
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
//@WebAppConfiguration : SpringJUnit4ClassRunner Ŭ�������� ������ ������ �����̳ʸ�
//ApplicationContext ��ü�� �ƴ� WebApplicationContext ��ü�� �����ϱ� ���� ������̼�
@WebAppConfiguration
@Slf4j
public class DataSourceTest {
	//�׽�Ʈ Ŭ������ �޼ҵ忡�� ���� ��ü�� �����ϱ� ���� �ʵ� �ۼ�
	// => @Autowired ������̼��� ����Ͽ� �ʵ忡 ��ü(Spring Bean)�� ����ǵ��� ������ ����
	// => �ʵ� ������ ������ ���Ը� ���� - ������ ������ ������ ���Խ� ���� �߻� 
	@Autowired
	private DataSource dataSource;

	//@Test : �׽�Ʈ �޼ҵ�� �����ϱ� ���� ������̼� - ��� �׽�Ʈ ��� �ۼ�
	// => SpringJUnit4ClassRunner Ŭ������ ���� �׽�Ʈ Ŭ������ ��ü�� ������ �� ��ü�� �ڵ� ȣ��
	@Test
	public void testDataSource() throws SQLException {
		log.info("DataSource = "+dataSource);
		Connection connection=dataSource.getConnection();
		log.info("Connection = "+connection);
		connection.close();
	}
}