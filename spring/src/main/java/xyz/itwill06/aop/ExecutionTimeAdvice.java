package xyz.itwill06.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class ExecutionTimeAdvice {
	/*
	//Ÿ�ٸ޼ҵ��� ����� ����Ǵ� �ð��� �����Ͽ� ����ϱ� ���� �޼ҵ� - Around Advice Method
	public Object timeWatchLog(ProceedingJoinPoint joinPoint) throws Throwable {
		
		//�ٽɰ����ڵ� ���� ���� ���ԵǾ� ����� Ⱦ�ܰ����ڵ� �ۼ�
		long startTime=System.currentTimeMillis();
		
		//�ٽɰ��ɸ���� �޼ҵ�(Ÿ�ٸ޼ҵ� - �ٽɰ����ڵ�)�� ȣ���Ͽ� ������� ��ȯ�޾� ����
		Object result=joinPoint.proceed();
		
		//�ٽɰ����ڵ� ���� �Ŀ� ���ԵǾ� ����� Ⱦ�ܰ����ڵ� �ۼ�
		long endTime=System.currentTimeMillis();
		
		String className=joinPoint.getTarget().getClass().getSimpleName();
		String methodName=joinPoint.getSignature().getName();
		
		System.out.println(className+" Ŭ������ "+methodName+"() �޼ҵ� ���� �ð� = "
						+(endTime-startTime)+"ms");
						
		return result;
	}
	*/
	
	public Object timeWatchLog(ProceedingJoinPoint joinPoint) throws Throwable {
		//�ٽɰ����ڵ� ���� ���� ���ԵǾ� ����� Ⱦ�ܰ����ڵ� �ۼ�
		//StopWatch Ŭ���� : �ð��� �����ϱ� ���� ����� �����ϴ� Ŭ����
		StopWatch stopWatch=new StopWatch();
		
		//StopWatch.start() : �ð� ������ �����ϴ� �޼ҵ�
		stopWatch.start();
		
		//�ٽɰ��ɸ���� �޼ҵ�(Ÿ�ٸ޼ҵ� - �ٽɰ����ڵ�)�� ȣ���Ͽ� ������� ��ȯ�޾� ����
		Object result = joinPoint.proceed();

		//�ٽɰ����ڵ� ���� �Ŀ� ���ԵǾ� ����� Ⱦ�ܰ����ڵ� �ۼ�
		//StopWatch.stop() : �ð� ������ �����ϴ� �޼ҵ�
		stopWatch.stop();

		String className = joinPoint.getTarget().getClass().getSimpleName();
		String methodName = joinPoint.getSignature().getName();
		
		//StopWatch.getTotalTimeMillis() : ������ �ð��� ms ������ ��ȯ�ϴ� �޼ҵ�
		System.out.println(className + " Ŭ������ " + methodName + "() �޼ҵ� ���� �ð� = " + stopWatch.getTotalTimeMillis() + "ms");
		
		return result;
	}
}
