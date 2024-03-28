package xyz.itwill09.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ParamController {
	@RequestMapping(value = "/param", method = RequestMethod.GET)
	public String form() {
		return "param_form";
	}

	/*
	//HttpServletRequest �������̽��� ��û ó�� �޼ҵ��� �Ű������� �ۼ��Ͽ� Front Controller����
	//Ŭ���̾�Ʈ�� ��û������ ����� HttpServletRequest ��ü�� �����޾� ���
	@RequestMapping(value = "/param", method = RequestMethod.POST)
	public String action(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		String food=request.getParameter("food");
		request.setAttribute("food", food);
		return "param_display";
	}
	*/
	
	/*
	//������ ��û�� ���޵Ǵ� ���� �̸��� ���� �̸����� ������(Wrapper Ŭ����) �Ǵ� String Ŭ������
	//�Ű������� �ۼ��Ͽ� Front Controller�� ���ް��� �Ű������� �����Ͽ� ����� �� �ֵ��� ����
	// => ���ް��� �̸��� �Ű������� �̸��� ���� ���� ��� String Ŭ������ �Ű��������� null ����
	// => �Ű������� �ڷ����� ������(Wrapper Ŭ����)�� ��� ���ް��� �̸��� �Ű������� �̸���
	//���� �ʰų� �ڷ����� ���� �ʴ� ���� ���޵� ��� 400 �����ڵ� �߻�
	//�Ű������� ���ް��� �����޾� ����ϱ� ���ؼ��� ���ް��� ���� ��������(ĳ���ͼ�)�� ����
	//ó���ǵ��� ���ڵ� ���� ���
	//����(Filter) : ��û ó�� �޼ҵ� ���� �� �Ǵ� �Ŀ� �ʿ��� ���(���)�� �����ϱ� ���� �����α׷�
	// => Filter �������̽��� ��ӹ޾� �ڽ�Ŭ����(Filter Ŭ����)�� �ۼ��ϰ� [web.xml] ���Ͽ���
	//Filter Ŭ������ ���ͷ� ����ϰ� ���Ͱ� ����� ��û URL ���� ���� ó��
	//���ڵ� ����(Encoding Filter) : Ŭ���̾�Ʈ ��û�� ���� ��û ó�� �޼ҵ� ���� �� ���ް���
	//���� �������¸� �����ϴ� ����� �����ϴ� ����
	// => spring-webmvc ���̺귯������ �����ϴ� CharacterEncodingFilter Ŭ������ ����Ͽ�
	//���ڵ� ���ͷ� ���۵ǵ��� [web.xml] ���Ͽ� ��� ó��
	@RequestMapping(value = "/param", method = RequestMethod.POST)
	public String action(String food, Model model) {
		model.addAttribute("food", food);
		return "param_display";
	}
	*/
	
	/*
	//���ް��� �����޾� �����ϱ� ���� �Ű������� @RequestParam ������̼� ��� - ����
	//@RequestParam : ���ް��� �����޾� �Ű������� �����ϱ� ���� ������̼�
	// => �Ű������� �̸��� ���� �̸����� ���޵� ���� ���� ��� 400 �����ڵ� �߻�
	// => ���ް��� �̸��� �Ű������� �̸��� ������ �ۼ��Ͽ� �ݵ�� ���ް��� �����޾� ����ϵ���
	//�����ϴ� ������̼�
	// => ���ް��� �̸��� �Ű������� �̸��� ���� ��� ���ް��� ������ �Ű������� null ���� - 400 �����ڵ� �̹߻�
	@RequestMapping(value = "/param", method = RequestMethod.POST)
	public String action(@RequestParam String food, Model model) {
		model.addAttribute("food", food);
		return "param_display";
	}
	*/
	
	/*
	//required �Ӽ� : false �Ǵ� true(�⺻��) �� �ϳ��� �Ӽ������� ����
	// => [false] �Ӽ����� ����ϸ� ���ް��� �̸��� �Ű������� �̸��� ���� �ʾƵ� 400 �����ڵ尡 
	//�߻����� �ʰ� [true] �Ӽ����� ����Ͽ� ���ް��� �̸��� �Ű������� �̸��� ���� ������ 400 �����ڵ� �߻�
	//value �Ӽ� : ���ް��� �̸��� �Ӽ������� ����
	// => value �Ӽ������� ������ �̸��� ���ް��� ���� �Ű������� ����
	// => value �Ӽ��ܿ� �ٸ� �Ӽ��� ���� ��� �Ӽ����� ���� ����
	// => ���ް��� �̸��� �Ű������� �̸��� �ٸ� ��� ���ް��� ���� �Ű������� �����ϱ� ���� ���
	@RequestMapping(value = "/param", method = RequestMethod.POST)
	public String action(@RequestParam(required = true, value = "food") String foodname, Model model) {
		model.addAttribute("food", foodname);
		return "param_display";
	}
	*/
	
	//defaultValue �Ӽ� : ���ް��� �̸��� �Ű������� �̸��� �ٸ� ��� �Ű������� ����� 
	//�⺻���� �Ӽ������� ����
	// => ���ް��� ���� ��� �Ű������� [null] ��ſ� defaultValue �Ӽ����� �Ű������� ����
	@RequestMapping(value = "/param", method = RequestMethod.POST)
	public String action(@RequestParam(defaultValue = "�����", value ="food") String foodname, Model model) {
		model.addAttribute("food", foodname);
		return "param_display";
	}
	
	@RequestMapping(value = "/same", method = RequestMethod.GET)
	public String same() {
		return "same_form";
	}
	
	//���� �̸����� ���޵� ���� �������� ��� �Ű������� String �迭�� �ۼ��ϸ� ���ް���
	// ��ҷ� ����� �迭�� �����޾� �Ű������� �����Ͽ� ��� ����
	/*
	 * @RequestMapping(value = "/same", method = RequestMethod.POST) public String
	 * same(@RequestParam("hobby") String[] hobbyList, Model model) {
	 * model.addAttribute("hobbyList", hobbyList); return "same_display"; }
	 */

	// ���� �̸����� ���޵� ���� �������� ��� �Ű������� �ڷ����� String �迭 ��� List
	// �������̽��� ����Ͽ� ���ް��� ��ҿ� ����� List ��ü�� �Ű������� �����Ͽ� ��� ����
	@RequestMapping(value = "/same", method = RequestMethod.POST)
	public String same(@RequestParam("hobby") List<String> hobbyList, Model model) {
		model.addAttribute("hobbyList", hobbyList);
		return "same_display";
	}
	
}