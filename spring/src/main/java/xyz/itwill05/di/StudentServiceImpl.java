package xyz.itwill05.di;

import java.util.List;
 
public class StudentServiceImpl implements StudentService {
	//StudentJdbcDAOImpl 클래스로 필드 작성 - StudentJdbcDAOImpl 객체만 저장 가능한 필드
	// => StudentJdbcDAOImpl 객체를 필드에 저장해야만 의존관계 완성
	// => StudentServiceImpl 클래스의 메소드에서 필드에 저장된 StudentJdbcDAOImpl 객체로 메소드 호출
	//문제점)DAO 클래스가 교체될 경우 Service 클래스의 필드 또는 메소드를 재작성 필요
	// => 결합도가 높아 유지보수의 효율성 감소
	//private StudentJdbcDAOImpl studentJdbcDAOImpl;
	
	//StudentDAO 인터페이스로 필드 작성 - StudentDAO 인터페이스를 상속받은 자식클래스로 생성된
	//모든 객체 저장
	// => StudentDAO 인터페이스를 상속받은 자식클래스의 객체를 필드에 저장해야만 의존관계 완성
	// => StudentDAO 인터페이스의 필드로 추상메소드를 호출하면 묵시적 객체 형변환되어 필드에  
	//저장된 자식 객체의 오버라이드 메소드가 호출 - 오버라이드에 의한 다형성
	// => DAO 클래스가 교체돼도 Service 클래스에 영향 최소화 - 결합도를 낮춰 유지보수의 효율성 증가
	private StudentDAO studentDAO;

	public StudentServiceImpl() {
		System.out.println("### StudentServiceImpl 클래스의 기본 생성자 호출 ###");
	}
	
	public StudentServiceImpl(StudentDAO studentDAO) {
		super();
		this.studentDAO = studentDAO;
		System.out.println("### StudentServiceImpl 클래스의 매개변수가 작성된 생성자 호출 ###");
	}

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
		System.out.println("*** StudentServiceImpl 클래스의 setStudentDAO(StudentDAO studentDAO) 메소드 호출 ***");
	}

	@Override
	public void addStudent(Student student) {
		System.out.println("*** StudentServiceImpl 클래스의 addStudent(Student student) 메소드 호출 ***");
		studentDAO.insertStudent(student);
	}

	@Override
	public void modifyStudent(Student student) {
		System.out.println("*** StudentServiceImpl 클래스의 modifyStudent(Student student) 메소드 호출 ***");
		studentDAO.updateStudent(student);
	}

	@Override
	public void removeStudent(int num) {
		System.out.println("*** StudentServiceImpl 클래스의 removeStudent(int num) 메소드 호출 ***");
		studentDAO.deleteStudent(num);
	}

	@Override
	public Student getStudent(int num) {
		System.out.println("*** StudentServiceImpl 클래스의 getStudent(int num) 메소드 호출 ***");
		return studentDAO.selectStudent(num);
	}

	@Override
	public List<Student> getStudentList() {
		System.out.println("*** StudentServiceImpl 클래스의 getStudentList() 메소드 호출 ***");
		return studentDAO.selectStudentList();
	}
}