package xyz.itwill06.oop;

//�ٽɰ����ڵ��� �޼ҵ尡 �ۼ��� Ŭ���� - �ٽɰ��ɸ��
// => Ⱦ�ܰ����ڵ尡 ���Ե� �޼ҵ�(Ÿ�ٸ޼ҵ�)�� �������̽��� ��ӹ޾� �ۼ� 
public class AopOne implements Aop {
	@Override
	public void display1() {
		//�ٽɰ����ڵ�
		System.out.println("*** AopOne Ŭ������ display1() �޼ҵ� ȣ�� ***");
	}
	
	@Override
	public void display2() {
		System.out.println("*** AopOne Ŭ������ display2() �޼ҵ� ȣ�� ***");
	}
	
	@Override
	public void display3() {
		System.out.println("*** AopOne Ŭ������ display3() �޼ҵ� ȣ�� ***");
	}
}