package basic;

//기본형(PrimitiveType) : 기본값을 표현하거나 변수를 선언하기 위한 자료형(키워드)
// =>숫자형(정수형, 실수형, 문자형), 논리형
public class DataTypeApp {
	public static void main(String[] args) {
		//정수형(IntegerType) 리터럴 - 소수점이 없는 숫자값
		System.out.println("<<정수형(IntegerType)>>");
		System.out.println("정수값(10진수 100) ="+100);//숫자값 - 10진수 정수형 리터럴
		System.out.println("정수값(8진수 100) ="+0100);//0숫자값 - 8진수 정수형 리터럴
		System.out.println("정수값(16진수 100) ="+0x100);//0x숫자값 - 8진수 정수형 리터럴
		System.out.println("정수값(10진수 100) ="+100L);//숫자값L - 10진수 정수형 리터럴(8Byte)
	
	
		System.out.println("정수값 ="+2147483647);//숫자값L - 10진수 정수형 리터럴(8Byte)
		System.out.println("정수값 ="+2147483648L);//숫자값L - 10진수 정수형 리터럴(8Byte)
	
		
		//정수값을 표현하기 위한 자료형(키워드) - byte, short, int, long
		byte a1=-128;//=128~127
		short a2=32767;//-32768~32767
		int a3=2147483647;//-21억~21억
		long a4=2147483648L;
	
		System.out.println("a1 = "+a1);
		System.out.println("a2 = "+a2);
		System.out.println("a3 = "+a3);
		System.out.println("a4 = "+a4);
	
		long a5=100;
		System.out.println("a5 ="+a5);
		System.out.println("==================================================");
	
	
	
	
	
	
	
	
	}
}
