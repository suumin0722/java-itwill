package xyz.itwill09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.RequiredArgsConstructor;
import xyz.itwill09.dto.Student;
import xyz.itwill09.service.StudentService;

//SpringMVC �����ӿ�ũ�� ����Ͽ� �����α׷��� �ۼ��ϴ� ���
// => ���̺� >> DTO Ŭ���� >> DAO Ŭ����(Mybatis) >> Service Ŭ���� >> Controller Ŭ���� 
// >> �׽�Ʈ ���α׷�(JUnit) - ���� ���α׷�(���) �׽�Ʈ >> HTML ������ JSP ������ ��ȯ
// >> ���� ���α׷� �׽�Ʈ - ������ ���

//Mybatis �����ӿ�ũ���� �߻��Ǵ� �α� �̺�Ʈ�� Spring �����ӿ�ũ�� �α� ����ü�� ����ϴ� ���
//1.log4jdbc-log4j2-jdbc4 ���̺귯���� ������Ʈ�� ���� ó�� - ���̺� : pom.xml
//2.Spring Bean Configuration File(root-context.xml)���� DataSource ���� Ŭ������ Spring Bean����
//����� bean ������Ʈ���� driverClassName �ʵ�� url �ʵ忡 ����� �� ����
//3.[src/main/resources] ������ [log4jdbc.log4j2.properties] ���� �ۼ�
//=> Mybatis �����ӿ�ũ���� �߻��Ǵ� �α� �̺�Ʈ�� Spring �����ӿ�ũ�� �α� ����ü�� �����ϱ�
//���� SpyLogDelegator Ŭ������ �����ϱ� ���� ����
//4.SpyLogDelegator ��ü�� ���� �߻��� �α� �̺�Ʈ�� Spring �����ӿ�ũ�� �α� ����ü�� ���
//�ǵ��� ȯ�漳������(log4j.xml) ���� - logger ������Ʈ �߰�

//Controller Ŭ���� : Ŭ���̾�Ʈ�� ��û�� ó���ϴ� ����� �����ϱ� ���� Ŭ����
// => Controller Ŭ������ �޼ҵ忡���� Ŭ���̾�Ʈ�� ��û�� ó���ϱ� ���� ������� Service 
//Ŭ������ �޼ҵ带 ȣ���Ͽ� �ۼ� 

//Controller Ŭ������ Front Controller���� ����� �� �ֵ��� �ݵ�� Spring Bean���� ���
// => Controller Ŭ������ @Controller ������̼��� ����Ͽ� Spring Bean���� ��� ó��
// => @Controller ������̼��� ������ �����̳ʰ� ó���ϱ� ���� �ݵ�� Ŭ������ �ۼ��� ��Ű����
//Spring Bean Configuration File(servlet-context.xml)�� component-scan ������Ʈ�� �˻��ǵ��� ����
@Controller
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {
	//Controller Ŭ������ �޼ҵ忡���� Service Ŭ������ �޼ҵ带 ȣ���� �� �ֵ��� Serviuce ��ü�� ����� �ʵ� �ۼ�
	// => Service ��ü�� ����� �� �ִ� �ʵ带 �ۼ��Ͽ� ������ �����̳ʷκ��� Spring Bean��
	//�����޾� ����ǵ��� ������ ����(DI) - ������ ������ ������ ����
	private final StudentService studentService;
	
	//�л������� �Է¹ޱ� ���� JSP ������ ���̸��� ��ȯ�ϴ� ��û ó�� �޼ҵ�
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add() {
		return "student/student_add";//������ �̵�
	}
	
	//�л������� ���޹޾� STUDENT ���̺� ������ �����ϰ� �л������ ����ϴ� �������� 
	//Ŭ���̾�Ʈ���� �����Ͽ� �����ϴ� ��û ó�� �޼ҵ�
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@ModelAttribute Student student, Model model) {
		try {
			studentService.addStudent(student);
		} catch (Exception e) {
			model.addAttribute("message", "�л���ȣ�� �ߺ��ǰų� �Է°��� ������ �ֽ��ϴ�.");
			return "student/student_add";
		}
		return "redirect:/student/display";//����̷�Ʈ �̵� 
	}

	//STUDENT ���̺� ����� ��� ���� �˻��Ͽ� ��ȯ���� �л������ Request Scope �Ӽ�������
	//������ �л������ ����ϴ� JSP ������ ���̸��� ��ȯ�ϴ� ��û ó�� �޼ҵ�
	@RequestMapping("/display")
	public String display(Model model) {
		model.addAttribute("studentList", studentService.getStudentList());
		return "student/student_display";
	}
}