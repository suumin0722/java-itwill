package xyz.itwill08.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//��Ʈ�ѷ�(Controller) : Ŭ���̾�Ʈ�� ��� ��û�� �޾� URL �ּҸ�  �м��Ͽ� �ʿ��� ��û ó��
//Ŭ����(Model)�� �޼ҵ带 ȣ���Ͽ� Ŭ���̾�Ʈ�� ��û�� ó���ϰ� JSP ����(View)�� �����带
//�̵��Ͽ� ����ó�� �ǵ��� ���α׷��� �帧�� �����ϴ� ����� ���� - ����(Servlet)���� ����

//��Ʈ�ѷ� ����� �����ϱ� ���� ���� Ŭ����
// => Ŭ���̾�Ʈ�� ��� ��û�� �޾� ó���ϴ� ���� �������� ������ �����ϵ��� ���� - Front Controller Pattern
// => [web.xml] ���Ͽ��� Ŭ������ �������� ����ϰ� Ŭ���̾�Ʈ�� ��� ��û�� �޾� ó���� ��
//�ֵ��� URL ���� ��� ó��
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//Ŭ���̾�Ʈ ��û�� ���� �ڵ� ȣ��Ǵ� �޼ҵ�
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Ŭ���̾�Ʈ�� ��û URL �ּҸ� �м��Ͽ� ��û������ ��ȯ�޾� ����
		String requestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
		String command=requestURI.substring(contextPath.length());
		
		//Ŭ���̾�Ʈ ��û����(Command)�� �̿��Ͽ� ��û ó�� Ŭ����(Model)�� ��ü�� �����޾� 
		//�޼ҵ带 ȣ���Ͽ� Ŭ���̾�Ʈ ��û�� ó���ϰ� ���� ���� ������ ��ȯ�޾� ����
		/*
		Controller controller=null;
		//Ŭ���̾�Ʈ�� ��û������ ���Ͽ� ��û ó�� Ŭ������ ��ü�� �����Ͽ� ����
		if(command.equals("/list.itwill")) {
			controller=new ListController();
		} else if(command.equals("/view.itwill")) {
			controller=new ViewController();
		}
		*/
		
		//HandlerMapping Ŭ������ ��ü ����
		HandlerMapping handlerMapping=new HandlerMapping();
		//HandlerMapping Ŭ������ �޼ҵ带 ȣ���Ͽ� Ŭ���̾�Ʈ�� ��û������ ���� ��û ó��
		//Ŭ������ ��ü�� ��ȯ�޾� ����
		Controller controller=handlerMapping.getController(command);
		
		//��û ó�� Ŭ������ �޼ҵ带 ȣ���Ͽ� Ŭ���̾�Ʈ�� ��û�� ó���ϰ� ���̸��� ��ȯ�޾� ����
		String viewName=controller.handleRequest(request, response);
		
		//��(JSP)�� ������ �̵��Ͽ� Ŭ���̾�Ʈ ��û�� ���� ó������� ���� ó��
		// => ��û ó�� �޼ҵ��� ��ȯ��(ViewName)�� ����Ͽ� JSP ������ ��θ� �ϼ��� ������ �̵�
		ViewResolver viewResolver=new ViewResolver();
		String view=viewResolver.getView(viewName);
		request.getRequestDispatcher(view).forward(request, response);
	}
}