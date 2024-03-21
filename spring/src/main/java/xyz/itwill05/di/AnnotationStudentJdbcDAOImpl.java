package xyz.itwill05.di;

import java.util.List;

import org.springframework.stereotype.Repository;

//@Component : Ŭ������ ������ �����̳ʰ� ������ �� �ִ� Spring Bean���� ����ϱ� ���� ������̼�
// => Ŭ������ �̸��� �ڵ����� beanName���� ���� - Ŭ���� �̸��� ù���ڴ� �ҹ��ڷ� ��ȯ
// => @Component ������̼��� value �Ӽ��� ����Ͽ� beanName ���� ����
//@Component
//@Primary : ������ ������ ���� �켱���� �����ϱ� ���� ������̼�
// => ������ �������̽��� ��ӹ��� Ŭ������ @Primary ������̼��� �ߺ� �����ϸ� ������ ���� ����
//@Primary

//@Repository : DAO Ŭ������ ������ �����̳ʰ� ������ �� �ִ� Spring Bean���� ����ϱ� ���� ������̼�
// => Ŭ������ �̸��� �ڵ����� beanName���� ���������� value �Ӽ��� ����Ͽ� beanName ���� ����
@Repository
public class AnnotationStudentJdbcDAOImpl implements StudentDAO {
	public AnnotationStudentJdbcDAOImpl() {
		System.out.println("### AnnotationStudentJdbcDAOImpl Ŭ������ �⺻ ������ ȣ�� ###");
	}
	
	@Override
	public int insertStudent(Student student) {
		System.out.println("*** AnnotationStudentJdbcDAOImpl Ŭ������ insertStudent(Student student) �޼ҵ� ȣ�� ***");
		return 0;
	}

	@Override
	public int updateStudent(Student student) {
		System.out.println("*** AnnotationStudentJdbcDAOImpl Ŭ������ updateStudent(Student student) �޼ҵ� ȣ�� ***");
		return 0;
	}

	@Override
	public int deleteStudent(int num) {
		System.out.println("*** AnnotationStudentJdbcDAOImpl Ŭ������ deleteStudent(int num) �޼ҵ� ȣ�� ***");
		return 0;
	}

	@Override
	public Student selectStudent(int num) {
		System.out.println("*** AnnotationStudentJdbcDAOImpl Ŭ������ selectStudent(int num) �޼ҵ� ȣ�� ***");
		return null;
	}

	@Override
	public List<Student> selectStudentList() {
		System.out.println("*** AnnotationStudentJdbcDAOImpl Ŭ������ selectStudentList() �޼ҵ� ȣ�� ***");
		return null;
	}
}