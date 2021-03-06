import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.SystemColor;
import javax.swing.UIManager;

import com.mysql.jdbc.PreparedStatement;

public class ArticleViewPage {

	private JFrame frame;
	JPanel panel = new JPanel();
	private JTextArea textField;  // 뉴스텍스트
	private JTextField textTitle;  // 뉴스타이틀
	private JTextField text;  // 추가메뉴

	private JLabel lblNewsbade;
	private JTextField textField_1;
	
	// article 테이블 정보 불러오기
	String ColumnURL;
	String ColumnTheme;
	String ColumnPname;
	static int ColumnViews;
	static int ColumnMale ;
	static int ColumnFemale;
	int ColumnA_number;
	JButton caller;
	// url_info 테이블 정보 불러오기
	String ColumnDate;
	String ColumnTitle;
	String ColumnText;
	byte[] ColumnImage;
	
    // MySQL 연결
    static String url = "jdbc:mysql://localhost:3306/newsbada";  //newsbada <- mysql에 있는 (내가 불러올) 스키마 이름
    static String user = "root"; 
    static String password = "1111";  // 자기꺼 비밀번호
    
	Connection myConn = null;
	java.sql.PreparedStatement myStmt = null;
	ResultSet rs = null;


	/**
	 * Create the application.
	 */
	public ArticleViewPage(JButton caller_input,String theme, int n) {
		
		caller = caller_input;
		
		
		try {
	         // 1. Get connection
	         myConn = DriverManager.getConnection(url, user, password);
	         // 2. Create a statement
	    
	         myStmt = myConn.prepareStatement("SELECT article.Url,A_img,Theme,A_title,Views,A_Number,P_name,Male,Female,Date,A_text "
	         		+ "FROM url_info,article WHERE url_info.Url=article.Url AND theme = ? AND A_Number = ? ORDER BY Views DESC");
	         
	         myStmt.setString(1, theme);
	         myStmt.setInt(2, n);
	         // 4. Execute SQL query
	         ResultSet rs = myStmt.executeQuery();
	
	         if(rs.next()){

	        	 ColumnURL = (rs.getString("Url"));
	        	 ColumnImage = (rs.getBytes("A_img"));
	        	 ColumnTheme  = (rs.getString("Theme"));
	        	 ColumnTitle = (rs.getString("A_title"));
	        	 ColumnViews = (rs.getInt("Views"));
	        	 ColumnA_number  = (rs.getInt("A_Number"));
	        	 ColumnPname  = (rs.getString("P_name"));
	        	 ColumnMale = (rs.getInt("Male"));
	        	 ColumnFemale = (rs.getInt("Female"));
	        	 ColumnDate =  (rs.getString("Date"));
	        	 ColumnText =  (rs.getString("A_text"));

	         }	
		   } catch (Exception exc) {
		         exc.printStackTrace();
	  	   }

		
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.text);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
	     frame.addWindowListener(new WindowListener() {
				
				@Override
				public void windowOpened(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void windowIconified(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void windowDeiconified(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void windowDeactivated(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void windowClosing(WindowEvent e) {
					caller.setEnabled(true);
					
				}
				
				@Override
				public void windowClosed(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void windowActivated(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}
			});
		
		JButton btnNewButton = new JButton();
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Desktop desktop = Desktop.getDesktop();
				try {
					desktop.browse(new URI(ColumnURL));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		// Image File insert here!
		
		try {
			
				ImageIcon image = new ImageIcon(new ImageIcon(ColumnImage).getImage()
						.getScaledInstance(400, 300, Image.SCALE_SMOOTH));
				btnNewButton.setIcon(image);


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 뉴스 텍스트 삽입 부분
		textField = new JTextArea();
		textField.setBackground(UIManager.getColor("CheckBox.background"));
		textField.setEditable(false);
		textField.setLineWrap(true);
		textField.setFont(new Font("굴림", Font.PLAIN, 20));
		textField.setColumns(10);
			
		// News Field insert here
		if (ColumnText != null){

			textField.setText(ColumnText);
		}
		else{
			textField.setText("값을 가져올 수 없습니다.");
		}

		// 뉴스 타이틀 삽입 부분
		textTitle = new JTextField();
		textTitle.setBackground(UIManager.getColor("Button.light"));
		textTitle.setEditable(false);
		textTitle.setFont(new Font("굴림", Font.PLAIN, 24));
		textTitle.setColumns(10);
		if (ColumnTitle != null){
			textTitle.setText(ColumnTitle);
		}
		else {
			textTitle.setText("값을 가져올 수 없습니다.");
		}
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.textHighlight);
		
//		// 수정
		int sum = ColumnFemale + ColumnMale;
		int a;
		int b;
		if(sum == 0){
			a = 0;
			b = 0;
		}

		else{
			a = ColumnMale*100 / sum;
			b = ColumnFemale*100 / sum;
		}

		JLabel lblMan = new JLabel("남자: "+a + "%");
		lblMan.setForeground(Color.BLUE);
		lblMan.setFont(new Font("굴림", Font.BOLD, 22));
		
		// 수정
		JLabel lblFemale = new JLabel("여자: "+b + "%");
		lblFemale.setForeground(Color.RED);
		lblFemale.setFont(new Font("굴림", Font.BOLD, 22));
		
		// URL, 신문사, 날짜
		textField_1 = new JTextField();
		textField_1.setBackground(UIManager.getColor("Button.disabledShadow"));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setText(ColumnURL+"                    "+ColumnPname+"                    "+ColumnDate);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel.setText("\uC870\uD68C\uC218: "+ColumnViews);
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 579, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 1112, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 425, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
											.addComponent(lblFemale, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(lblMan, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(textField_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
										.addComponent(textTitle, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
										.addComponent(textField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE))))
							.addGap(10))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textTitle, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE))
					.addGap(10)
					.addComponent(lblMan, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblFemale, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel))
		);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{489, 134, 0};
		gbl_panel_1.rowHeights = new int[]{28, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		
	
		lblNewsbade = new JLabel("NewsBada");
		lblNewsbade.setForeground(SystemColor.textHighlightText);
		lblNewsbade.setFont(new Font("HY목각파임B", Font.BOLD, 30));
		GridBagConstraints gbc_lblNewsbade = new GridBagConstraints();
		gbc_lblNewsbade.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewsbade.gridx = 1;
		gbc_lblNewsbade.gridy = 1;
		panel_1.add(lblNewsbade, gbc_lblNewsbade);
		frame.getContentPane().setLayout(groupLayout);
		
		
		// 추가 메뉴 삽입
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
}


	



