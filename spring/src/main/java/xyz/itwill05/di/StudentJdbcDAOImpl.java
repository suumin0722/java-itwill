package xyz.itwill05.di;

import java.util.List;

//DAO Ŭ���� : �����ü(File, DBMS ��)�� �࿡ ���� ����,����,����,�˻� ����� �����ϴ� Ŭ����
// => �����ü�� ���� �Ǵ� ����� ���� DAO Ŭ���� ��ü ����
// => DAO Ŭ������ ��ü�ŵ� DAO Ŭ������ ����ϴ� Ŭ����(Service Ŭ����)�� ������ �ּ�ȭ�ϱ�
//���� �ݵ�� �������̽��� ��ӹ޾� �ۼ� - ���յ��� ���� ���������� ȿ���� ����
public class StudentJdbcDAOImpl implements StudentDAO {
	public StudentJdbcDAOImpl() {
		System.out.println("### StudentJdbcDAOImpl Ŭ������ �⺻ ������ ȣ�� ###");
	}
	
	@Override
	public int insertStudent(Student student) {
		System.out.println("*** StudentJdbcDAOImpl Ŭ������ insertStudent(Student student) �޼ҵ� ȣ�� ***");
		return 0;
	}

	@Override
	public int updateStudent(Student student) {
		System.out.println("*** StudentJdbcDAOImpl Ŭ������ updateStudent(Student student) �޼ҵ� ȣ�� ***");
		return 0;
	}

	@Override
	public int deleteStudent(int num) {
		System.out.println("*** StudentJdbcDAOImpl Ŭ������ deleteStudent(int num) �޼ҵ� ȣ�� ***");
		return 0;
	}

	@Override
	public Student selectStudent(int num) {
		System.out.println("*** StudentJdbcDAOImpl Ŭ������ selectStudent(int num) �޼ҵ� ȣ�� ***");
		return null;
	}

	@Override
	public List<Student> selectStudentList() {
		System.out.println("*** StudentJdbcDAOImpl Ŭ������ selectStudentList() �޼ҵ� ȣ�� ***");
		return null;
	}
}