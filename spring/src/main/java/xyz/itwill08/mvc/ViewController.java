package xyz.itwill08.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Ŭ���̾�Ʈ�� [/view.itwill]�� URL �ּҷ� ��û�� ��� ��Ʈ�ѷ��� ���� ����� Ŭ����
public class ViewController implements Controller { 

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Member member=new Member("test258", "������", "����� ���α�");
		request.setAttribute("member", member);
		return "member_view";
	}
	
}
