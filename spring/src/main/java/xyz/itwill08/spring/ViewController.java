package xyz.itwill08.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//=> Ŭ���̾�Ʈ�� [/view.do]�� URL �ּҷ� ��û�� ��� ��Ʈ�ѷ��� ���� ����� Ŭ����
public class ViewController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelAndView=new ModelAndView();
		Product product=new Product(4000, "������");
		modelAndView.addObject("product", product);
		modelAndView.setViewName("product_view");
		
		return modelAndView;
	}

}
