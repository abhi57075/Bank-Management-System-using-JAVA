package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Admin extends JFrame implements ActionListener{
    
    JButton login,clear;
    JTextField emailTextField;
    JPasswordField passwordTextField;
    
    Admin(){
        
       setTitle("Admin Login");
       
       setLayout(null);
       
       JLabel text = new JLabel("Enter Admin Details");
       text.setFont(new Font("Osward", Font.BOLD, 38));
       text.setBounds(200, 40, 400, 40); // 40 se chalu ho raha hai and 40 iski length hai
       add(text);
       
       JLabel email = new JLabel("Email : ");
       email.setFont(new Font("Railway", Font.BOLD, 28));
       email.setBounds(120, 150, 150, 28);
       add(email);
       
       emailTextField = new JTextField();
       emailTextField.setBounds(300, 150, 250, 28);
       // here 300 is x, 150 is y, 250 is length and 28 is the width
       emailTextField.setFont(new Font("Arial", Font.BOLD, 14));
       add(emailTextField);
       
       JLabel pin = new JLabel("Password : ");
       pin.setFont(new Font("Railway", Font.BOLD, 28));
       pin.setBounds(120, 220, 200, 28);
       add(pin);
       
       passwordTextField = new JPasswordField();
       passwordTextField.setBounds(300, 220, 250, 28);
       passwordTextField.setFont(new Font("Arial", Font.BOLD, 14));
       add(passwordTextField);
       
       login = new JButton(" SIGN IN ");
       login.setBounds(300, 300, 115, 30);
       login.setBackground(Color.WHITE);
       login.setForeground(Color.BLACK);
       login.addActionListener(this);
       add(login); 
       
       clear = new JButton(" CLEAR ");
       clear.setBounds(430, 300, 120, 30);
       clear.setBackground(Color.WHITE);
       clear.setForeground(Color.BLACK);
       clear.addActionListener(this);
       add(clear); 
       
       getContentPane().setBackground(new Color(153,50,204));
       
       setSize(800,480); 
       setVisible(true);
       setLocation(350,200); 
       
    }
    
    public void actionPerformed(ActionEvent ae){
        
        String semail = emailTextField.getText();
        String spassword = passwordTextField.getText();
        
        if (ae.getSource() == clear){
            emailTextField.setText("");
            passwordTextField.setText("");
        }
        
        else if (ae.getSource() == login){    
                Conn conn = new Conn();
                String query = "select * from admin where email =  '"+semail+"' and password = '"+spassword+"'";
                try{
                    ResultSet rs = conn.s.executeQuery(query); // ResultSet is available in sql package
                    if(rs.next()){
                        setVisible(false);
                        new AdminPage().setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Incorrect Email or Password"); 
                    }
                }
                catch(Exception e){
                    System.out.println(e);
                }
        }
        
    }
    
    public static void main(String args[]){
        new Admin();
    }
    
}
