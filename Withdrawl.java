package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date; // for Date class
import java.sql.ResultSet;

public class Withdrawl extends JFrame implements ActionListener{
    
    JTextField amount;
    JButton withdraw, back;
    String formno;
    
    Withdrawl(String formno){
        this.formno = formno;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Enter the amount you want to withdraw");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(170,300,400,20);
        image.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Railway",Font.BOLD,22));
        amount.setBounds(170,350,320,25);
        image.add(amount);
        
        withdraw = new JButton("Withdraw");
        withdraw.setBounds(355,485,150,30);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if (ae.getSource() == withdraw){
            
            String number = amount.getText();
            int numb = Integer.parseInt(amount.getText());
            
            Date date = new Date();
            
            int balance = 0;
            
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from bank where formno = '"+formno+"'");
                while(rs.next()){
                    if (rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }
                    
                    else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }      
            }
            
            catch(Exception e){
                System.out.println(e);
            }
            
            if (number.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
            }
            
            else{
                try{
                    Conn conn = new Conn();
                    
                    if (balance >= numb){
                        String query = "insert into bank values ('"+formno+"', '"+date+"', 'Withdrawl', '"+number+"')";
                        conn.s.executeUpdate(query);
                        JOptionPane.showMessageDialog(null, "Rs " +number+ " Withdraw Successfully" );
                        setVisible(false);
                        new Transactions(formno).setVisible(true);
                    }
                    
                    else{
                        JOptionPane.showMessageDialog(null, "Insufficent Balance" );
                    }    
                }
                
                catch(Exception e){
                    System.out.println(e);
                }
            }
        }
        
        else if (ae.getSource() == back){
            setVisible(false);
            new Transactions(formno).setVisible(true);
        }
        
    }
    
    public static void main(String args[]){
        new Withdrawl("");
    }
    
}
