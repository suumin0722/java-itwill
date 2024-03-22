package xyz.itwill02.factory;

public class MessagePrintObject {
	public void messagePrint() {
		// ��ü�� ���� �����Ͽ� �޼ҵ� ȣ�� - ��ü���� ���յ��� ���� ���������� ȿ���� ����
		// MessageObject object=new HelloMessageObject();

		// ���α׷� ���࿡ �ʿ��� ��ü�� Factory Ŭ�����κ��� ��ȯ�޾� �޼ҵ� ȣ��
		// => ������ ����(IoC)�� ����Ͽ� ��ü���� ���յ��� ���� ���������� ȿ���� ����
		// MessageObject object = MessageObjectFactory.getmeMessageObject();

		//MessageObject object=MessageObjectFactory.getMessageObject(MessageObjectFactory.HELLO_MSG);
		MessageObject object = MessageObjectFactory.getMessageObject(MessageObjectFactory.HI_MSG);

		String message = object.getMessage();
		System.out.println("message = " + message);
	}
}
