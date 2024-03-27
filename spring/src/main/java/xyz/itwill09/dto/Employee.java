package xyz.itwill09.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class Employee {
	//@NotNull : ���ް��� [null]�� ��� ������ �߻��ϴ� ������̼�
	//@NotBlank : ���ް��� [null]�̰ų� ���ް��� ������ �ִ� ��� ������ �߻��ϴ� ������̼�
	//@NotEmpty : ���ް��� [null]�̰ų� [""]�� ��� ������ �߻��ϴ� ������̼�
	//message �Ӽ� : �信�� ������ �����޼����� �Ӽ������� ����
	// => message �Ӽ��� ������ ��� �⺻������ ������ �����޼��� ����
	//@NotEmpty(message = "���̵� �ݵ�� �Է��� �ּ���.")
	//@Size : ���ް��� ũ��(���ڰ���)�� ���Ͽ� ������ �߻��ϴ� ������̼�
	//min �Ӽ� : ���ް��� �ּ� ũ�⸦ �Ӽ������� ����
	//max �Ӽ� : ���ް��� �ִ� ũ�⸦ �Ӽ������� ����
	//@Size(min = 6, max = 20, message = "���̵�� �ּ� 6�� �̻� �ִ� 20�� ���Ϸθ� �Է��� �ּ���.")
	@Pattern(regexp = "^[a-zA-Z]\\w{5,19}$", message = "���̵� ���Ŀ� �°� �Է��� �ּ���.")
	private String id;
	//@NotEmpty(message = "��й�ȣ�� �Է��� �ּ���.")
	@Pattern(regexp = "(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[~!@#$%^&*_-]).{6,20}$", message = "��й�ȣ�� ���Ŀ� �°� �Է��� �ּ���.")
	private String passwd;
	@NotEmpty(message = "�̸��� �Է��� �ּ���.")
	private String name;
	@NotEmpty(message = "�̸����� �Է��� �ּ���.")
	//@Pattern(regexp = "^([a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+(\\.[-a-zA-Z0-9]+)+)*$", message = "�̸����� ���Ŀ� �°� �Է��� �ּ���.")
	//@Email : �̸��� ������ Ʋ�� ��� ������ �߻��ϴ� ������̼�
	@Email(message = "�̸����� ���Ŀ� �°� �Է��� �ּ���.")
	private String email;
	@NotEmpty(message = "������ �Է��� �ּ���.")
	private String gender;
}









