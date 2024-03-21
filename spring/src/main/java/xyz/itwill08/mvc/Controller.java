package xyz.itwill08.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//��û ó�� Ŭ����(Model)�� �ݵ�� ��ӹ޾ƾ� �ϴ� �������̽�
// => ��� ��û ó�� Ŭ������ �޼ҵ尡 �����ϰ� �ۼ��ǵ��� ��Ģ ����
// => ��Ʈ�ѷ����� ��û ó�� Ŭ������ ��ü�� �޼ҵ带 ���� ȣ���ϱ� ���� �������̽� �ʵ�
public interface Controller {
	//��û ó�� �޼ҵ带 �߻�޼ҵ�� �ۼ�
	String handleRequest(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException;
}
