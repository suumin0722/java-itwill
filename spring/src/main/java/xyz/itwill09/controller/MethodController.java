package xyz.itwill09.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MethodController {
	//����ڷκ��� ���� �Է¹ޱ� ���� JSP ������ ���̸�(ViewName)�� ��ȯ�ϴ� ��û ó�� �޼ҵ�
	// => Ŭ���̾�Ʈ�� ��û��Ŀ� ������� ��û ó�� �޼ҵ� ȣ��
	@RequestMapping("/method_input")
	public String inputOne() {
		return "method_input1";
	}
	
	//���ް��� ��ȯ�޾� Request Scope �Ӽ������� �����ϰ� �Ӽ����� ����ϱ� ���� JSP ������
	//���̸�(ViewName)�� ��ȯ�ϴ� ��û ó�� �޼ҵ� - POST ������� ��û�ǵ��� ����
	// => Ŭ���̾�Ʈ�� ��û��Ŀ� ������� ��û ó�� �޼ҵ� ȣ��
	@RequestMapping("/method_output")
	public String outputOne(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		//���������� ��û - Ŭ���̾�Ʈ���� �����ڵ� �Ǵ� ������������ ��û�� �� �ִ� URL �ּҸ� �����Ͽ� ���� 
		if(request.getMethod().equals("GET")) {
			//response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			response.sendRedirect("method_input");
			return null;
		}
 		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("name");
		request.setAttribute("name", name);
		return "method_output";
	}
	
	//����ڷκ��� ���� �Է¹ޱ� ���� JSP ������ ���̸�(ViewName)�� ��ȯ�ϴ� ��û ó�� �޼ҵ�
	// => Ŭ���̾�Ʈ�� GET ��Ŀ� �������� ��û�� ��� ��û ó�� �޼ҵ� ȣ��
	//method �Ӽ� : RequestMethod(Enum)�� ���(Constant) �� �ϳ��� �Ӽ������� ����
	// => RequestMethod(Enum)�� Ŭ���̾�Ʈ�� ��û����� ����� �����ϴ� Java �ڷ���
	// => method �Ӽ������� ������ ��û����� �ƴ� ���·� ��û�� ��� Ŭ���̾�Ʈ���� 405 �����ڵ� ����
	//@RequestMapping ������̼� ��� @GetMapping ������̼��� ����Ͽ� GET ������� ��û��
	//��� ��û ó�� �޼ҵ� ȣ�� ����
	//@GetMapping("/method")
	@RequestMapping(value = "/method", method = RequestMethod.GET)
	public String inputTwo() {
		return "method_input2";
	}

	//���ް��� ��ȯ�޾� Request Scope �Ӽ������� �����ϰ� �Ӽ����� ����ϱ� ���� JSP ������
	//���̸�(ViewName)�� ��ȯ�ϴ� ��û ó�� �޼ҵ� 
	// => Ŭ���̾�Ʈ�� POST ��Ŀ� �������� ��û�� ��� ��û ó�� �޼ҵ� ȣ��
	// => ��û ó�� �޼ҵ带 ȣ���ϴ� ��û����� �ٸ� ��� �������� ��û �̸��� ���Ƶ� ���� �̹߻�
	//@RequestMapping ������̼� ��� @PostMapping ������̼��� ����Ͽ� GET ������� ��û��
	//��� ��û ó�� �޼ҵ� ȣ�� ����
	//@PostMapping("/method")
	@RequestMapping(value = "/method", method = RequestMethod.POST)
	public String outputTwo(HttpServletRequest request) throws UnsupportedEncodingException {
 		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("name");
		request.setAttribute("name", name);
		return "method_output";
	}
}

