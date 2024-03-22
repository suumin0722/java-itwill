package xyz.itwill06.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

//Advice Ŭ������ �޼ҵ忡 AOP ���� ������̼��� ����Ͽ� AOP ���� ����
// => Spring Bean Configuration File�� aspectj-autoproxy ������Ʈ ����

@Slf4j
@Component
//@Aspect : �ٽɰ����ڵ忡 Ⱦ�ܰ����ڵ带 �����Ͽ� �����ϱ� ���� ����� �����ϴ� ������̼�
// => Spring Bean Configuration File�� aspect ������Ʈ�� ������ ��� ����
@Aspect
public class AopAnnotationAdvice {
	//@Pointcut : Ÿ�ٸ޼ҵ带 �����ϱ� ���� ������̼�
	// => Spring Bean Configuration File�� pointcut ������Ʈ�� ������ ��� ����
	// => �޼ҵ带 ȣ���Ͽ� Pointcut ǥ�������� ������ Ÿ�ٸ޼ҵ带 �����޾� ���
	//value �Ӽ� : Ÿ�ٸ޼ҵ带 �����ϱ� ���� Pointcut ǥ������ �Ӽ������� ����
	// => value �Ӽ��ܿ� �ٸ� �Ӽ��� ���� ��� �Ӽ����� ���� ����
	@Pointcut("within(xyz.itwill06.aop.AopAnnotationBean)")
	public void aopPointcut() {}
	
	//@Before : Ÿ�ٸ޼ҵ��� ���(�ٽɰ����ڵ�)�� ����Ǳ� ���� ���ԵǾ� ����� Ⱦ�ܰ����ڵ带
	//�����ϱ� ���� ������̼�
	// => Spring Bean Configuration File�� before ������Ʈ�� ������ ��� ����
	//value �Ӽ� : Ÿ�ٸ޼ҵ带 �����ϱ� ���� Pointcut ǥ������ �Ӽ������� ����
	// => @Pointcut ������̼����� ������ Pointcut �޼ҵ带 ȣ���Ͽ� Pointcut ǥ������ �����޾� 
	//Ÿ�ٸ޼ҵ�� ���� ����
	// => value �Ӽ��ܿ� �ٸ� �Ӽ��� ���� ��� �Ӽ����� ���� ����
	//@Before("within(xyz.itwill06.aop.AopAnnotationBean)")
	@Before("aopPointcut()")
	public void beforeLog() {
		log.info("[before]�ٽɰ����ڵ� ���� ���� ���ԵǾ� ����� Ⱦ�ܰ����ڵ�");
	}
	
	//@After : Ÿ�ٸ޼ҵ��� ���(�ٽɰ����ڵ�)�� ����� �Ŀ� ���� �߻��� ������� ������ 
	//���ԵǾ� ����� Ⱦ�ܰ����ڵ带 �����ϱ� ���� ������̼�
	// => Spring Bean Configuration File�� after ������Ʈ�� ������ ��� ����
	@After("aopPointcut()")
	public void afterLog() {
		log.info("[after]�ٽɰ����ڵ� ���� �Ŀ� ������ ���ԵǾ� ����� Ⱦ�ܰ����ڵ�");
	}

	//@AfterReturning : Ÿ�ٸ޼ҵ��� ���(�ٽɰ����ڵ�)�� ���� �߻� ���� ���������� ����� �Ŀ�  
	//���ԵǾ� ����� Ⱦ�ܰ����ڵ带 �����ϱ� ���� ������̼�
	// => Spring Bean Configuration File�� after-returning ������Ʈ�� ������ ��� ����
	//returning �Ӽ� : Ÿ�ٸ޼ҵ��� ��ȯ���� �����޾� ������ �Ű������� �̸��� �Ӽ������� ����
	@AfterReturning(value = "aopPointcut()", returning = "returnValue")
	public void afterReturningLog(Object returnValue) {
		log.info("[after-returning]�ٽɰ����ڵ尡 ���������� ����� �Ŀ� ���ԵǾ� ����� Ⱦ�ܰ����ڵ�");
	}

	//@AfterThrowing : Ÿ�ٸ޼ҵ��� ���(�ٽɰ����ڵ�)�� ����Ǹ鼭 ���ܰ� �߻��Ǹ� ���ԵǾ�
	//����� Ⱦ�ܰ����ڵ带 �����ϱ� ���� ������̼�
	// => Spring Bean Configuration File�� after-throwing ������Ʈ�� ������ ��� ����
	//throwing �Ӽ� : Ÿ�ٸ޼ҵ忡�� ���ܸ� �����޾� ������ �Ű������� �̸��� �Ӽ������� ����
	@AfterThrowing(value = "aopPointcut()", throwing = "exception")
	public void afterThrowingLog(Exception exception) {
		log.info("[after-throwing]�ٽɰ����ڵ� ����� ���ܰ� �߻��� �� ���ԵǾ� ����� Ⱦ�ܰ����ڵ�");
	}
	
	@Around("aopPointcut()")
	public Object aroungLog(ProceedingJoinPoint joinPoint) throws Throwable {
		log.info("[around]�ٽɰ����ڵ� ���� ���� ���ԵǾ� ����� Ⱦ�ܰ����ڵ�");
		Object result=joinPoint.proceed();
		log.info("[around]�ٽɰ����ڵ� ���� �Ŀ� ���ԵǾ� ����� Ⱦ�ܰ����ڵ�");
		return result;
	}
}