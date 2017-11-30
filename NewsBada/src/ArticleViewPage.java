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
		this.ColumnID = columnID;
		try {
			loadingMysql lm = new loadingMysql(ColumnID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setLocation(150, 100);
		GridLayout gl = new GridLayout(2,1);
		frame.setLayout(gl);
		frame.setSize(800, 1200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton();
		
		// Image File insert here!
		try {
			String path = new String();
			path = lm.ColumnImage;
			if (path != null) {
				System.out.println(path);
				URL image = new URL(path);
				BufferedImage img = ImageIO.read(image);
				btnNewButton.setIcon(new ImageIcon(img));
			}
			else btnNewButton.setIcon(new ImageIcon());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		frame.getContentPane().add(btnNewButton);
		
		JPanel innerFrame = new JPanel();
		GridLayout innerGl = new GridLayout(3,1);
		innerFrame.setLayout(innerGl);
		innerFrame.setSize(800, 600);
		
		frame.getContentPane().add(innerFrame);
		
		// ���� Ÿ��Ʋ ���� �κ�
		textTitle = new JTextField();
		
		//News Text insert here
		if (lm.ColumnTitle != null){
			ColumnTitle = lm.ColumnTitle;
			textTitle.setText(lm.ColumnTitle);
		}
		else {
			textTitle.setText("���� ������ �� �����ϴ�.");
		}
		innerFrame.add(textTitle);
		textTitle.setColumns(10);
		
		// ���� �ؽ�Ʈ ���� �κ�
		textField = new JTextField();
		
		// News Title insert here
		if (lm.ColumnText != null){
			ColumnText = lm.ColumnText;
			textField.setText(lm.ColumnText);
		}
		else{
			textTitle.setText("���� ������ �� �����ϴ�.");
		}
		
		innerFrame.add(textField);
		textField.setColumns(10);
		
		
		// �߰� �޴� ����
		
		frame.pack();
		frame.setVisible(true);
		
	}

}

class loadingMysql {
	
	//static Statement stmt = null;
	static Connection conn = null;
	
	public String ColumnTitle = new String();
	public String ColumnURL = new String();
	public String ColumnText = new String();
	public String ColumnImage = new String();
	
	public loadingMysql (int i) throws Exception {
		// 1.  ����̹� �ε�
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcpractice","root","1111");
			System.out.println("DB Connection OK!");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("DB Driver Error!");
		} catch(SQLException se) {
			se.printStackTrace();
			System.out.println("DB Connection Error!");
		}
		
		String sql = "select * from mytable";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				if(rs.getInt("A_Number")==i){
					ColumnTitle = rs.getString("Title");
					ColumnText = rs.getString("text");
					ColumnURL = rs.getString("Url");
					ColumnImage = rs.getString("Imgurl");
					System.out.println("title: "+ColumnTitle);
					System.out.println("url: "+ColumnURL);
					System.out.println("Text: "+ColumnText);
					System.out.println("Imgurl: "+ColumnImage);
					}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

