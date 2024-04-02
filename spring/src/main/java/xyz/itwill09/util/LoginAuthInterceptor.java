package xyz.itwill09.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import xyz.itwill09.dto.Userinfo;
import xyz.itwill09.exception.BadRequestException;

//Interceptor Ŭ���� : ��û ó�� �޼ҵ� ȣ�� �� �Ǵ� �Ŀ� ���ԵǾ� ����� ����� �����ϴ� Ŭ����
// => Interceptor Ŭ������ �ݵ�� HandlerInterceptor �������̽��� ��ӹ޾� �ۼ�
// => HandlerInterceptor �������̽��� �⺻ �޼ҵ�(Default Method) �� �ʿ��� �޼ҵ常 �������̵� �����Ͽ� ���
// => Interceptor Ŭ������ Front Controller�� ���� �����ǹǷ� Spring Bean Configuration File
//(servlet-context.xml)���� Spring Bean���� ����Ͽ� ��û ó�� �޼ҵ� ȣ�� �� �Ǵ� �Ŀ� ����ǵ��� ����
// => Filter Ŭ������ Front Controller ������ ��ġ�Ͽ� ����ǰ� Interceptor Ŭ������ Front 
//Controller ������ ��ġ�Ͽ� ���� - Filter Ŭ������ WAS ���α׷��� ���� ���� 

//�α��� ����� ���� ���� ó���� ���� �ۼ��� ���ͼ��� Ŭ����
// => ��û ó�� �޼ҵ� ȣ�� ���� ��α��� ����ڰ� �������� ��û�� ��� ������ ���� �߻�
public class LoginAuthInterceptor implements HandlerInterceptor {
	//preHandle �޼ҵ� : ��û ó�� �޼ҵ� ȣ�� ���� ����� ����� �ۼ��ϱ� ���� �޼ҵ�
	// => false ��ȯ : ��û ó�� �޼ҵ� ��ȣ��, true ��ȯ : ��û ó�� �޼ҵ� ȣ��
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session=request.getSession();
		
		Userinfo loginUserinfo=(Userinfo)session.getAttribute("loginUserinfo");
		
		if(loginUserinfo == null) {
			//������ ���� �߻� - ��û ó�� �޼ҵ� ��ȣ��
			throw new BadRequestException("���������� ������� �������� ��û �Ͽ����ϴ�.");
		}
		
		return true;
	}
	
	//postHandle �޼ҵ� : ��û ó�� �޼ҵ尡 ȣ��Ǿ� ����� �� ��ȯ�� ���̸����� ViewResolver
	//��ü�� ��(View)�� �����ϱ� ���� ����� ����� �ۼ��ϴ� �޼ҵ�
	// => ModelAndView ��ü�� �����޾� ViewName �Ǵ� �Ӽ����� ����(����)�ϱ� ���� ��� 
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	//afterCompletion �޼ҵ� : ��û ó�� �޼ҵ尡 ȣ��Ǿ� ����� �� ��ȯ�� ���̸����� ViewResolver
	//��ü�� ��(View)�� �����ϱ� �Ŀ� ����� ����� �ۼ��ϴ� �޼ҵ�
	// => ��(View)�� �����ϱ� ���� ���
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
}


