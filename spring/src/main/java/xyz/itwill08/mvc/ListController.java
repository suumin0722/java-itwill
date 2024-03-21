package xyz.itwill08.mvc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//��(Model) : Ŭ���̾�Ʈ�� ��û�� ó���ϱ� ���� ����� �����ϱ� ���� Ŭ����

//�� ����� �����ϱ� ���� Ŭ���� - �������̽��� ��ӹ޾� �ۼ�
//=> Ŭ���̾�Ʈ�� ��û�� �ϳ��� Ŭ������ ó���ǵ��� �ۼ� - Command Pattern
//Ŭ���̾�Ʈ�� [/list.itwill]�� URL �ּҷ� ��û�� ��� ��Ʈ�ѷ��� ���� ����� Ŭ����
public class ListController implements Controller {
	//��û ó�� �޼ҵ� : Ŭ���̾�Ʈ�� ��û�� ó���ϱ� ���� ����� �ۼ��� �޼ҵ�
	// => ������ ��(View - JSP)�� �̸�(ViewName)�� ��ȯ
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//��û ó�� ��� �ۼ� - ����Ÿ ó�� ��� : Service Ŭ������ �޼ҵ� ȣ��
		List<Member> memberList=new ArrayList<Member>();
		memberList.add(new Member("abc123", "ȫ�浿", "����� ������"));
		memberList.add(new Member("opq456", "�Ӳ���", "��õ�� ���̱�"));
		memberList.add(new Member("xyz789", "����ġ", "������ �ȴޱ�"));
		
		//��û�� ���� ó������� ��(View)���� �����ϱ� ���� request ��ü�� �Ӽ������� ����
		request.setAttribute("memberList", memberList);
		
		return "member_list";
	}

}
