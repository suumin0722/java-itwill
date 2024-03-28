package xyz.itwill09.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//��û ó�� �޼ҵ��� ��ɿ� ���� ������ ������� ��(JSP)���� �����ϴ� ���
//1.ModelAndView ��ü�� addObject() �޼ҵ带 ȣ���Ͽ� ������� �Ӽ������� �����Ͽ� ���� 
//2.HttpServletRequest ��ü�� setAttribute() �޼ҵ带 ȣ���Ͽ� ������� �Ӽ������� �����Ͽ� ���� 
//3.Model ��ü�� addAttribute() �޼ҵ带 ȣ���Ͽ� ������� �Ӽ������� �����Ͽ� ���� 

@Controller
public class ResultController {
	/*
	@RequestMapping("/resultMav")
	public ModelAndView modelAndViewResult() {
		ModelAndView modelAndView=new ModelAndView("result_display");
		
		//ModelAndView.addObject(String attributeName, Object attributeVale) 
		// => ModelAndView ��ü�� ������� �Ӽ������� �����ϴ� �޼ҵ� - Request Scope
		// => ��(JSP)������ EL �Ǵ� JSTL�� ����Ͽ� �Ӽ������� �Ӽ���(��ü)�� �����޾� ��� ó��
		modelAndView.addObject("mavName", "ȫ�浿");
		
		return modelAndView;
	}
	*/
	
	//��û ó�� �޼ҵ忡 �Ű������� �ۼ��ϸ� Front Controller�� ������ �����̳�(WebApplicationContext ��ü)��
	//����� Spring Bean���� ��ϵ� ��ü�� ���޹޾� �Ű������� �����Ͽ� ���
	@RequestMapping("/resultMav")
	public ModelAndView modelAndViewResult(ModelAndView modelAndView) {
		modelAndView.setViewName("result_display");
		modelAndView.addObject("mavName", "ȫ�浿");
		return modelAndView;
	}
	
	@RequestMapping("/resultRequest")
	public String requestResult(HttpServletRequest request) {
		//HttpServletRequest.setAttribute(String attributeName, Object attributeVale) 
		// => HttpServletRequest ��ü�� ������� �Ӽ������� �����ϴ� �޼ҵ� - Request Scope		
		request.setAttribute("requestName", "�Ӳ���");
		return "result_display";
	}
	
	@RequestMapping("/resultModel")
	public String modelResult(Model model) {
		//Model ��ü : ��û ó�� �޼ҵ��� ó�� ������� �信�� �����ϱ� ���� ��ä
		//Model.addAttribute(String attributeName, Object attributeVale) 
		// => Model ��ü�� ������� �Ӽ������� �����ϴ� �޼ҵ� - Request Scope		
		model.addAttribute("modelName", "����ġ");
		return "result_display";
	}
	//
}

