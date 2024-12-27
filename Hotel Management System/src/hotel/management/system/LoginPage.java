package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class LoginPage extends JFrame implements ActionListener {
    
    JTextField userText;
    JPasswordField passText; // for displaying passwordin the form ....
    JButton login;
    JButton cancel;
    
    
    
    LoginPage() {
        setSize(600, 300);
        setLocation(500, 200);
        setLayout(null);
        
        JLabel Username = new JLabel("Username: ");
        Username.setBounds(40, 20, 100, 30);
        Username.setFont(new Font("Arial", Font.BOLD, 14));
        add(Username);
        
        userText = new JTextField();
        userText.setBounds(150, 20, 150, 30);
        add(userText);
        
        JLabel password = new JLabel("Password: ");
        password.setBounds(40, 60, 100 ,30);
        password.setFont(new Font("Arial", Font.BOLD, 14));
        add(password);
        
        passText = new JPasswordField();
        passText.setBounds(150, 60, 150, 30);
        add(passText);
        
        
        login = new JButton("Login");
        login.setBounds(40, 150, 120, 30);
        login.addActionListener(this);
        add(login);
        
        
        cancel = new JButton("Cancel");
        cancel.setBounds(180, 150, 120, 30);
        cancel.addActionListener(this);
        add(cancel);
        
        
        ImageIcon loginImage = new ImageIcon(ClassLoader.getSystemResource("Images/second.jpg"));
        Image i2 = loginImage.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(330, 10, 200, 200);
        add(image);
        
        
        setVisible(true);
       
    }
    
    public void actionPerformed(ActionEvent ae) {
        
        if (ae.getSource() == login) {
            String user = userText.getText();
            String pass = passText.getText();
            
            try {
                DBConnection  connection = new DBConnection();
                
                String query = "select * from login where username = '"+ user + "' and password = '"+pass + "'";
                
                ResultSet rs = connection.s.executeQuery(query);
                
                if(rs.next()) {
                    setVisible(false);
                    Dashboard dashboard = new Dashboard();
                    
                }else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                    setVisible(false);
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
        }else if(ae.getSource() == cancel) {
            setVisible(false);
        }
        
        
    }
    
    public static void main(String[]args) {
        LoginPage login = new LoginPage();   
        
    }
}
