package xyz.itwill09.dto;

import lombok.Builder;
import lombok.Data;

//DTO Ŭ���� : DAO Ŭ����(Service Ŭ���� �Ǵ� Controller Ŭ����)�� �޼ҵ忡�� ���� ���޹ްų� ��ȯ�ϱ� ���� Ŭ����
// => ���̺��� ���� Java Ŭ������ ǥ���Ͽ� ��ü�� �����ϱ� ���� �ۼ�
//�˻����� �÷���� ���� �̸����� Ŭ������ �ʵ带 �ۼ��ϴ� ���� ���� - �ڵ� ���� ����ϱ� ����
@Data
@Builder
public class Student {
	private int no;
	private String name;
	private String phone;
	private String address;
	private String birthday;
}
