package xyz.itwill09.exception;

//ȸ�������� ���� ����, ����, �˻��� �� ����ڷκ��� ���޹��� ���̵��� ȸ�������� ���� ��쿡 ���� ������ 
//���� ������ �����Ͽ� ó���ϱ� ���� ����Ŭ����
public class UserinfoNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public UserinfoNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	
	public UserinfoNotFoundException(String message) {
		super(message);
	}
}