package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener{
    
    JPasswordField pin, repin;
    JButton change, back;
    String formno;
    
    PinChange (String formno){
        
        this.formno = formno;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Change your PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(250,280,500,35);
        image.add(text);
        
        JLabel pintext = new JLabel("New PIN");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System", Font.BOLD, 16));
        pintext.setBounds(165,320,180,25);
        image.add(pintext);
        
        pin = new JPasswordField();
        pin.setFont(new Font("Railway", Font.BOLD, 25));
        pin.setBounds(330, 320, 180, 25);
        image.add(pin);
        
        JLabel repintext = new JLabel("Re-Enter New PIN");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System", Font.BOLD, 16));
        repintext.setBounds(165,360,180,25);
        image.add(repintext);
        
        repin = new JPasswordField();
        repin.setFont(new Font("Railway", Font.BOLD, 25));
        repin.setBounds(330, 360, 180, 25);
        image.add(repin);
        
        change = new JButton("Change");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true); 
        
    }
    
    public void actionPerformed(ActionEvent ae){
        String npin = pin.getText();
        String rpin = repin.getText();
        
        if (ae.getSource() == change){
            try{ 
                if (!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match ");
                    return;
                }
                
                if (npin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter new PIN");
                    return;
                }
                
                if (rpin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please re-enter new PIN");
                    return;
                }
                
                if (npin.length()!=4 && rpin.length()!=4){
                    JOptionPane.showMessageDialog(null, "The PIN should be of exactly 4 digits");
                    return;
                }
                
                Conn conn = new Conn();
                String query2 = "update login set pin = '"+npin+"' where formno = '"+formno+"'";
                String query3 = "update signupthree set pin = '"+npin+"' where formno = '"+formno+"'";
                
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);
                
                JOptionPane.showMessageDialog(null, "PIN changed Successfully");
                
                setVisible(false);
                new Transactions(formno).setVisible(true);
                
            }
            
            catch(Exception e){
                System.out.println(e);
            }
            
        }
        
        else{
            setVisible(false);
            new Transactions(formno).setVisible(true);
        }
        
    }
    
    public static void main(String args[]){
        new PinChange("").setVisible(true);
    }
    
}
