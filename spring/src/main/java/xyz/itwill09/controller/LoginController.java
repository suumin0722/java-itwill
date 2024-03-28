package xyz.itwill09.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	//����ڿ��� ���������� �Է¹ޱ� ���� JSP ������ ���̸��� ��ȯ�ϴ� ��û ó�� �޼ҵ�
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login_form";
	}
	
	//���ް�(��������)�� �Ű������� �����޾� ���� ó�� �� ���� ���� ������ Session Scope �Ӽ�������
	//�����ϰ� �α��� ���� �޼����� ����ϴ� JSP ������ ���̸��� ��ȯ�ϴ� ��û ó�� �޼ҵ�
	// => ���ް��� String Ŭ������ �Ű������� �ϳ��� �����޾� ���
	//��û ó�� �޼ҵ��� �Ű����� �ڷ����� HttpSession �������̽��� �ۼ��ϸ� Front Controller����
	//���� ���ε� ó���� HttpSession ��ü�� �����޾� �Ű������� �����Ͽ� ���
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam String id, @RequestParam String passwd
			, Model model, HttpSession session) {
		if(!id.equals("abc123") || !passwd.equals("123456")) {//���� ����
			//���� ���� ���� ������ Model ��ü�� Request Scope �Ӽ������� ����
			//Request Scope : ���� ��û ó�� �޼ҵ�� ������ �̵� �Ǵ� �信���� �Ӽ����� �����޾� ��� 
			model.addAttribute("message", "���̵� �Ǵ� ��й�ȣ�� �߸� �Է� �Ͽ����ϴ�.");
			model.addAttribute("id", id);
			return "login_form";//�Է������� �̵�
		}
		
		//���� ���� - ���� ���� ������ Session Scope �Ӽ������� ����
		//Session Scope : ������ ������ ����ϴ� ��� ��û ó�� �޼ҵ�� �信�� �Ӽ����� �����޾� ���
		session.setAttribute("loginId", id);
		
		return "login_display";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		//session.removeAttribute("loginId");
		session.invalidate();
		
		return "logout_display";
	}
	
	//�α��� ������ ����ڸ� ���� ������ ������
	@RequestMapping("/login_user")
	public String login(HttpSession session, Model model) {
		if(session.getAttribute("loginId")==null) {
			model.addAttribute("message", "�α��� ����ڸ� ���� �����մϴ�.");
			return "login_form";
		}
		
		return "login_display";
	}
}