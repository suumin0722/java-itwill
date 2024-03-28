package xyz.itwill09.dao;

import java.util.List;

import xyz.itwill09.dto.Student;

//DAO Ŭ����(=Repository Class, �����) : �����ü(DBMS)�� �࿡ ���� ����, ����, ����, �˻� ����� �����ϱ� ���� Ŭ����
// => DAO Ŭ������ �޼ҵ�� DBMS ������ �����Ͽ� �ϳ��� SQL ����� �����Ͽ� �����ϰ� ��������
//Java ��ü(��)�� ��ȯ�ǵ��� �ۼ� - JDBC 
// => DAO Ŭ������ ��ü�Ǿ ��������� ������ Service Ŭ������ ������ �ּ�ȭ�ϱ� ���� �������̽��� ��ӹ޾� �ۼ��ϴ� ���� ����

//SpringMVC �����ӿ�ũ�� �����α׷� �ۼ� �� Mybatis �����ӿ�ũ�� ����Ͽ� DAO Ŭ������ �ۼ��ϴ� ���
//1.DataSource ���� ���̺귯���� Mybatis ���� ���̺귯���� ������Ʈ�� ���� ó�� - ���̺� : pom.xml
// => ojdbc, spring-jdbc(spring-tx), mybatis, mybatis-spirng
//2.Mybatis �����ӿ�ũ�� ȯ�漳������(mybatis-config.xml - settings ������Ʈ)�� �ۼ�
//3.DataSource ���� Ŭ����, SqlSessionFactory ���� Ŭ����, SqlSession ���� Ŭ������ Spring Bean���� ���
// => SpringMVC �����ӿ�ũ���� ������ �����̳ʸ� �ʱ�ȭ ó���ϱ� ���� Spring Bean Configuration File����
//bean ������Ʈ�� Ŭ������ Spring Bean���� ��� - root-context.xml �Ǵ� servlet-context.xml
public class StudentDAOImpl implements StudentDAO {

	@Override
	public int insertStudent(Student student) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Student> selectStudentList() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
