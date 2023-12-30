package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import com.toedter.calendar.JDateChooser;

public class SignupTwo extends JFrame implements ActionListener {
    
    JTextField pan,aadhar;
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JComboBox religion, category, occupation, education, income;
    String formno;
    
    SignupTwo(String formno){ // formno is the primary key
        
        this.formno = formno;
        setLayout(null);
        
        setTitle("Sign Up Page Two");
        
        JLabel additionalDetails = new JLabel("Page 2 : Additional Details");
        additionalDetails.setFont(new Font("Railway", Font.BOLD, 22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);
        
        JLabel religionlabel = new JLabel("Religion : ");
        religionlabel.setFont(new Font("Railway", Font.BOLD, 20));
        religionlabel.setBounds(100,140,200,30);
        add(religionlabel);
        
        String valReligion[] = {"Hindu","Muslim,","Sikh","Christian","Jain","Buddh","Other"};
        religion = new JComboBox(valReligion);
        religion.setFont(new Font("Railway",Font.BOLD, 14));
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
        JLabel categorylabel = new JLabel("Category : ");
        categorylabel.setFont(new Font("Railway", Font.BOLD, 20));
        categorylabel.setBounds(100,190,200,30);
        add(categorylabel);
        
        String valcategory[] = {"General", "SC", "ST", "OBC", "Other"};
        category = new JComboBox(valcategory);
        category.setFont(new Font("Railway",Font.BOLD, 14));
        category.setBounds(300,190,400,30);
        category.setBackground(Color.WHITE);
        add(category);
        
        JLabel incomelabel = new JLabel("Income : ");
        incomelabel.setFont(new Font("Railway", Font.BOLD, 20));
        incomelabel.setBounds(100,240,200,30);
        add(incomelabel);
        
        String incomecategory[] = {"NULL", "< 1,50,000", "2,50,000", "5,00,000", "Upto 10,00,000"};
        income = new JComboBox(incomecategory);
        income.setFont(new Font("Railway",Font.BOLD, 14));
        income.setBounds(300,240,400,30);
        income.setBackground(Color.WHITE);
        add(income);
        
        JLabel educational = new JLabel("Educational ");
        educational.setFont(new Font("Railway", Font.BOLD, 20));
        educational.setBounds(100,290,200,30);
        add(educational);
        
        JLabel qualification = new JLabel("Qualification : ");
        qualification.setFont(new Font("Railway", Font.BOLD, 20));
        qualification.setBounds(100,315,200,30);
        add(qualification);
        
        String educationValues[] = {"Non-Graduation","Graduation", "Post Graduation", "Doctrate", "Others"};
        education = new JComboBox(educationValues);
        education.setFont(new Font("Railway",Font.BOLD, 14));
        education.setBounds(300,315,400,30);
        education.setBackground(Color.WHITE);
        add(education);
        
        JLabel occupationlabel = new JLabel("Occupation : ");
        occupationlabel.setFont(new Font("Railway", Font.BOLD, 20));
        occupationlabel.setBounds(100,365,200,30);
        add(occupationlabel);
        
        String occupationValues[] = {"Salaried","Self-Employed", "Business", "Student", "Retired", "Others"};
        occupation = new JComboBox(occupationValues);
        occupation.setFont(new Font("Railway",Font.BOLD, 14));
        occupation.setBounds(300,365,400,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);
        
        JLabel panlabel = new JLabel("PAN Number : ");
        panlabel.setFont(new Font("Railway", Font.BOLD, 20));
        panlabel.setBounds(100,415,200,30);
        add(panlabel);
        
        pan = new JTextField();
        pan.setFont(new Font("Railway",Font.BOLD, 14));
        pan.setBounds(300,415,400,30);
        add(pan);
        
        JLabel aadharlabel = new JLabel("Aadhar Number : ");
        aadharlabel.setFont(new Font("Railway", Font.BOLD, 20));
        aadharlabel.setBounds(100,465,200,30);
        add(aadharlabel);
        
        aadhar = new JTextField();
        aadhar.setFont(new Font("Railway",Font.BOLD, 14));
        aadhar.setBounds(300,465,400,30);
        add(aadhar);
        
        JLabel seniorcitizenlabel = new JLabel("Senior Citizen : ");
        seniorcitizenlabel.setFont(new Font("Railway", Font.BOLD, 20));
        seniorcitizenlabel.setBounds(100,515,200,30);
        add(seniorcitizenlabel);
        
        syes = new JRadioButton("Yes");
        syes.setBounds(300, 515, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(450, 515, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        ButtonGroup seniorcitizengroup = new ButtonGroup();
        seniorcitizengroup.add(syes);
        seniorcitizengroup.add(sno);
        
        JLabel existingaccountlabel = new JLabel("Existing Account : ");
        existingaccountlabel.setFont(new Font("Railway", Font.BOLD, 20));
        existingaccountlabel.setBounds(100,565,200,30);
        add(existingaccountlabel);
        
        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 565, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno = new JRadioButton("No");
        eno.setBounds(450, 565, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eno);
        
        ButtonGroup existingaccountgroup = new ButtonGroup();
        existingaccountgroup.add(eyes);
        existingaccountgroup.add(eno);
        
        next = new JButton(" Next ");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Railway",Font.BOLD, 14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        String sreligion = (String)religion.getSelectedItem();
        // getSelectedItem returns an object
        String scategory = (String)category.getSelectedItem();
        String sincome = (String)income.getSelectedItem();
        String seducation = (String)education.getSelectedItem();
        String soccupation = (String)occupation.getSelectedItem();
        String sseniorcitizen = null;
        
        if (syes.isSelected()){
            sseniorcitizen = "Yes";
        }
        
        else if (sno.isSelected()){
            sseniorcitizen = "No";
        }
        
        String sexistingaccount = null;
        
        if (eyes.isSelected()){
            sexistingaccount = "Yes";
        }
        else if (eno.isSelected()){
            sexistingaccount = "No";
        }
        
        String span = pan.getText();
        String saadhar = aadhar.getText();
        
        try{
            if (sreligion.equals("") || scategory.equals("") || sincome.equals("") || seducation.equals("") || soccupation.equals("") || span.equals("") || saadhar.equals("") || sseniorcitizen.equals("") || sexistingaccount.equals("")){
                JOptionPane.showMessageDialog(null, "Fill the complete form");
            }
            
            else if(saadhar.length()!=12){
                JOptionPane.showMessageDialog(null, "Enter 12 digit aadhar number");
            }
            
            else{
                Conn c = new Conn();
                String query = "insert into signuptwo values ('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+sseniorcitizen+"','"+sexistingaccount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Form saved successfully");
                setVisible(false);
                new SignupThree(formno).setVisible(true);
            }   
        }
        
        catch(Exception e){
            System.out.println(e);
        }
      
    }
    
    public static void main(String args[]){
        new SignupTwo("");
    }
    
}
