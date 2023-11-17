package xyz.itwill.swing;

import java.awt.BorderLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;

//플랫폼의 현재 날짜와 시간을 1초마다 제공받아 출력하는 GUI 프로그램 작성
// => 새로운 스레드를 생성하여 플랫폼의 현재 날짜와 시간을 1초마다 제공받아 컴퍼넌트 변경 처리
public class DigitalClockApp extends JFrame {
	private static final long serialVersionUID = 1L;
	
	JLabel clockLabel;
	
	
	public DigitalClockApp(String title) {
		super(title);
		
		/*
		Date now=new Date();
		SimpleDateFormat df=new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
		String printDate=df.format(now);
		*/
		
		//JLabel clockLabel=new JLabel("2023년 11월 17일 13시 03분 20초", JLabel.CENTER);
		clockLabel=new JLabel("", JLabel.CENTER);
		clockLabel.setFont(new Font("굴림체", Font.BOLD, 30));

		//스레드 클래스로 객체를 생성하여 start() 메소드를 호출해 새로운 스레드를 만들어
		//run() 메소드의 명령 실행
		//new ClockThread().start();
		
		
		/*
		//Runnable 객체를 제공받아 Thread 객체를 생성하여 start()메소드를 호출
		new Thread(new Runnable() {
			@Override
			public void run() {
				SimpleDateFormat df=new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");

				while(true) {
				Date now=new Date();
				String printDate=df.format(now);
				clockLabel.setText(printDate);//컴퍼넌트의 문자열 변경

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				  }
				}
			}	
		}).start();
		 */
		
		//람다 표현식을 사용하여 Runnable 객체 생성
		new Thread(() -> {
				SimpleDateFormat df=new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
			
				while(true) {
					Date now=new Date();
					String printDate=df.format(now);
					clockLabel.setText(printDate);//컴퍼넌트의 문자열 변경

					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
		}).start();	
		
		
		getContentPane().add(clockLabel, BorderLayout.CENTER);
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(700, 200, 600, 200);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new DigitalClockApp("디지털 시계");
	}
	
	/*
	//플랫폼의 현재 날짜와 시간을 1초마다 제공받아 컴퍼넌트 변경 처리하는 스레드 클래스
	public class ClockThread extends Thread {
		@Override
		public void run() {
			SimpleDateFormat df=new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
		
			while(true) {
			Date now=new Date();
			String printDate=df.format(now);
			clockLabel.setText(printDate);//컴퍼넌트의 문자열 변경

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			  }

			}
			
		}
	}
	*/
}







