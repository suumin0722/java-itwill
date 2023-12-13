package xyz.itwill.net;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
//import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//채팅 클라이언트 프로그램
// => 서버에서 보내온 메세지를 전달받아 JTextArea 컴퍼넌트에 출력 처리 - 무한루프(main 스레드)
// => JTextField 컴퍼넌트에서 입력한 메세지를 서버에 전달 처리 - 이벤트 처리 클래스(Eventqueue 스레드)
//
public class ChattingClientApp extends JFrame {
	private static final long serialVersionUID = 1L;

	//컴퍼넌트를 저장하기 위한 필드
	private JTextArea textArea;//출력 컴퍼넌트
	private JTextField textField;//입력 컴퍼넌트

	//서버와 연결된 Socket 객체를 저장하기 위한 필드
	private Socket socket;
	
	//서버에서 보내온 메세지를 제공받기 위한 입력스트림을 저장하기 위한 필드
	private BufferedReader in;
	
	//서버에 메세지를 전달하기 위한 출력스트림을 저장하기 위한 필드
	private PrintWriter out;

	//대화명을 저장하기 위한 필드
	private String aliasName;

	public ChattingClientApp(String title) {
		super(title);
		
		textArea=new JTextArea();
		textField=new JTextField();
		
		textArea.setFont(new Font("굴림체", Font.BOLD, 20));
		textField.setFont(new Font("굴림체", Font.BOLD, 20));
		
		textArea.setFocusable(false);
		
		JScrollPane scrollPane=new JScrollPane(textArea);
		
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		getContentPane().add(textField, BorderLayout.SOUTH);
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(700, 200, 400, 500);
		setVisible(true);
		
		//JTextField 컴퍼넌트에서 ActionEvent가 발생될 경우 이벤트 처리를 위한 ActionListener 객체 생성
		// => ActionListener 객체는 익명의 클래스를 사용하여 생성
		textField.addActionListener(new ActionListener() {
			//JTextField 컴퍼넌트에서 입력된 문자열(메세지) 제공받아 서버에 전달
			//EventQueue 스레드가 처리 
			@Override
			public void actionPerformed(ActionEvent e) {
				String message=textField.getText();
				
				if(!message.equals("")) {//입력된 문자열(메세지)이 존재하는 경우
					out.println(message);
					//다른 메세지를 입력받기 위해 JTextField 컴퍼넌트 초기화
					textField.setText("");
				}
				
			}
		});
		
		try {
			//Socet 객체를 생성하여 필드에 저장 - 서버 접속
			Socket socket=new Socket("192.168.13.12", 5000);
			
			//소켓의 입력스트림을 제공받아 대량의 문자데이터(문자열)을 제공받을 수 있는 입력 스트림으로
			//확장하여 필드에 저장
			in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			//소켓의 출력스트림을 제공받아 문자열을 전달할 수 있는 출력스트림으로
			//확장하여 필드에 저장
			out=new PrintWriter(socket.getOutputStream(), true);
			
		} catch (IOException e) {
			//메세지 다이얼로그를 이용해 에러메세지를 출력 처리
			JOptionPane.showMessageDialog(this, "서버에 접속할 수 없습니다.",
					"접속오류", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		
		//대화명을 검증하기 위한 반복문 - 정상적인 대화명 입력 시 반복문 종료
		while(true) {
		//입력 다이얼로그를 이용해 대화명을 입력받아 필드에 저장
		aliasName=JOptionPane.showInputDialog(this, "대화명을 입력해주세요",
				 "대화명 입력", JOptionPane.QUESTION_MESSAGE);

		//2~6 범위의 한글만 저장되도록 정규표현식을 사용하여 표현 
		String regEx="^[가-힣]{2,6}$";
		
		//정규표현식의 패턴과 동일한 대화명을 입력한 경우 반복문 종료
		if(aliasName!=null && Pattern.matches(regEx, aliasName)) break;
		
		JOptionPane.showMessageDialog(this, "2~6 범위의 한글로된 대화명을 입력해주세요.",
				"입력오류", JOptionPane.ERROR_MESSAGE);
		
		
//		int re = JOptionPane.showConfirmDialog(this, "창을 닫으시겠습니까?", "창 닫기", JOptionPane.YES_NO_OPTION);
//		
//			if(re == 0) {
//		dispose();
//			}
		
		
		
		
		}
		
		//입력받은 대화명을 출력스트림을 사용하여 서버에 전달
		out.println(aliasName);
		
		//서버에서 보내온 메세지를 제공받아 JTextArea 컴퍼넌트에 추가하여 출력 처리
		// => 클라이언트 프로그램이 종료되기 전까지 반복 처리
		while(true) {
			try {
				//입력스트림을 사용하여 서버에서 보내온 메세지를 제공받아 JTextArea 컴퍼넌트에 추가하여 출력 
				textArea.append(in.readLine()+"\n");
				
				//JTextArea 컴퍼넌트의 스크롤을 맨 끝으로 이동 처리
				textArea.setCaretPosition(textArea.getText().length());
			} catch (IOException e) {//네트워크 문제로 서버 접속이 종료된 경우 IOException 발생
				JOptionPane.showMessageDialog(this, "서버와 연결이 끊어졌습니다.",
						"접속오류", JOptionPane.ERROR_MESSAGE);
				System.exit(0);
			}
		}
	}	
	
	
	public static void main(String[] args) {
		new ChattingClientApp("자바채팅");
	}

	
			

}










