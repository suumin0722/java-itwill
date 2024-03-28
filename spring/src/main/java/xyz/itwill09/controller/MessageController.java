package xyz.itwill09.controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import xyz.itwill09.dto.Product;

//������ �޼���(Spring Message) : Spring �����ӿ�ũ�� �޼����� �����ϱ� ���� ���
//1.�޼����� ����� Properties ���� ����
// => ������ �����̳ʰ� ������ �� �ֵ��� [src/main/webapp] ������ Properties ������ �ۼ��ϴ� ���� ����
//2.Spring Bean Configuration File(servlet-context.xml)�� �޼��� ���� ����� �����ϴ� Ŭ������
//Spring Bean���� ����ϰ� �޼����� ����� Properties ������ ��θ� ��ü �ʵ忡 ����ǵ��� ������ ó��
//3.��(JSP)���� spring �±� ���̺귯���� message �±׸� ����Ͽ� �޼����� �����޾� ��� ó��

@Controller
@RequestMapping("/message")
public class MessageController {
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String message(@ModelAttribute Product product) {
		return "message/register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String message(@ModelAttribute @Valid Product product, Errors errors, HttpSession session) {
		//Locale ��ü ���� - ��� ��� ����
		Locale locale = new Locale("en");
		
		//HttpSession ��ü�� Locale ��ü�� �Ӽ������� ����
		// => �ݵ�� �Ӽ����� SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME ����� ����
		session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, locale);
		
		if(errors.hasErrors()) {
			return "message/register";
		}
		return "message/success";
	}
}


