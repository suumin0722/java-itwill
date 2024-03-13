package xyz.itwill02.factory;

//Factory ������ ������ �����Ͽ� �ۼ��� Ŭ���� - Factory Ŭ����
//=> ���α׷� ���߿� �ʿ��� ��ü�� �����Ͽ� �����ϴ� Ŭ����
//=> IoC(Inversion of Control)����� Ŭ����
public class MessageObjectFactory {
	// Factory Ŭ������ ���� ������ ��ü�� �����ϱ� ���� ���(Constant)
	public static final int HELLO_MSG = 1;
	public static final int HI_MSG = 2;
	
	//�������̽��� ��ӹ��� �ڽ�Ŭ������ ��ü�� �����Ͽ� ��ȯ�ϴ� ���� �޼ҵ�
	public static MessageObject getMessageObject(int message) {
		// MessageObject object=new HelloMessageObject();
		//MessageObject object = new HiMessageObject();

		MessageObject object=null;
		switch (message) {
		case HELLO_MSG: 
			object=new HelloMessageObject();
			break;
		case HI_MSG: 
			object=new HiMessageObject();
			break;
		}
		
		return object;
	}
}