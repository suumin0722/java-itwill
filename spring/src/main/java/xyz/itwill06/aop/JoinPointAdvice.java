package xyz.itwill06.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

//Ⱦ�ܰ��ɸ��
public class JoinPointAdvice {
	//Around Advice Method�� ������ ������ Advice Method�� �Ϲ������� ��ȯ���� [void]�� �ۼ��ϰ�
	//�Ű������� �ۼ����� �ʰų� JoinPoint �������̽��� �ڷ������� ����ϴ� �Ű����� �ۼ� ����
	// => Advice Ŭ������ �޼ҵ带 ��Ģ�� ���� �ʰ� �ۼ��� ��� IllegalArgumentException �߻�
	//JoinPoint ��ü : Ÿ�ٸ޼ҵ� ���� ������ ����� ��ü
	// => AspectJ �����Ϸ��� ���� Advice Ŭ������ �޼ҵ尡 ȣ��� �� Ÿ�ٸ޼ҵ� ���� ������ ������
	//JoinPoint ��ü�� �Ű������� �����Ͽ� ����
	// => Advice Ŭ������ �޼ҵ忡�� Ÿ�ٸ޼ҵ� ���� ������ �ʿ��� ��� �Ű������� �����Ͽ�
	//JoinPoint ��ü�� ���޹޾� JoinPoint ��ü�� �޼ҵ带 ȣ���Ͽ� ��� ����
	
	public void beforeDisplay(JoinPoint joinPoint) {//Before Advice Method
		//System.out.println("### [before]�ٽɰ����ڵ� ���� ���� ���ԵǾ� ����� Ⱦ�ܰ����ڵ� ###");
		
		//JoinPoint.getTarget() : Ÿ�ٸ޼ҵ带 ȣ���� ��ü(�ٽɰ��ɸ�� - Spring Bean)�� ��ȯ�ϴ� �޼ҵ�
		// => Object Ÿ���� ��ü ��ȯ
		//Object.getClass() : ��ü�� ������ Ŭ������ Class ��ü�� ��ȯ�ϴ� �޼ҵ�
		//Class.getName() : Class ��ü�� Ŭ����(��Ű�� ����)�� ���ڿ��� ��ȯ�ϴ� �޼ҵ� 
		//System.out.println(joinPoint.getTarget().getClass().getName());
		//Class.getSimpleName() : Class ��ü�� Ŭ����(��Ű�� ������)�� ���ڿ��� ��ȯ�ϴ� �޼ҵ� 
		//System.out.println(joinPoint.getTarget().getClass().getSimpleName());
		
		//JoinPoint.getSignature() : Ÿ�ٸ޼ҵ��� ������ ����� Signature ��ü�� ��ȯ�ϴ� �޼ҵ�
		//Signature.getName() : Ÿ�ٸ޼ҵ��� �̸��� ��ȯ�ϴ� �޼ҵ�
		//System.out.println(joinPoint.getSignature().getName());
		
		//JoinPoint.getArgs() : Ÿ�ٸ޼ҵ��� �Ű������� ����� ��� ��(��ü)�� Object �迭�� ��ȯ�ϴ� �޼ҵ�
		//System.out.println(joinPoint.getArgs());
		
		String className=joinPoint.getTarget().getClass().getSimpleName();
		String methodName=joinPoint.getSignature().getName();
		Object[] params=joinPoint.getArgs();
		
		System.out.print("### [before]"+className+" Ŭ������ "+methodName+"(");
		for(int i=0;i<params.length;i++) {
			System.out.print(params[i]);
			if(i < params.length-1) {
				System.out.print(", ");
			}
		}
		System.out.println(") �޼ҵ� ȣ�� ###");
	}
	
	public void displayMessage(JoinPoint joinPoint) {//After Advice Mehtod
		//System.out.println("### [after]�ٽɰ����ڵ� ���� �Ŀ� ������ ���ԵǾ� ����� Ⱦ�ܰ����ڵ� ###");
		
		Object[] params=joinPoint.getArgs();
		System.out.println("### [after]�����ȣ�� "+params[0]+"�� ��������� ���� �Ͽ����ϴ�.");
	}
	
