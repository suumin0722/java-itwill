package xyz.itwill09.dto;

import lombok.Data;

//ȸ�������� �����ϱ� ���� Ŭ���� - VO Ŭ���� >> DTO Ŭ����
// => DAO Ŭ�������� ������ ������ �������� �ۼ��� Ŭ����
// => ������ ��û�� ���ް��� ������ �������� ��� - ���ް��� �̸��� �ʵ��� �̸��� ������ �ۼ�
@Data
public class Member {
	private String id;
	private String passwd;
	private String name;
	private String email;
}