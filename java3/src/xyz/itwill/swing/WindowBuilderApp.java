package xyz.itwill.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import xyz.itwill.swing.JTableApp.InputStudentDialog;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;

public class WindowBuilderApp extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JButton addBtn;
	InputStudentDialog dialog;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowBuilderApp frame = new WindowBuilderApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WindowBuilderApp() {
		setBackground(new Color(240, 240, 240));
		setIconImage(Toolkit.getDefaultToolkit().getImage(WindowBuilderApp.class.getResource("/images/penguin1.gif")));
		setTitle("WindowBuilder 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 200, 500, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 127, 80));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 255, 127), null));
		contentPane.add(scrollPane, BorderLayout.EAST);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(255, 0, 0), new Color(135, 206, 250), new Color(47, 79, 79), new Color(147, 112, 219)));
		table.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"\uC774\uB984", "\uD559\uBC88", "\uC804\uD654\uBC88\uD638"
			}
		));
		
		
		
		table.getColumnModel().getColumn(0).setPreferredWidth(72);
		table.getColumnModel().getColumn(1).setPreferredWidth(74);
		table.getColumnModel().getColumn(2).setResizable(false);
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(1, 4, 0, 0));
		
		dialog=new InputStudentDialog(this, "학생추가");
		
		addBtn = new JButton("학생 추가");
		addBtn.setForeground(SystemColor.info);
		addBtn.setBackground(new Color(0, 64, 128));
		addBtn.setIcon(null);
		addBtn.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 12));
		panel.add(addBtn);
		
		JButton modifyBtn = new JButton("학생변경");
		modifyBtn.setForeground(new Color(0, 0, 139));
		modifyBtn.setBackground(new Color(224, 255, 255));
		modifyBtn.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 12));
		panel.add(modifyBtn);
		
		JButton removeBtn = new JButton("학생삭제");
		removeBtn.setForeground(new Color(127, 255, 212));
		removeBtn.setBackground(new Color(255, 182, 193));
		removeBtn.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 12));
		panel.add(removeBtn);
		
		JButton searchBtn = new JButton("검색");
		searchBtn.setSelectedIcon(null);
		searchBtn.setIcon(null);
		searchBtn.setForeground(new Color(255, 255, 0));
		searchBtn.setBackground(new Color(178, 34, 34));
		searchBtn.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 12));
		panel.add(searchBtn);
		
		JMenuBar menuBar = new JMenuBar();
		contentPane.add(menuBar, BorderLayout.NORTH);
		
		JMenu file = new JMenu("File");
		file.setMnemonic('F');
		menuBar.add(file);
		
		JMenuItem open = new JMenuItem("open");
		open.setBackground(new Color(128, 0, 0));
		open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK | InputEvent.ALT_DOWN_MASK));
		file.add(open);
	}
	
	public class InputStudentDialog extends JDialog {
		private static final long serialVersionUID = 1L;

		JTextField numTf, nameTf, phoneTf;
		JButton okBtn, cancelBtn;
		
		//생성자 매개변수에는 부모창의 컨테이너 관련 객체와 제목을 전달받아 초기화
		public InputStudentDialog(JFrame frame, String title) {
			//JDialog(Frame owner, String title, boolean model) 생성자를 super 키워드로 호출
			// => owner 매개변수에는 부모창의 JFram 객체를 전달받고 model 매개변수에는 부모창의
			//비활성화 여부를 설정하는 논리값(false : 부모창 활성화, true : 부모창 비활성화)을 
			//전달받아 JDialog 객체 생성
			super(frame, title, true);

			getContentPane().setLayout(new GridLayout(2,1));
			
			JPanel panelOne=new JPanel(new GridLayout(3,2));
		
			panelOne.setBorder(new EmptyBorder(10, 10, 10, 10));
			
			numTf=new JTextField();
			nameTf=new JTextField();
			phoneTf=new JTextField();
		
			panelOne.add(new JLabel("학번", JLabel.CENTER));
			panelOne.add(numTf);
			panelOne.add(new JLabel("이름", JLabel.CENTER));
			panelOne.add(nameTf);
			panelOne.add(new JLabel("전화번호", JLabel.CENTER));
			panelOne.add(phoneTf);
			
			okBtn=new JButton("추가");
			cancelBtn=new JButton("취소");
			
			JPanel panelTwo  = new JPanel();
			panelTwo.setAlignmentX(JPanel.CENTER_ALIGNMENT);
			panelTwo.add(okBtn);
			panelTwo.add(cancelBtn);
			
			getContentPane().add(panelOne);
			getContentPane().add(panelTwo);
			
			setBounds(700, 200, 400, 300);
		}	
	}
}
