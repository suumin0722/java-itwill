package xyz.itwill06.aop;

import org.aspectj.lang.ProceedingJoinPoint;

//Ⱦ�ܰ��ɸ��(CrossCutting Concern Module) : Ⱦ�ܰ����ڵ��� �޼ҵ尡 �ۼ��� Ŭ���� - Advice Ŭ����
// => Ⱦ�ܰ����ڵ� : ����Ÿ ó�� ����� ������ �������� ����� �����ϴ� ���
// => �α� ó��, ����(����) ó��, Ʈ������ ó��, ���� ó�� ���� ���
public class HewonAdvice {
	//Ÿ�� �޼ҵ�(Target Method) : �ٽɰ��ɸ���� �޼ҵ� �� PointCut ���� �����Ǿ�
	//Ⱦ�ܰ����ڵ尡 ���Ե� ����� �޼ҵ�
	// => PointCut ��� : �ٽɰ��ɸ���� �޼ҵ� �� Ư�� �޼ҵ常�� �����ϱ� ���� ���
	
	//Ÿ�� �޼ҵ��� ��� �������� ���ԵǾ� ����� ����� �ۼ��� �޼ҵ� - Before Advice Method
	// => JoinPoint : �ٽɰ����ڵ带 �������� Ⱦ�ܰ����ڵ尡 ���ԵǾ� ����� ��ġ
	public void beforeLog() {
		System.out.println("### [before]�ٽɰ����ڵ� ���� ���� ���ԵǾ� ����� Ⱦ�ܰ����ڵ� ###");
	}
	
	//
	//
	public void afterLog() {
		System.out.println("### [after]�ٽɰ����ڵ� ���� �Ŀ� ������ ���ԵǾ� ����� Ⱦ�ܰ����ڵ� ###");
	}
	
	public void afterReturningLog() {
		System.out.println("### [after-returning]�ٽɰ����ڵ尡 ���������� ����� �Ŀ� ���ԵǾ� ����� Ⱦ�ܰ����ڵ� ###");
	}
	
	public void afterThrowingLog() {
		System.out.println("### [after-throwing]�ٽɰ����ڵ尡 ����� �� ���ܰ� �߻��� �Ŀ� ���ԵǾ� ����� Ⱦ�ܰ����ڵ� ###");
	}
	
	public Object aroundLog(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("### [around]�ٽɰ����ڵ尡 ���� ���� ���ԵǾ� ����� Ⱦ�ܰ����ڵ� ###");
		Object result = joinPoint.proceed();
		System.out.println("### [around]�ٽɰ����ڵ尡 ���� �Ŀ� ���ԵǾ� ����� Ⱦ�ܰ����ڵ� ###");
		return result;
	}
} 