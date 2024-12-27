package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class addEmployee extends JFrame implements ActionListener {
    
    JTextField nameText;
    JTextField ageText;
    JTextField salaryText;
    JTextField phoneText;
    JTextField emailText;
    JTextField aadharText;
    JRadioButton male;
    JRadioButton female;
    JComboBox jobs;
    JButton submit;
    
    
    
    addEmployee() {
        setSize(850, 540);
        setLocation(350, 200);
        setLayout(null);
        
        JLabel name = new JLabel("NAME: ");
        name.setBounds(60, 30, 120, 30);
        name.setFont(new Font("arial", Font.BOLD, 20));
        add(name);
        
        nameText = new JTextField();
        nameText.setBounds(180, 30, 200, 30);
        add(nameText);
        
        JLabel age = new JLabel("AGE: ");
        age.setFont(new Font("arial", Font.BOLD, 20));
        age.setBounds(60, 80, 120, 30);
        add(age);
        
        ageText = new JTextField();
        ageText.setBounds(180, 80, 200, 30);
        add(ageText);
        
        JLabel gender = new JLabel("GENDER: ");
        gender.setFont(new Font("arial", Font.BOLD, 20));
        gender.setBounds(60, 130, 120, 30);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(180, 130, 100, 30);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(280, 130, 100, 30);
        add(female);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);
        
        JLabel job = new JLabel("JOB: ");
        job.setFont(new Font("Arial", Font.BOLD, 20));
        job.setBounds(60, 180, 120, 30);
        add(job);
        
        String jobList [] = {"Front Desk Clerk", "Porters", "Housekeeping", "Kitchen Staff", "Roon Service", "Chefs",
        "Waiter/Waitress", "Manager", "Accountant"};
        jobs  = new JComboBox(jobList);
        jobs.setBounds(180, 180, 200, 30);
        add(jobs);
        
        JLabel salary = new JLabel("Salary: ");
        salary.setFont(new Font("Arial", Font.BOLD, 20));
        salary.setBounds(60, 230, 120, 30);
        add(salary);
        
        salaryText = new JTextField();
        salaryText.setBounds(180, 230, 200, 30);
        add(salaryText);
        
        JLabel phone = new JLabel("PHONE: ");
        phone.setFont(new Font("Arial", Font.BOLD, 20));
        phone.setBounds(60, 280, 120, 30);
        add(phone);
        
        phoneText = new JTextField();
        phoneText.setBounds(180, 280, 200, 30);
        add(phoneText);
        
        JLabel email = new JLabel("EMAIL: ");
        email.setFont(new Font("Arial", Font.BOLD, 20));
        email.setBounds(60, 330, 120, 30);
        add(email);
        
        emailText = new JTextField();
        emailText.setBounds(180, 330, 200, 30); 
        add(emailText);
        
        JLabel aadhar = new JLabel("AADHAR: ");
        aadhar.setFont(new Font("Arial", Font.BOLD, 20));
        aadhar.setBounds(60, 380, 120, 30);
        add(aadhar);
        
        aadharText = new JTextField();
        aadharText.setBounds(180, 380, 200, 30);  
        add(aadharText);
        
        submit = new JButton("SUBMIT");
        submit.setBounds(180, 430, 100, 30);
        submit.addActionListener(this);
        add(submit);
        
        ImageIcon employeeImage = new ImageIcon(ClassLoader.getSystemResource("Images/addEmployeeImage.jpg"));
        Image i2 = employeeImage.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380, 60, 450, 370);
        add(image);
        
        getContentPane().setBackground(Color.WHITE);
        
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        String name = nameText.getText();
        String age = ageText.getText();
        String phone = phoneText.getText();
        String salary = salaryText.getText();
        String email = emailText.getText();
        String aadhar = aadharText.getText();
        
        String gender = null;
        
        if(male.isSelected()) {
            gender = "Male";
        }else if(female.isSelected()) {
            gender = "Female";
        }
        
        String job = (String) jobs.getSelectedItem();
        
        try {
            DBConnection connection = new DBConnection();
            
            String query = "insert into employee values('"+name+"', '"+age+"', '"+gender+"', '"+job+"', '"+salary+"', '"+phone+"', '"+email+"', '"+aadhar+"')";
            
            connection.s.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null, "Employee added successfully");
            setVisible(false);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[]args) {
        addEmployee add = new addEmployee();
    }
    
}
