package xyz.itwill09.dto;

import lombok.Builder;
import lombok.Data;

//DTO Ŭ���� : DAO Ŭ������ �޼ҵ忡�� ���� ���޹ްų� ��ȯ�ϱ� ���� Ŭ����
// => ���̺��� ���� Java Ŭ������ ǥ���Ͽ� ��ü�� �����ϱ� ���� �ۼ�
@Data
@Builder
public class Student {
	private int no;
	private String name;
	private String phone;
	private String address;
	private String birthday;
}
