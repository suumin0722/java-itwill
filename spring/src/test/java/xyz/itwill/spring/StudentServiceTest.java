package xyz.itwill.spring;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import lombok.extern.slf4j.Slf4j;
import xyz.itwill09.dto.Student;
import xyz.itwill09.service.StudentService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"
		, "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
//@FixMethodOrder : �׽�Ʈ �޼ҵ� ȣ������� �����ϱ� ���� ������̼�
//value �Ӽ� : MethodSorters Enum �ڷ����� ��� �� �ϳ��� �Ӽ������� ����
//=> MethodSorters.DEFAULT : JUnit ���α׷��� ���� ��Ģ�� ���� �޼ҵ尡 ���ĵǾ� ȣ�� - ����� ������ ������ ���ĵǾ� ȣ��
//=> MethodSorters.JVM : JVM ���α׷��� ���� �޼ҵ尡 ���ĵǾ� ȣ�� - ����� �ұ�Ģ�� ������ ���ĵǾ� ȣ��
//=> MethodSorters.NAME_ASCENDING : �׽�Ʈ �޼ҵ��� �̸����� ���ĵǾ� ȣ�� - ����� ������ ������ ���ĵǾ� ȣ��
@FixMethodOrder(value = MethodSorters.DEFAULT)
@Slf4j
public class StudentServiceTest {
	@Autowired
	private StudentService studentService;
	
	@Test
	public void testAddStudent() {
		Student student=Student.builder().no(4000).name("�Ѹ�").phone("010-1112-1111")
				.address("����� ������").birthday("1992-06-22").build();
		
		studentService.addStuent(student);
	}
	
	@Test
	public void testGetStudentList() {
		List<Student> studentList=studentService.getStudentList();
		
		for(Student student : studentList) {
			log.info(student.toString());
		}
	}
}
