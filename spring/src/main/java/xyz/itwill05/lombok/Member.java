package xyz.itwill05.lombok;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//Ŭ���� �ۼ��� �ʿ��� �޼ҵ带 �ڵ����� �������ִ� Lombok ���̺귯���� ����ϴ� ���
//1.Lombok ���̺귯���� ������Ʈ ���� ó�� - ���̺� ��� : pom.xml
//2.��Ŭ����(STS)�� �����ϰ� �ܼ�(cmd)�� ������ �������� ������ �� Lombok ���̺귯�� ������
//����� ���� �����(Local Repository - ����� ������ .m2 ����)�� ������ �̵�
//3.�ֿܼ��� Jar ���α׷��� �����Ͽ� Lombok ���̺귯���� ��Ŭ�������� ����� �� �ֵ��� ����
// => Jar ���α׷� ���� ��� : java -jar lombok=1.18.30.jar
// => Ž���⿡�� ���� �������� ������ �̵��Ͽ� Lombok ���̺귯�� ����(Jar)�� ����Ŭ���Ͽ� ���� ���
//4.Jar ���α׷��� ������ ������ ��ġâ(Installer)���� Lombok ���̺귯���� ����� ��Ŭ����(STS)��
//�����Ͽ� Lombok ���̺귯�� ��ġ
// => ��Ŭ����(STS)�� �ڵ����� ã�� �� ���� ��� ��Ŭ����(STS)�� ��ġ�� ������ �����Ͽ� Lombok ��ġ
//5.��Ŭ����(STS)�� ��ġ�� ������ �̵��Ͽ� STS.ini ������ �����Ͽ� �����ϰ� ��Ŭ����(STS) ����
// => [-javaagent:lombok.jar] ���� - lombok.jar ������ ��θ� �����ο��� ����η� ����
//6.��Ŭ����(STS)���� Lombok ���̺귯���� �����ϴ� ������̼��� ����Ͽ� Ŭ���� �ۼ�
// => @AllArgsConstructor, @NoArgsConstructor, @RequiredArgsConstructor, @Setter, @Getter, @ToString �� 

//@NoArgsConstructor : �Ű������� ���� �⺻ �����ڸ� �����ϱ� ���� ������̼�
//@AllArgsConstructor : ��� �ʵ带 �ʱ�ȭ ó���ϱ� ���� �Ű������� �ۼ��� �����ڸ� �����ϱ� ���� ������̼�
//@RequiredArgsConstructor : final �����ڸ� ����� �ʵ常 �ʱ�ȭ ó���ϱ� ���� �Ű������� �ۼ��� 
//�����ڸ� �����ϱ� ���� ������̼�
// => @NoArgsConstructor ������̼ǰ� ���� ����� ��� ���� �߻�
//@Setter : Ŭ������ �ۼ��� ��� �ʵ忡 ���� Setter �޼ҵ带 �����ϱ� ���� ������̼�
// => �ʵ忡 @Setter ������̼��� ����Ͽ� �ش� �ʵ忡 ���� Setter �޼ҵ常 ���� ����
//@Getter : Ŭ������ �ۼ��� ��� �ʵ忡 ���� Getter �޼ҵ带 �����ϱ� ���� ������̼�
//=> �ʵ忡 @Getter ������̼��� ����Ͽ� �ش� �ʵ忡 ���� Getter �޼ҵ常 ���� ����
//@ToString : Ŭ������ toString() �޼ҵ带 �������̵� ����ǵ��� �����ϱ� ���� ������̼�
// => Ŭ������ �ۼ��� ��� �ʵ尪�� �����Ͽ� ���ڿ��� ��ȯ�ϴ� ��� ���� - �ʵ尪 Ȯ��
//@Data : Setter �޼ҵ�, Getter �޼ҵ�, toString �޼ҵ�, equals �޼ҵ�, hashCode �޼ҵ带 
//�����ϱ� ���� ������̼� - VO Ŭ����(��ü�� ������ �񱳵ǵ��� �ۼ��� Ŭ����)�� ������ �� ���
//@Builder : Ŭ������ Builder Ŭ������ Builder Ŭ���� ���� �޼ҵ带 �����ϴ� ������̼�
// => Builder Ŭ���� : ��ü ������ ��ü �ʵ忡 �ʿ��� ���� �����ϱ� ���� �޼ҵ带 �����ϴ� Ŭ����
// => Builder Ŭ������ �޼ҵ带 ȣ���Ͽ� ��ü �ʵ忡 �ʿ��� ���� ����ǵ��� ����
// => �ʿ��� �ʵ常 �ʱ�ȭ ó���� �� �־� ������ ���� �������� ������ �ʵ��� ������ �������
//�ʵ� �ʱ�ȭ �۾��� ��
//@Slf4j : �α� �̺�Ʈ�� �߻��� �� �ִ� Logger ��ü�� ����� log �ʵ带 �����ϱ� ���� ������̼�

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Member {
	private String id;
	private String name;
	private String email;
}