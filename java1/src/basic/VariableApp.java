package basic;

//저장단위 - Bit > Byte > Word > Field(Column) > Record(Row)

public class VariableApp {
	public static void main(String[] args) {
		int su;//정수값을 저장하기 위한 변수 선언 - 메모리에 변수 생성
		//대입연산자(=)를 이용하여 변수에 값을 저장 - 대입연산자 왼쪽에 변수를 위치하여 값을 제공받아 저장 
		su=100;//입력 명령
		System.out.print("초기값 = ");
		System.out.println(su);//변수에 저장된 값을 제공받아 화면에 출력 - 출력 명령
		
		//int su;//동일한 이름의 변수를 재선언할 경우 에러 발생
		su=200;//변수에는 기본값 대신 새로운 값 저장
		System.out.print("변경값 = ");
		System.out.println(su);
		System.out.println("==================================================");
		int num=100;//변수 선언 및 초기값 저장
	
		//"문자열"+값 or 값+"문자열" => 문자열과 값이 결합되어 결과값으로 문자열 제공
		System.out.println("num = "+num);
		System.out.println("==================================================");
		System.out.println("올해는 "+2+0+2+3+"년입니다.");
		//" " - 문자가 없는 비어있는 문자열(NullString)
		System.out.println(""+2+0+2+3+"년은 토키띠입니다.");//잘못된 결과 발생 - 실행 오류
		System.out.println("==================================================");
		//동일한 자료형의 변수는 , 기호를 사용하여 나열 선언 가능
		int num1=100, num2=200;
		System.out.println("연산결과 = "+num1+num2);
		System.out.println("연산결과 = "+(num1+num2));
		System.out.println("연산결과 = "+(num1*num2));
		System.out.println("==================================================");
		int kor=88, eng=90;
		//int tot=88-90;//리터럴 사용보다는 변수 사용하기!
		int tot=kor+eng;//변수값으로 연산 처리하고 결과값을 변수에 저장 - 처리 명령
		System.out.println("점수 합계 = "+tot);
		System.out.println("==================================================");
		//변수에 값이 저장되어 있지 않은 상태에서 변수를 사용할 경우 에러 발생
		int count=10;
		System.out.println("count ="+count);
		System.out.println("==================================================");
		
		
	}
}
