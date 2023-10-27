package example;

import java.util.Scanner;

//컴퓨터로부터 제공받은 정수 난수값을 키보드로 입력하여 맞추는 프로그램을 작성하세요.
//=> 1~100 범위의 정수 난수값을 제공받도록 작성
//=> 난수값을 맞출 수 있는 기회는 10번만 제공되도록 작성
//=> 키보드 입력값이 1~100 범위가 아닌 경우 메세지 출력 후 재입력
//=> 난수값과 입력값이 같은 경우 입력 횟수 출력 후 프로그램 종료 
//=> 난수값과 입력값이 다른 경우 "큰값 입력" 또는 "작은값 입력" 형식의 메세지 출력
//=> 난수값을 10번 안에 맞추지 못한 경우 난수값이 출력되도록 작성 
public class UnAndDownExample {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int computer = (int) (Math.random() * 100 + 1);
		
		//정답 상태를 저장하기 위한 변수
		// => false : 정답을 맞추지 못한 상태, true : 정답을 맞춘 상태
		boolean result=false;

		for (int i = 1; i <= 10; i++) {
			int user;
			while (true) {
				System.out.print("["+i+"번째 입력] >> ");
				user = scanner.nextInt();
				if (user > 0 && user < 100)
					break;
				System.out.println("[에러]1~100 범위의 숫자 중 하나를 선택하여 입력해 주세요.");
			}

			if (computer < user) {
				System.out.println("큰값 입력");
			} else if (computer > user) {
				System.out.println("작은값 입력");
			} else {
				System.out.println("맞췄습니다! [입력 횟수] = " + i);
				break;
			} 
				if (i == 10) {
				System.out.println("10번의 기회가 끝났습니다. 정답은 = "+computer);
				result=true;//변수에 정답을 맞춘 상태값을 저장
			}
			
			
		}
		
		
		scanner.close();
	}

}
