package xyz.itwill09.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import xyz.itwill09.dto.Member;

@Controller
public class JoinController {
	//ȸ�������� �Է¹ޱ� ���� JSP ������ ���̸��� ��ȯ�ϴ� ��û ó�� �޼ҵ�
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		return "join_form";
	}
	
	/*
	//���ް�(ȸ������)�� �Ű������� �����޾� Request Scope �Ӽ������� �����ϰ� �Ӽ����� ���
	//�ϴ� JSP ������ ���̸��� ��ȯ�ϴ� ��û ó�� �޼ҵ�
	// => ���ް��� ���� �̸��� �Ű������� �ۼ��Ͽ� ���ް��� �����޾� ���
	// => �Ű������� @RequestParam ������̼��� ����Ͽ� ���ް��� �̸��� �Ű������� �̸���
	//�ٸ� ��� 400 �����ڵ尡 �߻��ǵ��� �ۼ�
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@RequestParam String id, @RequestParam String passwd
			, @RequestParam String name, @RequestParam String email, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("passwd", passwd);
		model.addAttribute("name", name);
		model.addAttribute("email", email);
		return "join_display";
	}
	*/
	
	/*
	//���ް�(ȸ������)�� �Ű������� �����޾� Request Scope �Ӽ������� �����ϰ� �Ӽ����� ���
	//�ϴ� JSP ������ ���̸��� ��ȯ�ϴ� ��û ó�� �޼ҵ�
	// => ���ް��� ���� �̸��� �Ű������� �ۼ��Ͽ� ���ް��� �����޾� ���
	// => �Ű������� @RequestParam ������̼� ��� @ModelAttribute ������̼��� ���
	//@ModelAttribute : ��(��ü)�� ��(View)���� �����ϱ� ���� ������̼�
	// => @ModelAttribute ������̼��� �޼ҵ忡 ����ϸ� �޼ҵ��� ��ȯ���� ��Ʈ�ѷ� Ŭ������
	//��� ��û ó�� �޼ҵ��� ��(View)���� ����
	// => @ModelAttribute ������̼��� �Ű������� ����ϸ� �Ű������� ����� ��(��ü)�� ��û 
	//ó�� �޼ҵ��� ��(View)���� ���� - Model ��ü�� ������� �ʰ� �Ű������� ����� ��(��ü)��
	//�信�� �Ӽ��� ����
	// => ���ް��� �̸��� �Ű������� �̸��� ���� �ʾƵ� 400 �����ڵ� �̹߻�
	//value �Ӽ� : ��(View)���� �Ӽ����� ����� �� �ִ� �ĺ���(�Ӽ���)�� �Ӽ������� ����
	// => value �Ӽ������� ������ �̸��� ���ް��� ���� �Ű������� �����Ͽ� ��� ����
	// => value �Ӽ��ܿ� �ٸ� �Ӽ��� ���� ��� �Ӽ����� ���� ���� 
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@ModelAttribute(value = "id") String id, @ModelAttribute("passwd") String passwd
			, @ModelAttribute("name") String name, @ModelAttribute("email") String email) {
		return "join_display";
	}
	*/
	
	/*
	//���ް�(ȸ������)�� �Ű������� �����޾� DTO ��ü�� �ʵ尪���� ������ �� DTO ��ü�� Request
	//Scope �Ӽ������� �����Ͽ� �Ӽ����� ����ϰ� JSP ������ ���̸��� ��ȯ�ϴ� ��û ó�� �޼ҵ�
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@RequestParam String id, @RequestParam String passwd
			, @RequestParam String name, @RequestParam String email, Model model) {
		//DTO Ŭ������ ��ü�� �����Ͽ� ���ް����� DTO ��ü�� �ʵ尪 ����
		Member member=new Member();
		member.setId(id);
		member.setPasswd(passwd);
		member.setName(name);
		member.setEmail(email);

		//DTO ��ü�� Mode ��ü�� �Ӽ��� ���� - �信�� DTO ��ü ����
		//model.addAttribute("member", member);
		//Model.addAttribute(Object attributeValue) : ��ü�� �Ӽ������� �����Ͽ� �信�� �����ϴ� �޼ҵ�
		// => �Ű������� �Ӽ����� �������� ������ �Ӽ������� ����Ǵ� ��ü�� �ڷ���(Ŭ����)��
		//�̸��� �Ӽ������� ��� - ù��° ���ڴ� �ҹ��ڷ� ��ȯ�Ǿ� ���
		// => �Ӽ����� ������(Wrapper Ŭ����) �Ǵ� String Ŭ������ �ݵ�� �Ӽ��� ����
		model.addAttribute(member);
		
		return "join_display"; 
	}	
	*/

	/*
	//��û ó�� �޼ҵ��� �Ű����� �ڷ����� DTO Ŭ������ �ۼ��ϸ� Front Controller�� DTO Ŭ������
	//��ü�� �����Ͽ� �Ű������� �����Ͽ� ����
	// => ���ް��� �̸��� ���� �̸��� ��ü �ʵ忡 ���ް��� �ڵ����� �����Ͽ� ����
	//Command ��ü : ���ް��� �ʵ忡 ����� ��ü�� �Ű������� �����ϰ� �Ű������� ����� ��ü��
	//�Ӽ������� ������ �信�� ����� �� �ֵ��� �����ϴ� ��ü
	// => Command ��ü�� ����ϱ� ���� �Ű������� @ModelAttribute ������̼� ���
	// => @ModelAttribute ������̼��� ������� �ʾƵ� �信�� ����� �� �ִ� �Ӽ������� ����
	//Command ��ü�� ModelAttribute ������̼��� value �Ӽ� ���� ����
	// => value �Ӽ��� ������ ��� Command ��ü�� �ڷ���(Ŭ����)�� �ڵ����� �Ӽ������� ����
	//�Ͽ� ��� - ù��° ���ڴ� �ҹ��ڷ� ��ȯ�Ǿ� ���
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@ModelAttribute Member member) {
		return "join_display";
	}
	*/
	
	/*
	//@ModelAttribute ������̼��� value �Ӽ����� �����Ͽ� �信�� �Ӽ����� �����ϱ� ����
	//�Ӽ����� ���� ����
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@ModelAttribute("hewon") Member member) {
		return "join_display";
	}
	*/
	
	/*
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@ModelAttribute("hewon") Member member, Model model) {
		if(member.getId().equals("abc123")) {//���̵� �ߺ��� ���
			model.addAttribute("message", "�̹� ������� ���̵� �Է� �Ͽ����ϴ�.");
			return "join_form";
		}
		return "join_display";
	}
	*/

	//��û ó�� �޼ҵ��� �Ű����� �ڷ����� Map �������̽��� �ۼ��ϸ� Front Controller�� Map
	//��ü�� �����Ͽ� �Ű������� ����ǵ��� ����
	// => Map ��ü���� ��� ���ް��� �̸�(��Ű - String)�� ���ް�(�ʰ� - String)�� ��Ʈ����
	//�����Ǿ� �߰�
	// => ���ް��� ����� Map ��ü�� �����޾� �Ű������� �����ϱ� ���ؼ��� �ݵ�� @RequestParam
	//������̼��� �Ű������� �ۼ�
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@RequestParam Map<String, String> map, Model model) {
		model.addAttribute("hewon", map);
		return "join_display";
	}
}


