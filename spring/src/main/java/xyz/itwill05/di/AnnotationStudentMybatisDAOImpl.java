package xyz.itwill05.di;

import java.util.List;

import org.springframework.stereotype.Repository;

//@Component("studentDAO")
//@Component
@Repository
public class AnnotationStudentMybatisDAOImpl implements StudentDAO {
	public AnnotationStudentMybatisDAOImpl() {
		System.out.println("### AnnotationStudentMybatisDAOImpl Ŭ������ �⺻ ������ ȣ�� ###");
	}
	
	@Override
	public int insertStudent(Student student) {
		System.out.println("*** AnnotationStudentMybatisDAOImpl Ŭ������ insertStudent(Student student) �޼ҵ� ȣ�� ***");
		return 0;
	}

	@Override
	public int updateStudent(Student student) {
		System.out.println("*** AnnotationStudentMybatisDAOImpl Ŭ������ updateStudent(Student student) �޼ҵ� ȣ�� ***");
		return 0;
	}

	@Override
	public int deleteStudent(int num) {
		System.out.println("*** AnnotationStudentMybatisDAOImpl Ŭ������ deleteStudent(int num) �޼ҵ� ȣ�� ***");
		return 0;
	}

	@Override
	public Student selectStudent(int num) {
		System.out.println("*** AnnotationStudentMybatisDAOImpl Ŭ������ selectStudent(int num) �޼ҵ� ȣ�� ***");
		return null;
	}

	@Override
	public List<Student> selectStudentList() {
		System.out.println("*** AnnotationStudentMybatisDAOImpl Ŭ������ selectStudentList() �޼ҵ� ȣ�� ***");
		return null;
	}
}