package xyz.itwill09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//TilesView Ŭ���� : ��û ó�� �޼ҵ��� ��ȯ��(ViewName)�� �����޾� �ټ��� JSP ������ ���յ�
//��(���ø� ������ - JSP)�� �����ϱ� ���� ����� �����ϴ� ViewResolver Ŭ����
//1.TilesView ���� ���̺귯��(tiles-extras ���̺귯��)�� ������Ʈ�� ���� ó�� - ���̺� : pom.xml
//2.��û ó�� �޼ҵ��� ��ȯ��(ViewName)�� �����޾� ������ JSP ����(���ø� ������) ����
//=> TilesView Ŭ������ �����޾� ����ϱ� ���� ȯ�漳������ �ۼ� - /WEB-INF/spring/appServlet/tiles.xml
//3.Front Controller(DispatchServlet ��ü)�� ��û ó�� �޼ҵ��� ��ȯ��(ViewName)�� �����޾�
//TilesView Ŭ������ ��ü�� ���� ó���ǵ��� Spring Bean Configuration File(servlet-context.xml) ����
//=> InternalResourceViewResolver ��ü���� TilesView ��ü�� ���� ����ǵ��� �켱 ���� ����  


@Controller
public class TilesController {
	@RequestMapping("/")
	public String tiles() {
		return "main";
	}
	
	@RequestMapping("/tiles1")
	public String tiles1() {
		return "tiles1";
	}
	
	@RequestMapping("/tiles2")
	public String tiles2() {
		return "layout_tiles2";
	}
	
	@RequestMapping("/admin")
	public String admin() {
		return "admin";
	}
}
