package xyz.itwill09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RedirectController {
	@RequestMapping("/forward_move")
	public String forward(Model model) {
		//Model ��ü�� ����Ͽ� ��(View)���� ������ ��ü�� �Ӽ������� ���� - Request Scope
		model.addAttribute("name", "ȫ�浿");
		
		//��(View)�� �����ϱ� ���� ���̸�(ViewName) ��ȯ
		// => Front Controller(DispatchServlet ��ü)�� ��ȯ���� ���̸��� InternalResourceViewResolver
		//��ü���� �����Ͽ� JSP ������ ��θ� �����޾� �����带 �̵��� JSP ������ ���� ó�� - ������ �̵�
		//������ �̵� : Ŭ���̾�Ʈ ��û�� ���� ����� �����α׷�(Front Controller)���� ���� 
		//ó���� �����α׷�(View - JSP)���� �����带 �̵��Ͽ� ���� ó��
		// => Ŭ���̾�Ʈ�� URL �ּҴ� ������� ������ Request Scope �Ӽ����� ��ü�� �����޾� ��� ����
		return "display_forward";
	}
	
	/*
	@RequestMapping("/redirect")
	public String redirect() {
		//��û ó�� �޼ҵ��� ��ȯ��(���̸�)�� redirect ���λ縦 ����Ͽ� ��ȯ�ϸ� Front Controller
		//(DispatchServlet ��ü)�� ��ȯ���� URL �ּҸ� Ŭ���̾�Ʈ���� �����Ͽ� ���� ó��
		// => URL �ּҸ� ������� Ŭ���̾�Ʈ�� ������ ��û URL �ּҸ� �����Ͽ� �ش� ��������
		//��û�� ���ο� �������� �����޾� ��� ó�� - �����̷�Ʈ �̵�
		//�����̷�Ʈ �̵� : Ŭ���̾�Ʈ���� URL �ּҸ� �����Ͽ� �������� ���û�� �������� ����޾� ó��
		// => Ŭ���̾�Ʈ�� URL �ּҴ� ��������� Request Scope �Ӽ����� ��ü�� �����޾� ��� �Ұ���
		return "redirect:/redirect_move";
	}
	
	*/

	//��û ó�� �޼ҵ忡 RedirectAttributes �������̽��� �Ű������� �ۼ��Ͽ� RedirectAttributes
	//��ü�� �����޾� ��� ����
	// => RedirectAttributes ��ü : �����̷�Ʈ �̵��Ǵ� �������� ��û ó�� �޼ҵ�� �信��
	//����� �� �ִ� Request Scope �Ӽ����� �����ϱ� ���� ��ü
	@RequestMapping("/redirect")
	public String redirect(RedirectAttributes attributes) {
		//RedirectAttributes.addFlashAttribute(String attributeName, Object attributeValue)
		// => Request Scope �Ӽ����� �����Ͽ� �����̷�Ʈ �̵��Ǵ� �������� ��û ó�� �޼ҵ��
		//�信�� �Ӽ����� �����ϱ� ���� �޼ҵ�
		attributes.addFlashAttribute("name", "�Ӳ���");
		return "redirect:/redirect_move";
	}

	@RequestMapping("/redirect_move")
	public String redirect() {
		return "display_redirect";
	}
}






