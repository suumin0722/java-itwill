package xyz.itwill09.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import xyz.itwill09.dto.Userinfo;
import xyz.itwill09.exception.BadRequestException;

//������ ���� ���� ó���� ���� �ۼ��� ���ͼ��� Ŭ����
//=> ��û ó�� �޼ҵ� ȣ�� ���� ��α��� ����� �Ǵ� �Ϲ�ȸ���� �������� ��û�� ��� ������ ���� �߻�
public class AdminAuthInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session=request.getSession();
		
		Userinfo loginUserinfo=(Userinfo)session.getAttribute("loginUserinfo");
		
		if(loginUserinfo == null || loginUserinfo.getStatus() != 9) {
			throw new BadRequestException("���������� ������� �������� ��û �Ͽ����ϴ�.");
		}
		
		return true;
	}
}