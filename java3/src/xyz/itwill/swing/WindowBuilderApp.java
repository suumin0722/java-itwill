package xyz.itwill.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.JButton;
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

public class WindowBuilderApp extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JButton addBtn;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(WindowBuilderApp.class.getResource("/images/penguin1.gif")));
		setTitle("WindowBuilder 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 200, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		table.setModel(new DefaultTableModel(
			new Object[][] {
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
		
		addBtn = new JButton("학생 추가");
		addBtn.setIcon(null);
		addBtn.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 12));
		panel.add(addBtn);
		
		JButton modifyBtn = new JButton("학생변경");
		modifyBtn.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 12));
		panel.add(modifyBtn);
		
		JButton removeBtn = new JButton("학생삭제");
		removeBtn.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 12));
		panel.add(removeBtn);
		
		JButton searchBtn = new JButton("학생검색");
		searchBtn.setFont(new Font("한컴산뜻돋움", Font.PLAIN, 12));
		panel.add(searchBtn);
		
		JMenuBar menuBar = new JMenuBar();
		contentPane.add(menuBar, BorderLayout.NORTH);
		
		JMenu file = new JMenu("File");
		file.setMnemonic('F');
		menuBar.add(file);
		
		JMenuItem open = new JMenuItem("open");
		open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK | InputEvent.ALT_DOWN_MASK));
		file.add(open);
	}

}
