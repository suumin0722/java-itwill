package xyz.itwill06.aop;

import org.aspectj.lang.JoinPoint;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmailSendAdvice {
	//���� ���� ���� ���ԵǾ� ����� ����� �ۼ��� �޼ҵ� - Before Advice Method
	// => �޴� ����� �̸��� �ּҿ� ������ Ÿ�ٸ޼ҵ��� �Ű������� �����޾� ����ϴ� ��� �ۼ�
	public void accessLog(JoinPoint joinPoint) {
		//Ÿ�ٸ޼ҵ��� �Ű������� ����� ���� ����� �̸��� �ּҸ� ��ȯ�޾� ����
		String email=(String)joinPoint.getArgs()[0];
		//Ÿ�ٸ޼ҵ��� �Ű������� ����� �̸��� ������ ��ȯ�޾� ����
		String subject=(String)joinPoint.getArgs()[1];
		log.info(email+"�Կ��� <"+subject+"> ������ �̸����� �����մϴ�.");
	}
	
	//���� ���� ���� �� ���ԵǾ� ����� ����� �ۼ��� �޼ҵ� - After Returning Advice Method
	// => �޴� ����� �̸��� �ּҸ� Ÿ�ٸ޼ҵ��� ��ȯ������ �����޾� ����ϴ� ��� �ۼ�
	public void successLog(String email) {
		log.info(email+"�Կ��� �̸����� ���������� ���� �Ͽ����ϴ�.");
	}
	
	//���� ���� ���� �� ���ԵǾ� ����� ����� �ۼ��� �޼ҵ� - After Throwing Advice Method
	// => ���� ���� ���п� ���� ���ܸ� Ÿ�ٸ޼ҵ�� �����޾� ����ϴ� ��� �ۼ� 
	public void errorLog(Exception exception) {
		log.info("�̸��� ���� ���� = "+exception.getMessage());
	}
}