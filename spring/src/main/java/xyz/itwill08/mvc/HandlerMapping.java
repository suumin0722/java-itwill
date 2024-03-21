package xyz.itwill08.mvc;

import java.util.HashMap;
import java.util.Map;

//Ŭ���̾�Ʈ�� ��û����(Command)�� ��û ó�� Ŭ����(Model)�� ��ü�� �����ϱ� ���� Ŭ����
public class HandlerMapping {
	//Map ��ü�� �����ϱ� ���� �ʵ�
	// => Map ��ü�� ����� ��Ʈ��(Entry)�� ��Ű�� ��û������ �����ϱ� ���� String Ŭ������ ���׸� 
	//�����ϰ� �ʰ��� ��û ó�� Ŭ������ ��ü�� �����ϱ� ���� Controller �������̽��� ���׸� ����
	private Map<String, Controller> mappings;
	
	//�����ڸ� ����Ͽ� �ʵ忡 Map ��ü�� �����Ͽ� �����ϰ� Map ��ü�� ��Ʈ�� �߰��ϵ��� ó��
	public HandlerMapping() {
		mappings=new HashMap<String, Controller>();
		mappings.put("/list.itwill", new ListController());
		mappings.put("/view.itwill", new ViewController());
	}
	
	//Ŭ���̾�Ʈ�� ��û������ ���޹޾� ��û ó�� Ŭ������ ��ü�� ��ȯ�ϴ� �޼ҵ�
	public Controller getController(String command) {
		return mappings.get(command);
	}
}