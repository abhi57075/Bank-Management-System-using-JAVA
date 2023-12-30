package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AdminPage extends JFrame implements ActionListener{
    
     JButton delete,suspend,reactivate,back;
     JTextField accountno;
     
     AdminPage(){
         
       setTitle("Admin Page");
       
       setLayout(null);
       
       JLabel text = new JLabel("Enter the account number ");
       text.setFont(new Font("Osward", Font.BOLD, 38));
       text.setBounds(200, 40, 500, 40); // 40 se chalu ho raha hai and 40 iski length hai
       add(text);
       
       JLabel account = new JLabel("Account number : ");
       account.setFont(new Font("Railway", Font.BOLD, 28));
       account.setBounds(100, 150, 300, 28);
       add(account);
       
       accountno = new JTextField();
       accountno.setBounds(400, 150, 250, 28);
       // here 300 is x, 150 is y, 250 is length and 28 is the width
       accountno.setFont(new Font("Arial", Font.BOLD, 14));
       add(accountno);
       
       delete = new JButton(" DELETE ");
       delete.setBounds(100, 300, 125, 30);
       delete.setBackground(Color.WHITE);
       delete.setForeground(Color.BLACK);
       delete.addActionListener(this);
       add(delete); 
       
       suspend = new JButton(" SUSPEND ");
       suspend.setBounds(250, 300, 125, 30);
       suspend.setBackground(Color.WHITE);
       suspend.setForeground(Color.BLACK);
       suspend.addActionListener(this);
       add(suspend); 
       
       reactivate = new JButton(" RE-ACTIVATE ");
       reactivate.setBounds(400, 300, 125, 30);
       reactivate.setBackground(Color.WHITE);
       reactivate.setForeground(Color.BLACK);
       reactivate.addActionListener(this);
       add(reactivate); 
       
       back = new JButton(" Back ");
       back.setBounds(550, 300, 125, 30);
       back.setBackground(Color.WHITE);
       back.setForeground(Color.BLACK);
       back.addActionListener(this);
       add(back); 
       
       getContentPane().setBackground(new Color(230,230,250));
       
       setSize(800,480); 
       setVisible(true);
       setLocation(350,200); 
       
    }
    
    public void actionPerformed(ActionEvent ae){
        
        String acc = accountno.getText(); 
        String query = "select * from login where cardnumber = '"+acc+"'";
        
        if (ae.getSource() == delete){    
                Conn conn = new Conn();
                try{
                    ResultSet rs = conn.s.executeQuery(query); // ResultSet is available in sql package
                    if(rs.next()){
                        String query2 = "delete from login where cardnumber = '"+acc+"'";
                        conn.s.executeUpdate(query2);
                        JOptionPane.showMessageDialog(null,"Account Deleted Successfully ");
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Incorrect Account Number "); 
                    }
                }
                catch(Exception e){
                    System.out.println(e);
                }
                
        }
        
        else if (ae.getSource() == suspend){
            
                Conn conn = new Conn();
                String query3 = "insert into suspend values ('"+acc+"')";
                try{
                    ResultSet rs = conn.s.executeQuery(query);
                    if (rs.next()){
                        conn.s.executeUpdate(query3); // ResultSet is available in sql package
                        JOptionPane.showMessageDialog(null,"Account Suspended Successfully ");
                    }
                    else{
                       JOptionPane.showMessageDialog(null,"Incorrect Account Number "); 
                    }
                }
                catch(Exception e){
                    System.out.println(e);
                }
                
        }
        
        else if(ae.getSource() == reactivate){
                
                Conn conn = new Conn();
                String query4 = "delete from suspend where accountno = '"+acc+"'";
                try{
                   ResultSet rs = conn.s.executeQuery(query);
                   if (rs.next()){
                       conn.s.executeUpdate(query4); // ResultSet is available in sql package
                       JOptionPane.showMessageDialog(null,"Account Re-Activated Successfully ");
                   }
                   else{
                       JOptionPane.showMessageDialog(null,"Incorrect Account Number ");
                   }  
                }
                catch(Exception e){
                    System.out.println(e);
                }
                
        }
        
        else if(ae.getSource() == back){
            setVisible(false);
            new Login().setVisible(true);
        
        }
        
    }
    
    public static void main(String args[]){
        new AdminPage();
    }
    
}