	//After Returning Advice Mehtod���� JoinPoint �������̽��� �Ű������ܿ� Object Ŭ������
	//�Ű����� �ۼ� ����
	// => AspectJ �����Ϸ��� Object Ŭ������ �Ű������� Ÿ�ٸ޼ҵ��� ��ȯ���� �����޾� ����
	// => Ÿ�ٸ޼ҵ忡�� ��ȯ�Ǵ� ��(��ü)�� �ڷ����� �����Ǿ� �ִ� ��� Object Ŭ���� ���
	//��ȯ�Ǵ� ��(��ü)�� �ڷ������� �Ű����� �ۼ� ����
	// => After Returning Advice Mehtod�� Object Ŭ������ �Ű������� �ۼ��� ��� Spring Bean
	//Configuration File�� AOP �������� after-returning ������Ʈ�� returning �Ӽ��� �ݵ��
	//�ۼ��Ͼ� Ÿ�ٸ޼ҵ��� ��ȯ���� ������ �Ű������� ���� 
	// => after-returning ������Ʈ�� returning �Ӽ��� ���ų� �Ӽ����� �߸� �����Ǹ� IllegalArgumentException �߻�
	public void displayName(JoinPoint joinPoint, Object object) {//After Returning Advice Mehtod
		//System.out.println("### [after-returning]�ٽɰ����ڵ尡 ���������� ����� �Ŀ� ���ԵǾ� ����� Ⱦ�ܰ����ڵ� ###");

		String methodName=joinPoint.getSignature().getName();
		String userName=(String)object;
		System.out.println("### [after-returning]"+methodName+" �޼ҵ��� ��ȯ�� = "+userName);
	}
	
	//After Throwing Advice Mehtod���� JoinPoint �������̽��� �Ű������ܿ� Exception Ŭ������
	//�Ű����� �ۼ� ����
	// => AspectJ �����Ϸ��� Exception Ŭ������ �Ű������� Ÿ�ٸ޼ҵ忡�� �߻��� ����(Exception ��ü)�� �����޾� ����
	// => Ÿ�ٸ޼ҵ忡�� �߻��Ǵ� ���ܰ� �����Ǿ� �ִ� ��� Exception Ŭ���� ��� �ʿ���
	//���� Ŭ������ �Ű����� �ۼ� ����
	// => After Throwing Advice Mehtod�� Exception Ŭ������ �Ű������� �ۼ��� ��� Spring Bean
	//Configuration File�� AOP �������� after-throwing ������Ʈ�� throwing �Ӽ��� �ݵ��
	//�ۼ��ؾ� Ÿ�ٸ޼ҵ忡�� �߻��� ���ܰ� ����� �Ű������� ���� 
	// => after-throwing ������Ʈ�� throwing �Ӽ��� ���ų� �Ӽ����� �߸� �����Ǹ� IllegalArgumentException �߻�	
	public void exceptionHandle(JoinPoint joinPoint, Exception exception) {//After Throwing Advice Mehtod
		//System.out.println("### [after-throwing]�ٽɰ����ڵ忡�� ���ܰ� �߻��� �Ŀ� ���ԵǾ� ����� Ⱦ�ܰ����ڵ� ###");
		
		String methodName=joinPoint.getSignature().getName();
		System.out.println("### [after-throwing]"+methodName+" �޼ҵ忡�� �߻��� ���� = "
				+exception.getMessage());
	}
	
	//Around Advice Method�� Object Ŭ������ ��ȯ���� �ۼ��ϰ� ProceedingJoinPoint �������̽���
	//�Ű������� �ۼ��Ͽ� ����
	//Ÿ�ٸ޼ҵ��� ��ȯ���� �����޾� Around Advice Method���� ��ȯ�ϱ� ���� ��ȯ�� �ۼ�
	// => Ÿ�ٸ޼ҵ��� ��ȯ���� ���� ��� void �ڷ������� ��ȯ���� �ۼ��� �� ������ Ÿ�ٸ޼ҵ���
	//��ȯ���� �ִ� ��� void �ڷ������� ��ȯ���� �ۼ��ϸ� ���� �߻�
	//Ÿ�ٸ޼ҵ� ���� ������ ProceedingJoinPoint �������̽��� �Ű������� �����޾� ���
	// => ProceedingJoinPoint ��ü : Ÿ�ٸ޼ҵ� ���� ������ �����ϱ� ���� ��ü
	// => JoinPoint ��ü�� �ٸ����� ProceedingJoinPoint ��ü�� Ÿ�ٸ޼ҵ带 ���� ȣ�� ����
	public Object display(ProceedingJoinPoint joinPoint) throws Throwable {//Around Advice Method
		System.out.println("### [around]�ٽɰ����ڵ� ���� ���� ���ԵǾ� ����� Ⱦ�ܰ����ڵ� ###");
		//ProceedingJoinPoint.proceed() : ProceedingJoinPoint ��ü�� Ÿ�ٸ޼ҵ带 ȣ���ϴ� �޼ҵ�
		// => Ÿ�ٸ޼ҵ带 ȣ���Ͽ� ��ȯ�Ǵ� ������� ������ ����
		// => Throwable(Error Ŭ������ Exception Ŭ������ �θ�Ŭ����) ��ü�� �߻��ǹǷ� �ݵ��
		//���� ó���ϰų� ���� ����
		Object result=joinPoint.proceed();
		System.out.println("### [around]�ٽɰ����ڵ� ���� �Ŀ� ���ԵǾ� ����� Ⱦ�ܰ����ڵ� ###");
		return result;//Ÿ�ٸ޼ҵ��� ��ȯ���� ��ȯ ó��
	}
}