package xyz.itwill09.exception;

import lombok.Getter;

//�α��� ó���� ����ڷκ��� �Է¹��� ���̵�� ��й�ȣ�� ���� ������ ������ ��쿡 
//���� ������ �����Ͽ� ó���ϱ� ���� ����Ŭ����
public class LoginAuthFailException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	@Getter
	private String userid;
	
	public LoginAuthFailException() {
		// TODO Auto-generated constructor stub
	}
	
	public LoginAuthFailException(String message, String userid) {
		super(message);
		this.userid=userid;
	}
}