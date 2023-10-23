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
	
		System.out.println("<<실수형(DoubleType)>>");
		System.out.println("실수값(4Byte) = "+40.6F);//실수값F => 4Byte 실수형 리터럴(Float)
		//println() 메소드는 실수값이 아주 작거나 큰 경우 지수형태로 변환하여 출력
		System.out.println("실수값(8Byte) = "+0.00000000023);//실수값 => 8Byte 실수형 리터럴(Double)
		//실수값을 지수형태로 표현하여 사용 가능
		System.out.println("실수값(8Byte) = "+1.23E+10);
		
		
		//실수값을 표현하기 위한 자료형 - float, double
		float b1=1.23456789F;//가수부로 표현한 크기(정밀도) : 소숫점 7자리
		double b2=1.23456789;//가수부로 표현한 크기(정밀도) : 소숫점 15자리
		
		System.out.println("b1 ="+b1);
		System.out.println("b2 ="+b2);
		System.out.println("==================================================");
		System.out.println("<<문자형(CharacterType)>>");
		//'A' : 65, 'a':97, '0' : 48, ' ' : 32, '\n' : 13 
		System.out.println("문자값 = "+'A');
		System.out.println("\"개발자\"가 되고 싶어요!");
		System.out.println("ㅎ ㅎ \n재밌다");
		//Alt+숫자: 문자로 나타남
		//A    a 0   
		
		//문자값을 표현하기 위한 자료형 - char(2Byte)
		char c1='A';
		char c2=65;
		char c3='a' -32;
		
		System.out.println("c1 ="+c1);
		System.out.println("c2 ="+c2);
		System.out.println("c3 ="+c3);
		System.out.println("==================================================");
		//논리형(BooleanType) 리터럴 - false(거짓), true(참) => 연산 불가능
		// => Java프로그램에 문자형 리터럴은 기본적으로 1Byte 표현
		System.out.println("<<논리형(BooleanType)>>");
		System.out.println("논리값(1Byte) = "+false);
		System.out.println("논리값(1Byte) = "+true);
		//관계연산자(비교연산자)를 이용한 연산식의 결과값으로 논리값이 발생되어 제공
		System.out.println("논리값(1Byte) = "+(20 < 10));
		System.out.println("논리값(1Byte) = "+(20 > 10));
		
		boolean d1=false;
		boolean d2=20>10;
		System.out.println("d1 = "+d1);
		System.out.println("d2 = "+d2);
		System.out.println("==================================================");
		//문자열(StringType) 리터럴 : " " 안에 0개 이상의 문자들을 사용하여 표현되는 값
		// => 문자열은 기본형(원시형)이 아닌 String 클래스(참조형)를 사용하여 표현
		System.out.println("<<문자열(StringType)>>");
		System.out.println("문자열 = "+"홍길동");
		System.out.println("문자열 = "+"유관순 열사가 \"대한독립만세\"를 외쳤습니다.");
		
		//문자열을 표현하기 위한 자료형:String Class
		String name="임꺽정";
		System.out.println("이름 = "+name);
		
		
		
		
		
	}
}

