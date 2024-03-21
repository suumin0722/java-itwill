package xyz.itwill05.di;

import java.util.List;
 
public class StudentServiceImpl implements StudentService {
	//StudentJdbcDAOImpl Ŭ������ �ʵ� �ۼ� - StudentJdbcDAOImpl ��ü�� ���� ������ �ʵ�
	// => StudentJdbcDAOImpl ��ü�� �ʵ忡 �����ؾ߸� �������� �ϼ�
	// => StudentServiceImpl Ŭ������ �޼ҵ忡�� �ʵ忡 ����� StudentJdbcDAOImpl ��ü�� �޼ҵ� ȣ��
	//������)DAO Ŭ������ ��ü�� ��� Service Ŭ������ �ʵ� �Ǵ� �޼ҵ带 ���ۼ� �ʿ�
	// => ���յ��� ���� ���������� ȿ���� ����
	//private StudentJdbcDAOImpl studentJdbcDAOImpl;
	
	//StudentDAO �������̽��� �ʵ� �ۼ� - StudentDAO �������̽��� ��ӹ��� �ڽ�Ŭ������ ������
	//��� ��ü ����
	// => StudentDAO �������̽��� ��ӹ��� �ڽ�Ŭ������ ��ü�� �ʵ忡 �����ؾ߸� �������� �ϼ�
	// => StudentDAO �������̽��� �ʵ�� �߻�޼ҵ带 ȣ���ϸ� ������ ��ü ����ȯ�Ǿ� �ʵ忡  
	//����� �ڽ� ��ü�� �������̵� �޼ҵ尡 ȣ�� - �������̵忡 ���� ������
	// => DAO Ŭ������ ��ü�ŵ� Service Ŭ������ ���� �ּ�ȭ - ���յ��� ���� ���������� ȿ���� ����
	private StudentDAO studentDAO;

	public StudentServiceImpl() {
		System.out.println("### StudentServiceImpl Ŭ������ �⺻ ������ ȣ�� ###");
	}
	
	public StudentServiceImpl(StudentDAO studentDAO) {
		super();
		this.studentDAO = studentDAO;
		System.out.println("### StudentServiceImpl Ŭ������ �Ű������� �ۼ��� ������ ȣ�� ###");
	}

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
		System.out.println("*** StudentServiceImpl Ŭ������ setStudentDAO(StudentDAO studentDAO) �޼ҵ� ȣ�� ***");
	}

	@Override
	public void addStudent(Student student) {
		System.out.println("*** StudentServiceImpl Ŭ������ addStudent(Student student) �޼ҵ� ȣ�� ***");
		studentDAO.insertStudent(student);
	}

	@Override
	public void modifyStudent(Student student) {
		System.out.println("*** StudentServiceImpl Ŭ������ modifyStudent(Student student) �޼ҵ� ȣ�� ***");
		studentDAO.updateStudent(student);
	}

	@Override
	public void removeStudent(int num) {
		System.out.println("*** StudentServiceImpl Ŭ������ removeStudent(int num) �޼ҵ� ȣ�� ***");
		studentDAO.deleteStudent(num);
	}

	@Override
	public Student getStudent(int num) {
		System.out.println("*** StudentServiceImpl Ŭ������ getStudent(int num) �޼ҵ� ȣ�� ***");
		return studentDAO.selectStudent(num);
	}

	@Override
	public List<Student> getStudentList() {
		System.out.println("*** StudentServiceImpl Ŭ������ getStudentList() �޼ҵ� ȣ�� ***");
		return studentDAO.selectStudentList();
	}
}