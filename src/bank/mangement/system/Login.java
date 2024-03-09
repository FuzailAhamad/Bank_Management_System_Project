package bank.mangement.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    
    JButton login, signup, clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    
    Login(){
        
        setTitle("PNC Bank");
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100, 100, 100);
        ImageIcon i3= new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(70,10,100,100);
        add (label);
        
        JLabel text=new JLabel("Welcome to ATM");
        add (text);
        text.setBounds(250, 40,500,40);
        text.setFont(new Font("Osward", Font.BOLD,38));
        
        JLabel cardno=new JLabel("Card No:");
        add (cardno);
        cardno.setBounds(120,150,150,30);
        cardno.setFont(new Font("Raleway", Font.BOLD,28));
        
        cardTextField=new JTextField();
        cardTextField.setBounds(300,150,230,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,16));
        add(cardTextField);
        
        JLabel cardtext = new JLabel("Enter the Card No.");
        cardtext.setFont(new Font("Raleway", Font.BOLD, 12));
        cardtext.setBounds(300, 125, 350, 30);
        add(cardtext);
        
        JLabel pin=new JLabel("PIN:");
        add (pin);
        pin.setBounds(120, 220,250,40);
        pin.setFont(new Font("Raleway", Font.BOLD,28));
        
        pinTextField=new JPasswordField();
        pinTextField.setBounds(300,225,230,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,20));
        add(pinTextField);
        
        JLabel pinfield = new JLabel("Enter your 4 Digit PIN.");
        pinfield.setFont(new Font("Raleway", Font.BOLD, 12));
        pinfield.setBounds(300, 200, 350, 30);
        add(pinfield);
        
        login = new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        add(login);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        
        clear = new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        add(clear);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        
        JLabel signupform = new JLabel("If you don't hava an account click on Signup.");
        signupform.setFont(new Font("Raleway", Font.BOLD, 12));
        signupform.setBounds(300, 350, 350, 30);
        add(signupform);
        
        signup = new JButton("SIGN UP");
        signup.setBounds(300,380,230,30);
        add(signup);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        
        getContentPane().setBackground(Color.white);
        
        setSize(800,480);
        setVisible(true);
        setLocation(280,150);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==clear){
            cardTextField.setText("");
        }
        else if(ae.getSource()==login){
            Conn c = new Conn();
            String cardno = cardTextField.getText();
            String pinpass = pinTextField.getText();
            String query = "Select * from login where cardnumber = '"+cardno+"' AND pin = '"+pinpass+"'";
            pinTextField.setText("");
            try{
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()){
                    setVisible(false);
                    new Transaction(pinpass).setVisible(true);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
                }
            }catch (Exception e){
                System.out.println(e);
            }
          }
        else if(ae.getSource()==signup){
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }
    
    public static void main(String[] args){
        new Login();
    }
}
