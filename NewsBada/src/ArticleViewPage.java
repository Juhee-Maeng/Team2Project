import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class ArticleViewPage {
	
	private static int ColumnID; 

	private JFrame frame;
	JPanel panel = new JPanel();
	private JTextField textField;  // �����ؽ�Ʈ
	private JTextField textTitle;  // ����Ÿ��Ʋ
	private JTextField text;  // �߰��޴�

	static loadingMysql lm;
	
	static String ColumnText = null;
	static String ColumnTitle = null;
	static String ColumnImgae = null;
	private JLabel lblNewsbade;
	private JTextField textField_1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Į�� ��ȣ�� �����ؾ� �ϴ� �κ�
					int id =28;
					// Į�� ��ȣ �����ؾ��ϴ� �κ�
					ArticleViewPage window = new ArticleViewPage(id);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ArticleViewPage(int columnID) {
		
		// Į�� ��ȣ �Է� �ϴ� �κ�
		ArticleViewPage.ColumnID = columnID;
		try {
			loadingMysql lm = new loadingMysql(ColumnID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		initialize(lm);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("deprecation")
	private void initialize(loadingMysql lmclass) {
		frame = new JFrame();
		frame.setLocation(150, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton();
		
		// Image File insert here!
		/*
		try {
			String path = new String();
			path = lmclass.ColumnImage;
			if (path != null) {
				System.out.println(path);
				//URL image = new URL(path);
				BufferedImage img = ImageIO.read(image);
				btnNewButton.setIcon(new ImageIcon(img));
			}
			else btnNewButton.setIcon(new ImageIcon());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		//News Title insert here
		if (lm.ColumnTitle != null){
			ColumnTitle = lm.ColumnTitle;
			//textTitle.setText(lm.ColumnTitle);
		}
		else {
			textTitle.setText("���� ������ �� �����ϴ�.");
		}
		
		// News Field insert here
		if (lm.ColumnText != null){
			ColumnText = lm.ColumnText;
			//textField.setText(lm.ColumnText);
		}
		else{
			textTitle.setText("���� ������ �� �����ϴ�.");
		}
		
		// ���� Ÿ��Ʋ ���� �κ�
		textTitle = new JTextField();
		textTitle.setColumns(10);
		
		// ���� �ؽ�Ʈ ���� �κ�
		textField = new JTextField();
		textField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 235, 205));
		
		// ��ư ���� �ʿ�
		JButton btnNewButton_1 = new JButton("\uB3CC\uC544\uAC00\uAE30");
		
		// ����
		JLabel lblMan = new JLabel("male");
		
		// ����
		JLabel lblFemale = new JLabel("female");
		
		// URL, �Ź���, ��¥
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 462, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblMan, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 310, Short.MAX_VALUE)
									.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblFemale, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 401, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(textField_1)
										.addComponent(textField, GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
										.addComponent(textTitle, GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE))))))
					.addGap(10))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textTitle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(lblMan)
							.addGap(10)
							.addComponent(lblFemale))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(btnNewButton_1)))
					.addContainerGap())
		);
		
		
	
		lblNewsbade = new JLabel("NewsBada");
		lblNewsbade.setFont(new Font("������ũ��� M", Font.PLAIN, 27));
		panel_1.add(lblNewsbade);
		frame.getContentPane().setLayout(groupLayout);
		
		frame.setSize(1265, 379);
		// �߰� �޴� ����
		frame.pack();
		frame.setVisible(true);
		
	}
}

class loadingMysql {
	
	static Statement stmt = null;
	static Statement stmt1 = null;
	static Connection conn = null;
	
	// article ���̺� ���� �ҷ�����
	public static String ColumnURL = new String();
	public static String ColumnTheme = new String();
	public static String ColumnPname = new String();
	public static String ColumnViews = new String();
	public static String ColumnMale = new String();
	public static String ColumnFemale = new String();

	
	// url_info ���̺� ���� �ҷ�����
	public static String ColumnDate = new String();
	public static String ColumnTitle = new String();
	public static String ColumnText = new String();
	public static String ColumnImage = new String();
	
	public loadingMysql (int i) throws Exception {
		// 1.  ����̹� �ε�
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// ���̺� �̸� ���� �ʿ�
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newsbada","root","1111");
			System.out.println("DB Connection OK!");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("DB Driver Error!");
		} catch(SQLException se) {
			se.printStackTrace();
			System.out.println("DB Connection Error!");
		}
		
		
		// article ���̺��� ���� �ҷ�����
		String sql = "select * from article";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				if(rs.getInt("A_Number")==i){
					// article ���̺��� ���� �ҷ�����
					ColumnURL = rs.getString("Url");
					ColumnTheme = rs.getString("Theme");
					ColumnPname = rs.getString("P_name");
					ColumnViews = rs.getString("Views");
					ColumnMale = rs.getString("Male");
					ColumnFemale = rs.getString("Female");
					
					System.out.println("url: "+ColumnURL);
					System.out.println("Theme: "+ColumnTheme);
					System.out.println("P_name: "+ColumnPname);
					System.out.println("Views: "+ColumnViews);
					System.out.println("Male: "+ColumnMale);
					System.out.println("Female: "+ColumnFemale);
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// article ���̺��� ���� �ҷ�����
		String sql2 = "select * from url_info where Url = '" + ColumnURL+"'";
		try {
			Statement stmt1 = conn.createStatement();
			ResultSet rs1 = stmt1.executeQuery(sql2);
			
			while(rs1.next()){
				// article ���̺��� ���� �ҷ�����
				ColumnDate = rs1.getString("Date");
				ColumnTitle = rs1.getString("A_title");
				ColumnText = rs1.getString("A_text");
				ColumnImage = rs1.getString("A_img");
					
				System.out.println("P_name: "+ColumnDate);
				System.out.println("Views: "+ColumnTitle);
				System.out.println("Male: "+ColumnText);
				System.out.println("Female: "+ColumnImage);
				}
			
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}


