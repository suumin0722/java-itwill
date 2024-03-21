package xyz.itwill08.spring;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//�� ����� �����ϱ� ���� ��û ó�� Ŭ���� - Controller Ŭ����
// => Spring-webmvc ���̺귯���� ������ Controller �������̽��� ��ӹ޾� �ۼ�
// => Ŭ���̾�Ʈ�� [/list.do]�� URL �ּҷ� ��û�� ��� ��Ʈ�ѷ��� ���� ����� Ŭ����
public class ListController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//ModelAndView Ŭ������ ��ü ����
		// => ModelAndView ��ü : ó������� ���̸�(ViewName)�� �����ϱ� ���� ��ü
		ModelAndView modelAndView=new ModelAndView();
		
		//������ ó�� - Service Ŭ������ �޼ҵ� ȣ��
		List<Product> productList = new ArrayList<Product>();
		productList.add(new Product(1000, "��ǻ��"));
		productList.add(new Product(2000, "��Ʈ��"));
		productList.add(new Product(3000, "�º�"));
		
		//ModelAndView.addObject(String attributeName, Object attributeValue)
		// => ModelAndView ��ü�� ��û�� ���� ó�� ����� �Ӽ������� �����ϴ� �޼ҵ� - Request Scope
		modelAndView.addObject("productList", productList);
		
		//ModelAndView.setViewName(String viewName) : ModelAndView ��ü�� ���̸��� �����ϴ� �޼ҵ�
		modelAndView.setViewName("product_list");
	
		//ó������� ���̸��� �ϳ��� ������ ��Ƽ� ��ȯ
		return modelAndView;
	}
	
}
