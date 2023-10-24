package example;

public class OperatorExample {
	public static void main(String[] args) {
		
		//245678초를 일시분초 형식으로 변환하여 출력하세요.
		int cho=245678;
		System.out.print(cho+"초 = ");
		
		int day=cho/(24*60*60);
		cho%=24*60*60;
		int hr=cho/(60*60);
		cho%=60*60;
		int min=cho/60;
		int sec=cho%60;
			
		System.out.println(day+"일"+ hr+"시" + min+"분" + sec+"초");
		System.out.println("==============================================================");
			
			
		//한대의 가격이 1억 5천원만인 비행기를 20대 구매할 경우 지불해야될 금액을 계산하여 출력하세요. 
		//단, 15대 이상 구매할 경우 1대당 25%의 할인율을 적용하여 계산하세요.
		//b=비행기 한대의 가격
		int plane=150_000_000, count=20;
		long money=(long)plane*count;
		System.out.println("비행기 20대 지불 금액 ="+money);
		
		money=(long)(count>=15?plane*0.75:plane)*count;
		System.out.println("할인받은 비행기 가격 ="+money);
					
		System.out.println("==============================================================");
				
			
			//1. %연산자
			//2. 삼항연산자
		    //0.75
		
	
	
	
	}
}
