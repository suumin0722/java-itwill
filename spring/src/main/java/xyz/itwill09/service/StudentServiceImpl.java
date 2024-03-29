package xyz.itwill09.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import xyz.itwill09.dao.StudentDAO;
import xyz.itwill09.dto.Student;

//Service Ŭ���� : Ŭ���̾�Ʈ ��û�� ���� ������ ó�� ����� �����ϱ� ���� Ŭ���� -  ������Ʈ(Component) Ŭ����
// => Service Ŭ������ �޼ҵ忡���� ������ ó���� �ʿ��� ������� DAO Ŭ������ �޼ҵ带
//ȣ���Ͽ� �ۼ� - DAO ��ü�� ���ȭ ó���Ͽ� ����
// => Service Ŭ������ ��ü�Ǿ ��������� ������ Controller Ŭ������ ������ �ּ�ȭ �ϱ� ����
//�������̽��� ��ӹ޾� �ۼ��ϴ� ���� ����

//Service Ŭ������ Controller Ŭ�������� ��ü�� �����޾� ����� �� �ֵ��� Spring Bean���� ���
//=> Service Ŭ������ @Service ������̼��� ����Ͽ� Spring Bean���� ��� ó��
//=> @Service ������̼��� ������ �����̳ʰ� ó���ϱ� ���� �ݵ�� Ŭ������ �ۼ��� ��Ű����
//Spring Bean Configuration File(servlet-context.xmil)�� component-scan ������Ʈ�� �˻��ǵ��� ����
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
	//Service Ŭ������ �޼ҵ忡���� DAO Ŭ������ �޼ҵ带 ȣ���� �� �ֵ��� DAO ��ü�� ����� �ʵ� �ۼ�
	// => DAO ��ü�� ����� �� �ִ� �ʵ带 �ۼ��Ͽ� ������ �����̳ʷκ��� Spring Bean��
	//�����޾� ����ǵ��� ������ ����(DI) - ������ ������ ������ ����
	private final StudentDAO studentDAO;

	@Override
	public void addStudent(Student student) {
		studentDAO.insertStudent(student);
	}
	
	@Override
	public List<Student> getStudentList() {
		return studentDAO.selectStudentList();
	}

}
