package xyz.itwill09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//TilesView Ŭ���� : ��û ó�� �޼ҵ��� ��ȯ��(ViewName)�� �����޾� �ټ��� JSP ������ ���յ�
//��


@Controller
public class TilesController {
	@RequestMapping("/")
	public String tiles() {
		return "main";
	}
}
