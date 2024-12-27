package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener {
    
    HotelManagementSystem() {
        setSize(1366, 565);
        setLocation(100, 100);
        
        setLayout(null);
        
        ImageIcon originalImage = new ImageIcon(ClassLoader.getSystemResource("Images/first.jpg"));
        Image scaledImage = originalImage.getImage().getScaledInstance(1366, 565, Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(scaledImage);
        
        JLabel imageLabel = new JLabel(image);
        imageLabel.setBounds(0,0,1366, 565);
        add(imageLabel);
        
        
        JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
        text.setBounds(20, 430, 1000, 90);
        text.setForeground(Color.BLACK);
        text.setFont(new Font("serif", Font.PLAIN, 50));
        
        
        
        imageLabel.add(text);
        
        JButton next = new JButton("Next");
        next.setBounds(1150, 450, 150, 50);
        next.addActionListener(this);
        imageLabel.add(next);
        
        setVisible(true);
        
        while(true) {
            text.setVisible(false);
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace(); 
            }
            text.setVisible(true);
        }
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        LoginPage login = new LoginPage();
    }

    
    public static void main(String[] args) {
        HotelManagementSystem hotelManagementSystem = 
                new HotelManagementSystem();
    }
    
}
