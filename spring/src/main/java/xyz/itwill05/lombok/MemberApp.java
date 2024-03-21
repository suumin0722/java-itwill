package xyz.itwill05.lombok;

public class MemberApp {
	public static void main(String[] args) {
		Member member1=new Member("abc123", "ȫ�浿", "abc@itwill.xyz");
		
		System.out.println("���̵� = "+member1.getId());
		System.out.println("�̸� = "+member1.getName());
		System.out.println("�̸��� = "+member1.getEmail());
		System.out.println("==============================================================");
		//Member ��ü�� ����� ���������� ����� ��� �ڵ����� Member Ŭ������ toString() �޼ҵ� ȣ��
		// => Lombok ���̺귯���� ���� ������ toString() �޼ҵ�� ��� �ʵ尪�� ���ڿ��� �����Ͽ� ��ȯ
		System.out.println(member1);
		System.out.println("==============================================================");
		//Ŭ����.builder() : Ŭ���� ���ο� ����� Builder Ŭ����(���� ���� Ŭ����)�� ��ü�� 
		//�����Ͽ� ��ȯ�ϴ� ���� �޼ҵ�
		// => Builder Ŭ������ �ʵ��� ���� �̸��� �޼ҵ带 Builder ��ü�� ȣ���Ͽ� �ʵ尪��
		//����� Builder ��ü ��ȯ
		//Builder.build() : �ܺ� Ŭ������ ��ü�� �����Ͽ� Builder ��ü�� ����� �ʵ尪����
		//�ʵ� �ʱ�ȭ ó���� �ܺ� Ŭ������ ��ü�� ��ȯ�ϴ� �޼ҵ�
		Member member2=Member.builder()
				.id("xyz789")
				.name("�Ӳ���")
				.email("xyz@itwill.xyz")
				.build();
		
		System.out.println(member2);
		System.out.println("==============================================================");
	}
}









