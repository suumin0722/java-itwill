package example;

public class OperatorExample {
	public static void main(String[] args) {
		
		//245678초를 일시분초 형식으로 변환하여 출력하세요.
			int a=245678;
		    int day=a/(24*60*60);
		    a%=24*60*60;
			int hr=a/(60*60);
			a%=60*60;
			int min=a/60;
			int sec=(a%=60);
			
			System.out.println(day+"일"+ hr+"시간" + min+"분" + sec+"초");
			System.out.println("==============================================================");
			
			
			//한대의 가격이 1억 5천원만인 비행기를 20대 구매할 경우 지불해야될 금액을 계산하여 출력하세요. 
			//단, 15대 이상 구매할 경우 1대당 25%의 할인율을 적용하여 계산하세요.
			//b=비행기 한대의 가격
			int b=150_000_000;
			long tot=b * 20L;
			System.out.println("비행기 20대 지불 금액 ="+tot);
			
			System.out.println("할인받은 비행기 가격 ="+(tot >= (b*15) ? (b*0.75)*20 : b*20));
					
			System.out.println("==============================================================");
				
			
			
		
		
		//1. %연산자
		//2. 삼항연산자
	    //0.75
	
	
	
	
	}
}
