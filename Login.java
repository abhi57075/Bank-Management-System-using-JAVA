package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JButton login, signup, clear, administrator;
    JTextField cardTextField;
    JPasswordField pinTextField;
    
    Login(){
        
       setTitle("Automated Teller Machine");
       
       setLayout(null);
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
       Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel label = new JLabel(i3);
       label.setBounds(70, 10, 100, 100);
       add(label);
       
       JLabel text = new JLabel("Welcome to ATM");
       text.setFont(new Font("Osward", Font.BOLD, 38));
       text.setBounds(200, 40, 400, 40); // 40 se chalu ho raha hai and 40 iski length hai
       add(text);
       
       JLabel cardno = new JLabel("Card no : ");
       cardno.setFont(new Font("Railway", Font.BOLD, 28));
       cardno.setBounds(120, 150, 150, 28);
       add(cardno);
       
       cardTextField = new JTextField();
       cardTextField.setBounds(300, 150, 250, 28);
       // here 300 is x, 150 is y, 250 is length and 28 is the width
       cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
       add(cardTextField);
       
       JLabel pin = new JLabel("PIN : ");
       pin.setFont(new Font("Railway", Font.BOLD, 28));
       pin.setBounds(120, 220, 150, 28);
       add(pin);
       
       pinTextField = new JPasswordField();
       pinTextField.setBounds(300, 220, 250, 28);
       pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
       add(pinTextField);
       
       login = new JButton(" SIGN IN ");
       login.setBounds(300, 300, 115, 30);
       login.setBackground(Color.BLACK);
       login.setForeground(Color.WHITE);
       login.addActionListener(this);
       add(login); 
       
       clear = new JButton(" CLEAR ");
       clear.setBounds(430, 300, 115, 30);
       clear.setBackground(Color.BLACK);
       clear.setForeground(Color.WHITE);
       clear.addActionListener(this);
       add(clear); 
       
       signup = new JButton(" SIGNUP ");
       signup.setBounds(300, 345, 115, 30);
       signup.setBackground(Color.BLACK);
       signup.setForeground(Color.WHITE);
       signup.addActionListener(this);
       add(signup); 
       
       administrator = new JButton("ADMIN LOGIN");
       administrator.setBounds(430, 345, 115, 30);
       administrator.setBackground(Color.BLACK);
       administrator.setForeground(Color.WHITE);
       administrator.addActionListener(this);
       add(administrator);
       
       getContentPane().setBackground(Color.WHITE);
       
       setSize(800,480); 
       setVisible(true);
       setLocation(350,200); 
       
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if (ae.getSource() == clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }
        
        else if (ae.getSource() == login){
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            
            if(cardnumber.length()!= 16 || pinnumber.length() != 4){
                JOptionPane.showMessageDialog(null, "Please enter appropriate details");
            }
            
            else{
                Conn conn = new Conn();
                String query = "select * from login where cardnumber =  '"+cardnumber+"' and pin = '"+pinnumber+"'";
                
                try{
                    String query2 = "select * from suspend where accountno = '"+cardnumber+"'";
                    ResultSet rs2 = conn.s.executeQuery(query2);
                    if(rs2.next()){
                       JOptionPane.showMessageDialog(null,"Your account has been suspended by the Admin");
                       return;
                    }
                    
                    ResultSet rs = conn.s.executeQuery(query); // ResultSet is available in sql package
                    
                    if(rs.next()){
                        String formno = rs.getString("formno");
                        setVisible(false);
                        new Transactions(formno).setVisible(true);
                    }
                    
                    else{
                        JOptionPane.showMessageDialog(null,"Incorrect card number or PIN"); 
                    }
                    
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
        }
        
        else if (ae.getSource() == signup){
            setVisible(false);
            new SignupOne().setVisible(true);
        }
        
        else if (ae.getSource() == administrator){
            setVisible(false);
            new Admin().setVisible(true);
        }
        
    }
    
    public static void main(String args[]){
        new Login();
    }
    
}
