package xyz.itwill08.mvc;

//���� ó���ϱ� ���� �������� �����ϴ� ����� Ŭ����
public class ViewResolver {
	//�Ű������� ���޹��� ���̸����� ���� ó���� JSP ������ ��θ� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
	public String getView(String viewName) {
		return "/WEB-INF/mvc/"+viewName+".jsp";
	}
}