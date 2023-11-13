package xyz.itwill.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

//키보드로 생년월일을 입력받아 오늘까지 살아온 날짜(일)을 계산하여 출력하는 프로그램 작성
//ex) 생년월일 입력[ex. 2000-01-01] >> 2023-11-13
//    [결과]태어난지 <1일>이 지났습니다. 
// => 형식에 맞지 않는 생년월일을 입력한 경우 에러 메세지 출력 후 프로그램 종료
public class DayCalculateApp {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.print("생년월일 입력[ex. 2000-01-01] >> ");
		String birthday=sc.nextLine();
		sc.close();
		
		Date now = new Date();
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		//LocalDate now=LocalDate.now();
		try {
			Date bdayDate = sdf.parse(birthday);
			
			
			//long diffSec = (bdayDate.getTime() - nowDate.getTime())
			//long diffDays = / (24*60*60);
			
			
			
			
			
			//System.out.println(now);
			//System.out.println("생일 = "+bdayDate);
		} catch (ParseException e) {
			System.out.println("[에러]형식에 맞는 날짜와 시간을 입력해 주세요.");
			sc.close();
		}
		
		
		
	
	
	
	}
}










