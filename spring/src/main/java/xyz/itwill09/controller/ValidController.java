package xyz.itwill09.controller;

import java.util.regex.Pattern;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import xyz.itwill09.dto.Employee;

@Controller
public class ValidController {
	@RequestMapping(value = "/valid/html", method = RequestMethod.GET)
	public String html() {
		return "valid/html_form";
	}
	
	@RequestMapping(value = "/valid/html", method = RequestMethod.POST)
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
}










