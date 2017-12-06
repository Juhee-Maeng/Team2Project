

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

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.AbstractAction;
import javax.swing.AbstractButton;

import java.awt.Graphics2D;
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
    
    String Title;
    java.sql.Blob blob;
    int bloblength;
    byte[] bytes;
    
    private static final int IMG_WIDTH = 300;
    private static final int IMG_HEIGHT = 200;
    
    // �̹��� ��� method
   private static BufferedImage resizeImage(BufferedImage originalImage, int type){
            
       BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
       Graphics2D g = resizedImage.createGraphics();
       g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
       g.dispose();

       return resizedImage;
   }

    
   public ButtonPanel(String theme , int n) {
      setBackground(Color.MAGENTA);
      
      
      try {
         // 1. Get connection
         myConn = DriverManager.getConnection(url, user, password);
         // 2. Create a statement

         myStmt = myConn.prepareStatement("SELECT A_img,A_title "
         		+ "FROM url_info,article "
         		+ "WHERE url_info.Url = article.Url AND article.Theme = ?"
               + "ORDER BY Date DESC LIMIT ?,1");
         // 3. Set the parameters
         myStmt.setString(1, theme);
         myStmt.setInt(2, n-1);      
         // 4. Execute SQL query
         ResultSet rs = myStmt.executeQuery(); //����ؼ� ���� �����
         if(rs.next()){ ///////////////////// title��  �̹��� blob���� �ҷ��Ͷ�
            Title = rs.getString("A_title");
            blob = rs.getBlob("A_img");
            bloblength = (int)blob.length();
            bytes = blob.getBytes(1, bloblength);
            blob.free();
         }
         System.out.println("Done");

      }

      catch (Exception exc) {
         exc.printStackTrace();
      }
      
      JButton btnNewButton = new JButton(Title);
      btnNewButton.setVerticalTextPosition(SwingConstants.BOTTOM);
      btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
      btnNewButton.setBackground(Color.WHITE);
      btnNewButton.setFont(new Font("����", Font.BOLD, 15));
      btnNewButton.addActionListener(this);
      btnNewButton.setSize(IMG_WIDTH,IMG_HEIGHT);

      
        BufferedImage img;
        BufferedImage newimg;
         try {
            img = ImageIO.read(new ByteArrayInputStream(bytes));
            int type = img.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : img.getType();
            newimg = resizeImage(img,type);
            ImageIcon pic = new ImageIcon(newimg);
            btnNewButton.setIcon(pic);
         } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }

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
      
      System.out.println("yeah");
      
   }


}