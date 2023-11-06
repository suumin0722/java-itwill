package xyz.itwill.realization;


//부모클래스는 extends 키워드를 사용하여 자식클래스가 상속받아 작성 - 단일상속
//부모인터페이스를 implements 키워드로 자식클래스가 상속받아 사용 - 다중상속
// => 인터페이스를 상속받은 자식클래스는 상속받은 모든 인터페이스의 추상 메소드를 무조건 오버라이드 선언
public class WolfHuman extends Human implements Wolf {

	@Override
	public void fastWalk() {
		System.out.println("[늑대]네발로 빠르게 달릴 수 있는 능력");
	}
	
	@Override
	public void cryLoudly() {
		System.out.println("[늑대]큰 소리로 울부짖을 수 있는 능력");
	}
	
	public void change() {
		System.out.println("[늑대인간]변신할 수 있는 능력");
	}
}
