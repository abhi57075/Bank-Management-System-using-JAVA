package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

public class SignupThree extends JFrame implements ActionListener {
    
    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;
    String formno;
    
    String cardnumber;
    
    SignupThree(String formno){
        
        this.formno = formno;
        
        setLayout(null);
        
        JLabel l1 = new JLabel("Page 3 : Account Details");
        l1.setFont(new Font("Railway",Font.BOLD,22));
        l1.setBounds(280,40,400,40);
        add(l1);
        
        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Railway",Font.BOLD,22));
        type.setBounds(100,140,200,30);
        add(type);
        
        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Railway",Font.BOLD,16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100,180,250,20);
        add(r1);
        
        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Railway",Font.BOLD,16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350,180,250,20);
        add(r2);
        
        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Railway",Font.BOLD,16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100,220,250,20);
        add(r3);
        
        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Railway",Font.BOLD,16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350,220,250,20);
        add(r4);
        
        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);
        
        JLabel card = new JLabel("Card Number :");
        card.setFont(new Font("Railway",Font.BOLD,22));
        card.setBounds(100,270,500,30);
        add(card);
        
        JLabel number = new JLabel("XXXX-XXXX-XXXX-4184"); // this is a dummy card no
        number.setFont(new Font("Railway",Font.BOLD,22));
        number.setBounds(330,270,500,30);
        add(number);
        
        JLabel carddetail = new JLabel("Your 16 digit card no : "); // this is a dummy card no
        carddetail.setFont(new Font("Railway",Font.BOLD,22));
        carddetail.setBounds(100,300,500,30);
        add(carddetail);
        
        JLabel pin = new JLabel("PIN :");
        pin.setFont(new Font("Railway",Font.BOLD,22));
        pin.setBounds(100,350,500,30);
        add(pin);
        
        JLabel pnumber = new JLabel("XXXX"); // this is a dummy pin no
        pnumber.setFont(new Font("Railway",Font.BOLD,22));
        pnumber.setBounds(330,350,500,30);
        add(pnumber);
        
        JLabel pindetail = new JLabel("Your 4 digit password : "); // this is a dummy card no
        pindetail.setFont(new Font("Railway",Font.BOLD,22));
        pindetail.setBounds(100,380,500,30);
        add(pindetail);
        
        JLabel services = new JLabel("Services Required :");
        services.setFont(new Font("Railway",Font.BOLD,22));
        services.setBounds(100,430,500,30);
        add(services);
        
        c1 = new JCheckBox("ATM Card");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Railway",Font.BOLD,16));
        c1.setBounds(100, 460, 200, 30);
        add(c1);
        
        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Railway",Font.BOLD,16));
        c2.setBounds(350, 460, 200, 30);
        add(c2);
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Railway",Font.BOLD,16));
        c3.setBounds(100, 490, 200, 30);
        add(c3);
        
        c4 = new JCheckBox("Email and SMS alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Railway",Font.BOLD,16));
        c4.setBounds(350, 490, 200, 30);
        add(c4);
        
        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Railway",Font.BOLD,16));
        c5.setBounds(100, 520, 200, 30);
        add(c5);
        
        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Railway",Font.BOLD,16));
        c6.setBounds(350, 520, 200, 30);
        add(c6);
        
        c7 = new JCheckBox("I hereby declare that the above mentioned details are correct to the best of my knowledge");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Railway",Font.BOLD,16));
        c7.setBounds(100, 580, 1000, 30);
        c7.addActionListener(this);
        add(c7);
        
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Railway", Font.BOLD, 14));
        submit.setEnabled(false);
        submit.setBounds(250, 650, 100, 30);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Railway", Font.BOLD, 14));
        cancel.setBounds(420, 650, 100, 30);
        cancel.addActionListener(this);
        add(cancel);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,820);
        setLocation(350,0);
        setVisible(true);
        setTitle("Sign Up Page Three");
    }
    
    public void actionPerformed (ActionEvent ae){
        
        String accountType = "";
        if(ae.getSource() == c7){
            submit.setEnabled(true);
        }
        
        if(ae.getSource() == submit){  
            if(r1.isSelected()){
                accountType = "Saving Account";
            }
            
            else if (r2.isSelected()){
                accountType = "Fixed Deposit Account";
            }
            
            else if (r3.isSelected()){
                accountType = "Current Account";
            }
            
            else if (r4.isSelected()){
                accountType = "Recurring Deposit Account";
            }
            
            Random random = new Random();
            cardnumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
        
            boolean flag = true;
            try{
                while(flag == true){
                    String query = "select * from signupthree where cardnumber = '"+cardnumber+"'";
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery(query);
                    if (rs.next()){
                        cardnumber = "" + Math.abs(random.nextInt() % 1000);
                    }
                    
                    else{
                        flag = false;
                    }
                }
            }
            
            catch(Exception e){
                System.out.println(e);
            }
            
            
            String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
            
            String facility = "";
            
            if (c1.isSelected()){
                facility = facility + " ATM Card";
            }
            
            else if (c2.isSelected()){
                facility = facility + " Internet Banking";
            }
            
            else if (c3.isSelected()){
                facility = facility + " Mobile Banking";
            }
            
            else if (c4.isSelected()){
                facility = facility + " Email and SMS Alerts";
            }
            
            else if (c5.isSelected()){
                facility = facility + " Cheque Book";
            }
            
            else if (c6.isSelected()){
                facility = facility + " E-Statement";
            }
            
            try{
                if (accountType.equals("")){
                    JOptionPane.showMessageDialog(null, "Account Type is Required");
                }
                
                else{
                    Conn conn = new Conn();
                    
                    String query1 = "insert into signupthree values('"+formno+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                    String query2 = "insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";

                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);
                    
                    JOptionPane.showMessageDialog(null, "Card Number : " + cardnumber + "\nPin :" + pinnumber);
                    
                    setVisible(false);
                    new Deposit(formno).setVisible(true);
                }  
            }
            
            catch(Exception e){
                System.out.println(e);
            }
            
        }
        
        else if (ae.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
        
    }
   
    public static void main(String args[]){
        new SignupThree("");
    }
    
}
