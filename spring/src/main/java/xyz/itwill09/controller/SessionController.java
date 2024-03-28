package xyz.itwill09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import xyz.itwill09.dto.Hewon;

@Controller
//@SessionAttributes : Model ��ü�� ����Ͽ� ����Ǵ� �Ӽ����� ���� Controller Ŭ������ ���  
//��û ó�� �޼ҵ�� �信�� �����ϱ� ���� ������̼�
// => Model ��ü�� ����Ͽ� ����Ǵ� �Ӽ����� Request Scope �Ӽ����� �ƴ� �������� Session 
//Scope �Ӽ������� ���ǵ��� ����� �����ϴ� ������̼�
// > ���� ó���� ȣ��Ǵ� ��û ó�� �޼ҵ忡�� ������ ��ü�� �˻��ϴ� ����� �ۼ����� �ʾƵ�
//��(JSP)���� ��ü ��� ���� - �信�� ������ ��û�� �ĺ��� ���� ���ʿ�
//value �Ӽ� : �������� Session Scope �Ӽ������� ����ϱ� ���� �Ӽ����� �Ӽ������� ����
// => value �Ӽ��ܿ� �ٸ� �Ӽ��� ���� ��� �Ӽ����� ���� ����
@SessionAttributes("hewon")
public class SessionController {
	//���̵� ���޹޾� ȸ�������� �˻��Ͽ� ��ȯ�ϴ� �޼ҵ� - Service Ŭ������ �޼ҵ�
	private Hewon getHewon(String id) {
		return Hewon.builder().id("abc123").name("ȫ�浿").email("abc@itwill.xyz").build();
	}
	 
	//���̵� ���޹޾� ���̵��� ȸ�������� �˻��Ͽ� �信�� �����ϱ� ���� ��û ó�� �޼ҵ�
	// => ���̵�� �˻��� ȸ�������� �Ӽ������� �����Ͽ� ��(JSP)���� HTML �±׷� ��µǵ��� ���� ó��
	@RequestMapping("/hewon_view")
	public String view(@RequestParam(defaultValue = "abc123") String id, Model model) {
		//Service Ŭ������ �޼ҵ带 ȣ���Ͽ� �Ű������� ���޹��� ���̵��� ȸ�������� �˻��� ��ȯ�޾� ���� 
		Hewon hewon=getHewon(id);
		
		//Model ��ü�� ����Ͽ� �˻��� ȸ�������� �Ӽ������� �����Ͽ� �信�� ����
		// => ���� ��û ó�� �޼ҵ��� �信�Ը� �Ӽ����� ��ü�� �����Ͽ� ���� ó�� - Request Scope
		//@SessionAttributes ������̼ǿ� ���� Model ��ü�� ����� �Ӽ����� �������� Session Scope 
		//�Ӽ������� ���Ǿ� ���� Controller Ŭ������ ��� ��û ó�� �޼ҵ�� �信�� �Ӽ��� ����
		model.addAttribute(hewon);//�Ӽ��� ���� - �Ӽ����� ���� Ŭ�������� �Ӽ������� ���
		
		return "hewon_view";
	}
	
	/*
	//���̵� ���޹޾� ���̵��� ȸ�������� �˻��Ͽ� �信�� �����ϱ� ���� ��û ó�� �޼ҵ�
	// => ���̵�� �˻��� ȸ�������� �Ӽ������� �����Ͽ� ��(JSP)���� �Է��±��� �ʱⰪ���� ����Ͽ� ���� ó��
	@RequestMapping(value = "/hewon_update", method = RequestMethod.GET)
	public String update(@RequestParam(defaultValue = "abc123") String id, Model model) {
		Hewon hewon=getHewon(id);
		model.addAttribute(hewon);
		return "hewon_update";
	}

	//ȸ�������� ���޹޾� ����� ȸ�������� �信�� �����ϴ� ��û ó�� �޼ҵ�
	@RequestMapping(value = "/hewon_update", method = RequestMethod.POST)
	public String update(@ModelAttribute Hewon hewon) {
		return "hewon_result";
	}
	*/
	
	//@SessionAttributes ������̼����� ������ �Ӽ����� ��û ó�� �޼ҵ�� �信�� ���ǵ��� ����
	// => ���̵� ���޹޾� ȸ������ �˻� �� �Ӽ��� ���� ��� ���ʿ�
	@RequestMapping(value = "/hewon_update", method = RequestMethod.GET)
	public String update() {
		return "hewon_update";
	}

	//ȸ�������� ���޹޾� ����� ȸ�������� �信�� �����ϴ� ��û ó�� �޼ҵ�
	// => ��û ó�� �޼ҵ��� �Ű��������� @SessionAttributes ������̼����� ������ �Ӽ�����
	//��ü�� ���޹޾� �����ϰ� ���ް�(���氪)���� �ʵ尪�� ���� ó���Ͽ� ���ǵ��� ����
	//SessionStatus �������̽��� �Ű������� �ۼ��Ͽ� SessionStatus ��ü�� �����޾� ���
	// => SessionStatus ��ü : @SessionAttributes ������̼ǿ� ���� ������ �������� Session
	//Scope �Ӽ����� ���������� �����ϱ� ���� ��ü
	@RequestMapping(value = "/hewon_update", method = RequestMethod.POST)
	public String update(@ModelAttribute Hewon hewon, SessionStatus sessionStatus) {
		//SessionStatus.setComplete() : @SessionAttributes ������̼ǿ� ���� ������ �������� 
		//Session Scope �Ӽ����� �����ϴ� �޼ҵ�
		// => ��û ó�� �޼ҵ�� �信�� ���̻� �������� Session Scope �Ӽ����� ������� ���ϵ��� ����
		sessionStatus.setComplete();
		return "hewon_result";
	}
}