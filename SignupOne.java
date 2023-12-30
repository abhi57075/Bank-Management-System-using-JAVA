package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;

import com.toedter.calendar.JDateChooser;

public class SignupOne extends JFrame implements ActionListener {
    
    String emailPattern = "^[a-zA-Z0-9]+[@]+[a-zA-Z0-9]+[.]+[a-zA-Z0-9]+$";
    
    int var1;
    JTextField nameTextField, fnameTextField, dobTextField, emailTextField, addressTextField, cityTextField, stateTextField, pinTextField;
    JButton next;
    JRadioButton male, female, other, married, unmarried;
    JDateChooser dateChooser;
    
    SignupOne(){
        
        setLayout(null);
        
        Random random = new Random();
        var1 = Math.abs(random.nextInt() % 1000);
        
        boolean flag = true;
        try{
            while(flag == true){
                
                String query = "select * from signup where formno = '"+var1+"'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                
                if (rs.next()){
                    var1 = Math.abs(random.nextInt() % 1000);
                }
                
                else{
                    flag = false;
                }
            }
        }
        
        catch(Exception e){
            System.out.println(e);
        }
                
        JLabel formno = new JLabel("Application form no : " + var1);
        formno.setFont(new Font("Railway", Font.BOLD, 38));
        formno.setBounds(140,20,600,40);
        add(formno);
        
        JLabel personDetails = new JLabel("Page 1 : Personal Details");
        personDetails.setFont(new Font("Railway", Font.BOLD, 22));
        personDetails.setBounds(290,80,400,30);
        add(personDetails);
        
        JLabel name = new JLabel("Name : ");
        name.setFont(new Font("Railway", Font.BOLD, 20));
        name.setBounds(100,140,200,30);
        add(name);
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Railway",Font.BOLD, 14));
        nameTextField.setBounds(300,140,400,30);
        add(nameTextField);
        
        JLabel fname = new JLabel("Father's Name : ");
        fname.setFont(new Font("Railway", Font.BOLD, 20));
        fname.setBounds(100,190,200,30);
        add(fname);
        
        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Railway",Font.BOLD, 14));
        fnameTextField.setBounds(300,190,400,30);
        add(fnameTextField);
        
        JLabel dob = new JLabel("Date of Birth : ");
        dob.setFont(new Font("Railway", Font.BOLD, 20));
        dob.setBounds(100,240,200,30);
        add(dob);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,240,400,30);
        dateChooser.setFont(new Font("Railway",Font.BOLD, 14));
        dateChooser.setForeground(new Color(105,105,105));
        add(dateChooser);
        
        JLabel gender = new JLabel("Gender : ");
        gender.setFont(new Font("Railway", Font.BOLD, 20));
        gender.setBounds(100,290,200,30);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(300, 290, 100, 30);
        male.setBackground(Color.WHITE);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(450, 290, 100, 30);
        female.setBackground(Color.WHITE);
        add(female);
        
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        JLabel email = new JLabel("Email : ");
        email.setFont(new Font("Railway", Font.BOLD, 20));
        email.setBounds(100,340,200,30);
        add(email);
        
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Railway",Font.BOLD, 14));
        emailTextField.setBounds(300,340,400,30);
        add(emailTextField);
        
        JLabel marital = new JLabel("Marital Status : ");
        marital.setFont(new Font("Railway", Font.BOLD, 20));
        marital.setBounds(100,390,200,30);
        add(marital);
        
        married = new JRadioButton("Married");
        married.setBounds(300, 390, 100, 30);
        married.setBackground(Color.WHITE);
        add(married);
        
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450, 390, 100, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        
        other = new JRadioButton("Others");
        other.setBounds(600, 390, 100, 30);
        other.setBackground(Color.WHITE);
        add(other);
        
        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(other);
        
        JLabel address = new JLabel("Address : ");
        address.setFont(new Font("Railway", Font.BOLD, 20));
        address.setBounds(100,440,200,30);
        add(address);
        
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Railway",Font.BOLD, 14));
        addressTextField.setBounds(300,440,400,30);
        add(addressTextField);
        
        JLabel city = new JLabel("City : ");
        city.setFont(new Font("Railway", Font.BOLD, 20));
        city.setBounds(100,490,200,30);
        add(city);
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Railway",Font.BOLD, 14));
        cityTextField.setBounds(300,490,400,30);
        add(cityTextField);
        
        JLabel state = new JLabel("State : ");
        state.setFont(new Font("Railway", Font.BOLD, 20));
        state.setBounds(100,540,200,30);
        add(state);
        
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Railway",Font.BOLD, 14));
        stateTextField.setBounds(300,540,400,30);
        add(stateTextField);
        
        JLabel pincode = new JLabel("Pincode : ");
        pincode.setFont(new Font("Railway", Font.BOLD, 20));
        pincode.setBounds(100,590,200,30);
        add(pincode);
        
        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Railway",Font.BOLD, 14));
        pinTextField.setBounds(300,590,400,30);
        add(pinTextField);
        
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
        setTitle("Sign up Page One");
    }
    
    public void actionPerformed(ActionEvent ae){
        
        String formno = "" + var1; 
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        
        if (male.isSelected()){
            gender = "Male";
        }
        
        else if (female.isSelected()){
            gender = "Female";
        }
        
        String email = emailTextField.getText();
        String marital = null;
        
        if (married.isSelected()){
            marital = "Married";
        }
        
        else if (unmarried.isSelected()){
            marital = "Unmarried";
        }
        
        else if (other.isSelected()){
            marital = "Other";
        }
        
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pinTextField.getText();
        
        try{
            
            if (name.equals("") || fname.equals("") || dob.equals("") || gender.equals("") || email.equals("") || marital.equals("") || address.equals("") || city.equals("") || state.equals("") || pin.equals("")){
                JOptionPane.showMessageDialog(null, "Fill the complete form");
            }
            
            else if (!email.matches(emailPattern)){
                JOptionPane.showMessageDialog(null, "Put a proper gmail in email section");
            }
            
            else if (pin.length()!=6){
                JOptionPane.showMessageDialog(null, "Enter a 6 digit pincode");
            }
            
            else{
                Conn c = new Conn();
                String query = "insert into signup values ('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Form saved successfully");
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
            
        }
        
        catch(Exception e){
            System.out.println(e);
        }
        
    }
    
    public static void main(String args[]){
        new SignupOne();
    }
    
}
