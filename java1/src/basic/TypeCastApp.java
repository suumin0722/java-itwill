package basic;

//형변환(TypeCast) : 값의 자료형을 일시적으로 변환하여 사용하는 방법
public class TypeCastApp {
	public static void main(String[] args) {
	System.out.println("결과 = "+(3+1.5));//3(int)+1.5(double)>>3.0(double)+1.5(double) >> 4.5(double)
	
	double su=10;
	System.out.println("su = "+su);
		
	System.out.println("결과 = "+95/10);// int / int >> int
	System.out.println("결과 = "+95.0/10.0);// double / double >> double
	System.out.println("결과 = "+95.0/10);// double / int >> double / double 로 자동형변환
	
	int kor=95, eng=90;
	int tot=kor+eng;//총점을 계산하여 저장
	System.out.println("두 과목의 점수 합 = "+tot);
	//double ave=tot/2;//평균을 계산하여 저장 - 연산 결과값: 정수값(92) >> 실수(92.0) 자동형변환
	double ave=tot/2.; //자동형변환 - 연산 결과값(평균)인 실수(92.5)이 변수에 저장
	
	System.out.println("총점 = "+tot+", 평균 = "+ave);
	
	byte su1=10, su2=20;
	int su3=su1+su2;
	System.out.println("su3 = "+su3);
	System.out.println("==================================================");
	//강제 형변환 => Cast 연산자 : (자료형)값
	int num=(int)12.3;//(int)12.3 = 12
	System.out.println("num = "+num);
	
	int num1=95, num2=10;
	//double num3=num1/num2;//변수값 : 9.0
	double num3=(double)num1/num2;//변수값 : 9.5
	System.out.println("num3 = "+num3);
	
	
	int num4=100_000_000, num5=30;
	//정수값은 4Byte(-2147483648~2147483647)로 표현되어 연산 결과값이 범위를 벗어날 경우
	//쓰레기값 발생되어 변수에 저장 가능 => 잘못된 결과값 출력 - 실행 오류
	//int num6=num4*num5;
	//System.out.println("num6 = "+num6);
	long num6=(long)num4*num5;
	System.out.println("num6 = "+num6);
	
	double number=1.23456789;
	System.out.println("number = "+number);
	
	//소숫점 2번째 자리까지만 출력되도록 변환하여 출력
	System.out.println("number(내림) = "+(int)(number*100)/100.);
	System.out.println("number(반올림) = "+(int)(number*100+0.5)/100.);
	System.out.println("number(올림) = "+(int)(number*100+0.9)/100.);
	
	
	
	
	}
	
	
	
	
}
