package basic;


//제어문(Control Statement) : 프로그램의 흐름(스레드 - Thread)을 바꾸는 명령
// => 선택문(if, switch), 반복문(for, while), 기타(break, continue, return)


//if문 형식) if(조건식) {명령; 명령; ...}
// => 조건식의 결과가 참(true)인 경우 블럭({}) 내부에 작성된 명령들을 실행
// => 블럭 내부에 작성된 명령이 하나인 경우 블럭 기호 생략 가능


public class IfApp {
	public static void main(String[] args) {
		int su=90;
		su=40;
		
		//변수값이 50이상인 경우 화면에 출력되도록 프로그램 작성
		
		if(su>=50) {
			System.out.println("su = "+su);
		}
		System.out.println("==================================================");
		
		int score=50;
		
		//변수값이 60 이상인 경우 합격 메세지를 출력하고 60 미만인 경우 불합격 메세지 출력하는 프로그램 작성
		
		/*if(score>=60) {
			System.out.println("[결과]점수가 60점 이상이므로 <합격>입니다.");
		}
		
		if(score<60) {
			System.out.println("[결과]점수가 60점 미만이므로 <불합격>입니다.");
		}*/
		
		if(score>=60) {
			System.out.println("[결과]점수가 60점 이상이므로 <합격>입니다.");
		
		}	else {
				System.out.println("[결과]점수가 60점 미만이므로 <불합격>입니다.");
		}
		
		System.out.println("==================================================");
	
		int num=9;
		
		//변수값을 홀수와 짝수로 구분하여 출력하는 프로그램 작성
		if(num % 2 != 0) {
			System.out.println(num+" = 홀수입니다.");
		}	else {
			System.out.println(num+" = 짝수입니다.");
		}
		System.out.println("==================================================");
		
		char mun='O';
		
		//변수값을 영문자 또는 비영문자로 구분하여 출력하는 프로그램 작성
		if(mun >= 'A' && mun <='Z' || mun >= 'a' && mun <= 'z') {
			System.out.println("[결과]"+mun+" = 영문자");
		}	else {
			System.out.println("[결과]"+mun+" = 영문자");
		}
		System.out.println("==================================================");
		boolean bool=false;
		
		if(!bool) {
			System.out.println("현재 변수값은 [거짓]입니다.");
		} else {
			System.out.println("현재 변수값은 [참]입니다.");
			
		}
		System.out.println("==================================================");
		int jumsu=85;
		
		//변수값이 0~100 범위의 유효한 값이 맞는지를 구분하여 출력하는 프로그램 작성
		if(jumsu>=0 && jumsu<=100) {
			/*System.out.println("[결과]0~100범위의 정상적인 점수가 입력 되었습니다.");
		}	else {
			System.out.println("[에러]0~100범위를 벗어난 비정상적인 점수가 입력 되었습니다.");
		}	*/
			
		
			//변수값(점수)을 이용하여 등급(학점)을 구분하여 출력하는 프로그램 작성
			//100 ~ 90 : A, 89 ~ 80 : B, 79 ~ 70 : C, 69 ~ 60 : D, 59 ~ 0: F
			/*String grade="";//학점을 저장하기 위한 변수
			if(jumsu >= 90) {
				grade = "A";
			} else if(jumsu <= 89 && jumsu >= 80) {
				grade = "B";
			} else if(jumsu <= 79 && jumsu >= 70) {
				grade = "C";
			} else if(jumsu <= 69 && jumsu >= 60) {
				grade = "D";
			} else if(jumsu <= 59 && jumsu >= 0) {
				grade = "F";
			}	
			*/
			
			String grade="";//학점을 저장하기 위한 변수
			if(jumsu >= 90) {
				grade = "A";
			} else if(jumsu >= 80) {
				grade = "B";
			} else if(jumsu >= 70) {
				grade = "C";
			} else if(jumsu >= 60) {
				grade = "D";
			} else  {
				grade = "F";
			}
			System.out.println("[결과]"+jumsu+"점 = "+grade+"학점");
		}
			System.out.println("==================================================");
		
	}
}