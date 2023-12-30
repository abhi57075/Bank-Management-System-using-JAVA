package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
    
    JButton hundred, fivehundred, onek, twok, fivek, tenk, back;
    String formno;
    
    FastCash(String formno){
        
        this.formno = formno;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Select Withdrawl amount");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);
        
        hundred = new JButton("Rs 100");
        hundred.setBounds(170, 415, 150, 30);
        hundred.addActionListener(this);
        image.add(hundred);
        
        fivehundred = new JButton("Rs 500");
        fivehundred.setBounds(355, 415, 150, 30);
        fivehundred.addActionListener(this);
        image.add(fivehundred);
        
        onek = new JButton("Rs 1000");
        onek.setBounds(170, 450, 150, 30);
        onek.addActionListener(this);
        image.add(onek);
        
        twok = new JButton("Rs 2000");
        twok.setBounds(355, 450, 150, 30);
        twok.addActionListener(this);
        image.add(twok);
        
        fivek = new JButton("Rs 5000");
        fivek.setBounds(170, 485, 150, 30);
        fivek.addActionListener(this);
        image.add(fivek);
        
        tenk = new JButton("Rs 10000");
        tenk.setBounds(355, 485, 150, 30);
        tenk.addActionListener(this);
        image.add(tenk);
        
        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true); // removes the title
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if (ae.getSource() == back){
            setVisible(false);
            new Transactions(formno).setVisible(true);
        }
        
        else{
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where formno = '"+formno+"'");
                int balance = 0;
                while(rs.next()){
                    if (rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }
                    
                    else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                
                if (ae.getSource() != back && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                
                Date date = new Date();
                String query = "insert into bank values('"+formno+"', '"+date+"', 'Withdrawl', '"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs " + amount + " Debited Successfully");
                
                setVisible(false);
                new Transactions(formno).setVisible(true);
            }
            
            catch(Exception e){
                System.out.println(e);
            }
        }

    }
    
    public static void main(String args[]){
        new FastCash("");
    }
    
}
