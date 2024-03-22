package xyz.itwill09.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ModelController {
	@RequestMapping("/display1")
	public String display1(Model model) {
		model.addAttribute("display1Name","ȫ�浿");
		//model.addAttribute("now", new SimpleDateFormat("yyyy�� MM�� dd�� HH�� mm�� ss��").format(new Date()));
		return "model_display1";
	}
	
	@RequestMapping("/display2")
	public String display2(Model model) {
		model.addAttribute("display2Name","�Ӳ���");
		//model.addAttribute("now", new SimpleDateFormat("yyyy�� MM�� dd�� HH�� mm�� ss��").format(new Date()));
		return "model_display2";
	}
	
	@RequestMapping("/display3")
	public String display3(Model model) {
		model.addAttribute("display3Name","����ġ");
		//model.addAttribute("now", new SimpleDateFormat("yyyy�� MM�� dd�� HH�� mm�� ss��").format(new Date()));
		return "model_display3";
	}
	
	//�ý����� ���� ��¥�� �ð��� ����� ���ڿ��� ��ȯ�ϴ� �޼ҵ�
	//@ModelAttribute : �޼ҵ忡 @ModelAttribute ������̼��� ����ϸ� �޼ҵ��� ��ȯ��(��ü)��
	//���� Controller Ŭ������ �ۼ��� ��� ��û ó�� �޼ҵ��� �信�� �Ӽ������� �����ϴ� ������̼�
	//value �Ӽ� : �޼ҵ��� ��ȯ��(��ü)�� �信�� ����ϱ� ���� �̸�(�Ӽ���)�� �Ӽ������� ����
	// => value �Ӽ��ܿ� �ٸ� �Ӽ��� ���� ��� �Ӽ����� ���� ����
	@ModelAttribute(value = "now")
	public String getNow() {
		return new SimpleDateFormat("yyyy�� MM�� dd�� HH�� mm�� ss��").format(new Date());
	}
}