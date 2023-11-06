package inheritance;

public class MemberApp {
	public static void main(String[] args) {
		//1번 방법
		Member member1=new Member();
		
		member1.setId("abc123");
		member1.setName("홍길동");
		
		member1.display();
		System.out.println("====================================================");
		//2번 방법
		//매개변수가 있는 생성자로 객체를 생성하는 것이 더 좋음(1번 방법 < 2번 방법)
		Member member2=new Member("xyz789", "임꺽정");
		member2.display();
		System.out.println("====================================================");
	
	
	
	}
}




















