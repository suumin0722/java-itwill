package xyz.itwill05.di;

import java.util.List;

public class StudentMybatisDAOImpl implements StudentDAO {
	public StudentMybatisDAOImpl() {
		System.out.println("### StudentMybatisDAOImpl Ŭ������ �⺻ ������ ȣ�� ###");
	}
	
	@Override
	public int insertStudent(Student student) {
		System.out.println("*** StudentMybatisDAOImpl Ŭ������ insertStudent(Student student) �޼ҵ� ȣ�� ***");
		return 0;
	}

	@Override
	public int updateStudent(Student student) {
		System.out.println("*** StudentMybatisDAOImpl Ŭ������ updateStudent(Student student) �޼ҵ� ȣ�� ***");
		return 0;
	}

	@Override
	public int deleteStudent(int num) {
		System.out.println("*** StudentMybatisDAOImpl Ŭ������ deleteStudent(int num) �޼ҵ� ȣ�� ***");
		return 0;
	}

	@Override
	public Student selectStudent(int num) {
		System.out.println("*** StudentMybatisDAOImpl Ŭ������ selectStudent(int num) �޼ҵ� ȣ�� ***");
		return null;
	}

	@Override
	public List<Student> selectStudentList() {
		System.out.println("*** StudentMybatisDAOImpl Ŭ������ selectStudentList() �޼ҵ� ȣ�� ***");
		return null;
	}
}