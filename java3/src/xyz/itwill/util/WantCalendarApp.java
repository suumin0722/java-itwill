package xyz.itwill.util;

import java.util.Calendar;
import java.util.Scanner;

//키보드로 [년]과 [월]을 입력받아 해당 년월에 대한 달력을 출력하는 프로그램 작성
public class WantCalendarApp {
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.print("[입력]OOOO년을 입력하세요 >> ");
		int year=sc.nextInt();
		
		System.out.print("[입력]OO월을 입력하세요 >> ");
		int month=sc.nextInt();
		
		sc.close();
		
		Calendar calendar=Calendar.getInstance();
		
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month-1);
		calendar.set(Calendar.DATE, 1);
		
		
		int week=calendar.get(Calendar.DAY_OF_WEEK);
		
		
		System.out.println("         "+year+"년"+month+"월");
			System.out.println("=============================");	
			System.out.println("  일  월  화  수  목  금  토");	
			System.out.println("=============================");	
			
			for(int i=1; i<week; i++) {
				System.out.print("    ");
			}
			
			for(int i=1;i<=calendar.getActualMaximum(Calendar.DATE);i++) {
				//날짜 출력 - 자릿수를 맞춰 출력되도록 선택문 사용
				if(i <= 9) {
					System.out.print("   "+i);
				} else {
					System.out.print("  "+i);
				}
				
				//요일 증가
				week++;
				
				//다음에 출력될 [일]에 대한 요일이 [일요일]인 경우 
				if(week % 7 == 1) {
					System.out.println();//엔터 출력
				}
			}
			System.out.println();
			System.out.println("============================");
	
	
	
	
	
	}
}