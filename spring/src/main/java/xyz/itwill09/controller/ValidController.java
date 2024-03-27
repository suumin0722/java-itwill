package xyz.itwill09.controller;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xyz.itwill09.dto.Employee;

//Command ��ü�� �ʵ忡 ����� ���ް� ���� - Spring Validation
//1.validation-api ���̺귯���� hibernate-validator ���̺귯���� ������Ʈ�� ���� ó�� - ���̺� : pom.xml
//2.HTML �±� ��� Spring �±׸� ����Ͽ� ��(View - JSP) �ۼ� - �����޼����� �����޾� ��� ó��
//3.Controller Ŭ������ ��û ó�� �޼ҵ忡�� ���ް��� ����� Command ��ü�� ����� �Ű�������
//@Valid ������̼��� ����Ͽ� ���� ó���ǵ��� ����
//4.Command ��ü�� ���� DTO Ŭ������ �ʵ忡 ���� ���� ������̼��� ����Ͽ� ���ް� ����

@Controller
//@RequestMapping ������̼��� Ŭ������ ����� Controller Ŭ������ ��� ��û ó�� �޼ҵ��
//���ε� ��û URL �ּ� �պκп� ���������� �߰��� URL �ּ� ����
//value �Ӽ� : ��� ��û ó�� �޼ҵ�� ���ε� ��û URL �ּ� �պκп� �߰��� URL �ּҸ� �Ӽ������� ����
// => value �Ӽ��ܿ� �ٸ� �Ӽ��� ���� ��� �Ӽ����� ���� ����
@RequestMapping("/valid")
public class ValidController {
	//@RequestMapping(value = "/valid/html", method = RequestMethod.GET)
	@RequestMapping(value = "/html", method = RequestMethod.GET)
	public String html() {
		return "valid/html_form";
	}
	
	//@RequestMapping(value = "/valid/html", method = RequestMethod.POST)
	@RequestMapping(value = "/html", method = RequestMethod.POST)
	public String html(@ModelAttribute Employee employee, Model model) {
		//Java�� ����Ͽ� �������� ���ް�(�Է°�) ����
		if(employee.getId()==null || employee.getId().equals("")) {
			model.addAttribute("idMsg","���̵� �Է��� �ּ���.");
			return "valid/html_form";
		}
		
		String idReg="^[a-zA-Z]\\w{5,19}$";
		if(!Pattern.matches(idReg, employee.getId())) {
			model.addAttribute("idMsg","���̵� ���Ŀ� �°� �Է��� �ּ���.");
			return "valid/html_form";	
		}
		
		return "valid/result";
	}
	
	//@RequestMapping(value = "/valid/spring", method = RequestMethod.GET)
	@RequestMapping(value = "/spring", method = RequestMethod.GET)
	public String spring(@ModelAttribute Employee employee) {
		//Arrays.asList(Object ... args) : ��Ұ��� ����� List ��ü�� �����Ͽ� ��ȯ�ϴ� �����޼ҵ�
		//model.addAttribute("genderList", Arrays.asList("����","����"));
		return "valid/spring_form";
	}
	
	//��û ó�� �޼ҵ��� �Ű������� Errors �������̽��� �ۼ��ϸ� Errors ��ü�� ���޹޾� ����
	// => Errors : ���ް��� ���� ���� ���н� �߻��Ǵ� ��� ���� ���� ������ ������ ��ü
	@RequestMapping(value = "/spring", method = RequestMethod.POST)
	public String spring(@ModelAttribute @Valid Employee employee, Errors errors) {
		//Errors.hasErrors() : Errors ��ü�� ���� ���� ������ ����� ��� [true]�� ��ȯ�ϴ� �޼ҵ�
		if(errors.hasErrors()) {
			//model.addAttribute("genderList", Arrays.asList("����","����"));
			return "valid/spring_form";
		}
		return "valid/result";
	}
	
	//�޼ҵ��� ��ȯ���� Controller Ŭ������ ��� ��û ó�� �޼ҵ��� �信�� ����
	@ModelAttribute("genderList")
	public List<String> gendeList() {
		return Arrays.asList("����","����");
	}
}





