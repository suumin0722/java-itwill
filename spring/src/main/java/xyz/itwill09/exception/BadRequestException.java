package xyz.itwill09.exception;

//������������ �������� ��û�� ��쿡 ���� ������ �����Ͽ� ó���ϱ� ���� ����Ŭ����
public class BadRequestException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public BadRequestException() {
		// TODO Auto-generated constructor stub
	}
	
	public BadRequestException(String message) {
		super(message);
	}
}