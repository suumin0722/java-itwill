package xyz.itwill05.di;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

//@Component("studentService")

//@Service :  Service Ŭ������ ������ �����̳ʰ� ������ �� �ִ� Spring Bean���� ����ϱ� ���� ������̼�
//=> Ŭ������ �̸��� �ڵ����� beanName���� ���������� value �Ӽ��� ����Ͽ� beanName ���� ����
@Service("studentService")
public class AnnotationStudentServiceImpl implements StudentService {
	//@Autowired : ������ �����̳ʷκ��� Spring Bean�� �����޾� �ڵ����� �ʵ忡 ��ü�� ����ǵ��� 
	//������ ������ �����ϱ� ���� ������̼�
	//�ʵ忡 @Autowired ������̼��� ����Ͽ� ������ ���� - �ʵ� ������ ������ ����
	// => �ʵ尡 ������ �ۼ��� ��� �ʵ帶�� @Autowired ������̼��� ����Ͽ� ������ ����
	// => bean ������Ʈ�� autowire �Ӽ����� [byType]���� ������ �Ͱ� ���� ������� ������ ����
	// => Setter Injection�� ����Ͽ� �������� ���������� �ʵ��� Setter �޼ҵ尡 ��� ������ ���� ����
	//������)�ʵ��� �ڷ���(�������̽�)�� ���� �ڷ����� Spring Bean�� 2�� �̻��� ��� ������ ���� ���� - ���� �߻�
	//�ذ��-1)�ʵ��� �ڷ����� ���� �ڷ����� Spring Bean�� 2�� �̻��� ��� �ʵ��� ����� Spring
	//Bean�� �ĺ���(beanName)�� �ʵ��� �̸��� �����ϰ� ����
	// => @Autowired ������̼��� �ʵ��� �ڷ����� ���� �ڷ����� SpringSpring Bean�� 2�� �̻���
	//��� autowire �Ӽ����� [byName]���� ������ �Ͱ� ���� ������� ������ ����
	//�ذ��-2)�ʵ��� �ڷ����� ���� �ڷ����� Spring Bean�� 2�� �̻��� ��� �ʵ��� ����� Spring
	//Bean�� Ŭ������ @Primary ������̼��� ����Ͽ� ������ ����
	//�ذ��-3)�ʵ��� �ڷ����� ���� �ڷ����� Spring Bean�� 2�� �̻��� ��� �ʵ忡 @Qualifier 
	//������̼��� ����Ͽ� ������ ����
	//@Qualifier : �ʵ忡 ����� Spring Bean�� ���� �����Ͽ� �������� �����ϴ� ������̼�
	// => @Qualifier ������̼��� value �Ӽ��� ����Ͽ� �������� ���Ե� Spring Bean�� beanName ����
	// => value �Ӽ��ܿ� �ٸ� �Ӽ��� ���� ��� �Ӽ����� ���� ����
	@Autowired
	//@Qualifier(value="annotationStudentJdbcDAOImpl")
	@Qualifier("annotationStudentMybatisDAOImpl")
	private StudentDAO studentDAO;
	
	//@Autowired ������̼� ��� @Resouce ������̼� �Ǵ� @Inject ������̼��� ����Ͽ� ������ ���� ����
	// => @Autowired ������̼��� Spring �����ӿ�ũ�� ���̺귯������ ������ ������̼�
	//@Resouce ������̼� �Ǵ� @Inject ������̼��� Java ���̺귯������ ������ ������̼�
	// => @Resouce ������̼� �Ǵ� @Inject ������̼��� �ٸ� �����ӿ�ũ������ ��� ����
	//@Resouce : bean ������Ʈ�� autowire �Ӽ����� [byName]���� ������ �Ͱ� ������ ����� 
	//�������� �����ϴ� ������̼�
	//@Inject : bean ������Ʈ�� autowire �Ӽ����� [byType]���� ������ �Ͱ� ������ ����� 
	//�������� �����ϴ� ������̼�
	
	public AnnotationStudentServiceImpl() {
		System.out.println("### AnnotationStudentServiceImpl Ŭ������ �⺻ ������ ȣ�� ###");
	}
	
	/*
	public AnnotationStudentServiceImpl(StudentDAO studentDAO) {
		super();
		this.studentDAO = studentDAO;
		System.out.println("### AnnotationStudentServiceImpl Ŭ������ �Ű������� �ۼ��� ������ ȣ�� ###");
	}

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
		System.out.println("*** AnnotationStudentServiceImpl Ŭ������ setStudentDAO(StudentDAO studentDAO) �޼ҵ� ȣ�� ***");
	}
	*/

	@Override
	public void addStudent(Student student) {
		System.out.println("*** AnnotationStudentServiceImpl Ŭ������ addStudent(Student student) �޼ҵ� ȣ�� ***");
		studentDAO.insertStudent(student);
	}

	@Override
	public void modifyStudent(Student student) {
		System.out.println("*** AnnotationStudentServiceImpl Ŭ������ modifyStudent(Student student) �޼ҵ� ȣ�� ***");
		studentDAO.updateStudent(student);
	}

	@Override
	public void removeStudent(int num) {
		System.out.println("*** AnnotationStudentServiceImpl Ŭ������ removeStudent(int num) �޼ҵ� ȣ�� ***");
		studentDAO.deleteStudent(num);
	}

	@Override
	public Student getStudent(int num) {
		System.out.println("*** AnnotationStudentServiceImpl Ŭ������ getStudent(int num) �޼ҵ� ȣ�� ***");
		return studentDAO.selectStudent(num);
	}

	@Override
	public List<Student> getStudentList() {
		System.out.println("*** AnnotationStudentServiceImpl Ŭ������ getStudentList() �޼ҵ� ȣ�� ***");
		return studentDAO.selectStudentList();
	}
}