package bank.mangement.system;

import javax.swing.*;
import java.awt.*;  
import java.util.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;

public class SignupOne extends JFrame implements ActionListener {
    
    long random;
    JTextField nameTextField,fathernameTextField,emailTextField,addressTextField,cityTextField,pincodeTextField,stateTextField;
    JButton next,clear;
    JRadioButton male,female,married,unmarried,others;
    JDateChooser dateChooser;
    
    SignupOne(){
        
        Random ran= new Random();
        random=(Math.abs((ran.nextLong()%9000L)+1000L));
       
        setTitle("Signup Form 1");
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(90, 90, 100);
        ImageIcon i3= new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(30,5,100,100);
        add (label);
        
        JLabel formno=new JLabel("  APPLICATION FORM NO. " + random );
        formno.setFont(new Font("Raleway", Font.BOLD,38));
        formno.setBounds(140, 15,600, 40);
        add(formno);
        
        JLabel personalDetail=new JLabel("Page 1: Personal Details");
        personalDetail.setFont(new Font("Raleway", Font.BOLD,22));
        personalDetail.setBounds(290, 65,400, 30);
        add(personalDetail);
        
        JLabel name=new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD,20));
        name.setBounds(100, 120,100, 30);
        add(name);
        
        nameTextField=new JTextField();
        nameTextField.setBounds(310,120,380,30);
        nameTextField.setFont(new Font("Arial",Font.BOLD,13));
        add(nameTextField);
        
        JLabel fathername=new JLabel("Father's Name:");
        fathername.setFont(new Font("Raleway", Font.BOLD,20));
        fathername.setBounds(100, 170,200, 30);
        add(fathername);
        
        fathernameTextField=new JTextField();
        fathernameTextField.setBounds(310,170,380,30);
        fathernameTextField.setFont(new Font("Arial",Font.BOLD,13));
        add(fathernameTextField);

        JLabel dob=new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD,20));
        dob.setBounds(100, 220,200, 30);
        add(dob);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(310,220,380,30);
        dateChooser.setForeground(Color.BLACK);
        add(dateChooser);
        
        JLabel gen=new JLabel("Gender:");
        gen.setFont(new Font("Raleway", Font.BOLD,20));
        gen.setBounds(100, 270,200, 30);
        add(gen);
        
        male = new JRadioButton("Male");
        male.setBounds(310, 270, 80, 30);
        male.setBackground(Color.white);
        male.setFont(new Font("Raleway", Font.BOLD,13));
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(430, 270, 80, 30);
        female.setBackground(Color.white);
        female.setFont(new Font("Raleway", Font.BOLD,13));
        add(female);
        
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        JLabel email=new JLabel("Email Address:");
        email.setFont(new Font("Raleway", Font.BOLD,20));
        email.setBounds(100, 320,200, 30);
        add(email);
        
        emailTextField=new JTextField();
        emailTextField.setBounds(310,320,380,30);
        emailTextField.setFont(new Font("Arial",Font.BOLD,13));
        add(emailTextField);
 
        JLabel marital=new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway", Font.BOLD,20));
        marital.setBounds(100, 370,200, 30);
        add(marital);
        
        married = new JRadioButton("Married");
        married.setBounds(310, 370, 80, 30);
        married.setBackground(Color.white);
        married.setFont(new Font("Raleway", Font.BOLD,13));
        add(married);
        
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(430, 370, 100, 30);
        unmarried.setBackground(Color.white);
        unmarried.setFont(new Font("Raleway", Font.BOLD,13));
        add(unmarried);
        
        others = new JRadioButton("Other");
        others.setBounds(570, 370, 80, 30);
        others.setBackground(Color.white);
        others.setFont(new Font("Raleway", Font.BOLD,13));
        add(others);
        
        ButtonGroup maritalstatus = new ButtonGroup();
        maritalstatus.add(married);
        maritalstatus.add(unmarried);
        maritalstatus.add(others);
        
        JLabel address=new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD,20));
        address.setBounds(100, 420,200, 30);
        add(address);
        
        addressTextField=new JTextField();
        addressTextField.setBounds(310,420,380,30);
        addressTextField.setFont(new Font("Arial",Font.BOLD,13));
        add(addressTextField);
        
        JLabel city=new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD,20));
        city.setBounds(100, 470,200, 30);
        add(city);
        
        cityTextField=new JTextField();
        cityTextField.setBounds(310,470,380,30);
        cityTextField.setFont(new Font("Arial",Font.BOLD,13));
        add(cityTextField);
        
        JLabel pincode=new JLabel("Pin Code:");
        pincode.setFont(new Font("Raleway", Font.BOLD,20));
        pincode.setBounds(100, 520,200, 30);
        add(pincode);
        
        pincodeTextField=new JTextField();
        pincodeTextField.setBounds(310,520,380,30);
        pincodeTextField.setFont(new Font("Arial",Font.BOLD,13));
        add(pincodeTextField);
        
        JLabel state=new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD,20));
        state.setBounds(100, 570,200, 30);
        add(state);
        
        stateTextField=new JTextField();
        stateTextField.setBounds(310,570,380,30);
        stateTextField.setFont(new Font("Raleway",Font.BOLD,13));
        add(stateTextField);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(610,630,80,30);
        next.addActionListener(this);
        add(next);
        
        clear = new JButton("Clear");
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.setFont(new Font("Raleway",Font.BOLD,14));
        clear.setBounds(420,630,80,30);
        clear.addActionListener(this);
        add(clear);
        
        getContentPane().setBackground(Color.white);
        
        setSize(850,720);
        setLocation(350,10);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
         if(ae.getSource()==next){
            String formno = "" + random;
            setVisible(false);
            new SignupTwo(formno).setVisible(true);
        }
         else if (ae.getSource() == clear) {
            nameTextField.setText("");
            fathernameTextField.setText("");
            dateChooser.setDate(null);
            male.setSelected(false);
            female.setSelected(false);
            emailTextField.setText("");
            married.setSelected(false);
            unmarried.setSelected(false);
            others.setSelected(false);
            addressTextField.setText("");
            cityTextField.setText("");
            pincodeTextField.setText("");
            stateTextField.setText("");
        }
        
        String formno ="" + random;
        String name =  nameTextField.getText();
        String fathername = fathernameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected()){
            gender = "Male";
        }else if(female.isSelected()){
            gender = "Female";
        }else if(others.isSelected()){
            gender = "Other";
        }
        
        String email = emailTextField.getText();
        String maritalstatus =  null;
        if (married.isSelected()){
            maritalstatus =  "Married";
        }else if (unmarried.isSelected()){
            maritalstatus = "Unmarried";
        }
        
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String pincode = pincodeTextField.getText();
        String state = stateTextField.getText();
        
        try {
            if (name.trim().equals("")){
                
            }else{
                Conn c = new Conn();
                String query = "insert into signup values('"+formno+"','"+name+"','"+fathername+"','"+dob+"', '"+gender+"','"+email+"', '"+maritalstatus+"',  '"+address+"' ,'"+city+"', '"+pincode+"','"+state+"')";
                c.s.executeUpdate(query);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void main(String args[]){
        new SignupOne();
    }
}