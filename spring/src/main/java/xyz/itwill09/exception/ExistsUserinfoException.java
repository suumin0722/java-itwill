package xyz.itwill09.exception;

import lombok.Getter;
import xyz.itwill09.dto.Userinfo;

//ȸ�������� ����� �� ����ڷκ��� �Է¹��� ȸ�������� ���̵� ���� ȸ�������� ���̵��
//�ߺ��� ��쿡 ���� ������ ���� ������ �����Ͽ� ó���ϱ� ���� ����Ŭ���� 
public class ExistsUserinfoException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	//����ó���� �ʿ��� ���� �����ϱ� ���� �ʵ� - ����ڷκ��� �Էµ� ȸ�������� �ʵ忡 ����
	@Getter
	private Userinfo userinfo;
	
	public ExistsUserinfoException() {
		// TODO Auto-generated constructor stub
	}
	
	public ExistsUserinfoException(String message, Userinfo userinfo) {
		super(message);
		this.userinfo=userinfo;
	}
}