package xyz.itwill09.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import xyz.itwill09.dto.Student;
import xyz.itwill09.mapper.StudentMapper;

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
//4.���̺� ���� >> DTO Ŭ���� �ۼ� >> ���� ���� �ۼ� >> DAO Ŭ���� �ۼ�

//DAO Ŭ������ Service Ŭ�������� ��ü�� �����޾� ����� �� �ֵ��� Spring Bean���� ���
// => DAO Ŭ������ @Repository ������̼��� ����Ͽ� Spring Bean���� ��� ó��
// => @Repository ������̼��� ������ �����̳ʰ� ó���ϱ� ���� �ݵ�� Ŭ������ �ۼ��� ��Ű����
//Spring Bean Configuration File(servlet-context.xmil)�� component-scan ������Ʈ�� �˻��ǵ��� ����
@Repository
@RequiredArgsConstructor
//@RequiredArgsConstructor : final �����ڷ� �ۼ��� �ʵ常 �ʱ�ȭ ó���ϴ� �����ڸ� ������ִ� ������̼�
public class StudentDAOImpl implements StudentDAO {
	//DAO Ŭ������ �޼ҵ忡���� SqlSession ��ü�� ����Ͽ� ���ۿ� ����� SQL ����� �����޾�
	//�����Ͽ� �����ϰ� �������� Java ��ü(��)�� �����ޱ� ���� SqlSession ��ü �ʿ�
	// = > SqlSession ��ü�� ����� �� �ִ� �ʵ带 �ۼ��Ͽ� ������ �����̳ʷκ��� Spring Bean��
	//�����޾� ����ǵ��� ������ ����(DI)
	
	
	//SqlSession ��ü�� ����� �ʵ忡 @Autowired ������̼��� ����� ������ ����
	//@Autowired : �ʵ巹�� ������ ���� => �̰Ÿ��� ������ ������ ����(@RequiredArgsConstructor)��
	//�Ű������� �ۼ��� �����ڿ� @Autowired ������̼��� ����� ������ ���� - ��ȯ���� ����
	//@Autowired
	//private final SqlSession sqlSession;
	
	//=> �����ڰ� �ϳ��� �ۼ��� ��� @Autowired ������̼� ���� ����
	private final SqlSession sqlSession;
	
	
	@Override
	public int insertStudent(Student student) {
		return sqlSession.getMapper(StudentMapper.class).insertStudent(student);
	}

	@Override
	public List<Student> selectStudentList() {
		return sqlSession.getMapper(StudentMapper.class).selectStudentList();
	}
	
}
