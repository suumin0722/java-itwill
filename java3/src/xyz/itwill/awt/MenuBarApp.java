package xyz.itwill.awt;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.TextArea;
import java.awt.event.KeyEvent;

//Frame 클래스는 메뉴를 제공하는 MenuBar 영역이 존재하는 컨테이너 
// => 프레임의 MenuBar 영역을 변경하여 메뉴 제공
// => Frame - MenuBar << Menu << MenuItem
public class MenuBarApp extends Frame {
	private static final long serialVersionUID = 1L;

	public MenuBarApp(String title) {
		super(title);
		
		//MenuBar 클래스: 프레임에 메뉴를 배치하기 위한 컨테이너
		MenuBar menuBar=new MenuBar();
		
		//Menu 클래스: 메뉴바 메뉴를 배치하기 위한 컨테이너
		Menu file=new Menu("File");
		Menu help=new Menu("Help");
		
		menuBar.add(file);
		menuBar.add(help);
		
		//MenuItem 클래스: 메뉴에 배치하기 위한 메뉴아이템 컨퍼넌트
		//MenuShortcut 클래스: 메뉴아이템에 단축키를 제공하기 위한 클래스
		//KeyEvent: 키보드 관ㄹ녀 이벤트 정보를 저장하기 위한 클래스
		// => 가상의 키보드를 이용하여 키보드에 대한 정보를 상수로 제공
		MenuItem open=new MenuItem("Open", new MenuShortcut(KeyEvent.VK_0));
		MenuItem save=new MenuItem("Save", new MenuShortcut(KeyEvent.VK_S));
		MenuItem exit=new MenuItem("Exit");

		MenuItem view=new MenuItem("HelpView");
		MenuItem info=new MenuItem("Information");
		
	
		//메뉴에 메뉴아이템 배치
		file.add(open);
		file.add(save);
		file.addSeparator();//메뉴아이템을 구분하는 구분선 배치
		file.add(exit);

		help.add(view);
		help.add(info);
		
		//프레임의 메뉴바를 변경하는 메소드
		setMenuBar(menuBar);
		
		
		TextArea textArea=new TextArea();
		textArea.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
		add(textArea, BorderLayout.CENTER);

		setBounds(500, 100, 1000, 800);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MenuBarApp("MenuBar");
	}
}