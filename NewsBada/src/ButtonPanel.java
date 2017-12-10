

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.AbstractAction;
import javax.swing.AbstractButton;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

import com.mysql.jdbc.Blob;

public class ButtonPanel extends JPanel implements ActionListener {
   
    // MySQL ����
    String url = "jdbc:mysql://localhost:3306/newsbada";  //newsbada <- mysql�� �ִ� (���� �ҷ���) ��Ű�� �̸�
    String user = "root"; 
    String password = "1111";  // �ڱⲨ ��й�ȣ
    Connection myConn = null;
    PreparedStatement myStmt = null;
    ResultSet myRs = null;
    int Num;
    String Theme;
    String Title;
    
    private static final int IMG_WIDTH = 300;
    private static final int IMG_HEIGHT = 200;
    ArrayList<Article> list;
    
    
   public ButtonPanel(String theme , int n) {
      
	  setBackground(Color.MAGENTA);
      Num = n;
      Theme = theme;
      list = ImageDAO.returnImage(theme);


      
      JButton btnNewButton = new JButton(list.get(n-1).getTitle());
      btnNewButton.setVerticalTextPosition(SwingConstants.BOTTOM);
      btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
      btnNewButton.setBackground(Color.WHITE);
      btnNewButton.setFont(new Font("����", Font.BOLD, 15));
      btnNewButton.addActionListener(this);
      btnNewButton.setSize(IMG_WIDTH,IMG_HEIGHT);

	  ImageIcon image = new ImageIcon(new ImageIcon(list.get(n-1).getImage()).getImage()
				.getScaledInstance(IMG_WIDTH, IMG_HEIGHT, Image.SCALE_SMOOTH));
	  btnNewButton.setIcon(image);
      this.setSize(302,187);
      GroupLayout groupLayout = new GroupLayout(this);
      groupLayout.setHorizontalGroup(
      	groupLayout.createParallelGroup(Alignment.LEADING)
      		.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 302, Short.MAX_VALUE)
      );
      groupLayout.setVerticalGroup(
      	groupLayout.createParallelGroup(Alignment.LEADING)
      		.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 187, Short.MAX_VALUE)
      );
      setLayout(groupLayout);

   }

   @Override
   public void actionPerformed(ActionEvent arg0) {
      
      new ArticleViewPage(Theme,Num);
      
   }


}