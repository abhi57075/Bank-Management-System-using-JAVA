package bank.management.system;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

import java.io.FileNotFoundException;


public class MiniStatement extends JFrame implements ActionListener {
    
    JButton download;
    JTable table;
    String formno;
    
    MiniStatement(String formno){
        
        this.formno = formno;
        
        setTitle("Mini Statement");
        
        setLayout(null);
        
        JLabel mini = new JLabel();
        mini.setBounds(20,140,400,200);
        add(mini);
        
        download = new JButton("Download");
        download.setFont(new Font("Railway",Font.BOLD, 16));
        download.setBounds(200,600,150,30);
        download.setBackground(new Color(0,165,255));
        download.setForeground(Color.WHITE);
        download.addActionListener(this);
        add(download);
        
        JLabel bank = new JLabel("Indian Bank");
        bank.setFont(new Font("Serif",Font.BOLD,36));
        bank.setBounds(100,20,400,100);
        bank.setForeground(Color.RED);
        add(bank);
        
        JLabel card = new JLabel();
        card.setBounds(20,175,400,20);
        add(card);
        
        JLabel balance  = new JLabel();
        balance.setBounds(20,400,400,20);
        add(balance);
        
        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where formno = '"+formno+"'");
            while(rs.next()){
                card.setText("Card Number : " + rs.getString("cardnumber").substring(0,4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12));
                card.setFont(new Font("Serif",Font.BOLD,20));
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        try{
            Conn conn2 = new Conn();
            ResultSet rs = conn2.s.executeQuery("select * from bank where formno = '"+formno+"'order by date desc limit 5");
            String[][] data = new String[6][3];
            String[] columnnames = new String[3];
            columnnames[0] = "Date";
            columnnames[1] = "Type";
            columnnames[2] = "Amount";
            data[0][0] = "Date";
            data[0][1] = "Type";
            data[0][2] = "Amount";
            
            int i = 1;
            int bal = 0;
            
            while(rs.next()){
                if (rs.getString("type").equals("Deposit")){
                        bal += Integer.parseInt(rs.getString("amount"));
                }
                
                else{
                        bal -= Integer.parseInt(rs.getString("amount"));
                }
                
                data[i][0] = rs.getString("date");
                data[i][1] = rs.getString("type");
                data[i][2] = rs.getString("amount"); 
                i+=1;
            }
            
            balance.setText("Your Current account balance is Rs " + bal);
            balance.setFont(new Font("Serif",Font.ITALIC,20));
            balance.setForeground(Color.green);
            
            table = new JTable(data,columnnames);
            table.setSize(600,500);
            table.setBounds(20,220,500,500);
            table.setVisible(true);
            add(table);
            
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        setSize(500,700); // 400 600
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        
    }
    
    public void actionPerformed (ActionEvent ae){
        try{
            String path = "";
            JFileChooser j = new JFileChooser();
            j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int x = j.showSaveDialog(this);
            
            if (x == JFileChooser.APPROVE_OPTION){
                path = j.getSelectedFile().getPath();
            }
            
            try{
                    Document doc = new Document();
                    PdfWriter.getInstance(doc, new FileOutputStream(path + " BMS.pdf"));
                    doc.open();
                    
                    Paragraph para = new Paragraph ("***** Bank Management System *****",FontFactory.getFont(FontFactory.TIMES,28f,Font.BOLD,BaseColor.RED));
                    doc.add(para);
                    para = new Paragraph("\n\n\n");
                    doc.add(para);
                    para = new Paragraph("Here is the list of your recent transactions : ",FontFactory.getFont(FontFactory.HELVETICA,16f,Font.ITALIC,BaseColor.BLUE));
                    doc.add(para);
                    para = new Paragraph("\n\n\n");
                    doc.add(para);
                    
                    PdfPTable tb1 = new PdfPTable(3);
                    tb1.addCell("Date");
                    tb1.addCell("Type");
                    tb1.addCell("Amount");
                    
                    for(int i = 1; i<6; i++){
                        if (table.getValueAt(i,0)!=null && table.getValueAt(i,1)!=null && table.getValueAt(i,2)!=null){
                            String sdate = table.getValueAt(i,0).toString();
                            String stype = table.getValueAt(i,1).toString();
                            String samount = table.getValueAt(i,2).toString();
                            tb1.addCell(sdate);
                            tb1.addCell(stype);
                            tb1.addCell(samount);
                        }
                    }
                    
                    doc.add(tb1);
                    doc.close();
                    JOptionPane.showMessageDialog(null, "Mini Statement Downloaded Successfully");
            }
            
            catch(FileNotFoundException e){
                    System.out.println(e);
            }
            
            catch(DocumentException e){
                    System.out.println(e);
            }
        }
        
        catch(Exception e){
            System.out.println(e);
        }
        
    }
    
    public static void main (String args[]){
        new MiniStatement("");
    }
}
