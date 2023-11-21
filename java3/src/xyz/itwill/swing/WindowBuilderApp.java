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
import xyz.itwill.swing.JTableApp.StudentButtonEventHandle;

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
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	private JButton addBtn, removeBtn, modifyBtn, searchBtn;
	InputStudentDialog dialog;

	
	public static void main(String[] args) {
			new WindowBuilderApp("WindowBuilder 연습");
			
	}

	public WindowBuilderApp(String title) {
		super(title);
		
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
		scrollPane.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		String[] columnNames= {"학번", "이름", "전화번호"};
		
		DefaultTableModel tableModel=new DefaultTableModel(columnNames, 0);
		
		table = new JTable(tableModel);
			
			
		table.setToolTipText("학생목록");
		table.setBackground(new Color(192, 192, 192));
		table.setBorder(new EmptyBorder(0, 0, 0, 0));
		table.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		
		
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(72);
		table.getColumnModel().getColumn(1).setResizable(false);
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
		
		addBtn.addActionListener(new StudentButtonEventHandle());
		removeBtn.addActionListener(new StudentButtonEventHandle());
		modifyBtn.addActionListener(new StudentButtonEventHandle());
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(700, 200, 500, 400);
		setVisible(true);
	}
	
	
	public class StudentButtonEventHandle implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object eventSource=e.getSource();

			if(eventSource == addBtn) {
				dialog.setVisible(true);
			} else if(eventSource == removeBtn) {
				DefaultTableModel tableModel=(DefaultTableModel)table.getModel();
				
				//행이 하나도 없는 경우 메소드 종료
				if(tableModel.getRowCount()==0) return;
				
				//JTable.getSelectedRow(): 테이블에서 선택행의 행번호를 반환하는 메소드
				int row=table.getSelectedRow();
				if(row == -1) return;//선택행이 없는 경우 메소드 종료
				
				//DefaultTableModel.removeRow(int row): 매개변수로 전달받은 행을 삭제하는 메소드
				tableModel.removeRow(row);
			} else if(eventSource == modifyBtn) {
				dialog.setVisible(true);
			}
		}
	}
	
	public class InputStudentDialog extends JDialog {
		private static final long serialVersionUID = 1L;

		JTextField numTf, nameTf, phoneTf;
		JButton okBtn, cancelBtn;
		
		public InputStudentDialog(JFrame frame, String title) {
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
			
			okBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					//JTextField 컴퍼넌트의 입력값을 반환받아 저장
					String num=numTf.getText();
					String name=nameTf.getText();
					String phone=phoneTf.getText();
					
					//Vector 객체를 생성하여 입력값을 요소로 추가하여 저장
					Vector<String> vector=new Vector<String>();
					vector.add(num);
					vector.add(name);
					vector.add(phone);
					
					//JTable.getModel():테이블 관련 행에 대한 정보가 저장된 TableModel 객체를 반환하는 메소드
					// => 명시적 객체 형변환을 이용하여 DefaultTableModel 객체로 형변환
					DefaultTableModel tableModel=(DefaultTableModel)table.getModel();
					
					//DefaultTableModel.addRow(Vector vector): Vector 객체의 요소값(컬럼값)을
					//테이블에 행을 추가하는 메소드
					tableModel.addRow(vector);
					
					//JTextField 컴퍼넌트의 입력값 초기화
					numTf.setText("");
					nameTf.setText("");
					phoneTf.setText("");
					
					
					setVisible(false);
				}
			});
				
			
			cancelBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					
				}
			});
			
			setDefaultCloseOperation(HIDE_ON_CLOSE);

			setBounds(700, 200, 400, 300);
			
			
		}	
	}
}
 